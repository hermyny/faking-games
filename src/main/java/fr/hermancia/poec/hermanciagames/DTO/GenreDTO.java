package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.repository.GenreRepository;
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
public class GenreDTO {

    @NotBlank(
            message = "Veuillez renseigner un nom de catégorie.",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueName(
            repositoryClass = GenreRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    private String name;

    @NotBlank(
            message = "Veuillez rajouter une image à cette catégorie.",
            groups = ValidationGroup.OnPutItem.class
    )
    private String image;


}
