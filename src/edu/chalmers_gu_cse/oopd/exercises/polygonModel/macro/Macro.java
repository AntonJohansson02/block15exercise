package edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Niklas on 2016-03-02.
 *
 * A Macro is a Composite for Transforms.
 */
public class Macro implements Transform {
    private final List<Transform> transforms = new ArrayList<>();

    public void addTransform(Transform transform){
        transforms.add(transform);
    }

    @Override
    public Polygon apply(Polygon polygon) {
        Polygon temp = polygon;
        for (Transform transform : transforms) {
            temp = transform.apply(temp);
        }
        return temp;
    }

}
