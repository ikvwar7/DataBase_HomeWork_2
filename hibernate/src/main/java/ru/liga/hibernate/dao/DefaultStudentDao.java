package ru.liga.hibernate.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.hibernate.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DefaultStudentDao implements StudentDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public StudentEntity selectByFio(String fio) {
        return (StudentEntity) em.
                createQuery("FROM StudentEntity WHERE fio = :fio")
                .setParameter("fio", fio)
                .getResultList()
                .get(0);
    }

    @Override
    public void save(StudentEntity entity) {
        em.persist(entity);
    }

    @Override
    public void deleteById(Long entityId) {
        em.remove(selectById(entityId));

    }

    @Override
    public StudentEntity selectById(Long id) {
        return em.find(StudentEntity.class, id);
    }

    @Override
    public List<StudentEntity> selectByDepartmentId(Long departmentId) {
        return (List<StudentEntity>) em
                .createQuery("FROM StudentEntity WHERE department_id = :departmentId")
                .setParameter("departmentId", departmentId)
                .getResultList();
    }
}
