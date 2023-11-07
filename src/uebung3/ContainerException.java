package uebung3;

public class ContainerException extends Exception{
    public ContainerException(){
        super("ContainerException");
    }
    public ContainerException(String expetionText){
        super (expetionText);
    }
}

