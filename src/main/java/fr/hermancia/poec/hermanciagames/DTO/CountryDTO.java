package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.repository.CountryRepository;
import fr.hermancia.poec.hermanciagames.validator.annotation.UniqueName;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountryDTO {


    @NotBlank(
            message = "The name must have a value",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueName(
            repositoryClass = CountryRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    private String name;

    @NotBlank(
            message = "Veuillez renseigner une nationalité pour le pays",
            groups = ValidationGroup.OnPutItem.class
    )
    private String nationality;

    @Pattern(
            regexp = "[a-zA-Z]{2}",
            message = "Le code pays ne peut avoir que deux caractères",
            groups = ValidationGroup.OnPutItem.class
    )
    @NotBlank(
            message = "Veuillez renseigner le code",
            groups = ValidationGroup.OnPutItem.class
    )
    private String code;
}
