package fr.hermancia.poec.hermanciagames.exception;

import lombok.Getter;

@Getter
public class NotFoundHermanciaGamesException extends RuntimeException {

        private final String type;

        private final String field;

        private final Object value;

        public NotFoundHermanciaGamesException(String type, String field, Object value) {
            super("L'élément que vous recherchez n'existe pas");
            this.type = type;
            this.field = field;
            this.value = value;
        }
}
