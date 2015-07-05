package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import both.*;

class Client {
    public static void main(String arg[]) throws RemoteException, NotBoundException {
	   boolean worked;

       Registry r = LocateRegistry.getRegistry("localhost", 8080);
       TransferServerInterface service = (TransferServerInterface)r.lookup("service");

	   // ############# call by value #########################
       BankAccount y = new BankAccount(100);
       
       System.out.println("After Initialization:\t\t"+y.getValue()+"\n");
       
       worked = service.add(y,-200);
       System.out.println("Trying to take 200 worked: \t" + worked);
       System.out.println("Value afterwards: \t\t"+y.getValue());
       
       worked = service.add(y,1);
       System.out.println("\nTrying to add 1 worked: \t" + worked);
       System.out.println("Value afterwards: \t\t"+y.getValue());
		// Adding 1 did not work as expected because the BankAccount object
		// is passed by value, so the balance is changed in the copy of the
		// object in the Server process, but remains unchanged in the local
		// copy.


		// fixed call by value
		y = service.addCallByBalue(y,1);
		System.out.println("\nTrying to add 1 worked: \t" + worked);
		System.out.println("Value afterwards: \t\t"+y.getValue());


		// ############# call by ref #########################
		// 6.4.1c
		// creating a new account on the server
		service.createAccount(100, "MyAccount");
		// requesting a reference to the newly created account
		BankAccountInterface iface = (BankAccountInterface)r.lookup("MyAccount");

		System.out.println("\nbalance: " + iface.getValue());
		worked = service.add(iface, -200);
		System.out.println("Withdrawing 200 dollar worked? "+worked);

		System.out.println("\nbalance: " + iface.getValue());
		worked = service.add(iface, 1);
		System.out.println("Depositing 1 dollar worked? "+worked);

		System.out.println("\nbalance: " + iface.getValue());

	}
}
