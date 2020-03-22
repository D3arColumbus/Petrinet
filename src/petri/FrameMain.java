package petri;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FrameMain {

    public static Logger logger;

    private JPanel panel1;
    public static ButtonGroup buttonGroupFigure;
    public static JRadioButtonMenuItem place;
    public static JRadioButtonMenuItem transition;
    public static SelectedFigure selectedFigure = SelectedFigure.PLACE;
    public static ButtonGroup buttonGroupOrientation = new ButtonGroup();
    public static SelectedOrientation selectedOrientation = SelectedOrientation.VERTICAL;
    public static boolean controlDown = false;
    //File
    public static JMenuItem menuItemNew = new JMenuItem("Neu");
    public static JMenuItem menuItemLoad = new JMenuItem("Laden");
    public static JMenuItem menuItemSave = new JMenuItem("Speichern");
    public static JMenuItem menuItemClose = new JMenuItem("Beenden");

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

    public static boolean isControlDown() {
        return controlDown;
    }

    public static void setControlDown(boolean controlDown) {
        FrameMain.controlDown = controlDown;
    }

    public static void main(String[] args) {
        //Logger
        logging();

        //Init
        JFrame frame = new JFrame("FrameMain");
        frame.setMinimumSize(new Dimension(1200,600));

        //MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu File = new JMenu("File");
        File.add(menuItemNew);
        File.addSeparator();
        File.add(menuItemLoad);
        File.add(menuItemSave);
        File.addSeparator();
        File.add(menuItemClose);

        JMenu Figures = new JMenu("Figurs");
        place = new JRadioButtonMenuItem("Stelle");
        transition = new JRadioButtonMenuItem("Transition");
        JMenu transitionAlignment = new JMenu("Ausrichtung");
        JRadioButtonMenuItem horizontal = new JRadioButtonMenuItem("horizontal");
        JRadioButtonMenuItem vertical = new JRadioButtonMenuItem("waagrecht");
        transitionAlignment.add(vertical);
        transitionAlignment.add(horizontal);


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

        menuItemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        KeyListener kListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.isControlDown())
                    setControlDown(true);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                    setControlDown(false);
            }
        };
        frame.addKeyListener(kListener);

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

    private static void logging(){
        logger = Logger.getLogger("Petri_Logger");
        try {
            FileHandler fh = new FileHandler("C:/temp/logging/Petri.log");
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
            logger.info("Logger is working!");

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
