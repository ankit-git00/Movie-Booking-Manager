package entities.src;

import java.util.List;

public class Screen {

    private  final String id;
    private final List<Seat> seats;

    private Screen(String id, List<Seat> seats){
        this.seats = seats;
        this.id = id;
    }
}
