package valeriapagliarini.u5d5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Entity with ID " + id + " not found.");
    }
}