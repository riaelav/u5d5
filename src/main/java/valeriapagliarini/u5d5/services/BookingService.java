package valeriapagliarini.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.entities.Booking;
import valeriapagliarini.u5d5.exceptions.NotFoundException;
import valeriapagliarini.u5d5.repositories.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    //TODO!!! metodo per salvare le prenotazioni 


    //find all
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    //find id custom
    public Booking findById(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NotFoundException(bookingId));
    }

}
