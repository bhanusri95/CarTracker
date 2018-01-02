package io.egen.service;

import io.egen.entity.Vehicles;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository repository;

    @Transactional
    public Vehicles update(Vehicles v) {
        if(repository.findOne(v.getVin())!=null){
            return repository.update(v);
        }
        else{
            return repository.create(v);
        }
    }
}
