package fr.hermancia.poec.hermanciagames.restController;

import fr.hermancia.poec.hermanciagames.DTO.GenreDTO;
import fr.hermancia.poec.hermanciagames.entity.Genre;
import fr.hermancia.poec.hermanciagames.service.GenreService;
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
@RequestMapping("/apis/genre")
public class GenreRestController {


    private GenreService genreService;

    @GetMapping
    public List<Genre> findAll() {
        return genreService.findAll();
    }


    @GetMapping(path = "/{field}")
    public Optional<Genre> showOne(@PathVariable String field) {
        return genreService.findByField(field);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public Genre create(@Valid @RequestBody GenreDTO genreDTO) {
        return genreService.create(genreDTO, null);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Genre persist(@Valid @RequestBody GenreDTO genreDTO, @PathVariable Long id) {
        return genreService.create(genreDTO, id);
    }

}
