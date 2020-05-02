package id.yauhsien.demo.paint.util;

public class PixelKey {

    private int pivot;
    private int column;
    private int row;

    /**
     * Create a key of a pixel, for usages on HashSet and HashMap.
     * @param width Base number for hash-code creation
     * @param column X coordinate
     * @param row Y coordinate
     */
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
