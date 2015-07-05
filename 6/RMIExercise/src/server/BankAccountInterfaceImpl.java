package server;

import both.BankAccountInterface;

public class BankAccountInterfaceImpl implements BankAccountInterface{
	private int value;
	
	public BankAccountInterfaceImpl(int i){
		value = i;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int i){
		if (i>0)
			value = i;
	}

}
