// Assignment #: 8
//        Name: Austin Efnor
//    StudentID: 1208675503
//      Lecture: MWF 9
//  Description: The class Budget represents a budget of a project

import java.io.Serializable;
import java.text.NumberFormat;

public class Budget implements Serializable
{
	private double initialFunding;
	private double spending;
	private double currentBalance;

	//Constructor to initialize all member variables
	public Budget(double funding)
	{
		initialFunding = funding;
		spending = 0.0;
		currentBalance = initialFunding - spending;
	}

	//add some additional spending
	public boolean addSpending(double additionalSpending)
	{
		if (additionalSpending > 0 && additionalSpending <= currentBalance)
		{
			spending += additionalSpending;
			currentBalance = initialFunding - spending;
			return true;
		}
		else
			return false;
	}

	//toString() method returns a string containg its initial funding
	//spending and current balance
	public String toString()
	{
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String result = "Budget:"
				+ "\nInitial Funding\t" + fmt.format(initialFunding)
				+ "\nSpending\t" + fmt.format(spending)
				+ "\nCurrent Balance\t" + fmt.format(currentBalance);
		return result;
	}
}

