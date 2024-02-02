package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Country;
import fr.hermancia.poec.hermanciagames.entity.PEGIClassification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PEGIClassificationRepository
        extends
        JpaRepository<PEGIClassification, Long>,
        EntityNameRepository<PEGIClassification>{

    Optional<PEGIClassification> findBySlug(String slug);

}
