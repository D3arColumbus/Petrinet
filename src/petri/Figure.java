package petri;

import java.awt.*;

public abstract class Figure {
    protected int x, y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    protected Figure() {
    }

    public abstract void draw(Graphics2D g);

    public abstract Figure inFigure(int mx, int my);

    public void setX(int x) {
        if(x >= 0)
            this.x = x;
    }

    public void setY(int y) {
        if(y >= 0)
            this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract int getCenterX();
    public abstract int getCenterY();

}
