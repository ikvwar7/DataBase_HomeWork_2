package ru.liga.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.EmployeeDao;
import ru.liga.mybatis.dao.StudentDao;
import ru.liga.mybatis.entity.DepartmentEntity;
import ru.liga.mybatis.entity.EmployeeEntity;
import ru.liga.mybatis.entity.StudentEntity;
import ru.liga.mybatis.repository.DepartmentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class DbDepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository dbDepRep;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void saveAndDelete() {
        List<EmployeeEntity> employees = new ArrayList<>(Arrays.asList(
                new EmployeeEntity(
                        18L,
                        "NewEmp1_MB",
                        "male",
                        5l,
                        "доктор",
                        "профессор",
                        LocalDate.of(1994, 3, 5)
                ),
                new EmployeeEntity(
                        19L,
                        "NewEmp2_MB",
                        "male",
                        5l,
                        "доктор",
                        "профессор",
                        LocalDate.of(1994, 3, 5)
                )
        ));
        List<StudentEntity> students = new ArrayList<>(Arrays.asList(
                new StudentEntity(
                        58L,
                        "Студент1MB",
                        "Male",
                        5l,
                        3l,
                        LocalDate.of(1996, 3, 5)
                ),
                new StudentEntity(
                        59L,
                        "Студент2MB",
                        "Male",
                        5l,
                        3l,
                        LocalDate.of(1996, 3, 5)
                )
        ));
        DepartmentEntity departmentEntity = new DepartmentEntity(
                5l,
                "newDepartment",
                "newAdress",
                2018,
                employees,
                students
        );
        dbDepRep.save(departmentEntity);
        assertEquals("Студент1MB", dbDepRep.findById(5l).getStudents().get(0).getFio());
        assertEquals("NewEmp1_MB", dbDepRep.findById(5l).getEmployees().get(0).getFio());
    }

    @Test
    public void deleteById() {
        dbDepRep.deleteById(5l);
        assertNull(dbDepRep.findById(5l));
        assertEquals(0, studentDao.selectByDepartmentId(5l).size());
        assertEquals(0, employeeDao.selectByDepartmentId(5l).size());
    }

}