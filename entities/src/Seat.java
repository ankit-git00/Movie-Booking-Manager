package entities.src;

import enums.SeatStatus;
import enums.SeatType;

public class Seat {
    private final String id;
    private final Integer row;
    private final Integer col;
    private SeatStatus status;
    private final SeatType type;

    public Seat(String id, Integer row, Integer col, SeatType type) {
        this.id = id;
        this.row = row;
        this.col = col;
        this.type = type;
        this.status = SeatStatus.AVAILABLE;
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

    public SeatType getType(){
        return this.type;
    }
}
