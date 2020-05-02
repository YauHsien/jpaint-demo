package id.yauhsien.demo.paint.model;

public class Pixel {

    private int column;
    private int row;
    private ColorEnum color;
    private int pivot;

    public Pixel(int column, int row) {
        this.column = column;
        this.row = row;
        this.color = ColorEnum.background;
    }

    public Pixel(int pivot, int column, int row) {
        this.column = column;
        this.row = row;
        this.pivot = pivot;
        this.color = ColorEnum.background;
    }

    public Pixel(int column, int row, ColorEnum color) {
        this.column = column;
        this.row = row;
        this.color = color;
    }

    public Pixel(int pivot, int column, int row, ColorEnum color) {
        this.column = column;
        this.row = row;
        this.color = color;
        this.pivot = pivot;
    }

    public ColorEnum getColor() {
        return color;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public int hashCode() {
        return pivot * row + column;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pixel other = (Pixel) obj;
        if (this.hashCode() != other.hashCode())
            return false;
        return true;
    }
}
