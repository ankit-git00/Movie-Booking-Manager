import entities.src.*;
import strategy.payment.PaymentStrategy;
import strategy.pricing.WeekDayPricingStrategy;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class BookingManager {
    private final SeatLockManager seatLockManager;

    public BookingManager(SeatLockManager seatLockManager){
        this.seatLockManager = seatLockManager;
    }

   public Optional<Booking> createBooking(User user, Show show, List<Seat> seats, PaymentStrategy paymentStrategy){

        if(!this.seatLockManager.lockSeats(show, seats, user.getId())){
            System.out.println("Seats not available");
            return Optional.empty();
        }

        double totalAmount = show.getPricingStrategy().calculatePrice(seats);

        Payment payment = paymentStrategy.pay(totalAmount);

        if(payment.getStatus().equalsIgnoreCase("Success")){

            Booking booking = new Booking.BookingBuilder()
                    .setId(UUID.randomUUID().toString())
                    .setUser(user)
                    .setSeats(seats)
                    .setShow(show)
                    .setPayment(payment)
                    .build();



            seatLockManager.unlockSeats(show, seats, user.getId());

            booking.confirmBooking();

            return Optional.of(booking);
        }

        else{
            System.out.println("Booking failed");
            return Optional.empty();
        }

   }
}



