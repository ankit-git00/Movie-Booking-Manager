package entities.src;

public class City {
    private final String id;
    private  final String name;

    public City(String id, String name){
        this.id= id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
