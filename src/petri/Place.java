package petri;

import java.awt.*;

public class Place extends Figure {

    private static final int RADIUS = 20;
    private int count = 0;

    public Place(int x, int y) {
        super(x - RADIUS, y - RADIUS);

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if(count >= 0)
            this.count = count;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(new Color(238, 238, 238));
        g.fillOval(x,y, 2*RADIUS, 2*RADIUS);
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(count), (x + RADIUS) - g.getFontMetrics().stringWidth(String.valueOf(count))/2, (y + RADIUS) + g.getFontMetrics().getHeight()/4);
        g.drawOval(x,y, 2*RADIUS, 2*RADIUS );
    }

    @Override
    public Figure inFigure(int mx, int my) {
        if(mx >= x && mx <= x + RADIUS * 2 &&
           my >= y && my <= y + RADIUS * 2 )
            return this;
        return null;
    }

    @Override
    public int getCenterX() {
        return x + RADIUS;
    }

    @Override
    public int getCenterY() {
        return y + RADIUS;
    }

    @Override
    public void move(int x, int y) {
        this.x = x - RADIUS;
        this.y = y - RADIUS;
    }

    @Override
    public String toString() {
        return "Place";
    }


}
