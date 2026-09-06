import entities.src.*;

import java.awt.image.AreaAveragingScaleFilter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MovieBookingService {


    private static volatile MovieBookingService instance;
    private final Map<String, Movie> movies;
    private final Map<String, User> users;
    private final Map<String, Show> shows;
    private final Map<String, Cinema> cinemas;
    private final Map<String, City> cities;

    private SeatLockManager seatLockManager;
    private BookingManager bookingManager;


    private MovieBookingService(){

        this.movies = new ConcurrentHashMap<>();
        this.cinemas = new ConcurrentHashMap<>();
        this.shows = new ConcurrentHashMap<>();
        this.users = new ConcurrentHashMap<>();
        this.cities = new ConcurrentHashMap<>();


        this.seatLockManager = new SeatLockManager();
        this.bookingManager = new BookingManager();
    }

    public static MovieBookingService getInstance(){
        if( instance == null){
            synchronized (MovieBookingService.class){
                if (instance == null){
                    instance = new MovieBookingService();
                }
            }
        }

       return instance;
    }

    public City addCity(String id, String name){
        City city  = new City(id, name);
        this.cities.put(id, city);
        return city;
    }

    public User addUser(String name, String id, String email){
        User user = new User(id, name, email);
        this.users.put(id, user);
        return user;
    }

    public Movie addMovies(String id, String name){
        Movie movie = new Movie(id, name);
        this.movies.put(id, movie);
        return movie;

    }

    public Show addShows(String id, LocalDateTime time, Movie movie, Screen screen, Cinema cinema){
        Show show = new Show(id, movie, time, screen, cinema);
        this.shows.put(id, show);
        return show;
    }

    public Cinema addCinema(String id, City city, List<Screen> screens, List<Show> shows){
        Cinema cinema = new Cinema(id, city, screens, shows);
        this.cinemas.put(id, cinema);
    }

    public List<Show> findShows(String movieTitle, String cityName){
        List<Show> result = new ArrayList<>();

        shows.values().stream()
                .filter(show -> show.getMovie().getTitle().equalsIgnoreCase(movieTitle))
                .filter(show -> show.getCinema().getCity().getName().equalsIgnoreCase(cityName))
                .forEach(result::add);

        return result;
    }




}


