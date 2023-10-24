package uebung2;
import java.util.ArrayList;
public class Container {
    private ArrayList<Member> container = new ArrayList<Member>();
    private class ContainerException extends Exception{
        public ContainerException(){
            super("ContainerException");
        }
        public ContainerException(String expetionText){
            super (expetionText);
        }
    }

    public void addMember(Member member) throws ContainerException{
        try{
            for(Member m : container){
                if (m.getID() == member.getID()){
                    throw new ContainerException("Das Member-Objekt mit der ID"+ member.getID()+" ist bereits vorhanden!");
                }
            }
            container.add(member);
        }
        catch ( ContainerException e){
        }
    }
    public String deleteMember(Integer ID){
        for(Member m : container){
            if(m.getID()== ID){
                container.remove(m);
                return "";
            }
        }
        return ID+" ist nicht im Container;";
    }

    public void dump(){
        for (Member m : container){
            System.out.println(m.toString());
        }
    }

    public int size(){
        return container.size();
    }

}
