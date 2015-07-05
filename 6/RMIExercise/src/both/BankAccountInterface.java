package both;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankAccountInterface extends Remote {
	// all methods need to be declared with "throws RemoteException" as per the docs
	int getValue() throws RemoteException;
	void setValue(int i) throws RemoteException;
}
