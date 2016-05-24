// Assignment #: 8
//         Name: Austin Efnor
//    StudentID: 1208675503
//      Lecture: MWF 9
//  Description: 

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class ProjectManagement implements Serializable
{
	private ArrayList<Project> projectList;
	protected Project project;
	private boolean add;
	//private boolean numR;
	private boolean nameR;
	private ProjNumberComparator numComparator;
	private ProjNameComparator nameComparator;

	

	public ProjectManagement()
	{
		projectList = new ArrayList<Project>();
	}
	
	public int projNumberExists(int projNumber)
	{
		int index = -1;
		for (int i = 0; i < projectList.size(); i++) 
		{
			if(((Project) projectList.get(i)).getNumber() == projNumber)
			{
				index = i;
			}
		}
		return index;
	}
	
	public int nameLocationExists(String name, String location)
	{
		for (int i = 0; i < projectList.size(); i++) 
		{
			if(projectList.get(i).getLocation().equals(location) == true)//name == projectList.get(i).getName() && location == projectList.get(i).getLocation())
			{
				if(projectList.get(i).getName().equals(name) == true)
				{
					return i;
				}
			}
		}
		return -1;
	}

	public boolean addProject(String name, String location, int projNumber, double initialFund)
	{
		if(projNumberExists(projNumber) < 0)
		{
			Project obj = new Project(initialFund);
			//project = new Project(initialFund);
			obj.setName(name);
			obj.setLocation(location);
			obj.setNumber(projNumber);
			projectList.add(obj);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean removeProjNumber(int projNumber)
	{
		boolean numR = false;
		boolean banner = false;
		int remove = 0;
		for (int i = 0; i < projectList.size(); i++)
		{
			if(projectList.get(i).getNumber() == projNumber)
			{
				remove = i;
				banner = true;
			}	
		}
		if(banner==true){
			projectList.remove(remove);
			numR = true;
		}
		else
		{
			numR = false;
		}
		return numR;
	}
	
	public boolean removeNameLocation(String name, String location)
	{
		for (int i = 0; i < projectList.size(); i++)
		{
			if(name == projectList.get(i).getName() && location == projectList.get(i).getLocation())
			{
				projectList.remove(i);
				nameR = true;
			}
			else
			{
				nameR = false;
			}
		}
		return nameR;
	}
	
	public void sortByProjNumber()
	{
		Sorts.sort(projectList, new ProjNumberComparator());
		//numComparator = new ProjNumberComparator();
		//Sorts.sort(projectList, numComparator);
	}
	
	public void sortByNameLocation()
	{
	//	nameComparator = new ProjNameComparator();
	//	Sorts.sort(projectList, nameComparator);
		Sorts.sort(projectList, new ProjNameComparator());
	}
	
	public String listProjects()
	{
		String result = "";
		if(projectList.size() == 0)
		{
			result = "\nno project\n\n";
		}
		else
		{
			for (int i = 0; i < projectList.size(); i++)
			{
				result += projectList.get(i).toString();
			}
		}
		return result;
	}
	
	public void closeProjectManagement()
	{
		projectList.clear();
	}
}
