package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository
        extends
        JpaRepository<Publisher, Long>,
        EntityNameRepository<Publisher>{
    Optional<Publisher> findBySlugOrName(String field, String field1);
}
