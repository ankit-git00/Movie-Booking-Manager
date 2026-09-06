import entities.src.Seat;
import entities.src.Show;
import entities.src.User;
import enums.SeatStatus;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class SeatLockManager {

    private final Map<Show,Map<Seat, String>> lockedSeats = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);


    public boolean lockSeats(Show show, List<Seat> seats, String userId){

        synchronized (show){

            for(Seat seat : seats){
                if(seat.getStatus() != SeatStatus.AVAILABLE){
                    System.out.println("Seats are not available");
                    return false;
                }
            }

            for(Seat seat : seats){
                seat.setStatus(SeatStatus.LOCKED);
            }

            lockedSeats.computeIfAbsent(show, key -> new ConcurrentHashMap<>());

            for(Seat seat : seats){
                lockedSeats.get(show).put(seat, userId);
            }

            scheduler.schedule();
        }

    }

    public void unlockSeats(Show show, List<Seat> seats, String userId){
        synchronized (show){

            Map<Seat, String> seatMap = lockedSeats.get(show);
            if(seatMap != null){
                for(Seat seat : seats){
                    if(seat.getStatus() == SeatStatus.LOCKED && seatMap.get(seat).equals(userId)){
                        seatMap.remove(seat);
                        seat.setStatus(SeatStatus.AVAILABLE);
                        System.out.println("Seat " + seat.getId() + "unlocked due to timeout");
                    }

                    else{
                            seatMap.remove(seat);
                            System.out.println("Seat " + seat.getId() + "unlocked due to booking completion");
                    }
                }

                if(seatMap.isEmpty()){
                    lockedSeats.remove(show);
                }
            }

        }

    }

    public void shutDown(){
    System.out.println("Shutting down SeatLockManager");
    scheduler.shutdown();

    try{
        if( !scheduler.awaitTermination(5, TimeUnit.SECONDS))
    }
    }
}


//1. booking is not withing timeout
//2. payment failed within timeout
//        3. payment succeeds after timeout
//        4. booking completes with payment

//complete unlockSeats logic and schedule unlock