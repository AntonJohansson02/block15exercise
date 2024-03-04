package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Clock;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Transform;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Niklas on 2016-02-21.
 *
 * A PolygonModel combines the functionality of a PolygonSet, that
 * can be updated with new polygons; and a PolygonSetAnimator that
 * can update the position of the polygons over time.
 */
public class PolygonModel implements ModelUpdateListener, Iterable<Polygon> {

    // TODO 8: For extra challenge:
    //  PubSub Pattern: Create several separate polygon sets,
    //  and let each set have its own dedicated Publisher. Make
    //  good use of these Publishers, by differentiating outputs.

    private final PolygonSet polygonSet;
    private final PolygonSetAnimator animator;
    private final Clock clock;
    

    public PolygonModel() {
        polygonSet = new PolygonSet();
        animator = new PolygonSetAnimator(polygonSet);
        
        clock = new Clock();
        clock.addObserver(animator);
        animator.addListener(this);
    }//constructor

    // Delegate these methods to the polygon set
    public void addPolygon(Polygon p){
        polygonSet.addPolygon(p);
        actOnPolygonAdded(p);
    }

    // Delegate these methods to the animator
    public void animate(Transform macro){
        animator.animate(macro);
        clock.run();

    }


    @Override
    public Iterator<Polygon> iterator() {
        return polygonSet.iterator();
    }

    private final List<ModelUpdateListener> listeners = new ArrayList<>();
    public void addListener(ModelUpdateListener l){
        listeners.add(l);
    }

    @Override
    public void actOnModelUpdate() {
        for (ModelUpdateListener l : listeners)
            l.actOnModelUpdate();
    }

    @Override
    public void actOnPolygonAdded(Polygon p) {
        for (ModelUpdateListener l : listeners)
            l.actOnPolygonAdded(p);
    }

}

