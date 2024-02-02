package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.GenreDTO;
import fr.hermancia.poec.hermanciagames.entity.Genre;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GenreService implements DAOServiceInterface<Genre>{


    private GenreRepository categoryRepository;

    @Override
    public List<Genre> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Genre getObjectById(Long id) {

        Optional<Genre> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()) {
            throw new NotFoundHermanciaGamesException("Category", "id", id);
        }

        return optionalCategory.get();
    }

    public Optional<Genre> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return categoryRepository.findById(id);
        } catch (NumberFormatException e) {
            return categoryRepository.findBySlugOrName(field, field);
        }
    }


    public Genre create(GenreDTO categoryDTO, Long id) {
        if (id != null && categoryRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                    "Category", "id", id
            );
        }

        Genre category = new Genre();
        category.setId(id);
        category.setName(categoryDTO.getName ());
        category.setImage(categoryDTO.getImage());
        return categoryRepository.saveAndFlush(category);
    }


}
