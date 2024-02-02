package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.entity.interfaces.SluggerInterface;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Game implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.GameListShowView.class)
    private Long id;

    @JsonView(JsonViews.GameSimpleView.class)
    private String name;

    @JsonView(JsonViews.GameListShowView.class)
    private String description;

    @JsonView(JsonViews.GameSimpleView.class)
    private int price;

    @JsonView(JsonViews.GameListShowView.class)
    private Date publishedAt;

    @JsonView(JsonViews.GameSimpleView.class)
    private String thumbnailCover;

    @JsonView(JsonViews.GameSimpleView.class)
    private String slug;

    @ManyToOne
    @JsonView(JsonViews.GameListShowView.class)
    private Publisher publisher;

    @OneToMany(mappedBy = "game")
    @JsonView(JsonViews.GameListShowView.class)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_platform",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "platform_id")
    )
    @JsonView(JsonViews.GameListShowView.class)
    private List<Platform> platforms = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "game_category",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonView(JsonViews.GameListShowView.class)
    private List<Genre> genreList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "game_country",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id")
    )
    @JsonView(JsonViews.GameListShowView.class)
    private List<Country> countries = new ArrayList<>();


    @ManyToOne
    @JsonView(JsonViews.GameListShowView.class)
    private PEGIClassification PEGIClassification;


    @ManyToMany
    @JoinTable(
            name = "game_economic_model",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "economic_model_id")
    )
    @JsonView(JsonViews.GameListShowView.class)
    private List<EconomicModel> economicModelList = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}
