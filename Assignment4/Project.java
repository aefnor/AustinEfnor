import java.text.*;
public class Project {
	private String projName;
	private int projNumber;
	private String projLocation;
	private Budget projBudget;
	
	NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	
	public Project(double initialFunding) {
		projName = "?";
		projNumber = 0;
		projLocation = "?";
		projBudget = new Budget(initialFunding);
	}

	public void setName(String projName) {
		this.projName = projName;
	}
	public String getName(String projName) {
		return projName;
	}

	public void setNumber(int projNumber) {
		this.projNumber = projNumber;
	}
	public int getNumber(int projNumber) {
		return projNumber;
		
	}
	public Budget getBudget() {
		return getBudget();
		
	}

	public void setLocation(String projLocation) {
		this.projLocation = projLocation;
	}
	public String getLocation(String projLocation) {
		return projLocation;
	}

	public boolean addExpenditure(double amount) {
		return projBudget.addSpending(amount);
	}
	public String toString(){
		/*\nProject Name:\t\tConstruction Project\n 
		Project Number:\t\t15\n 
		Project Location:\tPhoenix\n 
		 Budget:\n
		 Initial Funding\t$0.00\n
		 Spending\t$0.00\n
		 Current Balance\t$0.00\n\n*/
		String r;
		return r = "\nProject Name:\t\t" + projName + "\nProject Number:\t\t" + projNumber + "\nProject Location:\t" + projLocation+ "\n" + projBudget.toString() ;
		
	}

}
