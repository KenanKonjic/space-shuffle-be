package com.spaceshufflebe.services;

import com.spaceshufflebe.models.ReviewDto;
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

    public List<ReviewDto> GetReviews() {
        List<ReviewDto> result = new ArrayList<>();
        ReviewDto x = new ReviewDto(22L, 12L, "Excellent driver", 5);
        ReviewDto y = new ReviewDto(23L, 14L, "Late", 3);
        result.add(x);
        result.add(y);
        return result;
//        List<Review> reviews = ReviewRepository.findAll();
//        List<ReviewDto> result = new ArrayList<>();
//        for (Review review : reviews) {
//            result.add(toDto(review));
//        }
//        return result;
    }

    public ReviewDto GetReview(long id){

        return new ReviewDto(id, 23L, "Late", 3);
//        Review entity = getEntity(id);
//        return toDto(entity);
    }

    public ReviewDto CreateReview(ReviewDto review){
        review.setId(33L);
        review.setReviewText("Okay");
        return review;

//        Review entity = toEntity(reviewDto);
//        Review review = ReviewRepository.save(entity);
//        return toDto(review);
    }

    public ReviewDto UpdateReview(long id, ReviewDto review){
        System.out.println("Review found with id " + id);
        review.setId(id);
        review.setRating(5);
        return review;
    }

    public void DeleteReview(long id){
        System.out.println("Deleted " + id);
        // ReviewRepository.deleteById(id);
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

//    private Review getEntity(long id) {
//        Optional<Review> reviewOptional = ReviewRepository.findById(id);
//        if(reviewOptional.isPresent()) {
//            return reviewOptional.get();
//        }
//
//        throw new RuntimeException("Review with id:" + id + " does not exist!");
//    }
}
