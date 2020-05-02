package id.yauhsien.demo.paint.model;

import id.yauhsien.demo.paint.ui.MessageEnum;

public class Line extends Rectangle {

    /**
     * Create a line by rectangle creation. Only horizontal and vertical lines are supported.
     * @param x1 First x coordinate
     * @param x2 Second x coordinate
     * @param y1 First y coordinate
     * @param y2 Second y coordinate
     */
    public Line(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
        if (x1 != x2 && y1 != y2)
            throw new UnsupportedOperationException(MessageEnum.LineCommandNotSupported.toString());
    }
}
