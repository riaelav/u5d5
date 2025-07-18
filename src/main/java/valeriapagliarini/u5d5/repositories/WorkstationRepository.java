package valeriapagliarini.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valeriapagliarini.u5d5.entities.Building;
import valeriapagliarini.u5d5.entities.Workstation;
import valeriapagliarini.u5d5.enums.WorkstationType;

import java.util.List;

public interface WorkstationRepository extends JpaRepository<Workstation, Long> {

    List<Workstation> findByTypeAndBuilding(WorkstationType type, Building building);


}
