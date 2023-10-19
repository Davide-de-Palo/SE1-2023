package uebung1.view;

import uebung1.control.GermanTranslator;


/**
 *  Anwendung des Musters "Dependency Injection (DI)"
 *  In Praxis eher üblich: Verwendung z.B. SpringBoot
 */

public class Assembler {

    public  static void main(String[] args){
        GermanTranslator translator = new GermanTranslator();
        Client client = new Client(translator);
        client.display(2);
        client.setTranslator( new GermanTranslator());
        client.display(3);
    }
}
