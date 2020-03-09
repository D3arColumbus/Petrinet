package petri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameMain {
    private JPanel panel1;
    public static ButtonGroup buttonGroupFigure;
    public static JRadioButtonMenuItem place;
    public static JRadioButtonMenuItem transition;
    public static SelectedFigure selectedFigure = SelectedFigure.PLACE;
    public static ButtonGroup buttonGroupOrientation = new ButtonGroup();
    public static SelectedOrientation selectedOrientation = SelectedOrientation.VERTICAL;

    public FrameMain() {

    }

    public static SelectedFigure getSelectedFigure() {
        return selectedFigure;
    }

    public static void setSelectedFigure(SelectedFigure selectedFigure) {
        FrameMain.selectedFigure = selectedFigure;
    }

    public static SelectedOrientation getSelectedOrientation() {
        return selectedOrientation;
    }

    public static void setSelectedOrientation(SelectedOrientation selectedOrientation) {
        FrameMain.selectedOrientation = selectedOrientation;
    }

    public static void main(String[] args) {
        //Init
        JFrame frame = new JFrame("FrameMain");
        frame.setMinimumSize(new Dimension(1200,600));

        //MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");
        JMenu Figures = new JMenu("Figurs");
        place = new JRadioButtonMenuItem("Stelle");
        transition = new JRadioButtonMenuItem("Transition");
        JMenu transitionAlignment = new JMenu("Ausrichtung");
        JRadioButtonMenuItem horizontal = new JRadioButtonMenuItem("horizontal");
        JRadioButtonMenuItem vertical = new JRadioButtonMenuItem("waagrecht");
        transitionAlignment.add(horizontal);
        transitionAlignment.add(vertical);

        //Listener
        ActionListener listener = actionEvent -> {
            if(buttonGroupFigure.getSelection() == place.getModel())
                selectedFigure = SelectedFigure.PLACE;
            else
                selectedFigure = SelectedFigure.TRANSITION;
        };
        place.addActionListener(listener);
        transition.addActionListener(listener);

        listener = actionEvent -> {
            if(buttonGroupOrientation.getSelection() == vertical.getModel())
                selectedOrientation = SelectedOrientation.VERTICAL;
            else
                selectedOrientation = SelectedOrientation.HORIZONTAL;
        };
        vertical.addActionListener(listener);
        horizontal.addActionListener(listener);


        //ButtonGroup
        buttonGroupFigure = new ButtonGroup();
        buttonGroupFigure.add(place);
        buttonGroupFigure.add(transition);

        buttonGroupOrientation.add(vertical);
        buttonGroupOrientation.add(horizontal);


        //MenuBar
        Figures.add(place);
        Figures.add(transition);
        Figures.add(transitionAlignment);
        menuBar.add(File);
        menuBar.add(Figures);
        frame.setJMenuBar(menuBar);

        //Post-Init
        frame.setContentPane(new PanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
