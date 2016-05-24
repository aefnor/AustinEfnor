import java.text.NumberFormat;

public class NonMemberCustomer extends Customer {
	private double visitFee;
	NumberFormat fmt = NumberFormat.getCurrencyInstance();

	public NonMemberCustomer(String fName, String lName, double amount, int year, int month, int date, double fee){
		super(fName,lName,amount,year,month,date);
		visitFee=fee;
	}
	
	public void computePaymentAmount(){
		super.paymentAmount = super.purchasedAmount	+ visitFee;
	}
	
	public String toString(){
		//super.toString();
		//String s = "\nMember Customer:" + "\nFirst name:\t\t" + firstName + "\nLast name:\t\t" + lastName + "\nPurchased Amount:\t" + purchasedAmount+ "\nPurchased Date:\t\t" + purchasedDate + "\nPayment Amount:\t\t$" + paymentAmount + "\nVisit Fee:\t\t$" + visitFee + "\n\n";
		String s = "\nNonMember Customer:"+ super.toString() + "Visit Fee:\t\t" + fmt.format(visitFee) + "\n\n";
		return s;
	}
	
}
