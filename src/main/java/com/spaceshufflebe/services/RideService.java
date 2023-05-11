package com.spaceshufflebe.services;
import com.spaceshufflebe.models.RideDto;
import com.spaceshufflebe.models.entities.RideEntity;
import com.spaceshufflebe.repositories.RideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Component
@Slf4j
@Service
public class RideService {
    @Autowired
    RideRepository repository;

    public RideEntity ReturnEntity(RideDto ride) throws Exception {

        RideEntity rideDb = new RideEntity();
        rideDb.setStaringLocation(ride.getStartingLocation());
        rideDb.setAvailableSeats(ride.getAvailableSeats());
        rideDb.setEndLocation(ride.getEndLocation());
        return rideDb;
    }

    public RideEntity createRide(RideDto ride) throws Exception {

        RideEntity rideDb = this.ReturnEntity(ride);

        return repository.save(rideDb);

    }

    public List<RideEntity> getRides() {
        log.info("getRides() called");
        return repository.findAll();
    }
}
