package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.RideDto;
import com.spaceshufflebe.services.RideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rides")
@RestController()
public class RideController {

    private final RideService rideService;

    RideController(RideService rideService){
        this.rideService = rideService;
    }

    @GetMapping("/list")
    public List<RideDto> getRides(){
        return rideService.GetRides();
    }

    @GetMapping("/{id}")
    public RideDto getRide(@PathVariable long id){
        return rideService.GetRide(id);
    }

    @PostMapping
    public RideDto createRide(@RequestBody RideDto ride){
        return rideService.CreateRide(ride);
    }

    @PutMapping("/{id}")
    public RideDto updateRide(@PathVariable long id, @RequestBody RideDto ride){
        return rideService.UpdateRide(id, ride);
    }

    @DeleteMapping("/{id}")
    public void deleteRide(@PathVariable long id){
        rideService.DeleteRide(id);
    }
}
