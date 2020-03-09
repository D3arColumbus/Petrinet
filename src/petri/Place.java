package petri;

import java.awt.*;

public class Place extends Figure {

    private String name;
    private static final int RADIUS = 20;


    public Place(int x, int y, String name) {
        super(x, y);

    }

    public String getName() {
        return name;
    }

    @Override
    public void draw(Graphics2D g) {

        g.drawOval(x - RADIUS ,y - RADIUS, 2*RADIUS, 2*RADIUS );
    }
}
