package com.spaceshufflebe.data;

import com.spaceshufflebe.models.RideDto;
import com.spaceshufflebe.models.entities.RideEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Time;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RideTest {


    private static Integer id1 = 1;
    private static String startingLocation1 = "Cengic Vila";
    private static String endLocation1 = "SSST";
    private static Integer availableSeats1 = 3;
    private static Time time1 = new Time(10);

    public static RideEntity ride() {
        RideEntity ride = new RideEntity();
        ride.setId(id1);
        ride.setStartingLocation(startingLocation1);
        ride.setEndLocation(endLocation1);
        ride.setAvailableSeats(availableSeats1);
        ride.setTime(time1);
        return ride;
    }

    public static RideDto rideDto1() {
        return new RideDto(id1, startingLocation1, endLocation1, availableSeats1, time1);
    }

    public static RideDto rideDto4() {
        return new RideDto(4, "Barscarsija", "Stup", 1, time1);
    }
}
