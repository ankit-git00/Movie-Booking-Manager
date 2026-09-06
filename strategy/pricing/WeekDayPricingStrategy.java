package strategy.pricing;

import entities.src.Seat;

import java.util.List;

public class WeekDayPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(List<Seat> seats) {

        return seats.stream().
                mapToDouble(seat -> seat.getType().getPrice())
                .sum();
    }
}
