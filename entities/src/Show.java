package entities.src;

import java.time.LocalDateTime;

public class Show {
    private final String id;
    private final Movie movie;
    private final LocalDateTime time;
    private final Screen screen;
    private final Cinema cinema;


    public Show(String id, Movie movie, LocalDateTime time, Screen screen, Cinema cinema) {
        this.id = id;
        this.movie = movie;
        this.time = time;
        this.screen = screen;
        this.cinema = cinema;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public Cinema getCinema(){
        return this.cinema;
    }

}
