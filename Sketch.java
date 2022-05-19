import processing.core.PApplet;

public class Sketch extends PApplet {
	//variables
  float bluePlayerX = 400;
  float bluePlayerY = 400;
  float bpSizeX = 50;
  float bpSizeY = 50;
  float[] circleY = new float[25];
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(800, 800);
  }

  public void setup() {
    for (int i = 0; i < circleY.length; i++) {
      circleY[i] = random(height);
    }
  }
  
  public void draw() {
    background(225, 235, 233);
  
    for (int i = 0; i < circleY.length; i++) {
      float circleX = width * i / circleY.length;
      fill(207, 224, 18);
      ellipse(circleX, circleY[i], 25, 25);
  
      circleY[i]++;
  
      if (circleY[i] > height) {
        circleY[i] = 0;
      }
    }
    //create player ball
    fill(4, 57, 191);
    ellipse(bluePlayerX, bluePlayerY, bpSizeX, bpSizeY);

    //create bounderies
    if(bluePlayerX < 25) {
      bluePlayerX -= -5;
    }
    else if (bluePlayerX > 775){
      bluePlayerX -= -5;
    }
    if(bluePlayerY < 25) {
      bluePlayerY -= -5;
    }
    else if (bluePlayerY > 775){
      bluePlayerY -= -5;
    }
  }
}