package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.GameDTO;
import fr.hermancia.poec.hermanciagames.entity.Country;
import fr.hermancia.poec.hermanciagames.entity.Game;
import fr.hermancia.poec.hermanciagames.entity.Platform;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService implements DAOServiceInterface<Game> {

    private GameRepository gameRepository;


    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game getObjectById(Long id) {

        Optional<Game> optionalGame = gameRepository.findById(id);
        if(optionalGame.isEmpty()) {
            throw new NotFoundHermanciaGamesException("Game", "id", id);

        }
        return optionalGame.get();
    }

    public Optional<Game> findByField(String field) {
        try {
            Long id = Long.parseLong(field);
            return gameRepository.findById(id);
        } catch (NumberFormatException e) {
            return gameRepository.findByNameOrSlug(field, field);
        }
    }

    public Game create(GameDTO gameDTO, Long id) {
        if (id != null && gameRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                    "Platform", "id", id
            );
        }
        Game game = new Game();
        game.setId(id);
        game.setName(gameDTO.getName());

        return gameRepository.saveAndFlush(game);
    }

    public Game findBySlug(String slug) {
        Optional<Game> optionalGame = gameRepository.findBySlug(slug);
        if(optionalGame.isEmpty()) {
            throw new NotFoundHermanciaGamesException("Game", "slug", slug);
        }
        return optionalGame.get();
    }

    public List<Game> findTop9ByOrderByPublishedAtDesc() {
        return gameRepository.findTop9ByOrderByPublishedAtDesc();
    }

    public List<Game>  findTop8ByOrderByPublishedAtDesc() {
        return gameRepository.findTop8ByOrderByPublishedAtDesc();
    }
}
