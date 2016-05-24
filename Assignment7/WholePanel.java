// Assignment #: 7
//         Name: your name
//    StudentID: your id
//      Lecture: your lecture days/time
//  Arizona State University CSE205
//  Description: It needs to be filled.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.LinkedList;

public class WholePanel extends JPanel
{
   private Color currentColor;
   private CanvasPanel canvas;
   private JPanel leftPanel;
   private JButton undo;
   private ArrayList<Line> lineList;
   private ArrayList<Line> lineListC;
   private JButton erase;
   private JRadioButton blackBox;
   private JRadioButton redBox;
   private JRadioButton blueBox;
   private JRadioButton greenBox;
   private JRadioButton orangeBox;
   private ButtonGroup group;
   private int x1,x2,y1,y2;
   private boolean mouseIsDragged = false;
   private boolean flag = false;
   private Shape line = null;
   //Is a linked like or ArraryList needed? has clear() method
   //Could you use repaint()?
   private Point point = null;

   public WholePanel()
   {
      //default color to draw is black
      currentColor = Color.black;
      lineList = new ArrayList<Line>();
      lineListC = new ArrayList<Line>();
      
      undo = new JButton ("Undo");
      undo.addActionListener(new ButtonListener());
      
      erase = new JButton("Erase");
      erase.addActionListener(new ButtonListener());
      
      blackBox = new JRadioButton("black",true);
      blackBox.addActionListener(new ColorListener());
      redBox = new JRadioButton("red");
      redBox.addActionListener(new ColorListener());
      blueBox = new JRadioButton("blue");
      blueBox.addActionListener(new ColorListener());
      greenBox = new JRadioButton("green");
      greenBox.addActionListener(new ColorListener());
      orangeBox = new JRadioButton("orange");
      orangeBox.addActionListener(new ColorListener());
      
      group = new ButtonGroup();
      group.add(blackBox);
      group.add(blueBox);
      group.add(greenBox);
      group.add(orangeBox);
      group.add(redBox);
      
      leftPanel = new JPanel(new GridLayout(7,0));
      
      leftPanel.add(undo,6,0);
      leftPanel.add(erase,7,0);
      
      leftPanel.add(orangeBox,1,0);
      leftPanel.add(greenBox,2,0);
      leftPanel.add(blueBox,3,0);
      leftPanel.add(redBox,4,0);
      leftPanel.add(blackBox,5,0);

      

      canvas = new CanvasPanel();
      canvas.addMouseListener(new PointListener());
      canvas.addMouseMotionListener(new PointListener());
      


      JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);
    }

  //CanvasPanel is the panel where shapes will be drawn
  private class CanvasPanel extends JPanel
   {
      //this method draws all shapes specified by a user
      public void paintComponent(Graphics page)
       {
        super.paintComponent(page);
        setBackground(Color.WHITE);
        page.setColor(currentColor);
        
         //to be filled
        if (mouseIsDragged){
           page.drawLine (x1, y1, x2, y2);
        }
        for(int i = 0; i< lineList.size(); i++){
            lineList.get(i).draw(page);
            }
        
       }
      
    } //end of CanvasPanel class


   //ButtonListener defined actions to take in case
   //"Undo", or "Erase" is chosed.
   private class ButtonListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event)
      {
    	  JButton source = (JButton)event.getSource();
          String name = source.getText();
          if (name.equals("Undo"))
          {
        	  if(flag == true)
              {
              for(int i = 0; i< lineListC.size(); i++){
                  lineList.add(lineListC.get(i));
                  }
              canvas.repaint();
        	  lineListC.clear();
              }
        	  
        	  if(lineList.size() > 0 && flag==false)
              {
                  lineList.remove(lineList.size()-1);  
                  canvas.repaint();
              }
        	  flag = false;
              
          }
          else if (name.equals("Erase"))
          {
        	  for(int i = 0; i< lineList.size(); i++){
                  lineListC.add(lineList.get(i));
                  }
        	  flag=true;
        	  System.out.println("flag");
        	  
        	  lineList.clear();
        	  repaint();
              
          }
          //needs to be filled
    	  if(event.getSource()==erase){
    		  System.out.println("erase");
    	  }
    	  else if(event.getSource()==undo){
    		  System.out.println("undo");
    	  }
      }
   } // end of ButtonListener


   // listener class to set the color chosen by a user using
   // the color radio buttons
   private class ColorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
         {
          //needs to be filled
        	if(event.getSource()==redBox){
        		//set color of foreground to red for current color
        		currentColor = Color.RED;
        		System.out.println("red");
        	}
        	else if (event.getSource()==blackBox){
        		currentColor = Color.BLACK;
        		System.out.println("black");
        	}
        	else if(event.getSource()==blueBox){
        		currentColor = Color.BLUE;
        		System.out.println("blue");
        	}
        	else if(event.getSource()==greenBox){
        		currentColor = Color.GREEN;
        		System.out.println("green");
        	}
        	else if(event.getSource()==orangeBox){
        		currentColor = Color.ORANGE;
        		System.out.println("orange");
        	}
         }
    } // end of ChoiceListener


   // listener class that listens to the mouse
   public class PointListener implements MouseListener, MouseMotionListener
    {
	   
	 //in case that a user presses using a mouse,
	 //record the point where it was pressed.
     public void mousePressed (MouseEvent event)
      {
          //needs to be filled
    	 point = event.getPoint();
    	 x1 = point.x;
    	 y1 = point.y;
    	 mouseIsDragged = true;
    	 System.out.println("m press");
      }

     //mouseReleased method takes the point where a mouse is released,
     //using the point and the pressed point to create a line,
     //add it to the ArrayList "lineList", and call paintComponent method.
     public void mouseReleased (MouseEvent event)
      {
    	 
    	 Line line = new Line(x1,y1,x2,y2, currentColor);
    	 lineList.add(line);
    	 canvas.repaint();
    	 System.out.println("m release");
    	 mouseIsDragged = false;
    	 
      }
     public void mouseClicked (MouseEvent event) {}
     public void mouseEntered (MouseEvent event) {}
     public void mouseExited (MouseEvent event) {}
    
     //mouseDragged method takes the point where a mouse is dragged
     //and call paintComponent method
     public void mouseDragged(MouseEvent event)
        {
            //needs to be filled
    	 point = event.getPoint();
    	 x2 = point.x;
    	 y2 = point.y;
    	 canvas.repaint();
        }
        
     public void mouseMoved(MouseEvent event) {}
        

    } // end of PointListener

} // end of Whole Panel Class
