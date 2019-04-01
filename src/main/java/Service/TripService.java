package Service;


import Entity.Astronaut;
import Entity.SpaceCraft;
import Entity.Trip;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.*;


public class TripService {
    private Trip trip;
    private List<Astronaut> astronauts;
    private Map<String,SpaceCraft> spaceCrafts;
    private ApplicationContext context;
    public TripService(){
        context=new ClassPathXmlApplicationContext("spring-config.xml");
        spaceCrafts=context.getBeansOfType(SpaceCraft.class);
        astronauts= new ArrayList<>();
        for (int i = 0; i < context.getBeansOfType(Astronaut.class).size() ; i++) {
            astronauts.add((Astronaut)context.getBean("astronaut"+(i+1)));
        }
    }
    public Trip getTrip() throws IOException {
        trip=(Trip)context.getBean("trip1");
        outInformation();
        trip.setShuttle(spaceCrafts.get("spaceCraft"+(Math.round(Math.random())+1)));
        System.out.println("Our shuttle is: "+trip.getShuttle());
        System.out.println("You want the best crew(1) or it doesn't matter(2)? Enter 1 or 2");
        char input=(char)System.in.read();
        if(input=='1'){
            Collections.sort(astronauts, Comparator.comparingInt(Astronaut::getSkill).reversed());
        }
        else{
            Collections.shuffle(astronauts);
        }
        List<Astronaut> tripAstronauts=new ArrayList<>();
        if(astronauts.size()>trip.getShuttle().getCapacity()) {
            tripAstronauts = astronauts.subList(0, trip.getShuttle().getCapacity());
        }
        trip.setAstronauts(tripAstronauts);
        System.out.println("Our astronauts are: "+trip.getAstronauts());
        return trip;
    }
    private void outInformation(){
        System.out.println("Information about trip:");
        System.out.println("- Name of the trip is "+trip.getDescription());
        System.out.println("- Duration of the flight is "+trip.getDuration());
        System.out.println("- Distance of the flight is "+trip.getDistance());
    }
}
