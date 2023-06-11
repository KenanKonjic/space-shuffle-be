package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.dtos.RideDto;
import com.spaceshufflebe.models.entities.RideEntity;
import com.spaceshufflebe.services.RideService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ride")
@RestController()
@Slf4j
public class RideController {

    private final RideService rideService;

    RideController(RideService rideService){
        this.rideService = rideService;
    }

    @GetMapping("/list")
    ResponseEntity<List<RideEntity>> getRideList() {
        log.info("getRides() called");
        return new ResponseEntity<>(rideService.getRides(), HttpStatus.OK);
    }

    @PostMapping("")
    ResponseEntity<Object> createRide(@RequestBody RideDto ride) throws Exception {
        log.info("createRide() called");
        return new ResponseEntity<>(rideService.createRide(ride), HttpStatus.OK);

    }



}


