package com.spaceshufflebe.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

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
    private String staringLocation;

    @Column(name = "endLocation", nullable = false)
    private String endLocation;

    @CreationTimestamp
    @Column(name = "availableSeats", updatable = false)
    private Integer availableSeats;

    @UpdateTimestamp
    @Column(name = "datetime")
    private Date updatedAt;
}
