package com.spaceshufflebe.controllers;

import com.spaceshufflebe.models.ReviewDto;
import com.spaceshufflebe.services.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@RestController()
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {this.reviewService = reviewService;}

    @GetMapping("/list")
    public List<ReviewDto> getReviews(){
        return reviewService.getReviews();
    }

    @GetMapping("/{id}")
    public ReviewDto getReview(@PathVariable long id){return reviewService.getReview(id);}

    @PostMapping
    public ReviewDto createReview(@RequestBody ReviewDto review){
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public ReviewDto updateReview(@PathVariable long id, @RequestBody ReviewDto review){return reviewService.updateReview(id, review);}

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable long id){
        reviewService.deleteReview(id);
    }
}
