package valeriapagliarini.u5d5.runners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import valeriapagliarini.u5d5.entities.Building;
import valeriapagliarini.u5d5.entities.User;
import valeriapagliarini.u5d5.services.BuildingService;
import valeriapagliarini.u5d5.services.UserService;

@Component
@Slf4j

public class Runner implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private BuildingService buildingService;


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


    }
}
