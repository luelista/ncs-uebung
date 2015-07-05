package both;


public class BankAccount{

	private int value;
	public BankAccount(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int i){
		if(i>0)
			value = i;
	}
}