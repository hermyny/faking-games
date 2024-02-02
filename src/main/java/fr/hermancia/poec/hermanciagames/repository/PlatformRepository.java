package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository
        extends
        JpaRepository<Platform, Long>,
        EntityNameRepository<Platform>{
}
