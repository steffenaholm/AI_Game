import java.lang.reflect.Array;
import java.util.ArrayList;

import processing.core.PApplet;

public class A_Star extends PApplet{
	private PApplet parent;
	public int present_x;
	public int present_y;
	public int start_x;
	public int start_y;
	public int finish_x;
	public int finish_y;
	public boolean move_right, move_left, move_up, move_down=false;
	//public ArrayList<A_Star_Grid> a_grid = new ArrayList<A_Star_Grid>();
	public A_Star_Grid[][] a_grid=new A_Star_Grid[29][29];
	public Grid grid;
	A_Star()
	{
		finish_x=0;
		finish_y=0;
		start_x=29;
		start_y=29;
		
		for(int i=0; i<30 ;i++)
		{
			
			for(int j=0; j<30 ; j++)
			{
				a_grid[i][j].x=i;
				a_grid[i][j].y=j;
				a_grid[i][j].forbidden=false;
				a_grid[i][j].open=true;
				if(grid.collision(a_grid[i][j].x*20, 20, 0, a_grid[i][j].y*20, 20, 0))
				{
					a_grid[i][j].forbidden=true;
				}
			}
		}
	}
		
	public void compute_f(int finish_x, int target_y) //can't pass by reference
		{
			
		}
	public void move(int target_x, int target_y)
		{
			compute_f(target_x, target_y);
		}
	

}
