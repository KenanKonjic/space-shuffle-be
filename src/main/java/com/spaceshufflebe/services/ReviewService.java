package com.spaceshufflebe.services;

import com.spaceshufflebe.models.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    public List<ReviewDto> GetReviews() {
        List<ReviewDto> result = new ArrayList<>();
        ReviewDto x = new ReviewDto(22L, 12L, "Excellent driver", 5);
        ReviewDto y = new ReviewDto(23L, 14L, "Late", 3);
        result.add(x);
        result.add(y);
        return result;
    }

    public ReviewDto GetReview(long id){
        return new ReviewDto(id, 23L, "Late", 3);
    }

    public ReviewDto CreateReview(ReviewDto review){
        review.setId(33L);
        review.setReviewText("Okay");
        return review;
    }

    public ReviewDto UpdateReview(long id, ReviewDto review){
        System.out.println("Review found with id " + id);
        review.setId(id);
        review.setRating(5);
        return review;
    }

    public void DeleteReview(long id){
        System.out.println("Deleted " + id);
    }
}
