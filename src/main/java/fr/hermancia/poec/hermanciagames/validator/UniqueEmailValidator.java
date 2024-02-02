package fr.hermancia.poec.hermanciagames.validator;

import fr.hermancia.poec.hermanciagames.repository.UserRepository;
import fr.hermancia.poec.hermanciagames.validator.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UniqueEmailValidator
        implements ConstraintValidator<UniqueEmail, String> {

    private final UserRepository userRepository;

    private String example;

    @Autowired
    UniqueEmailValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Pour récupérer des valeurs de notre annotation et les réutiliser à l'intérieur
    // de la classe de validation, on doit utiliser la méthode "initialize"
    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        example = constraintAnnotation.example();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("Valeur d'example : " + example);
        return userRepository.findByEmail(email).isEmpty();
    }
}
