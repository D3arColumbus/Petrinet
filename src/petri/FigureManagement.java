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

    public static void getTransition(int x, int y){
        transitions.forEach(transition -> transition.found(x,y));
    }

    public static void draw(Graphics2D g){
        places.forEach(place -> place.draw(g));
        transitions.forEach(transition -> transition.draw(g));

    }
}
