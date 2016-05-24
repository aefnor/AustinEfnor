// Assignment #: 11
// Name: Your name
// StudentID:
// Lecture:
// Description: To be completed

import java.util.Stack;

public class StackRearranger
 {
  private Stack<Integer> initialStack; //stack contains numbers in an order specified by a user
  private Stack<Integer> outputStack; //stack to have numbers in sorted order after running this algorithm
  private Stack<Integer>[] holdingStacks; //stacks to hold some numbers that are not in either initial or output stack
  private int sizeOfInitialStack; //the initial stack size
  private int numberOfHoldingStacks; //number of holding stacks, specified by a user
  private int smallestNumber; //current smallest number that can be moved to the output stack
  private int stackWithNextSmallest; //the index of holding stack that contains the next smallest number

  //Constructor to initialize member variables
  public StackRearranger(int sizeOfInitialStack, int numOfHoldingStacks)
    {
      initialStack = new Stack<Integer>();
      outputStack = new Stack<Integer>();
      this.sizeOfInitialStack = sizeOfInitialStack;
      this.numberOfHoldingStacks = numOfHoldingStacks;

      holdingStacks = new Stack[numberOfHoldingStacks];

       for (int i=0; i< numberOfHoldingStacks; i++)
        {
          holdingStacks[i] = new Stack<Integer>();
        }
       smallestNumber = sizeOfInitialStack+1; //large number
       stackWithNextSmallest = -1; //index of holding stack containing the next smallest is unknown
    }

  //The addNumberToStack adds the parameter number
  //to the initial stack
  public void addNumberToStack(int number)
   {
       initialStack.push(number);
   }

 //The printHoldingStacks prints out the content
 //of the holding stacks
 public void printHoldingStacks()
  {
    System.out.println("Holding Stack Contents:\n");
    for (int i = 0; i < numberOfHoldingStacks; i++)
    {
      System.out.println("Holding Stack " + i + ": " + holdingStacks[i].toString());
    }
    System.out.println();
  }

//The rearrange method rearranges the numbers in the initial stack
//into a sorted order in the output stack
public boolean rearrange()
 {
   boolean success = true;

   //the next number that should move to output stack is initially 1
   int nextNumberToOutputStack = 1;

   //Print out the initial stack content
   System.out.println("Initial Stack Content:\n" + initialStack.toString());

   while(initialStack.empty() == false)
    {
       int nextNumber;

       //get(pop) the next number to move from the initial stack
       //and assign it to "nextNumber"
       /****1. ADD Your Code Here ****/

      if (nextNumber == nextNumberToOutputStack)
      {
       //if it is the next smallest number,
       //then push it onto the output stack
       /***2. ADD Your Code Here ****/

       System.out.println("Move number " + nextNumber
                        + " from input stack to output stack");

       //nextNumberToOutputStack should be incremented now
       //to loop for the next smallest number.
       nextNumberToOutputStack++;

       //As long as the smallest number among all holding stacks
       //is same as the next number to move to output stack,
       //process the following:
       while (smallestNumber == nextNumberToOutputStack)
        {
          //look for the next smallest number among holding stacks
          //This will compute the smallest number
          //and which holding stack it belongs to
          fromHoldingStackToOutputStack();
          nextNumberToOutputStack++;
        }
       }
     else
       {
            //put the next number into one of the holding stack
            if (putInHoldingStack(nextNumber) == false)
              {
                success = false;
                return success;
              }
       }
    }

    System.out.println("Output Stack Content:\n" + outputStack.toString());

    return success;
 }

//The fromHoldingStackToOutputStack method moves the smallest element among
//all holding stacks into the output stack.
//It also keeps track of the next smallest number and the holding stack
//that contains in it.
public void fromHoldingStackToOutputStack()
{
    if (stackWithNextSmallest >= 0
        && holdingStacks[stackWithNextSmallest].isEmpty() == false)
     {
      //remove(pop) the smallest number from its stack to move to the output stack
      //and move(pop) it to output stack
      /****3. ADD Your Code Here ****/


      System.out.println("Move number " + smallestNumber + " from holding stack#"
                     + stackWithNextSmallest + " to output stack");
      printHoldingStacks();
     }

    //Find the next smallest number and the holding stack that contains it
    //by checking the top of all holding stacks
    smallestNumber = sizeOfInitialStack + 1;
    for (int i = 0; i < numberOfHoldingStacks; i++)
     {
      if (holdingStacks[i].isEmpty() == false
         && ((Integer) holdingStacks[i].peek()).intValue() < smallestNumber)
         {
            smallestNumber = ((Integer) holdingStacks[i].peek()).intValue();
            stackWithNextSmallest = i;
         }
     }
     //After the above loop, the variable "stackWithNextSmallest" should have an index
     //of the holding stack contains the next smallest Number
     //AND the variable "smallestNumber" should have the next smallestNumber to move
     //to the output stack.
}

//The putInHoldingStack tries to push the parameter number
//into the best stack, i.e., the one with the top element larger
//than the parameter number and also with the top element smallest among
//such holding stacks.
//If it cannot find such holding stack, it returns false.
public boolean putInHoldingStack(int number)
 {
   int bestStack = -1; //initialize to a stack index that does not exists
   int bestTop = sizeOfInitialStack + 1; //initialize a larger number

   for (int i = 0; i < numberOfHoldingStacks; i++)
    {
      //look for non-empty stack that contains a top item which is larger than
      //the parameter "number" to push into.
      //The one with smallest top is the best choice
      //
      //If such best stack is not picked yet, and if you see an empty stack,
      //that empty stack will be picked as a best stack (until another best stack is found)
      /****4. ADD Your Code Here ****/
    }

    //The process cannot be completed
    //since all holding stacks have its top number being smaller than
    //the number to be inserted.
    if (bestStack == -1)
      return false;

    //The process can continue, by pushing the parameter "number"
    //into the holding stack of the best choice
    /****5. ADD Your Code Here ****/


    System.out.println("Move the number " + number + " from input stack "
                      + "to holding stack#" + bestStack);
    printHoldingStacks();

    //update the variable "smallestNumber" to push into the output stack
    //and the variable "stackWithNextSmallest" if needed
    /****6. ADD Your Code Here ****/

    return true;
   }

 }


