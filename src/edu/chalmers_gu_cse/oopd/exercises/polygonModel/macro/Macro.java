package edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 2016-03-02.
 */
public class Macro implements Transform {
    private final List<Transform> transforms = new ArrayList<>();

    public void addTransform(Transform t){
        transforms.add(t);
    }

    public Polygon transform(Polygon p){
        for (Transform transform: transforms) {
            p = transform.transform(p);
        }
        return p;
    }
}
