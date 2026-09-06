package strategy.pricing;

import entities.src.Seat;

import java.util.List;

public class WeekendPricingStrategy implements PricingStrategy {

    double surcharge = 1.2;

    @Override
    public double calculatePrice(List<Seat> seats){
        return seats.stream().mapToDouble(seat -> seat.getType().getPrice() * surcharge).sum();
    }
}