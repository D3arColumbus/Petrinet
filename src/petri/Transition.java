package petri;

import java.awt.*;
import java.util.ArrayList;

public class Transition extends Figure {

    private ArrayList<Place> predecessor = new ArrayList<>();
    private ArrayList<Place> successor = new ArrayList<>();

    private static final int LENGTH = 10;
    private static final int WITH = 50;
    private SelectedOrientation selectedOrientation;

    public Transition(int x, int y, SelectedOrientation so) {
        selectedOrientation = so;
        setMouseX(x);
        setMouseY(y);
    }

    private void setMouseX(int x){
        if(selectedOrientation == SelectedOrientation.VERTICAL){
            setX(x - LENGTH/2);
        }else{
            setX(x - WITH/2);
        }
    }

    private void setMouseY(int y){
        if(selectedOrientation == SelectedOrientation.VERTICAL){
            setY(y - WITH/2);
        }else{
            setY(y - LENGTH/2);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        predecessor.forEach(e->g.drawLine(getCenterX(),getCenterY(),e.getCenterX(),e.getCenterY()));
        successor.forEach(e->g.drawLine(getCenterX(),getCenterY(),e.getCenterX(),e.getCenterY()));
        g.setColor(new Color(238, 238, 238));
        if(selectedOrientation == SelectedOrientation.VERTICAL)
            g.fillRect(x, y, LENGTH, WITH);
        else
            g.fillRect(x, y, WITH, LENGTH);
        g.setColor(Color.BLACK);
        if(selectedOrientation == SelectedOrientation.VERTICAL)
            g.drawRect(x, y, LENGTH, WITH);
        else
            g.drawRect(x, y, WITH, LENGTH);
    }

    public void fire(){
        predecessor.forEach(e-> e.setCount(e.getCount()-1));
        successor.forEach(e-> e.setCount(e.getCount() + 1));
        FrameMain.logger.info("fire!");
    }

    @Override
    public Figure inFigure(int mx, int my) {
        //FrameMain.logger.info("InFigureTransition: " + mx + " " + my);
        if(selectedOrientation == SelectedOrientation.VERTICAL) {
            if (mx >= x && mx <= x + LENGTH  &&
                    my >= y && my <= y + WITH )
                return this;
        }else{
            if(mx >= x && mx <= x + WITH &&
                    my >= y && my <= y + LENGTH )
                return this;
        }
        return null;
    }

    @Override
    public int getCenterX() {
        if(selectedOrientation == SelectedOrientation.VERTICAL) {
            return x + LENGTH / 2;
        }else {
            return x + WITH / 2;
        }
    }

    @Override
    public int getCenterY() {
        if(selectedOrientation == SelectedOrientation.VERTICAL){
            return y + WITH/2;
        }else{
            return y + LENGTH/2;
        }
    }

    @Override
    public void move(int x, int y) {
        setMouseX(x);
        setMouseY(y);
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

    @Override
    public String toString() {
        return "Transition";
    }
}
