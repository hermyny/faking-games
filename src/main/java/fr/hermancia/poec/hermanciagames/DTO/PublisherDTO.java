package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.repository.PublisherRepository;
import fr.hermancia.poec.hermanciagames.validator.annotation.PastDate;
import fr.hermancia.poec.hermanciagames.validator.annotation.UniqueName;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublisherDTO {

    @NotBlank(
            message = "Veuillez renseigner un nom valide",
            groups = ValidationGroup.OnPutItem.class
    )
    @UniqueName(
            repositoryClass = PublisherRepository.class,
            groups = ValidationGroup.OnPostItem.class
    )
    private String name;


    @NotNull(message = "Veuillez renseigner une date valide")
    private Date createdAt;


    @Pattern(
            regexp = "((http?|https|ftp|file)://)?((W|w){3}.)?[a-zA-Z0-9]+\\.[a-zA-Z]+",
            message = "Veuillez renseigner un email valide"
    )
    @NotNull(message = "Veuillez renseigner le nom du site internet.")
    private String website;


    @DecimalMin(message = "L'identifiant de la ville ne doit pas être inférieure à 0", value = "1")
    @NotNull(message = "Veuillez renseigner la ville.")
    private Long countryId;

}
