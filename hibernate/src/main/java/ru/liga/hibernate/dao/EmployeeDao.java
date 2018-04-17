package ru.liga.hibernate.dao;

import ru.liga.hibernate.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeDao {
    void save(EmployeeEntity entity);
    void delete(Long entityId);
    EmployeeEntity select(Long id) ;
    List<EmployeeEntity> selectByDepartmentId(Long departmentId);
    EmployeeEntity selectByFio(String title);
}
