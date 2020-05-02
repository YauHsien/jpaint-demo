package id.yauhsien.demo.paint.model;

import java.util.*;

public class BucketPainting implements Shape {

    private int x;
    private int y;
    private ColorEnum color;

    public BucketPainting(int x, int y, ColorEnum color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Get pixels by Flood Fill Algorithm.
     * @param canvas The environment for FFA
     * @return flood pixels
     */
    @Override
    public Collection<? extends Pixel> getPixels(Canvas canvas) {
        Set<Pixel> pixels = new HashSet<>();
        Set<Integer> breadcrumb = new HashSet<>();
        ColorEnum originColor = canvas.getColor(x, y);
        if (originColor == color)
            return pixels;
        Queue<Pixel> floodingPixels = new LinkedList<>();
        floodingPixels.add(new Pixel(x, y, color));
        while (floodingPixels.size() > 0) {
            Pixel replacingPixel = floodingPixels.remove();
            int x1 = replacingPixel.getColumn();
            int y1 = replacingPixel.getRow();
            Pixel pixel = new Pixel(canvas.getW(), x1, y1, color);
            pixels.add(pixel);
            breadcrumb.add(pixel.hashCode());
            if (x1 > 1 && !breadcrumb.contains(canvas.getW()*y1+x1-1) && canvas.getColor(x1-1, y1) == originColor)
                floodingPixels.add(new Pixel(x1-1, y1));
            if (x1 < canvas.getW() && !breadcrumb.contains(canvas.getW()*y1+x1+1) && canvas.getColor(x1+1, y1) == originColor)
                floodingPixels.add(new Pixel(x1+1, y1));
            if (y1 > 1 && !breadcrumb.contains(canvas.getW()*(y1-1)+x1) && canvas.getColor(x1, y1-1) == originColor)
                floodingPixels.add(new Pixel(x1, y1-1));
            if (y1 < canvas.getH() && !breadcrumb.contains(canvas.getW()*(y1+1)+x1) && canvas.getColor(x1, y1+1) == originColor)
                floodingPixels.add(new Pixel(x1, y1+1));
        }
        return pixels;
    }

    @Override
    public int getW() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public int getH() {
        throw  new UnsupportedOperationException();
    }
}
