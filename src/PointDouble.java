
public class PointDouble {
	public double x;
	public double y;
	
	public PointDouble()
	{
		x = 0;
		y = 0;
	}
	
	public PointDouble(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	
	public PointDouble(PointDouble pd)
	{
		x = pd.x;
		y = pd.y;
	}
	
}
