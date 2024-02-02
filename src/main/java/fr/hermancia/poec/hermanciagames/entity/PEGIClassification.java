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
public class PEGIClassification implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.PegiShowView.class)
    private Long id;

    @JsonView(JsonViews.PegiShowView.class)
    private String name;

    @JsonView(JsonViews.PegiShowView.class)
    private String image;

    @JsonView(JsonViews.PegiShowView.class)
    private String description;


    @JsonView(JsonViews.PegiShowView.class)
    private String slug;


    @Override
    public String getField() {
        return name;
    }
}
