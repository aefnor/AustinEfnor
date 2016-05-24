// Assignment #: 5
// Arizona State University - CSE205
//         Name: Austin Efnor
//    StudentID: 1208675503
//      Lecture: Your lecture time (MWF 9:00am)
//  Description: The Assignment 5 class displays a menu of choices
//               (add a member or non-member customer,
//               compute their payment amount, count certain students,
//               list students, quit, display menu) to a user.
//               Then it performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
import java.text.NumberFormat;

public class Assignment5
 {
  public static void main (String[] args)
   {
     char input1;
     String inputInfo = new String();
     String line = new String();
     boolean operation;

     // ArrayList object is used to store customer objects
     ArrayList<Customer> customerList = new ArrayList<Customer>();
     Customer custurd = null;
     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add Customer
               System.out.print("Please enter some customer information to add:\n");
               inputInfo = stdin.readLine().trim();
/***********************************************************************************
***  ADD your code here to create an object of one of child classes of Customer class
***  and add it to the customerList
***********************************************************************************/
               
               //CustomerParser parser = new CustomerParser();
               custurd = CustomerParser.parseStringToCustomer(inputInfo);
               //System.out.println(custurd.toString());//debugging
               customerList.add(custurd);
               
               break;
             case 'C':   //Compute Payment Amount
/***********************************************************************************
***  ADD your code here to compute the payment amount for all customers the customerList.
***********************************************************************************/
            	 for(int i=0; i<customerList.size();i++){
            		 customerList.get(i).computePaymentAmount();
            	 }
            	 System.out.print("payment amount computed\n");
               break;
             case 'D':   //Count certain customers
               System.out.print("Please enter a purchased amount:\n");
               inputInfo = stdin.readLine().trim();
               double amount = Double.parseDouble(inputInfo);
               int count = 0;
/***********************************************************************************
***  ADD your code here to count the number of customers who purchased more than the specified amount.
***********************************************************************************/
               for(int i=0; i<customerList.size();i++){
            	   double pamount = customerList.get(i).getPurchasedAmount();
            	   if(pamount > amount){
            		   count++;
            	   }
               }
                NumberFormat money = NumberFormat.getCurrencyInstance();
                System.out.println("The number of customers who purchased more than " + money.format(amount)
                                 + " is: " + count);
               break;
             case 'L':   //List Customers
/***********************************************************************************
***  ADD your code here to print out all customer objects. If there is no customer,
***  print "no customer\n"
***********************************************************************************/
            	 if(customerList.size()==0){
            		 System.out.println("no customer");
            	 }
            	 else
            		 for(int i=0; i<customerList.size();i++){
                		 System.out.print(customerList.get(i).toString());
                	 }
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Customer\n" +
                      "C\t\tCompute Payment Amount\n" +
                      "D\t\tCount Certain Customers\n" +
                      "L\t\tList Customers\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}


