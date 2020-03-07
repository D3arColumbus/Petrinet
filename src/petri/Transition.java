package petri;

import java.awt.*;
import java.util.ArrayList;

public class Transition extends Figure {

    private ArrayList<Place> predecessor = new ArrayList<>();
    private ArrayList<Place> successor = new ArrayList<>();

    private static final int LENGTH = 10;
    private static final int WITH = 50;

    public Transition(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawRect(x - LENGTH/2, y - WITH/2, LENGTH, WITH);
    }

    public void fire(){

    }

    public void addSuccessor(Place place){
        successor.add(place);
    }

    public void addPredecessor(Place place){
        predecessor.add(place);
    }

    public boolean found(int x, int y){
        return false;
    }
}
