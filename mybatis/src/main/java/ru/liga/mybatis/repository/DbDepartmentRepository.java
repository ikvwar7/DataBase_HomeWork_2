package ru.liga.mybatis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.liga.mybatis.dao.DepartmentDao;
import ru.liga.mybatis.dao.EmployeeDao;
import ru.liga.mybatis.dao.StudentDao;
import ru.liga.mybatis.entity.DepartmentEntity;
import ru.liga.mybatis.entity.EmployeeEntity;
import ru.liga.mybatis.entity.StudentEntity;

import java.util.List;

@Component
public class DbDepartmentRepository implements DepartmentRepository {

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmployeeDao employeeDao;

    public DbDepartmentRepository() {
    }

    @Override
    public DepartmentEntity save(DepartmentEntity entity) {
        if (departmentDao.select(entity.getId()) == null) {
            departmentDao.insert(entity);
            entity.getEmployees().stream()
                    .forEach(employee -> employeeDao.insert(employee));
            entity.getStudents().stream()
                    .forEach(studentEntity -> studentDao.insert(studentEntity));
        } else {
            departmentDao.update(entity);
            entity.getEmployees().stream()
                    .forEach(employee -> employeeDao.update(employee));
            entity.getStudents().stream()
                    .forEach(studentEntity -> studentDao.update(studentEntity));
        }
        return entity;
    }

    @Override
    public void deleteById(Long id) {
        departmentDao.delete(id);
        List<StudentEntity> studEntities = studentDao.selectByDepartmentId(id);
        for (StudentEntity ent : studEntities) {
            studentDao.deleteById(ent.getId());
        }
        List<EmployeeEntity> emplEntities = employeeDao.selectByDepartmentId(id);
        for (EmployeeEntity ent : emplEntities) {
            employeeDao.delete(ent.getId());
        }
    }

    @Override
    public DepartmentEntity findById(Long id) {
        return departmentDao.select(id);
    }
}

