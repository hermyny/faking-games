package fr.hermancia.poec.hermanciagames.DTO;

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
public class PEGIClassificationDTO {


    @NotBlank(
            message = "Veuillez renseigner un nom de classification",
            groups = ValidationGroup.OnPutItem.class
    )
    private String name;

    private String description;

    private String image;

}
