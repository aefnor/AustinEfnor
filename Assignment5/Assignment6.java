// Assignment #: 6
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture days/time
//  Description: The Assignment 6 class creates a Tabbed Pane with
//               two tabs, one for Project creation and one for
//               Project spending. and adds it as its Applet content
//               and also sets its size.

import javax.swing.*;
import java.util.*;

public class Assignment6 extends JApplet
 {
   private int APPLET_WIDTH = 900, APPLET_HEIGHT = 350;

   private JTabbedPane tPane;
   private CreatePanel createPanel;
   private ProjectSpendingPanel spendingPanel;
   private Vector projectList;

   //The method init initializes the Applet with a Pane with two tabs
   public void init()
    {
     //list of projects to be used in every panel
     projectList = new Vector();

     //review panel uses the list of projects
     spendingPanel = new ProjectSpendingPanel(projectList);

     createPanel = new CreatePanel(projectList, spendingPanel);

     //create a tabbed pane with two tabs
     tPane = new JTabbedPane();
     tPane.addTab("Project creation", createPanel);
     tPane.addTab("Project spending", spendingPanel);

     getContentPane().add(tPane);
     setSize (APPLET_WIDTH, APPLET_HEIGHT); //set Applet size
    }
}


