package ru.liga.hibernate.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.hibernate.entity.DepartmentEntity;
import ru.liga.hibernate.entity.EmployeeEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DefaultEmployeeDao implements EmployeeDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(EmployeeEntity entity) {
        em.persist(entity);
    }

    public void delete(Long entityId) {
        em.remove(select(entityId));
    }

    @Override
    public EmployeeEntity select(Long id) {
        return em.find(EmployeeEntity.class, id);
    }

    @Override
    public List<EmployeeEntity> selectByDepartmentId(Long departmentId) {
        return (List<EmployeeEntity>) em
                .createQuery("FROM EmployeeEntity WHERE department_id = :departmentId")
                .setParameter("departmentId", departmentId)
                .getResultList();
    }

    @Override
    public EmployeeEntity selectByFio(String fio) {
        return (EmployeeEntity) em.
                createQuery("FROM EmployeeEntity WHERE fio = :fio")
                .setParameter("fio", fio)
                .getResultList()
                .get(0);
    }
}
