import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uebung2.ConcreteMember;
import uebung2.Container;
import uebung2.Member;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {
    Container container = new Container();

    @BeforeEach
    void setUp(){
        container = new Container();
    }
    @Test
    void ContainerTestSize() {
        assertEquals(container.size(), 0);
    }
    @Test
    void ContainerTestAddMember() throws Container.ContainerException {
        Member m1 = new ConcreteMember(1);
        container.addMember(m1);
        assertEquals(container.size(), 1);
    }

    @Test
    void ContainerTestAddMember2() throws Container.ContainerException {
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(container.size(), 2);
    }

    @Test
    void ContainerTestDeleteMember() throws Container.ContainerException{
        Member m1 = new ConcreteMember(1);
        Member m2 = new ConcreteMember(2);
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(container.deleteMember(4),"4 ist nicht im Container.");
    }
    @Test
    void ContainerTestDeleteMember2() throws Container.ContainerException{
        Member m1 = new ConcreteMember();
        Member m2 = new ConcreteMember();
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(container.deleteMember(0),"0 ist nicht im Container.");
    }
    @Test
    void ContainerTestDeleteMember3() throws Container.ContainerException{
        Member m1 = new ConcreteMember();
        Member m2 = new ConcreteMember();
        container.addMember(m1);
        container.addMember(m2);
        container.deleteMember(m2.getID());
        assertEquals(container.size(),1);
    }
    @Test
    void ContainerTestDeleteMember4() throws Container.ContainerException{
        Member m1 = new ConcreteMember();
        Member m2 = new ConcreteMember();
        container.addMember(m1);
        container.addMember(m2);
        container.deleteMember(m2.getID());
        container.deleteMember(m1.getID());
        assertEquals(container.size(),0);
    }
    @Test
    void ContainerTestDeleteMember5() throws Container.ContainerException{
        Member m1 = new ConcreteMember();
        Member m2 = new ConcreteMember();
        container.addMember(m1);
        container.addMember(m2);
        container.deleteMember(2);
        container.deleteMember(1);
        assertEquals(container.deleteMember(2),"2 ist nicht im Container.");
    }
    @Test
    void ContainerTestDump() throws Container.ContainerException{
        Member m1 = new ConcreteMember();
        Member m2 = new ConcreteMember();
        container.addMember(m1);
        container.addMember(m2);
        container.dump();
        assertEquals(container.size(),2);
    }
}