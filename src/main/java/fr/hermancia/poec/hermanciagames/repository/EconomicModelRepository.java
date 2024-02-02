package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.EconomicModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EconomicModelRepository
        extends
        JpaRepository<EconomicModel, Long>,
        EntityNameRepository<EconomicModel>{
    Optional<EconomicModel> findByName(String string);
}
