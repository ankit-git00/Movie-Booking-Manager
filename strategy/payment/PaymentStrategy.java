package strategy.payment;

import entities.src.Payment;
import entities.src.User;

public interface PaymentStrategy {

    Payment pay(double amount);
}
