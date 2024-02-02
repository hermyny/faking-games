package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.repository.PlatformRepository;
import fr.hermancia.poec.hermanciagames.validator.annotation.UniqueName;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PlatformDTO {



    @NotBlank(
            message = "Veuillez renseigner un nom de variables",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueName(
            repositoryClass = PlatformRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    private String name;


}
