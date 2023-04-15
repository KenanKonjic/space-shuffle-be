package com.spaceshufflebe.services;

import com.spaceshufflebe.models.RideDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RideService {

    public List<RideDto> GetRides(){
        List<RideDto> result = new ArrayList<>();
        RideDto x = new RideDto(42L, "Adna", "Cengic Vila", "SSST", 3, new Date());
        RideDto y = new RideDto(22L, "Amra", "Stup", "SSST", 1, new Date());
        result.add(x);
        result.add(y);
        return result;
    }

    public RideDto GetRide(long id){
        return new RideDto(id, "Adna", "Cengic Vila", "SSST", 3, new Date());
    }

    public RideDto CreateRide(RideDto ride){
        ride.setAvailableSeats(2);
        ride.setId(23L);
        return ride;
    }

    public RideDto UpdateRide(long id, RideDto ride){
        System.out.println("Ride found with id " + id);
        ride.setId(id);
        ride.setAvailableSeats(1);
        return ride;
    }

    public void DeleteRide(long id){
        System.out.println("Deleted " + id);
    }
}
