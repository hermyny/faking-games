package fr.hermancia.poec.hermanciagames.entity.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SluggerInterface {

    void setSlug (String slug);

    @JsonIgnore
    String getField();

}
