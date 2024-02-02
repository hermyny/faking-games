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
public class EconomicModelDTO {

    @NotBlank(
            message = "Veuillez renseigner un nom de modèle économique",
            groups = ValidationGroup.OnPutItem.class
    )
    private String name;
}
