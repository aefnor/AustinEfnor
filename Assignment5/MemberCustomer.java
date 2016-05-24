
public class MemberCustomer extends Customer {
	private int pointsCollected;
	
	public MemberCustomer(String fName, String lName, double amount, int year, int month, int date, int points){
		super(fName,lName,amount,year,month,date);
		pointsCollected = points;
	}
	
	public void computePaymentAmount(){
		if(pointsCollected>100){
			super.paymentAmount = purchasedAmount *.8;
		}
		else{
			super.paymentAmount = purchasedAmount *.9;
		}
		pointsCollected += (int)(super.purchasedAmount * 0.01);
	}
	
	public String toString(){
		
		String s = "\nMember Customer:" + super.toString() + "Collected Points:\t"+ pointsCollected + "\n\n";
		return s;
	}

}
