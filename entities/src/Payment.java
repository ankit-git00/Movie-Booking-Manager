package entities.src;

import java.util.UUID;

public class Payment {
    private final String id;
    private final double amount;
    private final String status;
    private final String transactionId;


    public Payment(double amount, String status, String transactionId){
        this.id = UUID.randomUUID().toString();
        this.status = status;
        this.amount = amount;
        this.transactionId = transactionId;
    }

    public String getStatus(){
        return status;
    }

    public double getAmount() {
        return amount;
    }
}
