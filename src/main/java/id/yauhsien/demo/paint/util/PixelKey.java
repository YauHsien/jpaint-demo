package id.yauhsien.demo.paint.util;

public class PixelKey {

    private int pivot;
    private int column;
    private int row;

    public PixelKey(int width, int column, int row) {
        this.pivot = width;
        this.column = column;
        this.row = row;
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
        PixelKey other = (PixelKey) obj;
        if (this.hashCode() != other.hashCode())
            return false;
        return true;
    }
}
