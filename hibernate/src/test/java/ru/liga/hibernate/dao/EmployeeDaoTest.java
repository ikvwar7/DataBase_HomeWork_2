package ru.liga.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.hibernate.entity.EmployeeEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findByIdTest() {
        EmployeeEntity entity = employeeDao.select(0L);
        assertEquals("Владимир Николаевич Чубариков", entity.getFio());
        assertEquals("Механико-математический", entity.getDepartment().getTitle());
    }

    @Test
    public void findByDepartmentId() {
        List<EmployeeEntity> entities= employeeDao.selectByDepartmentId(1L);
        assertEquals(5, entities.size());
    }

}