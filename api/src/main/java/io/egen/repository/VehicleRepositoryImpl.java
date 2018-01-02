package io.egen.repository;


import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository()
public class VehicleRepositoryImpl implements VehicleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Vehicles findOne(String id) {
        return entityManager.find(Vehicles.class,id);
    }

    public Vehicles create(Vehicles v) {
        entityManager.persist(v);
        return v;
    }

    public Vehicles update(Vehicles v) {
        return entityManager.merge(v);
    }
}
