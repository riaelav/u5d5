package valeriapagliarini.u5d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import valeriapagliarini.u5d5.enums.WorkstationType;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "workstations")
public class Workstation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private WorkstationType type;

    @Column(name = "max_numb_people")
    private int maxNumbPeople;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Workstation(String description, WorkstationType type, int maxNumbPeople, Building building) {
        this.description = description;
        this.type = type;
        this.maxNumbPeople = maxNumbPeople;
        this.building = building;
    }
}
