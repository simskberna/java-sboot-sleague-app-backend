package com.example.nwsl_zone.reviews;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Component
public class ReviewsService {
    private final ReviewsRepository reviewsRepository;

    @Autowired
    public ReviewsService(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }
    public Page<Review> getReviews(Pageable pageable) {
        return reviewsRepository.findAll(pageable);
    }
//    public List<Review> getReviewsById(Integer id){
//        return reviewsRepository.findAll().stream()
//                .filter(review -> review.getId().equals(id))
//                .collect(Collectors.toList());
//    }
//    public List<Review> getReviewsByDate(String date) {
//        //date format dd/MM/yyyy
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDateTime dateTime = LocalDateTime.parse(date + "T00:00:00", formatter);
//
//        return reviewsRepository.findAll().stream()
//                .filter(review -> review.getDate().toLocalDate().isEqual(dateTime
//                        .toLocalDate()))
//                .collect(Collectors.toList());
//    }
    @Transactional
    public void deleteReview(Integer reviewId) {
        reviewsRepository.deleteById(reviewId);
    }
}
