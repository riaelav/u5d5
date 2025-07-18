package valeriapagliarini.u5d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "buildings")
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "building_name")
    private String buildingName;

    private String address;
    private String city;

    public Building(String buildingName, String address, String city) {
        this.buildingName = buildingName;
        this.address = address;
        this.city = city;
    }
}
