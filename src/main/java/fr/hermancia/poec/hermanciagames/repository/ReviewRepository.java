package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReviewRepository
        extends
        JpaRepository<Review, Long>
        {
            Optional<Review> findByTitle(String field);
        }
