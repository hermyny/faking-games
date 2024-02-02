package fr.hermancia.poec.hermanciagames.DTO;

import fr.hermancia.poec.hermanciagames.validator.group.ValidationGroup;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserUpdateProfIleDTO {

//    @Pattern(
//            regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\d)(?=.[@$!%?&])[A-Za-z\d@$!%?&]{8,}$",
//            message = "Votre mot de passe doit contenir au moins huit caractères dont un caractère spécial, une lettre minuscule, une lettre majuscule et un chiffre",
//            groups = ValidationGroup.OnPutItem.class
//    )
    @Size(message = "Le mot de passe doit contenir au moins 8 caractères.", min = 9)
    private String password;

    private String nickname;

    private String profileImage;

    private Long countryId;


}
