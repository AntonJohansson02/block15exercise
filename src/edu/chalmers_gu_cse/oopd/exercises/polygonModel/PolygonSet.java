package edu.chalmers_gu_cse.oopd.exercises.polygonModel;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Transform;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* package-private */ class PolygonSet implements Iterable<Polygon> {
    // TODO 5: For more challenge:
    //  Implement a Composite Pattern for PolygonSet, making it
    //  implement the full Polygon interface. What issues do you run into?
    //  How can you work around them?
    private List<Polygon> polygons = new ArrayList<>();
    public void addPolygon(Polygon p){
        polygons.add(p);
    }

    public void transform(int x, int y){
        transform(p -> p.translate(x, y));
    }

    @Override
    public Iterator<Polygon> iterator() {
        return polygons.iterator();
    }

    public void transform(Transform transform) {
        List<Polygon> translated = new ArrayList<>();
        for (Polygon p : polygons) {
            Polygon q = transform.transform(p);
            translated.add(q);
        }
        this.polygons = translated;
    }
}
