package io.egen.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import io.egen.entity.Readings;
import io.egen.entity.Vehicles;
import io.egen.service.ReadingService;
import io.egen.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/car")
public class CarTrackerController {

    @Autowired
    private VehicleService service;

    @Autowired
    private ReadingService servicer;

    @RequestMapping(method = RequestMethod.POST, value="/readings",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE
                    )
    public Readings create(@RequestBody Readings readings)
    {
          System.out.println(readings);
          return servicer.create(readings);
        //return service.create(emp);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/vehicles",
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update(@RequestBody List<Vehicles> vehicles) {
        for (Vehicles v:vehicles
             ) {
             service.update(v);
        }
        //service.update(vehicles);
        /*if(service.findOne(v.getVin())!= null){
            service.update(v);
        }
        else{
            service.create(v);
        }*/
        //return service.update(empId, emp);
    }

}