package strategy.payment;

import entities.src.Payment;

import java.util.UUID;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    private final String cardNumber;
    private final String cvv;

    public CreditCardPaymentStrategy(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public Payment pay(double amount){
        System.out.printf("Processing credit payment of $%.2f%n", amount);
        String transcactionId = UUID.randomUUID().toString();

        boolean paymentSuccess = Math.random() > 0.05;

        return new Payment(amount, paymentSuccess ? "Success" : "Failure", transcactionId);

    }
}
