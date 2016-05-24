// Assignment #: 11
// Name: Your name
// StudentID:
// Lecture:
// Description: Assignment 11 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//      enter the next choice until the choice of 'Q' (Quit) is entered.

import java.io.*;

public class Assignment11
 {
  public static void main (String[] args) throws IOException
   {
       char input1;
       String line = new String();
       int mazeSize = 10;
       String[] mazeInfo = new String[mazeSize];

       printMenu();

       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader stdin = new BufferedReader(isr);

       do  // will ask for user input
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           // matches one of the case statements
           switch (input1)
            {
             case 'E':   //Enter Problem parameters
               try
                {
                 System.out.print("Please specify how many numbers will be entered:\n");
                 int stackSize = Integer.parseInt(stdin.readLine().trim());

                 System.out.print("Please specify how many holding stacks to use:\n");
                 int numberOfHoldingStacks = Integer.parseInt(stdin.readLine().trim());

                 if (stackSize > 0 && numberOfHoldingStacks > 0)
                  {
                   //Create a re-arranger object
                   StackRearranger rearranger = new StackRearranger(stackSize, numberOfHoldingStacks);

                   //Read-in numbers and add them to the stack
                   for (int i = 0; i < stackSize; i++)
                    {
                      System.out.print("PLease enter a number:\n");
                      int number = Integer.parseInt(stdin.readLine().trim());
                      rearranger.addNumberToStack(number);
                    }

                   //rearrange the stack into a sorted order
                   boolean success = rearranger.rearrange();

                   if (success == true)
                    {
                     System.out.print("\nre-arrange completed\n");
                    }
                   else
                    {
                     System.out.print("\nrearrange was not completed\n");
                    }
                  }
                 else
                  {
                    System.out.print("Please enter a positive integer\n");
                  }
                }
               catch(NumberFormatException ex)
                {
                    System.out.print("Please enter a valid number\n");
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
        } while (input1 != 'Q' || line.length() != 1);
   }


  /** The method printMenu displays the menu to a user**/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "E\t\tEnter Problem Parameters\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}
