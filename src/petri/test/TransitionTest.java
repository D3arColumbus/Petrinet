package petri.test;

import petri.FigureManagement;
import petri.Place;
import petri.SelectedOrientation;
import petri.Transition;

import static org.junit.jupiter.api.Assertions.*;

class TransitionTest {

    @org.junit.jupiter.api.Test
    void inFigure() {
        Transition t = new Transition(100,100,SelectedOrientation.VERTICAL);
        assertNotNull(t.inFigure(110, 90));
        Place p = new Place(200,200);
       // assertNotNull(p.inFigure(110, 90));
        FigureManagement.addTransition(t);
        FigureManagement.addPlaces(p);
        assertEquals(FigureManagement.getFigure(110,90).toString(),"Transition");
    }
}