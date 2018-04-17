package ru.liga.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.liga.hibernate.entity.DepartmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DefaultDepartmentDao implements DepartmentDao {

    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(DepartmentEntity entity) {
        em.persist(entity);
    }

    public void delete(Long entityId) {
        em.remove(select(entityId));
    }

    @Override
    public DepartmentEntity select(Long id) {
        return em.find(DepartmentEntity.class, id);
    }

    @Override
    public List<DepartmentEntity> selectByFoundationYear(Integer year) {
        return (List<DepartmentEntity>) em
                .createQuery("FROM DepartmentEntity WHERE foundationYear = :foundationYear")
                .setParameter("foundationYear", year)
                .getResultList();
    }

    @Override
    public DepartmentEntity selectByTitle(String title) {
        return (DepartmentEntity) em.
                createQuery("FROM DepartmentEntity WHERE title = :title")
                .setParameter("title", title)
                .getResultList()
                .get(0);
    }

    @Override
    public DepartmentEntity selectById(Long id) {
        try (Session session = sessionFactory.openSession()) {
           return session.get(DepartmentEntity.class, id);
        }
    }
}
