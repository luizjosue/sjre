/**
 * UserInterfaceTeste.java
 *
 * @author Created by Omnicore CodeGuide
 */

package br.ufal.tci.tests.main;

/*import br.ufal.tci.UserInterface.FormBooleanType;
import br.ufal.tci.UserInterface.FormIntegerType;
import br.ufal.tci.UserInterface.FormStringType;*/
import br.ufal.tci.ui.UserInterfaceImpl;
import br.ufal.tci.ui.UserInterface;

public class UserInterfaceTeste{
	
	public static void main(String args[]){
		UserInterface inter = new UserInterfaceImpl();
		inter.getSource();
		/*Variable var = new Variable();
		var.setIdentifier(new Identifier("num"));
		var.setType(new StringType());
		inter.getAsk(var);*/
	}
}

	



