package id.yauhsien.demo.paint.model;

import id.yauhsien.demo.paint.util.PixelKey;

import java.util.HashMap;
import java.util.Map;

public class Canvas {

    private Shape rectangle;
    private Map<PixelKey, Pixel> pixelsMap = new HashMap<>();
    private Shape prevShape;

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

    public Map<PixelKey, Pixel> getPixelsMap() {
        return pixelsMap;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String horizon = "-".repeat(this.getW()+2);
        stringBuilder.append(horizon);
        stringBuilder.append('\n');
        for (int i = 1; i <= this.getH(); i++) {
            stringBuilder.append('|');
            for (int j = 1; j <= this.getW(); j++) {
                ColorEnum color = pixelsMap.getOrDefault(new PixelKey(this.getW(), j, i), new Pixel(j, i, ColorEnum.background)).getColor();
                stringBuilder.append(color);
            }
            stringBuilder.append("|\n");
        }
        stringBuilder.append(horizon);
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    public void setPrevShape(Line line) {
        this.prevShape = line;
    }

    public void setPrevShape(Rectangle rectangle) {
        this.prevShape = rectangle;
    }

    public void setPrevShape(BucketPainting bucketPainting) {
        this.prevShape = bucketPainting;
    }

    public void applyPrevShape() {
        if (this.prevShape == null)
            return;
        this.prevShape.getPixels(this)
                .forEach(pixel -> pixelsMap.put(new PixelKey(this.getW(), pixel.getColumn(), pixel.getRow()), pixel));
        this.prevShape = null;
    }

    public void applyShape(Line line) {
        this.setPrevShape(line);
        this.applyPrevShape();
    }

    public void applyShape(Rectangle rectangle) {
        this.setPrevShape(rectangle);
        this.applyPrevShape();
    }

    public void applyShape(BucketPainting bucketPainting) {
        this.setPrevShape(bucketPainting);
        this.applyPrevShape();
    }
}
