package fr.hermancia.poec.hermanciagames.restController;

import fr.hermancia.poec.hermanciagames.DTO.PlatformDTO;
import fr.hermancia.poec.hermanciagames.entity.Platform;
import fr.hermancia.poec.hermanciagames.service.PlatformService;
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
@RequestMapping("/apis/platform")
public class PlatformRestController {

    private PlatformService platformService;

    @GetMapping
    public List<Platform> findAll() {return platformService.findAll(); }


    @GetMapping(path = "/{field}")
    public Optional<Platform> showOne(@PathVariable String field) {
        return platformService.findByField(field);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/create")
    @Validated(ValidationGroup.OnPostItem.class)
    public Platform create(@Valid @RequestBody PlatformDTO platformDTO) {
        return platformService.create(platformDTO, null);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PutMapping("/update/{id}")
    @Validated(ValidationGroup.OnPutItem.class)
    public Platform  persist(@Valid @RequestBody PlatformDTO platformDTO, @PathVariable Long id) {
        return platformService.create(platformDTO, id);
    }
}
