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

	// rebind could throw a RemoteException, so this method is declared as "throws RemoteException"
	public void createAccount(int i, String name) throws RemoteException{
		BankAccountInterfaceImpl x = new BankAccountInterfaceImpl(i);
		// create a stub of the object so it will be called by reference
		BankAccountInterface stub = (BankAccountInterface) UnicastRemoteObject.exportObject(x, 0);
		// register the stub with the registry
		LocateRegistry.getRegistry(8080).rebind(name, stub);
	};

	public static void main(String arg[]) throws AccessException, RemoteException {
		System.out.println("Starting the server");
		Registry r = LocateRegistry.createRegistry(8080);
		r.rebind("service", new TransferServer());
		System.out.println("The server is started");
	}


	public boolean add(BankAccount account, int add) throws RemoteException{
		int temp = account.getValue();
		account.setValue(account.getValue() + add);

		return account.getValue() == temp+add;
	}

	public boolean add(BankAccountInterface account, int add) throws RemoteException{
		int temp = account.getValue();
		account.setValue(account.getValue() + add);

		return account.getValue() == temp+add;
	}
}
