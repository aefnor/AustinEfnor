// Assignment #: 6
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture days/time
//  Description: It needs to be filled

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class ProjectSpendingPanel extends JPanel
 {
     private Vector projectList;


   //Constructor initialize each component and arrange them using
   //certain layouts
   public ProjectSpendingPanel(Vector projectList)
     {
         this.projectList = projectList;

         //organize components for spending panel
     }

 //This method  refreshes the JList with
 //updated vector information
 public void updateProjectList()
  {
      //call updateUI() for the JList object
	 updateUI();
  }


 //RatingListener class listens to see the radio buttons
 //to keep track of a chosen rating for a project.
 private class RatingListener implements ActionListener
     {
         public void actionPerformed(ActionEvent event)
         {
             //to be completed
         }
     }



 //ButtonListener class listens to see the button "Add Spending" is pushed.
 //A user can choose which project to add spending, and that will update the
 //spending and current balance of such project.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
          //get some additional spending from the textfield,
          //update the spending and current balance
          //for the chosen project in the JList.
        }
  } //end of ButtonListener class

} //end of ProjectSpendingPanel class
