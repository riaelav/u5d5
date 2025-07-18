package valeriapagliarini.u5d5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import valeriapagliarini.u5d5.repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    
}
