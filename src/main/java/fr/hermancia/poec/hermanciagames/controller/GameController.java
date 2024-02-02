package fr.hermancia.poec.hermanciagames.controller;

import fr.hermancia.poec.hermanciagames.DTO.ReviewDTO;
import fr.hermancia.poec.hermanciagames.entity.Game;
import fr.hermancia.poec.hermanciagames.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/game", name = "AppGame")
@AllArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping(path = "/{slug}", name = "show")
    public ModelAndView show(@PathVariable String slug, ModelAndView mav) {
        Game game = gameService.findBySlug(slug);
        // Initialisation du ReviewDTO
        ReviewDTO dto = new ReviewDTO();
        dto.setGameId(game.getId());
        dto.setUserId(1L);
        mav.setViewName("game/show");
        mav.addObject("game", game);
        mav.addObject("reviewDto", dto);
        return mav;
    }
}
