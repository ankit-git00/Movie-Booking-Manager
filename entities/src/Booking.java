package entities.src;

import java.util.List;

public class Booking {
    private final String id;
    private final User user;
    private final Show show;
    private final List<Seat> seats;
    private  final Payment payment;


    private Booking(String id, User user, Show show, List<Seat> seats, Payment payment){
        this.id = id;
        this.user= user;
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    public static class BookingBuilder{
        private String id;
        private User user;
        private Show show;
        private List<Seat> seats;
        private Payment payment;

        public BookingBuilder setId(String id){
            this.id = id;
            return this;
        }

        public BookingBuilder setUser(User user){
            this.user = user;
            return this;
        }

        public BookingBuilder setShow(Show show){
            this.show = show;
            return this;
        }

        public BookingBuilder setSeats(List<Seat> seats){
            this.seats = seats;
            return this;
        }

        public BookingBuilder setPayment(Payment payment){
            this.payment = payment;
            return this;
        }

        public Booking build(){
           return new Booking(id, user, show, seats, payment);
        }
    }
}
