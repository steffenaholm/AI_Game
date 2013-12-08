import processing.core.PApplet;

public class Balltwo extends PApplet {
	public float x, y, vx, vy; //vector notation for velocity
	private int radius, color, speed;
	private PApplet parent;
//	private KeyReader reader;

	public Balltwo(PApplet parent, int speed) {
		this.parent = parent;
//		reader = parent.reader;
		this.x = parent.width -20;
		this.y = parent.height -20;
		vx = parent.random(-speed,speed);
		vy = parent.sqrt(speed*speed-vx*vx);
		this.speed=speed;
		//vy=3;
		radius = 10;
		color = 200;
		
	}

	private void update() {
		if (x + vx > parent.width || x + vx  < 0) vx = - vx;

		if (y + vy  > parent.height || y + vy  < 0) vy = -vy;

		x += vx;
		y += vy;
	}

	public void render() {
		
		update();
		parent.fill(color);
		parent.stroke(255);
		//parent.ellipseMode(CENTER);
		parent.ellipse(x, y, radius, radius);
	}

	public boolean seek2(int mouseX, int mouseY, boolean moved, float player_vx, float player_vy) {
		//float a=mouseY – this.y;
		if(moved==false)
		{
			vx=0;
			vx=0;
		}
		if((parent.sqrt((mouseX-x)*(mouseX-x) + (mouseY-y)*(mouseY-y))<=radius))
		{
			vx=0;
			vy=0;
			return true;
		}
		else
		{
			//Algorithm 2 -> predicts path and how to intersect it
			float b=mouseX - x;
			float c=mouseY - y;		
			float angle = parent.atan2( c, b );
			vx = speed * parent.cos(angle);
			vy = speed * parent.sin(angle);	
			
			
			return false;
		}
		
	}
}
