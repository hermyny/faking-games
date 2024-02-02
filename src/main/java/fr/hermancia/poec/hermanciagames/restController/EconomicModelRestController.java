package fr.hermancia.poec.hermanciagames.restController;

import fr.hermancia.poec.hermanciagames.DTO.EconomicModelDTO;
import fr.hermancia.poec.hermanciagames.entity.EconomicModel;
import fr.hermancia.poec.hermanciagames.service.EconomicModelService;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping("/apis/economic_model")
public class EconomicModelRestController {

    private EconomicModelService economicModelService;


    @GetMapping
    public List<EconomicModel> findAll() {
        return economicModelService.findAll();
    }

    @GetMapping(path = "/{field}")
    public Optional<EconomicModel> showOne(@PathVariable String field) {
        return economicModelService.findByField(field);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public EconomicModel create(@Valid @RequestBody EconomicModelDTO economicModelDTO) {
        return economicModelService.create(economicModelDTO, null);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public EconomicModel  persist(@Valid @RequestBody EconomicModelDTO economicModelDTO, @PathVariable Long id) {
        return economicModelService.create(economicModelDTO, id);
    }

}



