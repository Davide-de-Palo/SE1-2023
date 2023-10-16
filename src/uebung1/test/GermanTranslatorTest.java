package uebung1.test;

import org.junit.jupiter.api.Test;
import uebung1.control.GermanTranslator;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
     void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(5);
        assertEquals(value, "fünf");
    }
    @Test
    void aIndexoutOfBounceTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(11);
        assertEquals(value, "Übersetzung der Zahl 11 nicht möglich (1.0)");
    }
    @Test

    void aNegativTest() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(-1);
        assertEquals(value, "Übersetzung der Zahl -1 nicht möglich (1.0)");
    }
    @Test
    void aNegativ2Test() {
        GermanTranslator translator = new GermanTranslator();
        String value = translator.translateNumber(-8);
        assertEquals(value, "Übersetzung der Zahl -8 nicht möglich (1.0)");
    }
}