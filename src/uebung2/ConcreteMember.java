package uebung2;

public class ConcreteMember implements Member{
    private static int count = 1;
    private int id = 0;
    public ConcreteMember(){
        this.id = count++;
    }

    public Integer getID(){
        return this.id;
    }

    public String toString(){
        return "Member (ID = " + this.getID() + ")";
    }
}
