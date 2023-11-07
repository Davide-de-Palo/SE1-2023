package uebung3;

import java.io.IOException;
import java.util.ArrayList;
import uebung3.PersistenceException.ExceptionType;

public class GenericContainer  <E extends Member> {
    private static GenericContainer objectContainer;
    PersistenceStrategy strategy = null;
    private ArrayList<E> container = new ArrayList<E>();

    private GenericContainer(){
    }

    public static GenericContainer getContainer(){
        if (objectContainer == null){
            objectContainer = new GenericContainer();
        }
        return objectContainer;
    }
    public void setStrategy(PersistenceStrategy strategy){
        this.strategy = strategy;
    }
    public void addMember(E member) throws ContainerException {
        try{
            for(Member m : container){
                if (m.getID() == member.getID()){
                    throw new ContainerException("Das Member-Objekt mit der ID"+ member.getID()+" ist bereits vorhanden!");
                }
            }
            container.add(member);
        }
        catch (NullPointerException e){
            throw new ContainerException();
        }
    }
    public String deleteMember(Integer ID){
        for(Member m : container){
            if(m.getID()== ID){
                container.remove(m);
                return "";
            }
        }
        return ID+" ist nicht im Container.";
    }

    public ArrayList<E> getCurrentList(){
        return container;
    }

    public int size(){
        return container.size();
    }
    public void store() throws PersistenceException {
        //Das kann eigentlich nicht sein, da schon in PersistenceStrategyStream die IOExceptions behandelt werden.
        try{
            strategy.openConnection();
            strategy.save(container);
            strategy.closeConnection();
        } catch (IOException e) {
            throw new PersistenceException(ExceptionType.IOException,"Es konnt die Liste nicht geladen werden");
        }
    }
    public void load() throws PersistenceException {
        //Das kann eigentlich nicht sein, da schon in PersistenceStrategyStream die IOExceptions und ClassNotFoundException behandelt werden.
        try {
            strategy.openConnection();
            container = (ArrayList<E>) strategy.load();
            strategy.closeConnection();
        } catch (IOException e) {
            throw new PersistenceException(ExceptionType.IOException,"Es konnt die Liste nicht geladen werden");
        } catch (ClassNotFoundException e){
            throw new PersistenceException(ExceptionType.ClassNotFoundException,"Es konnt die Liste nicht geladen werden");
        }

    }
}
