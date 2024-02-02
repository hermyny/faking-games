package fr.hermancia.poec.hermanciagames.restController;


import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.DTO.GameDTO;
import fr.hermancia.poec.hermanciagames.entity.Game;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import fr.hermancia.poec.hermanciagames.service.GameService;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/apis/game")
public class GameRestController {

    private GameService gameService;

    @JsonView(JsonViews.GameListShowView.class)
    @GetMapping
    public List<Game> findAll() {
        return gameService.findAll();
    }

    @JsonView(JsonViews.GameListShowView.class)
    @GetMapping(path = "/{field}")
    public Optional<Game> showOne(@PathVariable String field) {

        return gameService.findByField(field);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public Game create(@Valid @RequestBody GameDTO gameDTO) {
        return gameService.create(gameDTO, null);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Game persist(@Valid @RequestBody GameDTO gameDTO, @PathVariable Long id) {
        return gameService.create(gameDTO, id);
    }


}
