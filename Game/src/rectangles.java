
import java.util.ArrayList;
import processing.core.PApplet;


public class rectangles extends PApplet{
private PApplet parent;
public int x_width;
public int y_width;
public int x;
public int y;

	public rectangles()
	{
		//nothing
	}
	public rectangles(int x, int y, int x_width,int y_width)
	{
		this.x_width=x_width;
		this.y_width=y_width;
		this.x=x;
		this.y=y;
	}
}
//use arraylist
//or Ball[] balltwo = new Ball[100]
//ArrayList<> al = new ArrayList<String>();