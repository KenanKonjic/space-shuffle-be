package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.RouteDto;
import com.spaceshufflebe.services.RouteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/routes")
@RestController()
public class RouteController {

    private final RouteService routeService;

    RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping("/list")
    public List<RouteDto> getRoutes(){
        return routeService.GetRoutes();
    }

    @GetMapping("/{id}")
    public RouteDto getRoute(@PathVariable long id){
        return routeService.GetRoute(id);
    }

    @PostMapping
    public RouteDto createRoute(@RequestBody RouteDto route){
        return routeService.CreateRoute(route);
    }

    @PutMapping("/{id}")
    public RouteDto updateRoute(@PathVariable long id, @RequestBody RouteDto route){
        return routeService.UpdateRoute(id, route);
    }
    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable long id){
        routeService.DeleteRoute(id);
    }

}
