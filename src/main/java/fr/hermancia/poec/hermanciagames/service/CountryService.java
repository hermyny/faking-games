package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.CountryDTO;
import fr.hermancia.poec.hermanciagames.entity.Country;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService implements DAOServiceInterface<Country> {

    private CountryRepository countryRepository;


    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }


    @Override
    public Country getObjectById(Long id) {
        Optional<Country> optionalCountry = findByField(id.toString());
        if (optionalCountry.isEmpty()) {
            throw new NotFoundHermanciaGamesException("Country", "id", id);
        }
        return optionalCountry.get();
    }


    public Optional<Country> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return countryRepository.findById(id);
        } catch (NumberFormatException e) {
            return countryRepository.findByNameOrCodeOrSlugOrNationality(field, field, field, field);
        }
    }


    public Country create(CountryDTO countryDTO, Long id) {
        if (id != null && countryRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                    "Country", "id", id
            );
        }

        Country country = new Country();
        country.setId(id);
        country.setName(countryDTO.getName());
        country.setNationality(countryDTO.getNationality());
        country.setCode(countryDTO.getCode().toLowerCase());
        country.setUrlFlag("https://flagcdn.com/32x24/" + countryDTO.getCode().toLowerCase() + ".png");
        return countryRepository.saveAndFlush(country);
    }




}
