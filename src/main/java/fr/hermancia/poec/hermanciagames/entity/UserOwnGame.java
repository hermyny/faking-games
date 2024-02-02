package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UserOwnGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.UserProfileView.class)
    private Long id;

    @CreationTimestamp
    @JsonView(JsonViews.UserProfileView.class)
    private Date createdAt;

    @JsonView(JsonViews.UserProfileView.class)
    private int gameTime;

    @UpdateTimestamp
    @JsonView(JsonViews.UserProfileView.class)
    private Date lastUsedAt;

    @JsonView(JsonViews.UserProfileView.class)
    private boolean isInstalled;

    @ManyToOne
    private User user;

    @ManyToOne
    @JsonView(JsonViews.UserProfileView.class)
    private Game game;
}
