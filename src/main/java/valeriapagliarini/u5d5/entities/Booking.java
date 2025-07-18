package valeriapagliarini.u5d5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "bookings")

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "workstation_id")
    private Workstation workstation;

    @Column(name = "booking_date")
    private LocalDate bookingDate;


    public Booking(User user, Workstation workstation, LocalDate bookingDate) {
        this.user = user;
        this.workstation = workstation;
        this.bookingDate = bookingDate;
    }
}
