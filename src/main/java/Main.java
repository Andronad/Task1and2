import Entity.Trip;
import Service.EmulationService;
import Service.TripService;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        TripService tripService=new TripService();
        Trip trip=tripService.getTrip();
        EmulationService emulate=new EmulationService(trip);
        emulate.preparation();
        emulate.emulate();
    }
}
