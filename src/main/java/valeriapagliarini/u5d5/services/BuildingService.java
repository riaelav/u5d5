package valeriapagliarini.u5d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.entities.Building;
import valeriapagliarini.u5d5.exceptions.NotFoundException;
import valeriapagliarini.u5d5.exceptions.ValidationException;
import valeriapagliarini.u5d5.repositories.BuildingRepository;

import java.util.List;

@Service
@Slf4j
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public void saveBuilding(Building building) {

        //controlli generici
        if (building.getBuildingName() == null) {
            throw new ValidationException("Il nome dell'edificio non può essere vuoto.");
        }

        if (building.getCity() == null) {
            throw new ValidationException("La città è obbligatoria.");
        }

        //salvo
        buildingRepository.save(building);

        //log
        log.info("Edificio" + building.getBuildingName() + " salvato correttamente");
    }

    //find all
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }


    //find id custom
    public Building findById(Long buildingId) {
        return buildingRepository.findById(buildingId)
                .orElseThrow(() -> new NotFoundException(buildingId));
    }


}
