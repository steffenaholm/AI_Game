
//import processing.core.PApplet;
import processing.core.*;

  

public class MyProcessingSketch extends PApplet {

	
public Grid grid;	
public Ball ball;
public Ball ball2;
public player player1;
public boolean endgame;
public boolean collided;
public int score;
//public KeyReader reader; /*assume it’s the same KeyReader you have seen */

public void setup() {
	//reader = KeyReader.getInstance();
	size(600, 600);
	noStroke();
	smooth();
	ellipseMode(CENTER);
	player1 = new player(this);
	ball = new Ball(this, 5);
	ball2= new Ball(this, 7);
	grid = new Grid(this);
	collided=false;
	endgame=false;
	score=100;
}

public void draw() {
	
	clear();
	ball.render();
	ball2.render();
	grid.render();
	//ball.seek(dmouseX, dmouseY);
	if(ball.seek(player1.x, player1.y, player1.moved)) { 
	score--; }
	if(ball2.seek(player1.x,player1.y, player1.moved))
	{score--;}
	player1.move();
	if(grid.collision(player1.x, 10,player1.vx, player1.y, 10, player1.vy))
	{collided=true;}
	player1.render(collided);
	if(score<0)
	{endgame=true;}
	textSize(20);
	text(score, 40,40);
	if(endgame)
		{
			textSize(32);
			text("Game Over", 300, 300);
			endgame=false;
		}
	collided=false;
}
	public static void main(String args[]) 
	{
	    PApplet.main(new String[] { "--present", "MyProcessingSketch" });
	    
	}
//public void keyPressed() {
	//reader.onKeyPress();
//}


//public void keyReleased() {
//	reader.onKeyRelease();
//}

public void mousePressed() {
	ball.seek(mouseX, mouseY, player1.moved);
}

}
//TO DO
//create gridspace
//change ball movement schemes
//set up git hub
//add sounds
//add sprite