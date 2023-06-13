package com.spaceshufflebe.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RideEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "startingLocation", nullable = false, unique = true)
    private String startingLocation;

    @Column(name = "endLocation", nullable = false)
    private String endLocation;

    @Column(name = "availableSeats", updatable = false)
    private Integer availableSeats;

    @Column(name = "time")
    private String time;

}
