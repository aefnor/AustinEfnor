// Assignment #: 8
// 		Name: Austin Efnor
//    	StudentID: 1208675503
//      Lecture: MWF 9
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. 

import java.io.*;

public class Assignment8
{
	public static void main (String[] args)
	{
		char input1;
		String name, location, projNumStr, budgetStr;
		int projNumber;
		double budget;
		boolean operation = false;
		int operation2 = 0;
		String line;
		String filename;
		String text;
		String firstLine;

		// create a ProjectManagement object. This is used throughout this class.
		ProjectManagement manage1 = new ProjectManagement();

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

				if (line.length() == 1)          //check if a user entered only one character
				{
					switch (input1)
					{
					case 'A':   //Add Project
						try 
						{
							System.out.print("Please enter a project name to add:\n");
							name = stdin.readLine().trim();
							System.out.print("Please enter its projNumber to add:\n");
							projNumStr = stdin.readLine().trim();
							projNumber = Integer.parseInt(projNumStr);
							System.out.print("Please enter its location to add:\n");
							location = stdin.readLine().trim();
							System.out.print("Please enter its initial budget to add:\n");
							budgetStr = stdin.readLine().trim();
							budget = Double.parseDouble(budgetStr);

							operation = manage1.addProject(name, location, projNumber, budget);
							if (operation == true)
								System.out.print("project added\n");
							else
								System.out.print("project exists\n");
						}
						/************************************************************************************
						 ***  Complete the following catch statement
						 ***********************************************************************************/
						catch(NumberFormatException exception)
						{
							System.out.println("Please enter a numeric value for project number and budget. Project not added\n");
						}
						break;
					case 'D':  //Search by projNumber
						try
						{
							System.out.print("Please enter projNumber to search:\n");
							projNumStr = stdin.readLine().trim();
							projNumber = Integer.parseInt(projNumStr);
							operation2=manage1.projNumberExists(projNumber);

							if (operation2 > -1)
								System.out.print("projNumber found\n");
							else
								System.out.print("projNumber not found\n");
						}
						/************************************************************************************
						 ***  Complete the follwing catch statement
						 ***********************************************************************************/
						catch(NumberFormatException exception)
						{
							System.out.println("Please enter a numeric value for project number and budget. Project not added\n");
						}
						break;
					case 'E':  //Search by name and location
						System.out.print("Please enter a name to search:\n");
						name = stdin.readLine().trim();
						System.out.print("Please enter a location to search:\n");
						location = stdin.readLine().trim();
						operation2=manage1.nameLocationExists(name, location);

						if (operation2 > -1)
							System.out.print("project name and location found\n");
						else
							System.out.print("project name and location not found\n");
						break;
					case 'L':   //List projects
						System.out.print("\n"+manage1.listProjects()+"\n");
						break;
					case 'O':  // Sort by projNumber
						manage1.sortByProjNumber();
						System.out.print("sorted by projNumber\n");
						break;
					case 'P':  // Sort by locations and project names
						manage1.sortByNameLocation();
						System.out.print("sorted by project names and locations\n");
						break;
					case 'Q':   //Quit
						break;
					case 'R':  //Remove by projNumber
						try
						{
							System.out.print("Please enter projNumber to remove:\n");
							projNumStr = stdin.readLine().trim();
							projNumber = Integer.parseInt(projNumStr);
							operation=manage1.removeProjNumber(projNumber);
							if (operation == true)
								System.out.print("projNumber removed\n");
							else
								System.out.print("projNumber not found\n");
						}
						/************************************************************************************
						 ***  Complete the following catch statement
						 ***********************************************************************************/
						catch(NumberFormatException exception)
						{
							System.out.println("Please enter an integer for projNumber. Project not removed\n");
						}
						break;
					case 'S':  //Remove by location and name
						System.out.print("Please enter a name to remove:\n");
						name = stdin.readLine().trim();
						System.out.print("Please enter a location to remove:\n");
						location = stdin.readLine().trim();
						operation=manage1.removeNameLocation(name, location);
						if (operation == true)
							System.out.print("project name and location removed\n");
						else
							System.out.print("project name and location not found\n");
						break;
					case 'T':  //Close ProjectManagement
						manage1.closeProjectManagement();
						System.out.print("project management system closed\n");
						break;
					case 'U':  //Write Text to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						FileWriter file = new FileWriter(filename);
						
						try
						{
							
						BufferedWriter writer = new BufferedWriter(file);
						
						PrintWriter pFile = new PrintWriter(writer);
						
						System.out.print("Please enter a string to write in the file:\n");
						text = stdin.readLine().trim();
						pFile.print(text + "\n");
						pFile.println();
						pFile.close();
						//writer.write(text+"\n");
						System.out.print(filename + " was written\n");
						}
						catch(IOException exception)
						{
							System.out.println("Invalid input\n");
						}
						/*finally
						{
							
							if(writer != null)
							{
								writer.close();
							}
						}*/
						/************************************************************************************
						 ***  ADD your code to write a text (string) to the specified file. Catch exceptions.
						 ************************************************************************************/
						
						break;
					case 'V':  //Read Text from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						try
						{
							FileReader reader = new FileReader(filename);
							BufferedReader buffReader = new BufferedReader(reader);
							firstLine = buffReader.readLine();
							System.out.print(filename + " was read\n");
							System.out.print("The first line of the file is:\n" + firstLine + "\n");
						}
						catch(FileNotFoundException exception)
						{
							System.out.print(filename + " was not found\n");
						}
						catch(IOException exception)
						{
							System.out.println(exception);
						}
						/************************************************************************************
						 ***  ADD your code to read a text (string) from the specified file. Catch exceptions.
						 ************************************************************************************/
						break;
					case 'W':  //Serialize ProjectManagement to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						FileOutputStream fileOutput = null;
						ObjectOutputStream outStream = null;
						try
						{
							fileOutput = new FileOutputStream(filename);
							outStream = new ObjectOutputStream(fileOutput);
							outStream.writeObject(manage1);
							System.out.print(filename + " was written\n");
						}
						catch(NotSerializableException exception)
						{
							System.out.println(exception);
						}
						catch(IOException exception)
						{
							System.out.println(exception);
						}
						finally
						{
							if(outStream != null)
							{
								outStream.close();
							}
						}
						/************************************************************************************
						 ***  ADD your code to write the project management bject to the specified file. Catch exceptions.
						 ************************************************************************************/
						break;
					case 'X':  //Deserialize ProjectManagement from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						FileInputStream fileInput = null;
						ObjectInputStream inStream = null;
						try
						{
							fileInput = new FileInputStream(filename);
							inStream = new ObjectInputStream(fileInput);
							manage1 = (ProjectManagement)inStream.readObject();
							System.out.print(filename + " was read\n");
						}
						catch(ClassNotFoundException exception)
						{
							System.out.println(exception);
						}
						catch(FileNotFoundException exception)
						{
							System.out.print(filename + " was not found\n");
						}
						catch(IOException exception)
						{
							System.out.println(exception);
						}
						finally
						{
							if(inStream != null)
							{
								inStream.close();
							}
						}
						/************************************************************************************
						 ***  ADD your code to read a project management object from the specified file. Catch exceptions.
						 ***********************************************************************************/
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
				"A\t\tAdd Project\n" +
				"D\t\tSearch for ProjNumber\n" +
				"E\t\tSearch for Name and Location\n" +
				"L\t\tList Projects\n" +
				"O\t\tSort by ProjNumber\n" +
				"P\t\tSort by Name and Location\n" +
				"Q\t\tQuit\n" +
				"R\t\tRemove by ProjNumber\n" +
				"S\t\tRemove by Name and Location\n" +
				"T\t\tClose ProjectManagement\n" +
				"U\t\tWrite Text to File\n" +
				"V\t\tRead Text from File\n" +
				"W\t\tSerialize ProjectManagement to File\n" +
				"X\t\tDeserialize ProjectManagement from File\n" +
				"?\t\tDisplay Help\n\n");
	}
} // end of Assignment8 class


