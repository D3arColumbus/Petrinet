package petri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelMain extends JPanel {

    public PanelMain(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent evt) {
                if(FrameMain.getSelectedFigure() == SelectedFigure.PLACE){
                    FigureManagement.addPlaces(new Place(evt.getX(), evt.getY(), "HUHU"));
                }else{
                    FigureManagement.addTransition(new Transition(evt.getX(), evt.getY(), FrameMain.getSelectedOrientation()));
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent evt) {

            }
        });
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        FigureManagement.draw((Graphics2D) g);

    }


}
