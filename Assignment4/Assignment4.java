// Assignment #: 4
// Arizona State University - CSE205
// Name: Your name
// StudentID:
// Lecture:
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;
import java.util.*;

public class Assignment4
 {
  public static void main (String[] args)
   {
       // local variables, can be accessed anywhere from the main method
       char input1 = 'Z';
       String inputInfo;
       String projName, projLocation;
       int projNumber;
       double initialFunding, expenditure;
       String line = new String();

       //Project object to be used in this assignment;
       Project project1 = new Project(0);

       printMenu();

       //Create a Scanner object to read user input
       Scanner scan = new Scanner(System.in);


       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = scan.nextLine();

         if (line.length() == 1)
          {
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           // matches one of the case statement
           switch (input1)
            {
             case 'A':   //Add Project
               System.out.print("Please enter the project information:\n");
               System.out.print("Enter a project name:\n");
               projName = scan.nextLine();
               System.out.print("Enter a project number:\n");
               projNumber = Integer.parseInt(scan.nextLine());
               System.out.print("Enter a project location:\n");
               projLocation = scan.nextLine();
               System.out.print("Enter a project initial funding:\n");
               initialFunding = Double.parseDouble(scan.nextLine());
               project1 = new Project(initialFunding);
               project1.setName(projName);
               project1.setNumber(projNumber);
               project1.setLocation(projLocation);
               break;
             case 'D':   //Display Project
               System.out.print(project1);
               break;
             case 'Q':   //Quit
               break;
             case 'R':   //Add Expenditure
               System.out.print("Please enter any additional expenditure:\n");
               expenditure = Double.parseDouble(scan.nextLine());
               boolean success = project1.addExpenditure(expenditure);
               if (success == false)
                 System.out.println("The entered expenditure is not accepted");
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
        } while (input1 != 'Q' || line.length() != 1);
   }


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd Project\n" +
                        "D\t\tDisplay Project\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tAdd Expenditure\n" +
                        "?\t\tDisplay Help\n\n");
  }
}

