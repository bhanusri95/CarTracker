package io.egen.repository;

import io.egen.entity.Readings;
import io.egen.entity.Tires;
import io.egen.entity.Vehicles;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository {
    @PersistenceContext
    private EntityManager entityManager;
    public Readings findOne(String id) {
        return null;
    }


    public Readings create(Readings r) {
        //entityManager.persist(t);
        entityManager.persist(r);
        //Tire t=(Tire)r.getTire();
        //System.out.println(r.getEngineHp());
        return r;
    }

}
