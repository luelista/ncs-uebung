package server;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import both.*;

class TransferServer extends UnicastRemoteObject  implements TransferServerInterface {
	private static final long serialVersionUID = -3574164174035790417L;
	
	public TransferServer() throws RemoteException{
		
	}

	public void createAccount(int i, String name){
		BankAccountInterfaceImpl x = new BankAccountInterfaceImpl(i);
//		BankAccountInterface stub = ...
//		LocateRegistry.getRegistry(8080).rebind(name, stub);
	};

	public static void main(String arg[]) throws AccessException, RemoteException {
		System.out.println("Starting the server");
		Registry r = LocateRegistry.createRegistry(8080);
		r.rebind("service", new TransferServer());
		System.out.println("The server is started");
	}


	public boolean add(BankAccount account, int add){
		int temp = account.getValue();
		account.setValue(account.getValue() + add);
		
		return account.getValue() == temp+add;
	}
}
