package com.spaceshufflebe.services;

import com.spaceshufflebe.models.dtos.RouteDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    public List<RouteDto> GetRoutes() {

        List<RouteDto> result = new ArrayList<>();
        RouteDto x = new RouteDto(1, "Route 1", "Stup", "SSST");
        RouteDto y = new RouteDto(2, "Route 2", "Malta", "SSST");
        result.add(x);
        result.add(y);
        return result;
    }


    public RouteDto GetRoute(long ID) {
        return new RouteDto(1, "Route 1", "Stup", "SSST");
    }

    public RouteDto CreateRoute(RouteDto route) {
        route.setTakeOffPoint("Alipasino");
        route.setEndPoint("SSST");
        route.setID(3);
        route.setTitle("Route 3");
        return route;
    }

    public RouteDto UpdateRoute(long ID, RouteDto route) {
        route.setTakeOffPoint("SSST");
        route.setEndPoint("Alipasino");
        route.setID(ID);
        return route;
    }

    public void DeleteRoute(long ID) {
        System.out.println("Deleted " + ID);
    }


}
