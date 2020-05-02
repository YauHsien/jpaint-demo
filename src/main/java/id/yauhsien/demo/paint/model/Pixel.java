package id.yauhsien.demo.paint.model;

public class Pixel {

    private int column;
    private int row;
    private ColorEnum color;
    private int pivot;

    /**
     * Create a pixel.
     * @param column X coordinate
     * @param row Y coordinate
     */
    public Pixel(int column, int row) {
        this.column = column;
        this.row = row;
        this.color = ColorEnum.background;
    }

    /**
     * Create a pixel.
     * @param column X coordinate
     * @param row Y coordinate
     * @param color A pixel depth attribute
     */
    public Pixel(int column, int row, ColorEnum color) {
        this.column = column;
        this.row = row;
        this.color = color;
    }

    /**
     * Create a pixel for comparison.
     * @param pivot Base number for hash-code creation, normally it applies to width or height
     * @param column X coordinate
     * @param row Y coordinate
     * @param color A pixel depth attribute
     */
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
