package fr.hermancia.poec.hermanciagames.controller;


import fr.hermancia.poec.hermanciagames.DTO.ReviewDTO;
import fr.hermancia.poec.hermanciagames.service.GameService;
import fr.hermancia.poec.hermanciagames.service.ReviewService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping(name = "AppReview")
public class ReviewController {

    private ReviewService reviewService;

    private GameService gameService;

    @PostMapping(value = "/game/{slug}", name = "create")
    public ModelAndView createReview(
            @PathVariable String slug,
            @ModelAttribute("reviewDto") @Valid ReviewDTO reviewDto,
            BindingResult result,
            ModelAndView mav
    ) {
        if (result.hasErrors()) {
            mav.setViewName("game/show");
            mav.addObject("game", gameService.findBySlug(slug));
            return mav;
        }

        reviewService.create(reviewDto);
        mav.setViewName("redirect:/game/" + slug);
        return mav;
    }
}
