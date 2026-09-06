package entities.src;

import enums.SeatStatus;

public class Seat {
    private final String id;
    private final Integer row;
    private final Integer col;
    private SeatStatus status;

    public Seat(String id, Integer row, Integer col) {
        this.id = id;
        this.row = row;
        this.col = col;
    }

    public SeatStatus getStatus(){
        return this.status;
    }

    public String getId(){
        return this.id;
    }

    public void setStatus(SeatStatus status){
        this.status = status;
    }
}
