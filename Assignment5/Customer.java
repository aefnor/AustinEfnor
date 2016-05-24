import java.text.NumberFormat;

public abstract class Customer {
/*
	firstName	String	The first name of the customer
	lastName	String	The last name of the customer
	purchasedAmount	double	a purchased amount of the customer
	purchasedYear	int	The purchased year of the purchase
	purchasedMonth	int	The purchased month of the purchase
	purchasedDate	int	The purchased date of the purchase
	paymentAmount	double	a payment amount of the customer
*/
	protected String firstName;
	protected String lastName;
	protected double purchasedAmount;
	protected int purchasedYear;
	protected int purchasedMonth;
	protected int purchasedDate;
	protected double paymentAmount = 0.0;
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	//Initalizing the Constructor
	public Customer(String fName, String lName, double amount, int year, int month, int date){
		firstName = fName;
		lastName = lName;
		purchasedAmount = amount;
		purchasedYear = year;
		purchasedMonth = month;
		purchasedDate = date;
	}
	public double getPurchasedAmount(){
		return purchasedAmount;
	}
	public abstract void computePaymentAmount();
	
		 //System.out.print("payment amount computed\n");

		
	public String toString(){
		String s = "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nPurchased Amount:\t" + fmt.format(purchasedAmount) + "\nPurchased Date:\t\t" + purchasedMonth+"/"+purchasedDate+"/"+purchasedYear + "\nPayment Amount:\t\t" + fmt.format(this.paymentAmount) +"\n";
		return s;
	}
}
