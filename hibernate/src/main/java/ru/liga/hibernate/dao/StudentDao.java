package ru.liga.hibernate.dao;

import ru.liga.hibernate.entity.EmployeeEntity;
import ru.liga.hibernate.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    void save(StudentEntity entity);

    void deleteById(Long entityId);

    StudentEntity selectById(Long id);

    List<StudentEntity> selectByDepartmentId(Long department_id);

    StudentEntity selectByFio(String fio);
}
