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
    public List<ReviewDto> GetReviews(){
        return reviewService.GetReviews();
    }

    @GetMapping("/{id}")
    public ReviewDto GetReview(@PathVariable long id){return reviewService.GetReview(id);}

    @PostMapping
    public ReviewDto createReview(@RequestBody ReviewDto review){
        return reviewService.CreateReview(review);
    }

    @PutMapping("/{id}")
    public ReviewDto updateReview(@PathVariable long id, @RequestBody ReviewDto review){return reviewService.UpdateReview(id, review);}

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable long id){
        reviewService.DeleteReview(id);
    }
}
