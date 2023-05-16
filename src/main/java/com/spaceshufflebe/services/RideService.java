package com.spaceshufflebe.services;
import com.spaceshufflebe.models.RideDto;
import com.spaceshufflebe.models.entities.RideEntity;
import com.spaceshufflebe.repositories.RideRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Component
@Slf4j
@Service
public class RideService {

    private final RideRepository repository;

    public RideService(RideRepository repository) {
        this.repository = repository;
    }

    public RideEntity ReturnEntity(RideDto ride) throws Exception {

        RideEntity rideDb = new RideEntity();
        rideDb.setStartingLocation(ride.getStartingLocation());
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

    public void deleteRide(Integer id) {
        repository.deleteById(id);
    }

    public RideDto updateRide(Integer id, RideDto dto) {
        RideEntity entity = getEntity(id);
        entity.setAvailableSeats(dto.getAvailableSeats());
        entity.setEndLocation(dto.getEndLocation());
        entity.setAvailableSeats(dto.getAvailableSeats());
        entity.setTime(dto.getTime());

        RideEntity ride = repository.save(entity);

        return toDto(ride);
    }

    private static RideDto toDto(RideEntity ride) {
        return new RideDto(ride.getId(),
                ride.getStartingLocation(),
                ride.getEndLocation(),
                ride.getAvailableSeats(),
                ride.getTime());
    }

    private RideEntity getEntity(Integer id) {
        Optional<RideEntity> rideOptional = repository.findById(id);
        if(rideOptional.isPresent()) {
            return rideOptional.get();
        }

        throw new RuntimeException("Ride with id:" + id + " does not exist!");
    }

}
