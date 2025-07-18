package valeriapagliarini.u5d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import valeriapagliarini.u5d5.entities.Booking;
import valeriapagliarini.u5d5.entities.User;
import valeriapagliarini.u5d5.entities.Workstation;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserAndBookingDate(User user, LocalDate date);

    List<Booking> findByWorkstationAndBookingDate(Workstation workstation, LocalDate date);
}

