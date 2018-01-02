package io.egen.repository;


import io.egen.entity.Vehicles;

public interface VehicleRepository {
    Vehicles findOne(String id);

    Vehicles create(Vehicles v);

    Vehicles update(Vehicles v);
}
