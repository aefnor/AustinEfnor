// Assignment #: 10
//         Name: Your name
//    StudentID: Your id
//  Lab Lecture: Your lecture
//  Description: The Assignment 10 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;

public class Assignment10
{
   public static void main(String[] args)
   {
      char input1;
       String inputInfo = new String();
       int operation2;
       String line = new String();

       //create a linked list to be used in this method.
       LinkedList list1 = new LinkedList();

       try
        {
         // print out the menu
         printMenu();

         // create a BufferedReader object to read input from a keyboard
         InputStreamReader isr = new InputStreamReader (System.in);
         BufferedReader stdin = new BufferedReader (isr);

         do
          {
           System.out.print("What action would you like to perform?\n");
           line = stdin.readLine().trim();  //read a line
           input1 = line.charAt(0);
           input1 = Character.toUpperCase(input1);

           if (line.length() == 1)   //check if a user entered only one character
            {
             switch (input1)
              {
               case 'A':   //Add String
                 System.out.print("Please enter a string to add:\n");
                 String str1 = stdin.readLine().trim();
                 System.out.print("Please enter its index:\n");
                 int index = Integer.parseInt(stdin.readLine().trim());
                 try
                  {
                    list1.addElementAt(str1, index);
                  }
                 catch(IndexOutOfBoundsException ex)
                  {
                      System.out.print("The index is out of bounds\n");
                  }
                 break;
               case 'B':   //Add Strings at End
                 System.out.print("Please enter a string to add at the end:\n");
                 String str2 = stdin.readLine().trim();
                 System.out.print("Please enter a number of times to add:\n");
                 String times = stdin.readLine().trim();
                 int howMany = Integer.parseInt(times);
                 list1.addFewAtEnd(str2, howMany);
                 break;
               case 'C':   //Count the size of the linked list
                 int size = list1.size();
                 System.out.print("The size of the linked list is " + size + "\n");
                 break;
               case 'L':   //List Strings
                 System.out.print(list1.toString());
                 break;
               case 'Q':   //Quit
                 break;
               case 'R':  //Remove Strings from end
                 System.out.print("Please enter a number of elements to remove from the end:\n");
                 inputInfo = stdin.readLine().trim();
                 int howMany2 = Integer.parseInt(inputInfo);
                 list1.removeLastFew(howMany2);
                 break;
               case 'S':   //Remove String from List
                 System.out.print("Please enter a string to remove from the linked list:\n");
                 inputInfo = stdin.readLine().trim();
                 list1.removeAllOccurrences(inputInfo);
                 break;
               case 'T':   //Reverse Strings from End
                 System.out.print("Please enter a number of elements to reverse from the end:\n");
                 inputInfo = stdin.readLine().trim();
                 int howMany3 = Integer.parseInt(inputInfo);
                 list1.reverseLastFew(howMany3);
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
       catch (IOException exception)
        {
          System.out.print("IO Exception\n");
        }
    }

    /** The method printMenu displays the menu to a user **/
    public static void printMenu()
     {
       System.out.print("Choice\t\tAction\n" +
                        "------\t\t------\n" +
                        "A\t\tAdd String\n" +
                        "B\t\tAdd Strings at End\n" +
                        "C\t\tCount its Size\n" +
                        "L\t\tList Strings\n" +
                        "Q\t\tQuit\n" +
                        "R\t\tRemove Strings from End\n" +
                        "S\t\tRemove String from List\n" +
                        "T\t\tReverse Strings from End\n" +
                        "?\t\tDisplay Help\n\n");
    } //end of printMenu()
}
