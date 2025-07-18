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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(name = "complete_name")
    private String completeName;

    private String email;

    public User(String username, String completeName, String email) {
        this.username = username;
        this.completeName = completeName;
        this.email = email;
    }
}
