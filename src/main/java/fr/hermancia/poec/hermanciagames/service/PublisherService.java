package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.PublisherDTO;
import fr.hermancia.poec.hermanciagames.entity.Publisher;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PublisherService implements DAOServiceInterface<Publisher>{


    private CountryService countryService;

    private PublisherRepository publisherRepository;


    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }


    @Override
    public Publisher getObjectById(Long id) {

        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if(optionalPublisher.isEmpty()) {
            throw new NotFoundHermanciaGamesException("Publisher", "id", id);
        }
        return optionalPublisher.get();
    }


    public Optional<Publisher> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return publisherRepository.findById(id);
        } catch (NumberFormatException e) {
            return publisherRepository.findBySlugOrName(field, field);
        }
    }

    public Publisher create(PublisherDTO publisherDTO, Long id) {
        if (id != null && publisherRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                   "Category", "id", id
            );
        }

        Publisher publisher = new Publisher();
        publisher.setId(id);
        publisher.setName(publisherDTO.getName ());
        publisher.setCreatedAt(publisherDTO.getCreatedAt());
        publisher.setWebsite(publisherDTO.getWebsite());
        publisher.setCountry(countryService.getObjectById(publisherDTO.getCountryId()));

        return publisherRepository.saveAndFlush(publisher);
        }

    }

