package petri;

import javafx.scene.input.MouseDragEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMain extends JPanel {

    private boolean placeToTrans = false;
    private boolean transToPlace = false;
    private Place currentPlace;
    private Transition currentTrans;
    private boolean moving;

    public PanelMain(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                Figure selectedFigure = FigureManagement.getFigure(evt.getX(),evt.getY());
                if(FrameMain.isControlDown()){
                    if(selectedFigure != null){
                        selectedFigure.move(evt.getX(), evt.getY());
                        moving = true;
                    }


                }else {
                    if (selectedFigure != null) {
                        if (selectedFigure.toString().equals("Place")) {
                            Place place = (Place) selectedFigure;
                            if (evt.getButton() == 1)
                                currentPlace = place;
                            else if (evt.getButton() == 3)
                                place.setCount(place.getCount() - 1);
                        } else {
                            Transition transition = (Transition) selectedFigure;
                            if (evt.getButton() == 1)
                                currentTrans = transition;
                        }
                    } else {
                        if (evt.getButton() == 1) {
                            if (FrameMain.getSelectedFigure() == SelectedFigure.PLACE) {
                                FigureManagement.addPlaces(new Place(evt.getX(), evt.getY()));
                            } else {
                                FigureManagement.addTransition(new Transition(evt.getX(), evt.getY(), FrameMain.getSelectedOrientation()));
                            }
                        }
                    }
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if(currentPlace != null){
                    if(FigureManagement.getFigure(evt.getX(), evt.getY()) != null){
                        if(FigureManagement.getFigure(evt.getX(), evt.getY()).toString().equals("Transition")){
                            FigureManagement.addConnection(currentPlace, (Transition)FigureManagement.getFigure(evt.getX(), evt.getY()));
                        }else if(FigureManagement.getFigure(evt.getX(), evt.getY()).toString().equals("Place")){
                            currentPlace.setCount(currentPlace.getCount() + 1);
                        }
                    }else{
                        currentPlace.setCount(currentPlace.getCount() + 1);
                    }
                }else if(currentTrans != null){
                    if(FigureManagement.getFigure(evt.getX(), evt.getY()) != null){
                        if(FigureManagement.getFigure(evt.getX(), evt.getY()).toString().equals("Place")) {
                            FigureManagement.addConnection(currentTrans, (Place) FigureManagement.getFigure(evt.getX(), evt.getY()));
                        }else if(FigureManagement.getFigure(evt.getX(), evt.getY()).equals(currentTrans)){
                            currentTrans.fire();
                        }
                    }


            }
                currentPlace = null;
                currentTrans = null;
                repaint();
        }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if (moving) {
                    Figure selectedFigure = FigureManagement.getFigure(evt.getX(), evt.getY());
                    if (FrameMain.isControlDown()) {
                        if (selectedFigure != null) {
                            selectedFigure.move(evt.getX(), evt.getY());
                            moving = true;
                        }
                    }
                }
                repaint();
            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FigureManagement.draw((Graphics2D) g);

    }


}
