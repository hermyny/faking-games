package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.entity.Game;
import fr.hermancia.poec.hermanciagames.entity.User;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDTO {


    @NotBlank
    private String title;

    @NotBlank
    private String content;

//    @Positive(message = "The user id has to be positive")
    @NotNull(message = "Un identifiant de jeu est requis")
    private Long gameId;


//    @Positive(message = "The user id has to be positive")
    @NotNull(message = "L'utilisateur est requis")
    private Long userId;


    @DecimalMin(
            value = "0",
            message= "The rating should be at least 0"
    )
    @DecimalMax(
            value = "5",
            message= "The rating should be 5 at max"
    )
    @NotNull
    private double rating;



}
