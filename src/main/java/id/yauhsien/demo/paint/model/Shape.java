package id.yauhsien.demo.paint.model;

import java.util.Collection;

public interface Shape {
    Collection<? extends Pixel> getPixels(Canvas canvas);

    int getW();

    int getH();
}
