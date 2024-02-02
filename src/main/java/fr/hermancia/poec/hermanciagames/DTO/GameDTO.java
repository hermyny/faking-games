package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.entity.Genre;
import fr.hermancia.poec.hermanciagames.entity.Country;
import fr.hermancia.poec.hermanciagames.entity.EconomicModel;
import fr.hermancia.poec.hermanciagames.entity.Platform;
import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDTO {


    @NotBlank(
            message = "Veuillez renseigner le nom du jeu",
            groups = ValidationGroup.OnPutItem.class
    )
    private String name;


    private String description;

    @NotBlank(
            message = "Veuillez renseigner le prix du jeu",
            groups = ValidationGroup.OnPutItem.class
    )
    @DecimalMin(message = "Vous ne pouvez pas renseigner un prix inférieur à 0", value = "0")
    private int price;

    @NotBlank(
            message = "Veuillez renseigner une date valide",
            groups = ValidationGroup.OnPutItem.class
    )
    private Date publishedAt;

    private String thumbnailCover;

    @NotBlank(
            message = "Veuillez renseigner le nom d'un éditeur pour ce jeu",
            groups = ValidationGroup.OnPutItem.class
    )
    private Long publisher_id;

    private List<Platform> platforms = new ArrayList<>();

    private List<Genre> genreList = new ArrayList<>();

    private List<Country> countries = new ArrayList<>();

    private Long pegiclassification_id;

    private List<EconomicModel> economicModelList = new ArrayList<>();





}
