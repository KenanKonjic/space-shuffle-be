package com.spaceshufflebe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class RideDto {
    private Long id;
    private String driverName;
    private String startingLocation;
    private String endLocation;
    private Number availableSeats;
    private Date time;
}
