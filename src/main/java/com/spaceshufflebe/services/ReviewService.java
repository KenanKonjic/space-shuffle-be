package com.spaceshufflebe.services;

import com.spaceshufflebe.models.dtos.ReviewDto;
import com.spaceshufflebe.models.entities.Review;
import com.spaceshufflebe.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<ReviewDto> getReviews() {
        List<Review> reviews = repository.findAll();
        List<ReviewDto> result = new ArrayList<>();
        for (Review review : reviews) {
            result.add(toDto(review));
        }
        return result;
    }

    public ReviewDto getReview(long id){
        Review entity = getEntity(id);
        return toDto(entity);
    }

    public ReviewDto createReview(ReviewDto reviewDto){
        Review entity = toEntity(reviewDto);
        Review review = repository.save(entity);
        return toDto(review);
    }

    public ReviewDto updateReview(long id, ReviewDto review){
        System.out.println("Review found with id " + id);
        review.setId(id);
        review.setRating(5);
        return review;
    }

    public void deleteReview(long id){
         repository.deleteById(id);
    }

    private static ReviewDto toDto(Review review) {
        return new ReviewDto(review.getId(),
                review.getUserId(),
                review.getReviewText(),
                review.getRating());
    }
    private static Review toEntity(ReviewDto reviewDto) {
        Review review = new Review();
        review.setRating(reviewDto.getRating());
        review.setReviewText(reviewDto.getReviewText());
        return review;
    }

    private Review getEntity(long id) {
        Optional<Review> reviewOptional = repository.findById(id);
        if(reviewOptional.isPresent()) {
            return reviewOptional.get();
        }

        throw new RuntimeException("Review with id:" + id + " does not exist!");
    }
}
