package fr.hermancia.poec.hermanciagames.restController;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.entity.Review;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import fr.hermancia.poec.hermanciagames.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/apis/review")
public class ReviewRestController {

    private ReviewService reviewService;

    @JsonView(JsonViews.ReviewAllView.class)
    @GetMapping
    public List<Review> findAll() {
        return reviewService.findAll();
    }

}
