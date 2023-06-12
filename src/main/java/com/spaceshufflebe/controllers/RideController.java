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
    public ResponseEntity<String> updateRide(@PathVariable Integer id) {
        try {
            rideService.updateRide(id);
            return ResponseEntity.ok("Ride updated successfully!");
        } catch (RuntimeException e) {
            // Handle any exceptions or errors that may occur during the update process
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update ride: " + e.getMessage());
        }
    }

    @GetMapping("/reserve/{id}")
    ResponseEntity<String> reserveSeat(@PathVariable Integer id){
        return rideService.reserveSeat(id);
    }



}


