// Assignment #: 12
//         Name: Austin Efnor	
//    StudentID: 1208675503
//      Lecture: MWF9A
//Description: Controls prettyness

import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.Graphics;

public class BeamsPanel extends JPanel {

	private Color color;
	private int delay, step, centerX, centerY, diameter, diameterLimit, beamNum, angleSize;
	private Timer timer;
	
	public BeamsPanel(Color initialColor, int width) {
		color = initialColor;
		//width = widthL;
		delay = 20;
		step = 3;
		setBackground(Color.black);
		centerX = width/2;
		centerY = width/2;
		diameterLimit = (width-10)/2;
		diameter = 0;
		beamNum = 8;
		angleSize = 360/(beamNum*2);
		timer = new Timer(delay, new MoveListener());
		timer.start();
		
	}
	public void resume(){
		timer.start();
	}
	public void suspend(){
		timer.stop();
	}

	public void changeColor(Color anotherColor) {
		this.color = anotherColor;
		
	}
	public void setBeamNumber(int beam){
		beamNum = beam;
	}
	public void setDelay( int delayValue){
		timer.setDelay(delayValue);
	}
	public void paintCompenent(Graphics page){
		System.out.println("what");
		super.paintComponent(page);
		page.setColor(color);
		int currentAngle = 0;
		angleSize = 360/(beamNum*2);
		
		//page.drawRect(100, 100, 150, 150);
		while (currentAngle<=360){
		page.fillArc(centerX-diameter/2, centerY-diameter/2, diameter, diameter, currentAngle, angleSize);
		currentAngle += 2*angleSize;}
	}
	private class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(diameter <= diameterLimit){
				diameter+=step;
			//repaint();
			}
			else
				diameter = 0;
			repaint();
		}
	}

}
