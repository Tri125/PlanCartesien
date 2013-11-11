import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


public class PlanCartesian extends JPanel {
	
	private List <PointDouble> points;
	private PointDouble axeX;
	private PointDouble axeY;
	private boolean IsInitialiser = false;
	private final int RAYON = 5; 
	private final int MULTIPLIER = 10;
	
	public PlanCartesian()
	{
		
	}
	
	public PlanCartesian(List<PointDouble> points, PointDouble axeX, PointDouble axeY)
	{
		points = new ArrayList<PointDouble>();
		axeX = new PointDouble();
		axeY = new PointDouble();
		this.NouvelleSerie(points, axeX, axeY);
		IsInitialiser = true;
	}
	
	
	public void NouvelleSerie(List<PointDouble> points, PointDouble axeX, PointDouble axeY)
	{
		this.points = points;
		this.axeX = axeX;
		this.axeY = axeY;
		IsInitialiser = true;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//Contour Case
		g.setColor(Color.black);
        if (IsInitialiser)
        {
        	g.drawLine(10, 10, 10, this.getWidth()+10);
        	g.drawLine(10, this.getHeight()-10, this.getWidth()-10,this.getHeight()-10);
        	
        	g.setColor(Color.red);
        	for (PointDouble temp : points) 
        	{
        		Double x = ( (temp.x /this.axeX.y) * this.getWidth());
        		Double y = ( (temp.y / this.axeY.y) * this.getHeight());
        		g.fillRect( x.intValue(), this.getHeight() - y.intValue(), RAYON, RAYON);
     
        	}
        }
	}

}
