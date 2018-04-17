package ru.liga.hibernate.dao;

import ru.liga.hibernate.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentDao {

    void save(DepartmentEntity entity);

    void delete(Long entityId);

    DepartmentEntity select(Long id);

    List<DepartmentEntity> selectByFoundationYear(Integer year);

    DepartmentEntity selectByTitle(String title);

    DepartmentEntity selectById(Long id);

}
