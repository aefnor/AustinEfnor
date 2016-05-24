
//Assignment #: 1
//Arizona State University - CSE205
//      Name: Austin efnor 
// StudentID: 1208675503
//   Lecture: 9AM
//Description: This class reads an integer from a keyboard and prints the amount of negative, even and the small integer
import java.util.Scanner;
public class Assignment2 {

	public static void main(String[] args) {
		//Declaring Scanner
		Scanner scan = new Scanner(System.in);
		//Declaring all other variables
		int evenCount = 0;
		int smallInt = Integer.MAX_VALUE;
		int negCount = 0;
		int userIn;
		
		do{
			userIn = scan.nextInt();
			//Getting the smallest integer
			if ( userIn <= smallInt)
                smallInt = userIn;
			//Checking if a number is even
			if((userIn%2)==0)
				evenCount++;
			//checking if a number is odd
			if(userIn<0)
				negCount+=userIn;
		}
		while(userIn != 0 );
		//Outputting the smallest int, along with amount of even and negative integers
		System.out.print("The minimum integer is " +smallInt+
				"\nThe count of even integers in the sequence is " +evenCount+
				"\nThe sum of negative integers is " +negCount + "\n");
		//closing Scanner
		scan.close();
	}

}
