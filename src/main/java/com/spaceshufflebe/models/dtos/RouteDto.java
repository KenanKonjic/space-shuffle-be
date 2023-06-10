package com.spaceshufflebe.models.dtos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class RouteDto {
    private long ID;
    private String title;
    private String takeOffPoint;
    private String endPoint;
}
