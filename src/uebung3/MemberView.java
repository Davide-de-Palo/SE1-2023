package uebung3;
import java.util.List;
public class MemberView <E extends Member>{
    public void dump(List<E> liste){
        for (E m : liste){
            System.out.println(m.toString());
        }
    }
}
