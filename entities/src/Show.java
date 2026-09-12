package entities.src;

import strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;

public class Show {
    private final String id;
    private final Movie movie;
    private final LocalDateTime time;
    private final Screen screen;
    private final Cinema cinema;
    private final PricingStrategy pricingStrategy;


    public Show(String id, Movie movie, LocalDateTime time, Screen screen, Cinema cinema, PricingStrategy pricingStrategy) {
        this.id = id;
        this.movie = movie;
        this.time = time;
        this.screen = screen;
        this.cinema = cinema;
        this.pricingStrategy = pricingStrategy;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public Cinema getCinema(){
        return this.cinema;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }

    public Screen getScreen(){
        return screen;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getId(){
        return this.id;
    }
}
