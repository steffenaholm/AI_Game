import processing.core.PApplet;
import java.util.ArrayList;

public class Grid extends PApplet {
	private PApplet parent;
	public int x,y,x_width,y_width;
	public int x_2,y_2,x_width_2,y_width_2 = 0;
	public int rect_row_num=4;
	public int rect_col_num=4;
	ArrayList<rectangles> rect = new ArrayList<rectangles>();
	public Grid(PApplet parent)
	{
		this.parent=parent;
		x=20;
		y=20;
		//x_width=(600-rect_col_num*20)/(rect_col_num); //dynamic. neat-o
		x_width=125;
		//y_width=(600-rect_row_num*20)/(rect_row_num); //same
		y_width=125;
		//x_2=560/2+30;
		//y_2=20;
		//x_width_2=560/2-10;
		//y_width_2=560;
		int row_num=0;
		int col_num=0;
		for(int i=0;i<=16;i++) //fills in the arraylist with rectangles that conform to the grid		
		{		
			rect.add(i,new rectangles((20+(x_width+20)*(row_num)),//rectangles(int x,  
					(20+(y_width+20)*(col_num)), 					//int y,
					x_width,										//int x_width,
					y_width)); 										//int y_width)
			row_num++;
			if(row_num>=rect_row_num)
			{
				col_num++;	
				row_num=0;
			}
		}
	}
	public void render()
	{
		parent.noFill();
		parent.stroke(0,255,255);
		for(int i=0; i<=15; i++)
		{
			parent.rect(rect.get(i).x,rect.get(i).y,rect.get(i).x_width,rect.get(i).y_width); //renders each rectangle in the arraylist
		}
		
		//parent.rect(x_2, y_2, x_width_2, y_width_2); //2nd square
	}
/*public boolean collision(int object_x, int object_x_width, float vx, int object_y, int object_y_width, float vy, int x, int y, int x_width, int y_width)
	{
		//this is going to be collision detection for each of the rectangular objects in Grid_Parts
		//but for now its just a static list of rectangular objects
		//REPLACE WITH ARRAYLIST VARIABLES AND LOOP THROUGH FULL ARRAYLIST
		if((object_x + object_x_width + vx > x )
				&& (object_x - object_x_width + vx < x+x_width) 
				&& (object_y + object_y_width + vy> y) 
				&& (object_y - object_y_width + vy< y + y_width))
		{ return true;}
		else
		{
			return false;
		}
	}*/
	public boolean collision(int object_x, int object_x_width, float vx, int object_y, int object_y_width, float vy)
	{
		//this is going to be collision detection for each of the rectangular objects in Grid_Parts
		//but for now its just a static list of rectangular objects
		//REPLACE WITH ARRAYLIST VARIABLES AND LOOP THROUGH FULL ARRAYLIST
		//for(rectangles r:rect)
		for(int i=0;i<=15;i++)//loop through every element of the arraylist and see if it is colliding
		{
			if((object_x + object_x_width + vx > rect.get(i).x )
					&& (object_x - object_x_width + vx < rect.get(i).x+rect.get(i).x_width) 
					&& (object_y + object_y_width + vy> rect.get(i).y) 
					&& (object_y - object_y_width + vy< rect.get(i).y + rect.get(i).y_width))
			{ return true;}
		}
		return false; //if nothing is colliding then return false
		
	}

}
