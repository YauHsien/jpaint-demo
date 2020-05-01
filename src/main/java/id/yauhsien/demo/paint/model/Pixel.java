package id.yauhsien.demo.paint.model;

public class Pixel {

    private int colomn;
    private int row;
    private ColorEnum color;

    public Pixel(int colomn, int row, ColorEnum color) {
        this.colomn = colomn;
        this.row = row;
        this.color = color;
    }
}
