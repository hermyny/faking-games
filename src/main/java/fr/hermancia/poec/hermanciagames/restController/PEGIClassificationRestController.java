package fr.hermancia.poec.hermanciagames.restController;

import fr.hermancia.poec.hermanciagames.DTO.PEGIClassificationDTO;
import fr.hermancia.poec.hermanciagames.entity.PEGIClassification;
import fr.hermancia.poec.hermanciagames.service.PEGIClassificationService;
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
@RequestMapping("/apis/classification")
public class PEGIClassificationRestController {

    private PEGIClassificationService classificationService;


    @GetMapping
    public List<PEGIClassification> findAll() {
        return classificationService.findAll();
    }


    @GetMapping(path = "/{field}")
    public Optional<PEGIClassification> showOne(@PathVariable String field) {
        return classificationService.findByField(field);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public PEGIClassification create(@Valid @RequestBody PEGIClassificationDTO pegiDTO) {
        return classificationService.create(pegiDTO, null);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public PEGIClassification  persist(@Valid @RequestBody PEGIClassificationDTO pegiDTO, @PathVariable Long id) {
        return classificationService.create(pegiDTO, id);
    }

}
