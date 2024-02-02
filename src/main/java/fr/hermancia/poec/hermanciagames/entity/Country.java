package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Country implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.CountryDetailView.class)
    private Long id;

    private String code;

    @JsonView(JsonViews.CountryDetailView.class)
    private String name;


    private String nationality;

    @JsonView(JsonViews.CountryDetailView.class)
    private String slug;

    @JsonView(JsonViews.CountryDetailView.class)
    private String urlFlag;



    @Override
    public String getField() {
        return name;
    }


}
