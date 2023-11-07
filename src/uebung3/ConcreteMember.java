package uebung3;

public class ConcreteMember implements Member {
    private Integer id = null;
    public ConcreteMember(Integer id){
        this.id = id;
    }

    public Integer getID(){
        return this.id;
    }
    public void setID ( Integer id ) {
        this.id = id;
    }
    public String toString(){
        return "Member (ID = " + this.getID() + ")";
    }
}
