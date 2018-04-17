package ru.liga.mybatis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.DepartmentDao;
import ru.liga.mybatis.dao.EmployeeDao;
import ru.liga.mybatis.entity.EmployeeEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class EmployeetDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Before
    public void init() {

    }

    @Test
    public void selectById() {
        assertEquals("Владимир Николаевич Чубариков", employeeDao.select(1L).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals(4, employeeDao.selectByDepartmentId(1L).size());
    }

    @Test
    public void insert() {
        employeeDao.insert(new EmployeeEntity(
                16L,
                "NewEmployee",
                "Male",
                3l,
                "Кандидат наук",
                "Доцент",
                LocalDate.of(1994, 3, 5)
        ));
        assertEquals("NewEmployee", employeeDao.select(16L).getFio());
    }

    @Test
    public void update() {
        employeeDao.update(new EmployeeEntity(
                16L,
                "NewEmployeeUpdated",
                "Male",
                3l,
                "Кандидат наук",
                "Доцент",
                LocalDate.of(1994, 3, 5)
        ));
        assertEquals("NewEmployeeUpdated", employeeDao.select(16L).getFio());
    }

    @Test
    public void deleteById() {
        employeeDao.delete(16L);
        assertNull(employeeDao.select(16l));
    }
}