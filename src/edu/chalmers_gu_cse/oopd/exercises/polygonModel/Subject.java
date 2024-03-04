package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
