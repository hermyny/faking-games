package fr.hermancia.poec.hermanciagames.advisor;

import fr.hermancia.poec.hermanciagames.custom_response.ResponseException;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundResponse {

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY) // Modifie le code HTTP de la réponse
    @ExceptionHandler(NotFoundHermanciaGamesException.class) // L'exception qui doit être "catch"
    ResponseException notFoundResponseHandler(NotFoundHermanciaGamesException e) {
        return new ResponseException(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                e.getType(),
                e.getField(),
                e.getValue(),
                e.getMessage()
        );
    }
}
