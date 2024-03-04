package edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.internal;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.Polygon;

import java.awt.*;
import java.util.List;

public class PolygonBuilder {

    // TODO 3: Builder Pattern: Replace this simple abstraction around the BasePolygon
    //  constructor with a Builder Pattern for creating new complex polygons.
    public static Polygon buildPolygon(List<Point> points) {
        return new BasePolygon(points);
    }

}
