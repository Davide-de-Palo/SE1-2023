package uebung3;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteCharsExample {
    public static void main(String[] args) {
        String data = "Hello, World!";

        // Verwenden von try-with-resources, um sicherzustellen, dass die Streams geschlossen werden
        try (FileOutputStream fileOut = new FileOutputStream("Text.txt");
             DataOutputStream dataOut = new DataOutputStream(fileOut)) {

            dataOut.writeChars(data);

            // Da writeChars() nicht automatisch einen Zeilenumbruch oder ein Dateiendezeichen schreibt,
            // könnten Sie hier zusätzlich einen Zeilenumbruch oder ein spezielles Endezeichen hinzufügen, wenn nötig.
            // Zum Beispiel:
            // dataOut.writeChar('\n'); // Für einen Zeilenumbruch

        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
