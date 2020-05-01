package id.yauhsien.demo.paint.model;

import java.util.HashSet;
import java.util.Set;

public class Canvas {

    private RectInterface rectangle;
    private Set<Pixel> pixels = new HashSet<>();
    private RectInterface prevCmd;

    public Canvas(int w, int h) {
        this.rectangle = new Rectangle(0, w+1, 0, h+1);
    }

    public int getW() {
        return rectangle.getW() - 2;
    }

    public int getH() {
        return rectangle.getH() - 2;
    }

    public void setLine(Line line) {
        this.prevCmd = line;
    }

    public void setRectangle(Rectangle rectangle) {
        this.prevCmd = rectangle;
    }

    public void applyLine(Line line) {
        this.setLine(line);
        this.applyPrevCmd();
    }

    public void applyRectanble(Rectangle rectangle) {
        this.setRectangle(rectangle);
        this.applyPrevCmd();
    }

    public void applyPrevCmd() {
        if (this.prevCmd == null)
            return;
        pixels.addAll(this.prevCmd.getPixels());
        this.prevCmd = null;
    }
}
