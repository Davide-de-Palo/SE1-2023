package uebung1.control;

public class TranslatorFactory {
    public static Translator creatGermanTranslator() {
        return new GermanTranslator();
    }
}
