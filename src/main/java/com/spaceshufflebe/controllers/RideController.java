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

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteRide(@PathVariable Integer id) {
        log.info("deleteRide() called with id: {}", id);
        rideService.deleteRide(id);
        return new ResponseEntity<>("Ride deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<RideDto> updateRide(@PathVariable Integer id, @RequestBody RideDto dto) {
        log.info("updateRide() called with id: {}", id);
        RideDto updatedRide = rideService.updateRide(id, dto);
        return new ResponseEntity<>(updatedRide, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<String> reserveSeat(@PathVariable Integer id){
        return rideService.reserveSeat(id);
    }



}


