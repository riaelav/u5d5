package valeriapagliarini.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valeriapagliarini.u5d5.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
