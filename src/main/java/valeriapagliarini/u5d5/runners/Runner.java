package valeriapagliarini.u5d5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import valeriapagliarini.u5d5.entities.Building;
import valeriapagliarini.u5d5.entities.User;
import valeriapagliarini.u5d5.entities.Workstation;
import valeriapagliarini.u5d5.enums.WorkstationType;
import valeriapagliarini.u5d5.services.BuildingService;
import valeriapagliarini.u5d5.services.UserService;
import valeriapagliarini.u5d5.services.WorkstationService;

@Component
@Slf4j

public class Runner implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private WorkstationService workstationService;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("caraxes", "Daemon Targaryen", "daemon.targaryen@kingslandin.com");
        User user2 = new User("syrax", "Rhaenyra Targaryen", "rhaenyra.targaryen@kingslandin.com");
        User user3 = new User("alicent", "Alicent Hightower", "alicent.hightower@kingslandin.com");
        User user4 = new User("vhagar", "Aemond Targaryen", "aemond.targaryen@kingslanding.com");
        User user5 = new User("meleys", "Corlys Velaryon", "corlys.velaryon@kingslandin.com");

       /*serService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(user5);*/


        Building building1 = new Building("Red Keep", "A castle in King’s Landing, seat of the Targaryen monarchy.", "King's Landing"
        );
        Building building2 = new Building("Dragonstone castle", "The Targaryen castle on a volcanic island", "Dragonstone");
        Building building3 = new Building("Driftmark castle", "Island home of House Velaryon.", "Driftmark");
        Building building4 = new Building("Castle Black", "The main stronghold of the Night's Watch", "The Wall");
        Building building5 = new Building("Winterfell castle", "The ancient seat of House Stark", "Winterfell");

       /* buildingService.saveBuilding(building1);
        buildingService.saveBuilding(building2);
        buildingService.saveBuilding(building3);
        buildingService.saveBuilding(building4);
        buildingService.saveBuilding(building5);*/

//recupero dati dal db
        Building redKeep = buildingService.findById(1L);
        Building dragonstone = buildingService.findById(2L);
        Building driftmark = buildingService.findById(3L);
        Building castleBlack = buildingService.findById(4L);
        Building winterfell = buildingService.findById(5L);

        Workstation ws1 = new Workstation("Strategic War Room", WorkstationType.MEETING_ROOM, 12, redKeep);
        Workstation ws2 = new Workstation("Dragonstone Observatory", WorkstationType.OPENSPACE, 6, dragonstone);
        Workstation ws3 = new Workstation("Corlys' Private Office", WorkstationType.PRIVATE, 1, driftmark);
        Workstation ws4 = new Workstation("Castle Black Training Hall", WorkstationType.MEETING_ROOM, 10, castleBlack);
        Workstation ws5 = new Workstation("Winterfell Strategy Desk", WorkstationType.PRIVATE, 2, winterfell);
        Workstation ws6 = new Workstation("Dragonpit Arena", WorkstationType.OPENSPACE, 100, redKeep);

        workstationService.saveWorkstation(ws1);
        workstationService.saveWorkstation(ws2);
        workstationService.saveWorkstation(ws3);
        workstationService.saveWorkstation(ws4);
        workstationService.saveWorkstation(ws5);
        workstationService.saveWorkstation(ws6);


    }
}
