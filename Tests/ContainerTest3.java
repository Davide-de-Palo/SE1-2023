import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uebung3.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest3 {
    GenericContainer container;
    MemberView mV;
    @BeforeEach
    void setUp(){
        container  = GenericContainer.getContainer();
        mV = new MemberView();
    }
    @AfterEach
    void clear(){
        container = null;
    }
    @Test
    void ContainerStrategyNullTest() {
        try {
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(2));
            container.addMember(new ConcreteMember(3));
            container.addMember(new ConcreteMember(4));
        } catch (ContainerException e) {
            throw new RuntimeException(e);
        }

        assertThrows(PersistenceException.class, () -> {container.store();});
    }
    @Test
    void ContainerPersistenceStrategyMongoDBTest(){
        try {
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(2));
            container.addMember(new ConcreteMember(3));
            container.addMember(new ConcreteMember(4));
        } catch (ContainerException e) {
            throw new RuntimeException(e);
        }
        PersistenceStrategy psmdb = new PersistenceStrategyMongoDB();
        container.setStrategy(psmdb);
        assertThrows(UnsupportedOperationException.class, ()-> {container.store();});
        assertThrows(UnsupportedOperationException.class, ()-> {container.load();});
    }

    @Test
    void ContainerWrongFileStreamTest(){
        try {
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(2));
            container.addMember(new ConcreteMember(3));
            container.addMember(new ConcreteMember(4));
        } catch (ContainerException e) {
            throw new RuntimeException(e);
        }
        PersistenceStrategyStream psmS = new PersistenceStrategyStream();
        container.setStrategy(psmS);
        psmS.setLocation("falschesFile.lol");
        assertThrows(PersistenceException.class, ()-> {container.store();});
        assertThrows(PersistenceException.class, ()-> {container.load();});
    }
    void RoundTripTest(){
        try {
            container.addMember(new ConcreteMember(1));
            container.addMember(new ConcreteMember(2));
            container.addMember(new ConcreteMember(3));
            container.addMember(new ConcreteMember(4));
            assertEquals(4,container.size());
            PersistenceStrategyStream psmS = new PersistenceStrategyStream();
            container.setStrategy(psmS);
            container.store();
            assertEquals(4,container.size());
            container.deleteMember(1);
            assertEquals(3,container.size());
            container.load();
            assertEquals(4,container.size());
            container.deleteMember(1);
            container.deleteMember(2);
            container.deleteMember(3);
            container.deleteMember(4);
            assertEquals(0,container.size());
            container.load();
            assertEquals(4,container.size());
        } catch (ContainerException e) {
            throw new RuntimeException(e);
        } catch (PersistenceException e) {
            throw new RuntimeException(e);
        }
    }
}