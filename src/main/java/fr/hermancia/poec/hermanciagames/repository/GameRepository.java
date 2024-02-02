package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository
        extends
        JpaRepository<Game, Long>,
        EntityNameRepository<Game>{
    Optional<Game> findByNameOrSlug(String field, String field1);

    Optional<Game> findBySlug(String slug);

    List<Game> findTop9ByOrderByPublishedAtDesc();

    List<Game> findTop8ByOrderByPublishedAtDesc();
}
