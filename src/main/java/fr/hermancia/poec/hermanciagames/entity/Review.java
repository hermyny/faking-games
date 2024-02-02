package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Review {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.ReviewShowView.class)
    private Long id;

    @JsonView(JsonViews.ReviewShowView.class)
    private String content;

    @CreationTimestamp
    @JsonView(JsonViews.ReviewShowView.class)
    private Date createdAt;

    @JsonView(JsonViews.ReviewShowView.class)
    private int downVote = 0;

    @JsonView(JsonViews.ReviewShowView.class)
    private int upVote = 0;

    @JsonView(JsonViews.ReviewShowView.class)
    private double rating;

    @JsonView(JsonViews.ReviewShowView.class)
    private String title;

    @ManyToOne
    @JsonView(JsonViews.ReviewView.class)
    private User user;

    @ManyToOne
    @JsonView(JsonViews.ReviewView.class)
    private Game game;
}
