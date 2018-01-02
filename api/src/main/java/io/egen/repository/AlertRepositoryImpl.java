package io.egen.repository;

import io.egen.entity.Alert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AlertRepositoryImpl implements AlertRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Alert alert) {
        entityManager.persist(alert);
    }
}
