package ru.liga.hibernate.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.hibernate.entity.DepartmentEntity;
import ru.liga.hibernate.entity.StudentEntity;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DefaultStudentDaoTest {

    @Autowired
    private StudentDao studentDao;


    @Test
    public void crudTest() {
        DepartmentEntity departmentEntity = new DepartmentEntity(
                4l,
                "newDepartment",
                "newAdress",
                2018,
                null,
                null
        );
        StudentEntity studentEntity = new StudentEntity(
                null,
                "Студент2MB",
                "Male",
                departmentEntity,
                LocalDate.of(1996, 3, 5)

        );
        studentDao.save(studentEntity);
        assertEquals("Male", studentDao.selectByFio("Студент2MB").getGender());
        studentDao.selectById(studentEntity.getId());
        assertNull(studentDao.selectById(studentEntity.getId()));
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals(12, studentDao.selectByDepartmentId(1L).size());
    }
}