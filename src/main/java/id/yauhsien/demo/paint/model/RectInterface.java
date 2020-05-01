package id.yauhsien.demo.paint.model;

import java.util.Collection;

public interface RectInterface {
    Collection<? extends Pixel> getPixels();

    int getW();

    int getH();
}
