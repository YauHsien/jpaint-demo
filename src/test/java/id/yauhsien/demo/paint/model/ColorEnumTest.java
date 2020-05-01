package id.yauhsien.demo.paint.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorEnumTest {

    @Test
    public void enum_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ColorEnum.valueOf("abc"));
        Assertions.assertEquals(ColorEnum.a, ColorEnum.valueOf("a"));
        Assertions.assertEquals("b", ColorEnum.b.toString());
    }
}