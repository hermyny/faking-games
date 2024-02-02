package fr.hermancia.poec.hermanciagames.service;

import fr.hermancia.poec.hermanciagames.DTO.EconomicModelDTO;
import fr.hermancia.poec.hermanciagames.entity.EconomicModel;
import fr.hermancia.poec.hermanciagames.exception.NotFoundHermanciaGamesException;
import fr.hermancia.poec.hermanciagames.repository.EconomicModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EconomicModelService implements DAOServiceInterface<EconomicModel> {


    private EconomicModelRepository economicModelRepository;
    @Override
    public List<EconomicModel> findAll() {
        return economicModelRepository.findAll();
    }

    @Override
    public EconomicModel getObjectById(Long id) {
        Optional<EconomicModel> optionalEconomicModel = findByField(id.toString());
        if (optionalEconomicModel.isEmpty()) {
            throw new NotFoundHermanciaGamesException("EconomicModel", "id", id);
        }
        return optionalEconomicModel.get();
    }



    public Optional<EconomicModel> findByField(String string) {

        try {
            Long id = Long.parseLong(string);
            return economicModelRepository.findById(id);
        } catch (NumberFormatException e) {
            return economicModelRepository.findByName(string);
        }
    }


    public EconomicModel create (EconomicModelDTO economicModelDTO, Long id) {
        if (id != null && economicModelRepository.findById(id).isEmpty()) {
            throw new NotFoundHermanciaGamesException(
                    "economicModel", "id", id
            );
        }

        EconomicModel economicModel = new EconomicModel();
        economicModel.setId(id);
        economicModel.setName(economicModelDTO.getName());
        return economicModelRepository.saveAndFlush(economicModel);

    }


}
