package edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro;

import java.util.ArrayList;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.Observer;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.Subject;

public class Clock implements Subject {

    ArrayList<Observer> observers = new ArrayList<>();

    public Clock(){
        //run();
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyObservers(){
        for (Observer o: observers){
            o.actOnClockUpdate();
        }
    }

    public void run(){
        while (true) {
            try {
                Thread.sleep(500);
                notifyObservers();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }
    }
    
}
