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
	public ArrayList<A_Star_Grid> queue= new ArrayList<A_Star_Grid>(); //queue for those g values to be considered
	public Grid grid; //should just be a static class
	A_Star() //sets up the grid array
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
		
	public void compute_f(int target_x, int target_y) //can't pass by reference
		{
			finish_x=target_x;
			finish_y=target_y;
			int temporary_f=0;
			boolean swapped=true;
			if(present_x-1>=0)//check don't check out of bounds
			{
				if(!a_grid[present_x-1][present_y].forbidden) //check not forbidden area
				{
					temporary_f=a_grid[present_x-1][present_y].G+20;//add cost function 
					a_grid[present_x-1][present_y].G=temporary_f;
					a_grid[present_x-1][present_y].prev_x=a_grid[present_x][present_y].x;//set the pointer to the current node
					a_grid[present_x-1][present_y].prev_y=a_grid[present_x][present_y].y;//
					queue.add(a_grid[present_x-1][present_y]);
				}
			}
			if(present_x+1<=29)
			{
				if(!a_grid[present_x+1][present_y].forbidden)
				{
					temporary_f=a_grid[present_x+1][present_y].G+20;
					a_grid[present_x+1][present_y].G=temporary_f;
					a_grid[present_x+1][present_y].prev_x=a_grid[present_x][present_y].x;
					a_grid[present_x+1][present_y].prev_y=a_grid[present_x][present_y].y;
					queue.add(a_grid[present_x+1][present_y]);
				}
			}
			if(present_y-1>=0)
			{
				if(!a_grid[present_x][present_y-1].forbidden)
				{
					temporary_f=a_grid[present_x][present_y-1].G+20;
					a_grid[present_x][present_y-1].G=temporary_f;
					a_grid[present_x][present_y-1].prev_x=a_grid[present_x][present_y].x;
					a_grid[present_x][present_y-1].prev_y=a_grid[present_x][present_y].y;
					queue.add(a_grid[present_x][present_y-1]);
				}
			}
			if(present_y+1<=29)
			{
				if(!a_grid[present_x][present_y+1].forbidden)
				{
					temporary_f=a_grid[present_x][present_y+1].G+20;
					a_grid[present_x][present_y+1].G=temporary_f;
					a_grid[present_x][present_y+1].prev_x=a_grid[present_x][present_y].x;
					a_grid[present_x][present_y+1].prev_y=a_grid[present_x][present_y].y;
					queue.add(a_grid[present_x][present_y+1]);
				}
			}
			while(swapped) // sorts the arraylist by descending order - bubble sort?
			{
				swapped=false;
				for(int i=0; i<queue.size(); i++)
				{
					if(queue.get(i).G>queue.get(i+1).G)
					{
						queue.add(i-1, queue.get(i+1));//switches the 2 positions
						queue.remove(i+1);
						swapped=true;
					}
				}
			}
			present_x=queue.get(0).x;
			present_y=queue.get(0).y;
			if(present_x==finish_x&&present_y==finish_y)
			{
				//retrace sequence 
			}
			//if present node =start node then done
			//retrace steps
			//take the one with the least g value and make it your new present node
			//look up left right down at each stop compute the g+cost where cost=20
		}
	public void move(int target_x, int target_y)
		{
			compute_f(target_x, target_y);
		}
	

}
