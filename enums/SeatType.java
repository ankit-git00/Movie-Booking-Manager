package enums;

public enum SeatType {

    REGULAR(50.00),
    PREMIUM(80.00),
    RECLINER(100);

    private final double price;

    SeatType(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }
}
