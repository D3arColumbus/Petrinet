package petri;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMain {
    private JPanel panel1;
    public static ButtonGroup buttonGroupFigure;
    public static JRadioButtonMenuItem place;
    public static JRadioButtonMenuItem transition;


    public FrameMain() {
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if(buttonGroupFigure.getSelection() == place.getModel()){
                    FigureManagement.addPlaces(new Place(evt.getX(), evt.getY(), "HUHU"));
                }else if(buttonGroupFigure.getSelection() == transition.getModel()){
                    FigureManagement.addTransition(new Transition(evt.getX(), evt.getY()));
                }
            }

            @Override
            public void mousePressed(MouseEvent evt) {

            }

            @Override
            public void mouseReleased(MouseEvent evt) {

            }
        });
    }

    public static void main(String[] args) {
        //Init
        JFrame frame = new JFrame("FrameMain");
        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");
        JMenu Figures = new JMenu("Figurs");
        place = new JRadioButtonMenuItem("Stelle");
        transition = new JRadioButtonMenuItem("Transition");
        //Listener
        /*FigureListener listener = new FigureListener();
        line.addActionListener(listener);
        circle.addActionListener(listener);
        rectangle.addActionListener(listener);

         */
        //ButtonGroup
        buttonGroupFigure = new ButtonGroup();
        buttonGroupFigure.add(place);
        buttonGroupFigure.add(transition);

        //Post-Init
        Figures.add(place);
        Figures.add(transition);

        menuBar.add(File);
        menuBar.add(Figures);
        frame.setJMenuBar(menuBar);

        frame.setContentPane(new PanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
