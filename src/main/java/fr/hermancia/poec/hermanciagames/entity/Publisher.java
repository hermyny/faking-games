package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Publisher implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.PublisherAllView.class)
    private Long id;


    @JsonView(JsonViews.PublisherAllView.class)
    private Date createdAt;

    @JsonView(JsonViews.PublisherShowView.class)
    private String name;

    @JsonView(JsonViews.PublisherShowView.class)
    private String slug;

    @JsonView(JsonViews.PublisherAllView.class)
    private String website;

    @ManyToOne
    @JsonView(JsonViews.PublisherAllView.class)
    private Country country;

    @OneToMany(mappedBy = "publisher")
    @JsonView(JsonViews.PublisherAllView.class)
    private List<Game> games = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}
