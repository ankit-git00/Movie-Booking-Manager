package strategy.pricing;

import entities.src.Seat;

import java.util.List;

public interface PricingStrategy {

    double calculatePrice(List<Seat> seats);
}
