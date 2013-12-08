import processing.core.PApplet;


@SuppressWarnings("serial")
public class Ball extends PApplet  {
	public float x, y, vx, vy; //vector notation for velocity
	private int radius, color, speed;
	private PApplet parent;
//	private KeyReader reader;

	public Ball(PApplet parent, int speed) {
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

	public boolean seek(int mouseX, int mouseY, boolean moved) {
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
			float b=mouseX - x;
			float c=mouseY - y;
			//parent.atan2(,mouseX – x);
			
			float angle = parent.atan2( c, b );
			// ^^ remember? this is the angle from ball to mouse
	
			//vx = parent.abs(vx) * parent.cos(angle);
			//vy = parent.abs(vy) * parent.sin(angle);	
			vx = speed * parent.cos(angle);
			vy = speed * parent.sin(angle);	
			//if()
			/* This is a little tricky. parent.abs is an absolute value 
				function. This code should change our vx and vy so 
				that we are moving toward point (mouseX, mousey) with 
				the same SPEED (magnitude of velocity) as before this 			function call
			*/
			return false;
		}
		
	}
}
