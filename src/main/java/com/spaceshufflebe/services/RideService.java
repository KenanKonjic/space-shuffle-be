package com.spaceshufflebe.services;

import com.spaceshufflebe.models.RideDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RideService {



        private Map<Long, RideDto> rides = new HashMap<>();
        private long lastRideId = 0;

        public RideDto createRide(RideDto ride) {
            ride.setId(lastRideId++);
            rides.put(ride.getId(), ride);
            return ride;
        }

        public RideDto getRide(long id) {
            return rides.get(id);
        }

//    public List<RideDto> getRides(long rideId) {
//        return rides.get(rideId);
//    }
}
