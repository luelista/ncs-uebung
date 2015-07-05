package both;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TransferServerInterface extends Remote{
	
	void createAccount(int i, String name) throws RemoteException;

	boolean add(BankAccount account, int add) throws RemoteException;
	
	//boolean add(BankAccountInterface account, int add);
}

