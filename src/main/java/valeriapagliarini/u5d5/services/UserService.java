package valeriapagliarini.u5d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.entities.User;
import valeriapagliarini.u5d5.exceptions.ValidationException;
import valeriapagliarini.u5d5.repositories.UserRepository;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //save custom
    public void saveUser(User newUser) {
        // se email già esistente
        if (userRepository.existsByEmail(newUser.getEmail())) {
            throw new ValidationException("Email " + newUser.getEmail() + " già in uso.");
        }

        // se null o minore di due lettere
        if (newUser.getCompleteName() == null || newUser.getCompleteName().length() < 2) {
            throw new ValidationException("Il nome completo deve contenere almeno 2 caratteri.");
        }

        // salvo
        userRepository.save(newUser);

        // log
        log.info("Utente" + newUser.getUsername() + "salvato correttamente");
    }


}
