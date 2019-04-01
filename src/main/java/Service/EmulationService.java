package Service;

import Entity.Trip;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmulationService {
    private Trip trip;
    public void emulate() throws InterruptedException {
        while(true){
            Thread.sleep(1000);
            double value=Math.random()*10000;
            trip.setDistance(trip.getDistance()-(int)value);
            trip.setDuration(trip.getDuration()-value/7500);
            System.out.println("Rest distance = "+trip.getDistance()+" km; Rest duration = "+trip.getDuration()+" hours");
        }
    }
    public void preparation() throws InterruptedException {
        System.out.println("10 sec preparation");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("GOOO!!!");
    }
}
