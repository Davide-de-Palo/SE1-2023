package uebung1.view;

import uebung1.control.GermanTranslator;
import uebung1.control.Translator;
import uebung1.control.TranslatorFactory;

public class Client {

	private Translator translator;
		public Client(Translator translator){
			this.translator = translator;
		}
		/*
		 * Methode zur Ausgabe einer Zahl auf der Console
		 * (auch bezeichnet als CLI, Terminal)
		 *
		 */
		 public void display( int aNumber ){
			// In dieser Methode soll die Methode translateNumber
			// mit dem übergegebenen Wert der Variable aNumber
			// aufgerufen werden.
			//
			// Strenge Implementierung gegen das Interface Translator gewuenscht!
			//Translator translator = TranslatorFactory.creatGermanTranslator();
			System.out.println("Das Ergebnis der Berechnung: " + this.translator.translateNumber(aNumber));

		 }

		 public void setTranslator(Translator translator){
			 this.translator = translator;
		 }


}





