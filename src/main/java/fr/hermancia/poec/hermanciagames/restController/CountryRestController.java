package fr.hermancia.poec.hermanciagames.restController;


import fr.hermancia.poec.hermanciagames.DTO.CountryDTO;
import fr.hermancia.poec.hermanciagames.entity.Country;
import fr.hermancia.poec.hermanciagames.service.CountryService;
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
@RequestMapping("/apis/country")
public class CountryRestController {

    private CountryService countryService;


    @GetMapping
    public List<Country> findAll() {
        return countryService.findAll();
    }



    @GetMapping(path = "/{field}")
    public Optional<Country> showOne(@PathVariable String field) {
        return countryService.findByField(field);
    }





    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public Country create(@Valid @RequestBody CountryDTO countryDTO) {
        return countryService.create(countryDTO, null);
    }



    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Country  persist(@Valid @RequestBody CountryDTO countryDTO, @PathVariable Long id) {
        return countryService.create(countryDTO, id);
    }

}
