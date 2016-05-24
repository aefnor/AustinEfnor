// Assignment #: 8
//        Name: Austin Efnor
//    StudentID: 1208675503
//      Lecture: MWF 9
//  Description: 

import java.io.Serializable;
import java.util.Comparator;

public class ProjNameComparator implements Comparator<Project> , Serializable
{
	public int compare(Project first, Project second)
	{	
		int result=0;
		if(first.getLocation().equals(second.getLocation()))
		{
				result = first.getName().compareTo(second.getName());
				result = -1;
		}
		else
		{
			result = first.getLocation().compareTo(second.getLocation());
			result = 1;
		}
		return result;
	}
}