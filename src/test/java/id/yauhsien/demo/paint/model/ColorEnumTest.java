package id.yauhsien.demo.paint.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ColorEnumTest {

    @Test
    public void enum_test() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> ColorEnum.valueOf("abc"));
        Assertions.assertEquals(ColorEnum.a, ColorEnum.valueOf("a"));
        Assertions.assertEquals("b", ColorEnum.b.toString());
        Assertions.assertEquals(CommandEnum.C, CommandEnum.valueOf("C"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> CommandEnum.valueOf("C "));
    }

    @Test
    public void other_test() {
        Assertions.assertEquals(3, "hello,   wo  rld".split("\\s+").length);
    }

    @Test
    public void int_parsing_test() {
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.parseInt("3."));
        Assertions.assertEquals(3, Integer.parseInt("3"));
    }
}