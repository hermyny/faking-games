package fr.hermancia.poec.hermanciagames.custom_response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseException {

    private int code;

    private String entity;

    private String field;

    private Object value;

    private String message;
}
