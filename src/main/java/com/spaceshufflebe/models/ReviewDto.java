package com.spaceshufflebe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private Long userId;
    private String reviewText;
    private int rating;
}
