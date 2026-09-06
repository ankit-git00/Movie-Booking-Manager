import entities.src.*;

import java.util.List;
import java.util.Optional;

public class BookingManager {
    private final SeatLockManager seatLockManager;

    public BookingManager(SeatLockManager seatLockManager){
        this.seatLockManager = seatLockManager;
    }

   public Optional<Booking> createBooking(String id, User user, Show show, List<Seat> seats, Payment payment){


   }
}



