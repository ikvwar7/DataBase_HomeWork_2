package ru.liga.dao;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;

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
    public void findByFoundationYearTest() {
        assertEquals(1, departmentDao.findByFoundationYear(1933).size());
    }

}