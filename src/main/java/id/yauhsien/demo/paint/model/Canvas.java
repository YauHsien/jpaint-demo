package id.yauhsien.demo.paint.model;

import id.yauhsien.demo.paint.util.PixelKey;

import java.util.HashMap;
import java.util.Map;

public class Canvas {

    private Shape rectangle;
    private Map<PixelKey, Pixel> pixelsMap = new HashMap<>();

    public Canvas(int w, int h) {
        this.rectangle = new Rectangle(1, w, 1, h);
    }

    public int getW() {
        return rectangle.getW();
    }

    public int getH() {
        return rectangle.getH();
    }

    public ColorEnum getColor(int x, int y) {
        PixelKey key = new PixelKey(this.getW(), x, y);
        return pixelsMap.getOrDefault(key, new Pixel(x, y, ColorEnum.background)).getColor();
    }

    /**
     * Get layout of canvas.
     * @return Multiple lines of symbols
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String horizon = BorderColorEnum.horizontal.toString().repeat(this.getW()+2) + '\n';
        stringBuilder.append(horizon);
        for (int i = 1; i <= this.getH(); i++) {
            stringBuilder.append(BorderColorEnum.vertical);
            for (int j = 1; j <= this.getW(); j++) {
                ColorEnum color = pixelsMap.getOrDefault(new PixelKey(this.getW(), j, i), new Pixel(j, i, ColorEnum.background)).getColor();
                stringBuilder.append(color);
            }
            stringBuilder.append(BorderColorEnum.closingVertical);
        }
        stringBuilder.append(horizon);
        return stringBuilder.toString();
    }

    /**
     * Apply a shape on this canvas and make change on its pixel map.
     * @param shape A shape such as line, rectangle, or bucket-painting
     */
    public void applyShape(Shape shape) {
        shape.getPixels(this)
                .forEach(pixel -> pixelsMap.put(new PixelKey(this.getW(), pixel.getColumn(), pixel.getRow()), pixel));
    }
}
