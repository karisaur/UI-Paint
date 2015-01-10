import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class paintView extends JFrame implements MouseListener, MouseMotionListener, ActionListener  // NOTE multiple interfaces
{
	JFrame window;
	Container main;
	int mouseX,mouseY,oldX,oldY;
	JLabel location;
	Color colorToUse;

	public paintView()
	{
		JFrame window = new JFrame("Painting");
		main = window.getContentPane();
		main.setLayout( new FlowLayout() );
		location = new JLabel();
		main.add( location); 
		main.addMouseListener(this);        
		main.addMouseMotionListener(this); 
		JButton colorButton = new JButton("Choose Pen Color");
		colorButton.addActionListener(this);
		main.add(colorButton);
		main.add(colorButton);
		window.setSize(640,480);
		window.setVisible(true);
	}		

	public void actionPerformed(ActionEvent e) 
	{
		Color colorToUse;
		colorToUse = paintView.showDialog(this, "Choose Color", getBackground());//COMPILING ERROR: cannot find symbol
		if (colorToUse != null)
		{
			colorToUse = Color.BLACK;
		}
	}
	private static Color showDialog(paintView paintView, String string,
			Color background) {
		// TODO Auto-generated method stub
		return null;
	}

	public void mouseClicked( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportlocation("Mouse clicked at: " +
			mouseX + "," + mouseY );
	}
	public void mousePressed( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportlocation("Mouse Pressed at: " +
			mouseX + "," + mouseY );
		//rePainting();
	}
	public void mouseReleased( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportlocation("Mouse released at: " +
			mouseX + "," + mouseY );
		//rePainting();
	}
	public void mouseExited( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportlocation("Mouse exited at: " +
			mouseX + "," + mouseY );
		//rePainting();
	}
	public void mouseEntered( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportlocation("Mouse Entered at: " +
			mouseX + "," + mouseY );
		//rePainting();
	}
	public void mouseDragged( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();

		if (oldX ==0 )
		{
			oldX=mouseX;
			oldY=mouseY;
			return;
		}
		// drawPoint( x,y );
		Graphics g = main.getGraphics();
		g.drawLine( oldX,oldY, mouseX, mouseY );
		oldX = mouseX;
		oldY = mouseY;
		reportlocation("Mouse Dragged at: " +
			mouseX + "," + mouseY );
		//rePainting();
	}
	public void mouseMoved( MouseEvent me)
	{
		mouseX = me.getX();
		mouseY = me.getY();
		reportlocation("Mouse Moved at: " +
			mouseX + "," + mouseY );
		//rePainting();
	}	

	public static void main( String[] args)
	{
		new paintView();
	}
	private void reportlocation( String msg )
	{
		location.setText( msg ); 
	}
}
