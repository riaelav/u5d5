package valeriapagliarini.u5d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.entities.Building;
import valeriapagliarini.u5d5.exceptions.ValidationException;
import valeriapagliarini.u5d5.repositories.BuildingRepository;

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


}
