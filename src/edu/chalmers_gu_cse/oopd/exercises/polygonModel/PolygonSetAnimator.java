package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Transform;

import java.util.ArrayList;
import java.util.List;

/* package-private */ class PolygonSetAnimator {
    private final PolygonSet polygonSet;

    public PolygonSetAnimator(PolygonSet polygonSet) {
        this.polygonSet = polygonSet;
    }

    public void update(Transform transform){
        polygonSet.transform(transform);
        notifyListeners();
    }
    // TODO 1: Observer Pattern: Put the clock in a separate class, and let
    //  PolygonModel have, and start, such a clock. Make the clock observable,
    //  and let this animator be an observer so that update is called on
    //  each tick.
    public void animate(Transform transform){
        boolean running = true;
        while (running) {
            try {
                Thread.sleep(500);
                update(transform);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    private final List<ModelUpdateListener> listeners = new ArrayList<>();
    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }
    protected void notifyListeners(){
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate();
    }


}
