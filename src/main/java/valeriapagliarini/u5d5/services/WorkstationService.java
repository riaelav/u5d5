package valeriapagliarini.u5d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.entities.Workstation;
import valeriapagliarini.u5d5.exceptions.ValidationException;
import valeriapagliarini.u5d5.repositories.WorkstationRepository;

@Service
@Slf4j

public class WorkstationService {
    @Autowired
    private WorkstationRepository workstationRepository;

    //save custom
    public void saveWorkstation(Workstation workstation) {

        //controlli generici validazione dei campi

        if (workstation.getDescription() == null) {
            throw new ValidationException("La descrizione della postazione è obbligatoria");
        }

        if (workstation.getType() == null) {
            throw new ValidationException("Il tipo di postazione è obbligatorio");

        }
        if (workstation.getMaxNumbPeople() <= 0) {
            throw new ValidationException("Il numero massimo di occupanti deve essere maggiore di zero.");
        }

        if (workstation.getBuilding() == null) {
            throw new ValidationException("La postazione deve essere associata a un edificio.");
        }
        //salvo e log
        workstationRepository.save(workstation);

        // 3. Log
        log.info("Postazione salvata con successo in edificio" + workstation.getBuilding().getBuildingName());
    }

}



