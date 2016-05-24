// Assignment #: 8
//        Name: Austin Efnor
//    StudentID: 1208675503
//      Lecture: MWF 9
//  Description: 

import java.io.Serializable;
import java.util.Comparator;

public class ProjNumberComparator implements Comparator<Project>, Serializable
{
	public int compare(Project first, Project second)
	{
		Integer b = first.getNumber();
		return b.compareTo(second.getNumber());
	}
}
