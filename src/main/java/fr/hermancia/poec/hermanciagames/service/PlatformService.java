package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.PlatformDTO;
import fr.hermancia.poec.hermanciagames.entity.Platform;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.PlatformRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PlatformService implements DAOServiceInterface<Platform>{


    private PlatformRepository platformRepository;

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }


    public Page<Platform> findAll(Pageable pageable) {
        return platformRepository.findAll(pageable);
    }
    @Override
    public Platform getObjectById(Long id) {
        Optional<Platform> optionalPlatform = platformRepository.findById(id);
        if(optionalPlatform.isEmpty()) {
            throw new NotFoundHermanciaGamesException("Category", "id", id);
        }
        return optionalPlatform.get();
    }


    public Optional<Platform> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return platformRepository.findById(id);
        } catch (NumberFormatException e) {
            return platformRepository.findByName(field);
        }
    }

    public Platform create(PlatformDTO platformDTO, Long id) {
        if (id != null && platformRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                    "Platform", "id", id
            );
        }
        Platform platform= new Platform();
        platform.setId(id);
        platform.setName(platformDTO.getName());

        return platformRepository.saveAndFlush(platform);
    }



    public PlatformDTO getDTOById(Long id) {
        Platform platform = getObjectById(id);
        PlatformDTO dto = new PlatformDTO();
        dto.setName(platform.getName());
        return dto;
    }


}
