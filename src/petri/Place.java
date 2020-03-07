package petri;

import java.awt.*;

public class Place extends Figure {

    private String name;

    public Place(int x, int y, String name) {
        super(x, y);

    }

    public String getName() {
        return name;
    }

    @Override
    public void draw(Graphics2D g) {

    }
}
