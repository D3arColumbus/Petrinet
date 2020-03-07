package petri;

import java.awt.*;

public abstract class Figure {
    protected int x, y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void draw(Graphics2D g);

    public void setX(int x) {
        if(x >= 0)
            this.x = x;
    }

    public void setY(int y) {
        if(y >= 0)
            this.y = y;
    }
}
