package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.PEGIClassificationDTO;
import fr.hermancia.poec.hermanciagames.entity.PEGIClassification;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.PEGIClassificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PEGIClassificationService implements DAOServiceInterface<PEGIClassification>{

    private PEGIClassificationRepository classificationRepository;


    @Override
    public List<PEGIClassification> findAll() {
        return classificationRepository.findAll();
    }

    @Override
    public PEGIClassification getObjectById(Long id) {

        Optional<PEGIClassification> optionalPEGIClassification = classificationRepository.findById(id);
        if (optionalPEGIClassification.isEmpty()) {
            throw new NotFoundHermanciaGamesException("PEGIClassification", "id", id);
        }
        return optionalPEGIClassification.get();
    }

    public Optional<PEGIClassification>findByField(String string) {
        try {
            Long id = Long.parseLong(string);
            return classificationRepository.findById(id);
        } catch (NumberFormatException e) {
            return classificationRepository.findBySlug(string);
        }
    }

    public PEGIClassification create (PEGIClassificationDTO pegiDTO, Long id) {
        if (id != null && classificationRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                    "PEGIClassification", "id", id
            );
        }

        PEGIClassification classification = new PEGIClassification();
        classification.setId(id);
        classification.setName(pegiDTO.getName ());
        classification.setImage(pegiDTO.getImage());
        classification.setDescription(pegiDTO.getDescription());

        return classificationRepository.saveAndFlush(classification);
    }
}





