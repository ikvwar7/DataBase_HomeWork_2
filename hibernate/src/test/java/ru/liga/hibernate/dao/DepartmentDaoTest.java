package ru.liga.hibernate.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.liga.hibernate.entity.DepartmentEntity;
import ru.liga.hibernate.entity.EmployeeEntity;
import ru.liga.hibernate.entity.StudentEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void selectTest() {
        DepartmentEntity entity = departmentDao.select(0L);
        assertEquals("Механико-математический", entity.getTitle());
        assertEquals("119991, ГСП-1, Москва, Ленинские горы, МГУ, д.1, Главное здание, механико-математический факультет", entity.getAddress());
        assertEquals(5, entity.getEmployees().size());
        assertEquals(Integer.valueOf(1932), entity.getFoundationYear());
    }

    @Test
    public void selectByIdTest() {
        DepartmentEntity entity = departmentDao.selectById(0L);
        assertEquals("Механико-математический", entity.getTitle());
        assertEquals("119991, ГСП-1, Москва, Ленинские горы, МГУ, д.1, Главное здание, механико-математический факультет", entity.getAddress());
        assertEquals(5, entity.getEmployees().size());
        assertEquals(Integer.valueOf(1932), entity.getFoundationYear());
    }

    @Test
    public void selectByFoundationYearTest() {
        List<DepartmentEntity> entities = departmentDao.selectByFoundationYear(1934);
        assertEquals(1, entities.size());
    }

    @Test
    public void saveTest() {
        DepartmentEntity entity = new DepartmentEntity();
        entity.setTitle("Психологический");
        entity.setFoundationYear(1948);
        entity.setAddress("Москва");
        entity.setEmployees(Arrays.asList(new EmployeeEntity(null, "Chernoded Anton Aleksadrovich", "FEMALE", entity, "MASTER", "postgraduate", LocalDate.now())));
        departmentDao.save(entity);
        DepartmentEntity savedEntity = departmentDao.select(entity.getId());
        assertTrue(
                savedEntity.getEmployees()
                        .stream()
                        .anyMatch(e -> e.getFio().equals("Chernoded Anton Aleksadrovich"))
        );
    }

    @Test
    public void OneToManyTest() {
        DepartmentEntity departmentEntity = new DepartmentEntity(
                4l,
                "newDepartment",
                "newAdress",
                2018,
                null,
                null
        );
        List<EmployeeEntity> employees = new ArrayList<>(Arrays.asList(
                new EmployeeEntity(
                        null,
                        "NewEmp1_MB",
                        "male",
                        departmentEntity,
                        "доктор",
                        "профессор",
                        LocalDate.of(1994, 3, 5)
                ),
                new EmployeeEntity(
                        null,
                        "NewEmp2_MB",
                        "male",
                        departmentEntity,
                        "доктор",
                        "профессор",
                        LocalDate.of(1994, 3, 5)
                )
        ));
        List<StudentEntity> students = new ArrayList<>(Arrays.asList(
                new StudentEntity(
                        null,
                        "Студент1MB",
                        "Male",
                        departmentEntity,
                        LocalDate.of(1996, 3, 5)
                ),
                new StudentEntity(
                        null,
                        "Студент2MB",
                        "Male",
                        departmentEntity,
                        LocalDate.of(1996, 3, 5)
                )
        ));

        departmentEntity.setEmployees(employees);
        departmentEntity.setStudents(students);
        departmentDao.save(departmentEntity);
        assertEquals(1, departmentDao.selectByFoundationYear(2018).size());
        assertEquals("Male", studentDao.selectByFio("Студент2MB").getGender());
        assertEquals("доктор", employeeDao.selectByFio("NewEmp2_MB").getDegree());

        departmentDao.delete(departmentEntity.getId());
        assertEquals(0, studentDao.selectByDepartmentId(4l).size());
        assertEquals(0, employeeDao.selectByDepartmentId(4l).size());
    }
}