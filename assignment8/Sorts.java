// Assignment #: 8
//         Name: Erick Larson
//    StudentID: 1208845777
//      Lecture: T TH 4:30pm
//  Description: 

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts
{
	public static void sort(ArrayList<Project> objects, Comparator<Project> comparator)
	{

		for (int index = 1; index < objects.size(); index++)
		{
			Project key = objects.get(index);
			int position = index;
			// shift larger values to the right
			while (position > 0 && comparator.compare(key, objects.get(position-1)) > 0)// && projectList.get(position-1).compare())
			{
				objects.set(position, objects.get(position-1));
				position--;
			}
			objects.set(position, key);
		}
	} 

}





