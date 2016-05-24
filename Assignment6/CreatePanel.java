// Assignment #: 6
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture days/time
//  Description: It needs to be filled

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class CreatePanel extends JPanel
 {
   private Vector projectList;
   private JButton button1;
   private ProjectSpendingPanel spendingPanel;
   private JTextArea projInfo;
   private JLabel projName2;
   private JTextField projNameT;
   private JLabel projNumber;
   private JTextField projNumberT;
   private JLabel projLocation;
   private JTextField projLocationT;
   private JLabel initialFunding;
   private JTextField initialFundingT;
   private JLabel redLabel;
   


   
 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector projectList, ProjectSpendingPanel spendingPanel)
  {
    this.projectList = projectList;
    this.spendingPanel = spendingPanel;

    //organize components here
    
    //setLayout(new BorderLayout());
    
    JPanel pan1 = new JPanel();
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel panf = new JPanel();
    JPanel panf2 = new JPanel();
    JPanel left = new JPanel( new GridLayout(0,1));
    
    pan1.setLayout(new GridLayout(6,1));
    pan2.setLayout(new GridLayout(1,1));
    pan3.setLayout(new GridLayout(1,2));
    
    redLabel = new JLabel("");
    redLabel.setForeground(Color.red);
    //redLabel.setVisible(true);
    //redLabel.setText("Please fill all fields");

    JPanel ProjNamePanel = new JPanel(new GridLayout(1,2));
    projName2 = new JLabel("Project Name");
    //add(projName);
    projNameT = new JTextField();
    //add(projNameT);

    JPanel ProjNumberPanel = new JPanel(new GridLayout(1,2));
    projNumber = new JLabel("Project Number");
    //add(projNumber);
    projNumberT = new JTextField();
    //add(projNumberT);
    
    JPanel ProjNumberLocation = new JPanel(new GridLayout(1,2));
    projLocation = new JLabel("Project Location");
    //add(projNumber);
    projLocationT = new JTextField();
    //add(projNumberT);
    
    JPanel InitialFunding = new JPanel(new GridLayout(1,2));
    initialFunding = new JLabel("Initial Funding");
    //add(projNumber);
    initialFundingT = new JTextField();
    //add(projNumberT);
    
    JPanel bpan = new JPanel(new FlowLayout());
    JPanel bpan1 = new JPanel();
    JPanel bpan2 = new JPanel();


    button1 = new JButton("Create a project");
    ActionListener listener = new ButtonListener();
    button1.addActionListener(listener);
    bpan.add(bpan1);
    bpan.add(button1);
    bpan.add(bpan2);
    
    projInfo = new JTextArea();
    //add(new ScrollPane(projInfo));
    projInfo.setText("No Project");
    JScrollPane scroll = new JScrollPane(projInfo);
    
    ProjNamePanel.add(projName2, BorderLayout.WEST);
    ProjNamePanel.add(projNameT, BorderLayout.EAST);
    
    ProjNumberPanel.add(projNumber, BorderLayout.WEST);
    ProjNumberPanel.add(projNumberT, BorderLayout.EAST);
    
    ProjNumberLocation.add(projLocation, BorderLayout.WEST);
    ProjNumberLocation.add(projLocationT, BorderLayout.EAST);

    InitialFunding.add(initialFunding, BorderLayout.WEST);
    InitialFunding.add(initialFundingT, BorderLayout.EAST);
    
    //pan2.add(projInfo);
    pan2.add(scroll);
    //pan1.setAlignmentX(LEFT_ALIGNMENT);
    //pan2.setAlignmentX(RIGHT_ALIGNMENT);
    ////pan1.add(panf);
    panf.add(redLabel, BorderLayout.SOUTH);
    panf.setVisible(true);
    pan1.add(ProjNamePanel, BorderLayout.CENTER);
    pan1.add(ProjNumberPanel, BorderLayout.CENTER);
    pan1.add(ProjNumberLocation, BorderLayout.CENTER);
    pan1.add(InitialFunding, BorderLayout.CENTER);
    pan1.add(bpan, BorderLayout.CENTER);
    ////pan1.add(panf2);
    pan3.add(pan1);
    pan3.add(pan2);
    left.add(panf);
    left.add(pan1);
    left.add(panf2);

    
    /*
    pan1.add(ProjNamePanel, BorderLayout.WEST);
    pan1.add(ProjNumberPanel, BorderLayout.WEST);
    pan1.add(ProjNumberLocation, BorderLayout.WEST);
    pan1.add(InitialFunding, BorderLayout.WEST);
    pan1.add(button1, BorderLayout.WEST);
    */
    
    add(left);
    add(pan2);
    //add(pan3, BorderLayout.CENTER);
    setLayout(new GridLayout(1,2));
    
  }


  //ButtonListener is a listener class that listens to
  //see if the buttont "Create a project" is pushed.
  //When the event occurs, it adds a project information from
  //the text fields to the text area. It also creates a Project object
  //using theinformation and add it to the projectList.
  //It also does error checking.
  private class ButtonListener implements ActionListener
   {
    public void actionPerformed(ActionEvent event)
     {
       // if there is no error, add a project to project list
       // otherwise, show an error message
    	String nameData = projNameT.getText(); //perform your operation
		String numData = projNumberT.getText();
		String locData = projLocationT.getText();
		String funData = initialFundingT.getText();
    	try{
    	if(numData.isEmpty()||nameData.isEmpty()||locData.isEmpty()||funData.isEmpty())
		{
    		System.out.println("Please fill all fields");
    		redLabel.setText("Please fill all fields");
    		updateUI();
		}
    	else if(numData.contains("")||nameData.contains("")||locData.contains("")||funData.contains("")){
            		int num = Integer.parseInt(numData);
            		double num2 = Double.parseDouble(funData);
            		Project proj = new Project(Double.parseDouble(funData));
            		proj.setLocation(locData);
            		proj.setName(nameData);
            		proj.setNumber(num);
            		projectList.add(proj);
            		spendingPanel.updateProjectList();
            		
            		if(projInfo.getText().equals("No Project")){
            			projInfo.setText(proj.toString());
            			
            		}
            		else{
            			projInfo.append(proj.toString());
            		}
            		nameData.equals("");
            		locData.equals("");
            		numData.equals("");
            		funData.equals("");

            		System.out.println(nameData);
            		System.out.println(numData);
            		System.out.println(locData);
            		System.out.println(funData);
    				System.out.println("button");
    	    		redLabel.setText("Project Added");
    	    		

    		}
    	}
    		catch(NumberFormatException e){
    			System.out.println("Please enter a number for both Project Number and Funding.");
    		}
    	}
     } //end of actionPerformed method
  } //end of ButtonListener class

 //end of CreatePanel class
