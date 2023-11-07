package uebung3;

import uebung1.control.Translator;

public class Client {

	public static void main(String[] args) {
		GenericContainer container = GenericContainer.getContainer();
		MemberView mV = new MemberView();

		try {
			container.addMember(new ConcreteMember(1));
			container.addMember(new ConcreteMember(2));
			container.addMember(new ConcreteMember(3));
			container.addMember(new ConcreteMember(4));
			container.addMember(new ConcreteMember(5));
			container.addMember(new ConcreteMember(6));
			mV.dump(container.getCurrentList());
			PersistenceStrategyStream pS;
			container.setStrategy(pS = new PersistenceStrategyStream<Member>());
			container.store();
			//pS.setLocation("duHure");
			//container.load();
		} catch (ContainerException e) {
			throw new RuntimeException(e);
		} catch (PersistenceException e){
			throw new RuntimeException(e);
		}
	}

}





