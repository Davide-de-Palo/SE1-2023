import uebung2.ConcreteMember;
import uebung2.Container;
import uebung2.Member;

public class ContainerTest2 {

    public static void main(String[] arg) throws Container.ContainerException {
        Container container = new Container();
        Member m1 = new ConcreteMember();
        Member m2 = new ConcreteMember();
        container.addMember(m1);
        container.addMember(m2);
        container.deleteMember(1);
        container.deleteMember(2);
        container.dump();
        System.out.println(container.size());
        container.dump();
    }



}
