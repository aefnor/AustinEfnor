import java.text.*;
public class Budget {
	private double initialFunding;
	private double spending = 0.0;
	private double currentBalance;
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	public Budget(double funding) {
		initialFunding = funding;;
		spending = 0.0;
		currentBalance= initialFunding - spending;
		
		}
	public boolean addSpending(double amount){
		//If the parameter value is positive and is less than or equals to currentBalance, it should be added to spending, and currentBalance 
		//should be re-computed as initialFunding-spending, and the method should return true. Otherwise, the method should not change any value and return false.
		if(amount>0 & amount<=currentBalance){
			spending+=amount;
			currentBalance = initialFunding-spending;
			return true;
		}
		else{
			return false;
		}
	}
	public String toString(){
		String result;
		return result = "Budget:\nInitial Funding\t" + fmt.format(initialFunding) + "\nSpending\t" + fmt.format(spending) + "\nCurrent Balance\t" + fmt.format(currentBalance) + "\n\n";
		
	}
}
