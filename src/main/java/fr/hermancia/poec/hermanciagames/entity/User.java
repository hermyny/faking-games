package fr.hermancia.poec.hermanciagames.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.hermanciagames.json_views.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.UserProfileView.class)
    private Long id;

    @JsonView(JsonViews.UserProfileView.class)
    private String name;

    @JsonView(JsonViews.UserMinimalView.class)
    private String nickname;

    @CreationTimestamp
    @JsonView(JsonViews.UserProfileView.class)
    private Date createdAt;

    @JsonView(JsonViews.UserProfileView.class)
    private String email;

    private String password;

    @JsonView(JsonViews.UserMinimalView.class)
    private String profileImage;


    @JsonView(JsonViews.UserProfileView.class)
    private String role = "[]";

    @JsonView(JsonViews.UserProfileView.class)
    private double wallet = 0;

    @JsonView(JsonViews.UserProfileView.class)
    private boolean isActive = false;

    @ManyToOne
    @JsonView(JsonViews.UserProfileView.class)
    private Country country;

    @ManyToMany
    @JoinTable(
            name = "user_wish_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id")
    )
    @JsonView(JsonViews.UserProfileView.class)
    private List<Game> wantedGames = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViews.UserProfileView.class)
    private List<Review> reviews = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    @JsonView(JsonViews.UserProfileView.class)
    private List<UserOwnGame> userOwnGames = new ArrayList<>();
    @JsonView(JsonViews.UserListView.class)
    public int getNbGames() {
        return this.userOwnGames.size();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isActive;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isActive;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
