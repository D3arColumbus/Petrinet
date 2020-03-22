package petri;

import java.awt.*;
import java.util.ArrayList;


public class FigureManagement {

    private static ArrayList<Place> places = new ArrayList<>();
    private static ArrayList<Transition> transitions = new ArrayList<>();

    public static void addPlaces(Place p){
        if(p != null)
            places.add(p);
    }

    public static void addTransition(Transition t){
        if(t != null)
            transitions.add(t);
    }

    public static void addConnection(int xFirst, int yFirst, int xLast, int yLast){

    }

    public static void addConnection(Place place, Transition transition){
        transition.addPredecessor(place);
    }

    public static void addConnection(Transition transition, Place place){
        transition.addSuccessor(place);
    }

    public static void getTransition(int x, int y){
        transitions.forEach(transition -> transition.found(x,y));
    }

    public static Figure getFigure(int x, int y){
        for(Place p : places){
            if(p.inFigure(x,y) != null){
                return p.inFigure(x,y);
            }
        }
        for(Transition t : transitions){
            if(t.inFigure(x,y) != null){
                return t.inFigure(x,y);
            }
        }
        FrameMain.logger.info("Found no figure");
        return null;
    }

    public static void draw(Graphics2D g){
        transitions.forEach(transition -> transition.draw(g));
        places.forEach(place -> place.draw(g));
    }
}
