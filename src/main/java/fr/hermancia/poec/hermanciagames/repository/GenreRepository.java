package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository
        extends
        JpaRepository<Genre, Long>,
        EntityNameRepository<Genre>{


    Optional<Genre> findBySlugOrName(String slug, String name);

    Optional<Genre> findBySlug(String slug);
}
