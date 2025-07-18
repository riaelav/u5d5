package valeriapagliarini.u5d5.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.entities.Booking;
import valeriapagliarini.u5d5.entities.User;
import valeriapagliarini.u5d5.entities.Workstation;
import valeriapagliarini.u5d5.exceptions.BookingConflictException;
import valeriapagliarini.u5d5.exceptions.NotFoundException;
import valeriapagliarini.u5d5.repositories.BookingRepository;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    //save
    public Booking createBooking(User user, Workstation workstation, LocalDate bookingDate) {

        if (bookingRepository.findByUserAndBookingDate(user, bookingDate).isPresent()) {
            throw new BookingConflictException("User already has a booking on " + bookingDate);
        }

        if (bookingRepository.findByWorkstationAndBookingDate(workstation, bookingDate).isPresent()) {
            throw new BookingConflictException("Workstation is already booked on " + bookingDate);
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setWorkstation(workstation);
        booking.setBookingDate(bookingDate);

        Booking savedBooking = bookingRepository.save(booking);
        log.info(" Booking saved");
        return savedBooking;
    }


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
