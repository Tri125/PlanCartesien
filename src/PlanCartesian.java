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
        	g.drawLine(0, 0, this.getHeight(), this.getWidth());
        	
        	
        	g.setColor(Color.red);
        	for (PointDouble temp : points) 
        	{
        		g.fillRect( (int)temp.x * MULTIPLIER,  (int)temp.y * MULTIPLIER, RAYON, RAYON);
        	}
        }
	}

}
