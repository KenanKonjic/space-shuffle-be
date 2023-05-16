package com.spaceshufflebe.services;

import com.spaceshufflebe.data.ReviewTest;
import com.spaceshufflebe.models.ReviewDto;
import com.spaceshufflebe.models.entities.Review;
import com.spaceshufflebe.repositories.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class ReviewServiceUnitTest {

    @MockBean
    private ReviewRepository reviewRepository;

    @TestConfiguration
    static class ReviewServiceTestConfiguration {

        @Bean
        @Primary
        public ReviewService reviewService(ReviewRepository reviewRepository) {
            return new ReviewService(reviewRepository);
        }
    }

    @Autowired
    private ReviewService reviewService;

    @Test
    public void givenReviews_whenGetReviews_thenReviewsShouldBeFound(){
        // arrange
        Mockito.when(reviewRepository.findAll())
                .thenReturn(List.of(ReviewTest.review()));
        //act
        List<ReviewDto> returnedReviews = reviewService.getReviews();

        //assert
        assertThat(returnedReviews).hasSize(1);
    }
    @Test
    public void givenNoReviews_whenGetReviews_thenReviewsShouldBeEmpty() {
        // act
        List<ReviewDto> returnedReviews = reviewService.getReviews();

        // assert
        assertThat(returnedReviews).isEmpty();
    }

    @Test
    public void givenValidId_whenGetReview_thenReviewShouldBeFound() {
        // arrange
        long id = 1L;
        Mockito.when(reviewRepository.findById(id))
                .thenReturn(Optional.of(ReviewTest.review()));

        // act
        ReviewDto resultReview = reviewService.getReview(id);

        // assert
        assertThat(resultReview.getReviewText()).isEqualTo("Good");
    }
    @Test
    public void givenInvalidId_whenGetReview_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> reviewService.getReview(3L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("does not exist");
    }

    @Test
    public void givenReview_whenCreateReview_thenReviewIsReturned() {
        // arrange
        ReviewDto inputReviewDto = ReviewTest.reviewDto1();
        inputReviewDto.setId(0L);
        Review outputReview = ReviewTest.review();

        Mockito.when(reviewRepository.save(any(Review.class)))
                .thenReturn(outputReview);

        // act
        ReviewDto resultReview= reviewService.createReview(inputReviewDto);

        // assert
        assertThat(resultReview).isNotNull();
        assertThat(resultReview.getReviewText()).isEqualTo(inputReviewDto.getReviewText());
        assertThat(resultReview.getId()).isNotEqualTo(0L);
    }
    @Test
    public void givenReview_whenCreateReview_thenRepositoryCalled() {
        // arrange
        ReviewDto reviewDto = ReviewTest.reviewDto2();

        Mockito.when(reviewRepository.save(any(Review.class)))
                .thenReturn(ReviewTest.review());

        // act
        reviewService.createReview(reviewDto);

        // assert
        verify(reviewRepository, times(1)).save(any(Review.class));
    }

    @Test
    public void givenReviewAndValidId_whenUpdate_thenReviewReturned() {
        // arrange
        ReviewDto inputReviewDto = ReviewTest.reviewDto1();
        inputReviewDto.setId(0L);
        long id = 1L;
        Review outputReview = ReviewTest.review();
        outputReview.setId(id);

        Mockito.when(reviewRepository.findById(id))
                .thenReturn(Optional.of(outputReview));
        Mockito.when(reviewRepository.save(any(Review.class)))
                .thenReturn(outputReview);

        // act
        ReviewDto resultReview = reviewService.updateReview(id, inputReviewDto);

        // assert
        assertThat(resultReview).isNotNull();
        assertThat(resultReview.getReviewText()).isEqualTo(inputReviewDto.getReviewText());
        assertThat(resultReview.getId()).isEqualTo(id);
    }

    @Test
    public void givenReview_whenDelete_thenRepositoryCalled() {
        // arrange
        long id = 2L;

        // act
        reviewService.deleteReview(id);

        // assert
        verify(reviewRepository, times(1)).deleteById(id);
    }

}
