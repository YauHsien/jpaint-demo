package id.yauhsien.demo.paint.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Rectangle implements Shape {

    protected static ColorEnum color = ColorEnum.x;
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private Set<Pixel> border = new HashSet<>();

    /**
     * Create a rectangle. Border pixels are built upon rectangle creation.
     * @param x1 First x coordinate
     * @param x2 Second x coordinate
     * @param y1 First y coordinate
     * @param y2 Second y coordinate
     */
    public Rectangle(int x1, int x2, int y1, int y2) {
        if (x1 > x2) {
            this.x1 = x2;
            this.x2 = x1;
        }
        else {
            this.x1 = x1;
            this.x2 = x2;
        }
        if (y1 > y2) {
            this.y1 = y2;
            this.y2 = y1;
        }
        else {
            this.y1 = y1;
            this.y2 = y2;
        }
        generateBorderPixels();
    }

    /**
     * Build fence pixels.
     */
    private void generateBorderPixels() {
        int w = 1 + x2 - x1;
        for (int i = x1; i <= x2; i++)
            border.add(new Pixel(w, i, y1, Rectangle.color));
        for (int i = y1; i <= y2; i++)
            border.add(new Pixel(w, x1, i, Rectangle.color));
        if (x1 != x2)
            for (int i = y1; i <= y2; i++)
                border.add(new Pixel(w, x2, i, Rectangle.color));
        if (y1 != y2)
            for (int i = x1; i <= x2; i++)
                border.add(new Pixel(w, i, y2, Rectangle.color));
    }

    @Override
    public Collection<? extends Pixel> getPixels(Canvas canvas) {
        return border;
    }

    @Override
    public int getW() {
        return 1 + this.x2 - this.x1;
    }

    @Override
    public int getH() {
        return 1 + this.y2 - this.y1;
    }
}
