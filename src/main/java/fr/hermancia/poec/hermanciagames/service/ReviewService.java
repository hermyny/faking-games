package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.PlatformDTO;
import fr.hermancia.poec.hermanciagames.DTO.ReviewDTO;
import fr.hermancia.poec.hermanciagames.entity.Platform;
import fr.hermancia.poec.hermanciagames.entity.Review;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ReviewService implements DAOServiceInterface<Review>{


    private ReviewRepository reviewRepository;

    private GameService gameService;

    private UserService userService;



    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getObjectById(Long id) {

        Optional<Review> optionalReview = reviewRepository.findById(id);
            if(optionalReview.isEmpty()) {
                throw new NotFoundHermanciaGamesException("Category", "id", id);
            }
        return optionalReview.get();
    }

    public Optional<Review> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return reviewRepository.findById(id);
        } catch (NumberFormatException e) {
            return reviewRepository.findByTitle(field);
        }
    }

//    public Review create(ReviewDTO reviewDTO, Long id) {
//        if (id != null && reviewRepository.findById(id).isEmpty()) {
//            throw new NotFoundHermanciaGamesException(
//                    "Review", "id", id
//            );
//        }
//        Review review= new Review();
//        review.setId(id);
//        review.setTitle(reviewDTO.getTitle());
//        review.setGame(gameService.getObjectById(reviewDTO.getGameId()));
//        review.setUser(userService.getObjectById(reviewDTO.getUserId()));
//        review.setContent(reviewDTO.getContent());
//        review.setRating(reviewDTO.getRating());
//
//        return reviewRepository.saveAndFlush(review);
//    }

    public Review create(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setGame(gameService.getObjectById(reviewDTO.getGameId()));
        review.setUser(userService.getObjectById(reviewDTO.getUserId()));
        review.setContent(reviewDTO.getContent());
        review.setTitle(reviewDTO.getTitle());
        review.setRating(reviewDTO.getRating());
        return reviewRepository.saveAndFlush(review);
    }
}
