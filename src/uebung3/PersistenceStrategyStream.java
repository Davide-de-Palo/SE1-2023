package uebung3;

import java.util.List;
import java.io.*;
import uebung3.PersistenceException.ExceptionType;
public class PersistenceStrategyStream<E> implements PersistenceStrategy<E> {

    // URL of file, in which the objects are stored
    private String location1 = "objects.ser";
    private String location = "Text.txt";
    private FileOutputStream fileOut;
    private ObjectOutputStream oos;
    private FileInputStream fileIn;
    private ObjectInputStream ois;


    // Backdoor method used only for testing purposes, if the location should be changed in a Unit-Test
    // Example: Location is a directory (Streams do not like directories, so try this out ;-)!
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    /**
     * Method for opening the connection to a stream (here: Input- and Output-Stream)
     .     * In case of having problems while opening the streams, leave the code in methods load
     * and save.
     */
    public void openConnection() throws PersistenceException {
        try {
            fileOut = new FileOutputStream(location);
            oos = new ObjectOutputStream(fileOut);
            fileIn = new FileInputStream(location);
            ois = new ObjectInputStream(fileIn);
        }
        catch (IOException e){
            throw new PersistenceException(ExceptionType.IOException,"Fehler beim oeffnen der Verbindung");
        }
    }
    @Override
    /**
     * Method for closing the connections to a stream
     */
    public void closeConnection() throws PersistenceException {
        try {
            oos.close();
            ois.close();
        }
        catch (IOException e){
            throw new PersistenceException(ExceptionType.IOException, "IO-Fehler beim Öffnen der Verbindung");
        } finally {
            fileOut = null;
            oos = null;
            fileIn = null;
            ois = null;
        }
    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<E> listMember) throws PersistenceException  {
        try {
            oos.writeChars("Test");
            //oos.writeObject(listMember);
        } catch (IOException e) {
            throw new PersistenceException(ExceptionType.IOException,"Fehler beim Speichern der Mitgliederliste");
        }
    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     * Take also a look at the import statements above ;-!
     */
    public List<E> load() throws PersistenceException {
        List<E> newListe =  null;
        try {
            Object obj = ois.readObject();
            if (obj instanceof List<?>)
                newListe =  (List<E>) obj;
            return newListe;
        } catch (IOException e) {
            throw new PersistenceException(ExceptionType.IOException, "IO-Fehler beim Laden der Daten");
        } catch (ClassNotFoundException e) {
            throw new PersistenceException(ExceptionType.ClassNotFoundException, "Klasse nicht gefunden beim Laden der Daten");
        } catch (NullPointerException e){
            throw new PersistenceException(ExceptionType.NoStrategyIsSet, "Es gibt keine Strategie");
        }

    }
}
