package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import both.*;

class Client {
    public static void main(String arg[]) throws RemoteException, NotBoundException {
       Registry r = LocateRegistry.getRegistry("localhost", 8080);
       TransferServerInterface service = (TransferServerInterface)r.lookup("service");
       service.createAccount(100, "Account");

       BankAccount y = new BankAccount(100);
       
       System.out.println("After Initialization:\t\t"+y.getValue()+"\n");
       
       boolean worked = service.add(y,-200);
       System.out.println("Trying to take 200 worked: \t" + worked);
       System.out.println("Value afterwards: \t\t"+y.getValue());
       
       worked = service.add(y,1);
       System.out.println("\nTrying to add 1 worked: \t" + worked);
       System.out.println("Value afterwards: \t\t"+y.getValue());
    }
}
