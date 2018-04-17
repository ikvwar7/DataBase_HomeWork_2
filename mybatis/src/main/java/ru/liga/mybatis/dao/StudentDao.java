package ru.liga.mybatis.dao;

import ru.liga.mybatis.entity.StudentEntity;

import java.util.List;

public interface StudentDao {

    int insert(StudentEntity entity);

    int update(StudentEntity entity);

    void deleteById(Long entityId);

    StudentEntity selectById(Long id);

    List<StudentEntity> selectByDepartmentId(Long department_id);
}
