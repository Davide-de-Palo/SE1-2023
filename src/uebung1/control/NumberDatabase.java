package uebung1.control;

public class NumberDatabase {
    static String[] numbers =  {"eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun","zehn"};

    static String zahlenSuche(int number) throws IndexOutOfBoundsException{
        try {
            return numbers[number-1];
        }
        catch (IndexOutOfBoundsException use){
            return "Übersetzung der Zahl "+number+" nicht möglich ("+Translator.version+")";
        }
        catch (NegativeArraySizeException use){
            return "Übersetzung der Zahl "+number+" nicht möglich ("+Translator.version+")";
        }
    }
}
