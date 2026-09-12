import entities.src.*;
import enums.SeatStatus;
import enums.SeatType;
import strategy.payment.CreditCardPaymentStrategy;
import strategy.pricing.WeekDayPricingStrategy;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieBookingDemo{

    public static void main(String[] args){
        System.out.println("class is working");

        MovieBookingService bookingService = MovieBookingService.getInstance();

        City city1 = bookingService.addCity("1", "Bangalore");
        City city2 = bookingService.addCity("2", "Chicago");

        Screen screen1 = new Screen("Scr1");
        Screen screen2 = new Screen("Scr2");

        for(int i = 0; i < 10; i++){
            screen1.addSeat( new Seat("A" + i, i, i+1, i%2 == 0 ? SeatType.RECLINER : SeatType.REGULAR));
            screen2.addSeat (new Seat("B" + i, i, i, i%2 == 0 ? SeatType.RECLINER : SeatType.REGULAR));
        }

        Movie movie1 = new Movie("M1", "Avengers");
        Movie movie2 = new Movie("M2", "Donalds");

        Cinema c1 = bookingService.addCinema("Cin1", city1 , List.of(screen1, screen2));

        bookingService.addShows("Show1", LocalDateTime.now().plusHours(2), movie1, screen1,c1 , new WeekDayPricingStrategy());
        bookingService.addShows("Show2", LocalDateTime.now().plusHours(1), movie1, screen1,c1 , new WeekDayPricingStrategy());

        User alice = bookingService.addUser("Alice", "1", "alice@example.com");

        List<Show> availableShows = bookingService.findShows("Avengers", city1.getName());
        System.out.println("Available Shows" + availableShows.get(0).getCinema().getId());
        Show selectedShow = availableShows.get(0);

        List<Seat> availableSeats = selectedShow.getScreen().getSeats().stream()
                .filter(seat -> seat.getStatus() == SeatStatus.AVAILABLE)
                .toList();

        System.out.printf("Available seats for show %s at time %s are : %s%n",
                selectedShow.getMovie().getTitle(), selectedShow
                .getTime(), availableSeats.stream().map(Seat::getId).collect(Collectors.toList()));


        List<Seat> selectedSeats = List.of(availableSeats.get(2), availableSeats.get(3));


        Optional<Booking>   bookingOpt =  bookingService.bookTicket(alice.getId(), selectedShow.getId(), selectedSeats, new CreditCardPaymentStrategy("11232", "334"));

        if(bookingOpt.isPresent()){
            Booking booking = bookingOpt.get();

            System.out.println("Booking Successful");
            System.out.println("Booking Id" + booking.getId());
            System.out.print("Amount : "+  booking.getPayment().getAmount());
        }


        bookingService.shutDown();
    }


}