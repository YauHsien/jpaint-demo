package id.yauhsien.demo.paint.model;

public enum BorderColorEnum {

    vertical("|"),
    closingVertical("|\n"),
    horizontal("-");

    private String symbols;

    BorderColorEnum(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return symbols;
    }
}
