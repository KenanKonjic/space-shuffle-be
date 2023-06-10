package com.spaceshufflebe.data;

import com.spaceshufflebe.models.entities.Review;
import com.spaceshufflebe.models.dtos.ReviewDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewTest {
    private static Long id1 =1L;
    private static Long userid =2L;
    private static String reviewtext1 = "Good";
    private static int rating1 = 4;

    public static Review review(){
        Review review = new Review();
        review.setId(id1);
        review.setUserId(userid);
        review.setReviewText(reviewtext1);
        review.setRating(rating1);

        return review;
    }

    public static ReviewDto reviewDto1(){
        return new ReviewDto(id1, userid, reviewtext1, rating1);
    }

    public static ReviewDto reviewDto2(){
        return new ReviewDto(2L, 3L, "Late", 2);
    }
}

