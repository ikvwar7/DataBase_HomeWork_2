package ru.liga.mybatis.dao;

import ru.liga.mybatis.entity.DepartmentEntity;

import java.util.List;

public interface DepartmentDao {

    int insert(DepartmentEntity entity);

    int update(DepartmentEntity entity);

    void delete(Long entityId);

    DepartmentEntity select(Long id);

    List<DepartmentEntity> selectByFoundationYear(Integer year);

    DepartmentEntity selectByTitle(String title);
}
