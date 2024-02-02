package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository
        extends
            JpaRepository<Country, Long>,
            EntityNameRepository<Country>{

    Optional<Country> findBySlug(String slug);

    Optional<Country> findByNameOrCodeOrSlugOrNationality(String name, String code, String slug, String nationality);


}
