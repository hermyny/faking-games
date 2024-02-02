package fr.hermancia.poec.hermanciagames.repository;

import fr.hermancia.poec.hermanciagames.entity.User;
import fr.hermancia.poec.hermanciagames.entity.Validation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValidationRepository extends JpaRepository<Validation, Long> {
    Optional<Validation> findByCode (String code);
}
