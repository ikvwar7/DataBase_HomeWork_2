package ru.liga.mybatis;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.DepartmentDao;
import ru.liga.mybatis.entity.DepartmentEntity;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Before
    public void init() {

    }

    @Test
    public void selectByFoundationYear() {
        assertEquals(4, departmentDao.select(1L).getEmployees().size());
    }

    @Test
    public void selectById() {
        assertEquals(2, departmentDao.select(4L).getStudents().size());
    }

}