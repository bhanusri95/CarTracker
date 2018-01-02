package io.egen.service;

import io.egen.entity.Vehicles;
import io.egen.repository.VehicleRepository;

import java.util.List;

public interface VehicleService {

    Vehicles update(Vehicles v);
}
