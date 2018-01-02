package io.egen.service;

import io.egen.entity.Alert;
import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.exception.ResourceNotFoundException;
import io.egen.repository.AlertRepository;
import io.egen.repository.ReadingRepository;
import io.egen.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReadingServiceImpl implements ReadingService {
    @Autowired
    private ReadingRepository repository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private AlertRepository alertRepository;


    @Transactional
    public Readings create(Readings r) {
        Vehicles veh=vehicleRepository.findOne(r.getVin());
        if(veh==null){
            throw new ResourceNotFoundException("your vehicle is not registered");
        }
        else {
            repository.create(r);
            //Vehicles veh=vehicleRepository.findOne(r.getVin());
            System.out.println(veh);
            Boolean tirePressureLow = ((r.getTire().getFrontLeft() < 32) || (r.getTire().getFrontRight() < 32) || (r.getTire().getRearLeft() < 32) || (r.getTire().getRearRight() < 32));
            Boolean tirePressureHigh = ((r.getTire().getFrontLeft() > 36) || (r.getTire().getFrontRight() > 36) || (r.getTire().getRearLeft() > 36) || (r.getTire().getRearRight() > 36));
            if (r.getEngineRpm() > veh.getRedlineRpm()) {
                Alert alert = new Alert();
                alert.setVin(veh.getVin());
                alert.setPriority("High");
                alert.setDescription("your engine rpm is greater then redline rpm");
                alertRepository.create(alert);
            }
            double fv = 0.1 * (veh.getMaxFuelVolume());
            if (r.getFuelVolume() < fv) {
                Alert alertf = new Alert();
                alertf.setVin(veh.getVin());
                alertf.setPriority("Medium");
                alertf.setDescription("your fuel volume is less then maximum fuel volume");
                alertRepository.create(alertf);
            }
            if (tirePressureHigh || tirePressureLow) {
                Alert alertt = new Alert();
                alertt.setVin(veh.getVin());
                alertt.setPriority("Low");
                if (tirePressureHigh) {
                    alertt.setDescription("your tire pressure is greater than 36psi");
                }
                if (tirePressureLow) {
                    alertt.setDescription("your tire pressure is low than 32psi");
                }
                alertRepository.create(alertt);
            }
            if (r.isEngineCoolantLow() || r.isCheckEngineLightOn()) {
                Alert alertc = new Alert();
                alertc.setVin(veh.getVin());
                alertc.setPriority("Low");
                alertc.setDescription("your engine coolant is low or its light is on");
                alertRepository.create(alertc);
            }
            return r;
        }
    }
}
