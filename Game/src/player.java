import processing.core.PApplet;
import java.awt.event.KeyEvent;

public class player extends PApplet
{
	public int x, y;
	public float vx, vy, last_vx, last_vy; //vector notation for velocity
	private int radius, color;
	public boolean moved;
	private PApplet parent;
	public player(PApplet parent) {
		this.parent = parent;
//		reader = parent.reader;
		this.x = 10;
		this.y = 10;
		vx = 0;
		vy = 0;
		last_vx=0;
		last_vy=0;
		radius = 10;
		color = parent.color(255,0,0);
		moved=false;
	}
	public void move()
	{
		last_vx=vx;
		last_vy=vy;
		if(parent.keyPressed)
		{
			moved=true;
			switch (parent.keyCode)
			{
				case KeyEvent.VK_UP:
					vy=-10;
					vx=0;
					break;
				case KeyEvent.VK_DOWN:
					vy=10;
					vx=0;
					break;
				case KeyEvent.VK_LEFT:
					vx=-10;
					vy=0;
					break;
				case KeyEvent.VK_RIGHT:
					vx=10;
					vy=0;
					break;
				default:
						break;
			}			
			}
		}
	private void update(boolean collided) {
		if (x + vx + 10> parent.width || x + vx - 10< 0 ) vx = 0; //edge clamping
		if (y + vy + 10 > parent.height || y + vy - 10 < 0 ) vy = 0; //edge clamping
		if(collided) //so it doesn't stop when traveling and then being told to go in direction can't go
		{
			vx=last_vx;
			vy=last_vy;
		}

		x += vx;
		y += vy;
	}
public void render(boolean collided) { //creates ellipse and calls function to update speed.
		
		update(collided);
		parent.fill(color);
		//if(collided) parent.fill(0,255,0);
		parent.stroke(255);
		parent.ellipse(x, y, radius, radius);
	}
}
