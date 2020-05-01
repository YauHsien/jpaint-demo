package id.yauhsien.demo.paint.model;

public enum BorderColorEnum {

    virtical('|'),
    horizontal('-');

    private char character;

    BorderColorEnum(char character) {
        this.character = character;
    }
}
