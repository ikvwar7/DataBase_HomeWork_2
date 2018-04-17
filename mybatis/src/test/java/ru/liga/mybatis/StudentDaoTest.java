package ru.liga.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.EmployeeDao;
import ru.liga.mybatis.dao.StudentDao;
import ru.liga.mybatis.entity.StudentEntity;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void selectById() {
        assertEquals("Бардашов Данила Романович", studentDao.selectById(1L).getFio());
    }

    @Test
    public void selectByDepartmentId() {
        assertEquals("Пискарева Вероника Максимовна", studentDao.selectByDepartmentId(2l).get(0).getFio());
    }

    @Test
    public void deleteById() {
        studentDao.deleteById(51l);
        assertEquals(null, studentDao.selectById(51l));
    }

    @Test
    public void insert() {
        studentDao.insert(new StudentEntity(
                53L,
                "Петров Пётр Петрович",
                "Male",
                3L,
                6L,
                LocalDate.of(1994, 3, 5)
        ));
        assertEquals("Петров Пётр Петрович", studentDao.selectById(51L).getFio());
    }

    @Test
    public void update() {
        studentDao.update(new StudentEntity(
                53L,
                "Updated1",
                "Male",
                3l,
                3l,
                LocalDate.of(1996, 3, 5)
        ));
        assertEquals("Updated1", studentDao.selectById(53L).getFio());
    }

}