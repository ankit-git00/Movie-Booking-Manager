package entities.src;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private final String id;
    private final City city;
    List<Screen> screens;
    List<Show> shows;

    public Cinema(String id, City city, List<Screen> screens) {
        this.id = id;
        this.city = city;
        this.screens = screens;
        this.shows = new ArrayList<>();

    }


    public String getId(){
        return this.id;
    }

    public City getCity(){
        return this.city;
    }

    public List<Screen> getScreens(){
        return this.screens;
    }

    public List<Show> getShows(){
        return this.shows;
    }

    public void addShows(Show show){
        this.shows.add(show);
    }


}
