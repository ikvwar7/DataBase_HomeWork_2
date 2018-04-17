package ru.liga.mybatis.repository;

import ru.liga.mybatis.entity.DepartmentEntity;

public interface DepartmentRepository {
    DepartmentEntity save(DepartmentEntity entity);

    void deleteById(Long id);

    DepartmentEntity findById(Long id);
}
