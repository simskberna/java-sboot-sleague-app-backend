package com.example.nwsl_zone.reviews;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "api/v1/reviews")
public class ReviewsController {
    private final ReviewsService reviewsService;

    @Autowired
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public Page<Review> getReviews(
            Pageable pageable,
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String date

    ) {
//        if(id != null){
//            return reviewsService.getReviewsById(id);
//        }
//        else if(date != null){
//            return reviewsService.getReviewsByDate(date);
//        }
        return reviewsService.getReviews(pageable);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(
            @PathVariable Integer reviewId
    ){
        reviewsService.deleteReview(reviewId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }
}
