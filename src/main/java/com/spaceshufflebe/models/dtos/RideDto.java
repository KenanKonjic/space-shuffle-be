package com.spaceshufflebe.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class RideDto {
    private Integer id;
    private String startingLocation;
    private String endLocation;
    private Integer availableSeats;
    private Time time;
}
