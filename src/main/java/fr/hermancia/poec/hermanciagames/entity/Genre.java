package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "category")
@Entity
public class Genre implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.PublisherAllView.class)
    private Long id;

    @JsonView(JsonViews.CategoryView.class)
    private String image;

    @JsonView(JsonViews.CategoryMinimalView.class)
    private String name;

    @JsonView(JsonViews.CategoryMinimalView.class)
    private String slug;

    @Override
        public String getField() {
            return name;
        }
    }
