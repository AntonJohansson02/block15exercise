package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Transform;

import java.util.ArrayList;
import java.util.List;

public class PolygonSetAnimator implements Observer {
    private final PolygonSet polygonSet;
    private Transform pendingTransform;

    public PolygonSetAnimator(PolygonSet polygonSet) {
        this.polygonSet = polygonSet;
    }

    public void update(Transform t){
        polygonSet.transform(t);
        notifyListeners();
    }
    // TODO 1: Observer Pattern: Put the clock in a separate class, and let
    //  PolygonModel have, and start, such a clock. Make the clock observable,
    //  and let this animator be an observer so that update is called on
    //  each tick.

    public void animate(Transform transform){
        pendingTransform = transform;    
    }

    public void actOnClockUpdate() {
        update(pendingTransform);
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
