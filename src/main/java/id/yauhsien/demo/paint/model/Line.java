package id.yauhsien.demo.paint.model;

import id.yauhsien.demo.paint.ui.MessageEnum;

public class Line extends Rectangle {

    public Line(int x1, int x2, int y1, int y2) {
        super(x1, x2, y1, y2);
        if (x1 != x2 && y1 != y2)
            throw new IllegalArgumentException(MessageEnum.BadCommand.toString());
    }
}
