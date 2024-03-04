package edu.chalmers_gu_cse.oopd.exercises;

/* This is now all we (can) use from the sub-package */
import edu.chalmers_gu_cse.oopd.exercises.controller.PolygonClicker;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.PolygonModel;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Clock;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.macro.Macro;
import edu.chalmers_gu_cse.oopd.exercises.polygonModel.PolygonSetAnimator;

import edu.chalmers_gu_cse.oopd.exercises.polygonModel.polygon.PolygonFactory;
import edu.chalmers_gu_cse.oopd.exercises.view2d.PolygonViewer;


import javax.swing.*;

public class DrawPolygons {

    public static void main(String[] args) {
        PolygonModel polygons = initModel();
        PolygonViewer view = initViewForModel(polygons);
        initUIForView(view);
        PolygonClicker controller = new PolygonClicker(polygons, view);
    

        Macro macro = new Macro();
        macro.addTransform(p -> p.rotate(Math.PI*0.1));
        macro.addTransform(p -> p.scale(1.1, 1.1));


        polygons.animate(macro);

    }//main
    private static void initUIForView(PolygonViewer view) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBounds(30, 30, 300, 300);
        frame.add(view);
    }
    public static PolygonModel initModel(){
        PolygonModel polygons = new PolygonModel();

        polygons.addPolygon(PolygonFactory.createSquare(50,50));
        polygons.addPolygon(PolygonFactory.createTriangle(100,100));
        polygons.addPolygon(PolygonFactory.createRectangle(50,150));

        return polygons;
    }//initModel

    private static PolygonViewer initViewForModel(PolygonModel polygonModel) {
        PolygonViewer view = new PolygonViewer();
        view.addModel(polygonModel);
        polygonModel.addListener(view);
        
        return view;
    }//initViewForModel

}//DrawPolygons