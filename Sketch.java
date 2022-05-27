import processing.core.PApplet;

public class Sketch extends PApplet {
	//variables
  float bluePlayerX = 400;
  float bluePlayerY = 400;
  float bpSizeX = 50;
  float bpSizeY = 50;
  float[] circleY = new float[25];
  float[] circleX = new float[25];

  boolean boolUpPressed = false;
  boolean boolDownPressed = false;
  boolean boolLeftPressed = false;
  boolean boolRightPressed = false;

  boolean boolPlayerStatus = true;
  int intLives = 3;

  boolean boolMouseClicked = false;

  boolean[] ballHideStatus = new boolean[25];

  int snowballSpeed = 3;

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
      circleX[i] = random(width);
      ballHideStatus[i] = false;
   }
  }
  
  public void draw() {
    //check if player is alive 
    if (boolPlayerStatus == true) {
      background(225, 235, 233);
    
      //draw snowballs
      fill(66, 245, 242);
      for (int i = 0; i < circleY.length; i++) {
      if (ballHideStatus[i] == false) {
          ellipse(circleX[i], circleY[i], 50, 50);

          circleY[i] += snowballSpeed;
      }

      if (circleY[i] > height - 25) {
        circleY[i] = 0;
      }

      //if player ball hits snowball stop drawing snowball and -1 life
      if (dist(bluePlayerX, bluePlayerY, circleX[i], circleY[i]) <= 37.5 && ballHideStatus[i] == false) {
        ballHideStatus[i] = true;
        intLives--;
      }

      //if snowball is clicked stop drawing snow ball
      if (dist(mouseX, mouseY, circleX[i], circleY[i]) <= 25 && boolMouseClicked) {
        ballHideStatus[i] = true;
    }
    
  }
      //create player ball
      fill(4, 57, 191);
      ellipse(bluePlayerX, bluePlayerY, bpSizeX, bpSizeY);

      //control player ball
      if (boolLeftPressed) {
        bluePlayerX += -5;
      }
      if (boolRightPressed) {
        bluePlayerX += 5;
      }
      if (boolUpPressed) {
        bluePlayerX += -5;
      }
      if (boolDownPressed) {
        bluePlayerX += 5;
      }
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
      //draw live indicators 
      fill(245, 66, 96);
      for (int i = 1; i <= intLives; i++) {
        rect(70 * i, 50, 50, 50);
      }

      if (intLives == 0) {
        boolPlayerStatus = false;
      }
    }
    else {
      background(255);
      textSize(50);
      text("GAME OVER", 150, 300);
    }
  }
 /**
  * map movement keys so that if they are pressed change bollean values to move the player
  */
  public void keyPressed() {
    if (key == 'a') {
      boolLeftPressed = true;
    }
    else if (key == 'd') {
      boolRightPressed = true;
    }
    else if (key == 'w') {
      boolUpPressed = true;
    }
    else if (key == 's') {
      boolDownPressed = true;
    }
    // set keys to change snow ball speed
    if (keyCode == UP) {
      snowballSpeed = 1;
    } 
    if (keyCode == DOWN) {
      snowballSpeed = 5;
    }
  }
  public void keyReleased() {
    // allow handling multiple keys when moving the player ball
    if (key == 'w') {
      boolUpPressed = false;
    }
    else if (key == 's') {
      boolDownPressed = false;
    }
    else if (key == 'a') {
      boolLeftPressed = false;
    }
    else if (key == 'd') {
      boolRightPressed = false;
    }
  }

  public void mousePressed() {
    // allow mouse input to destroy snowball when clicked
    ellipse(mouseX, mouseY, 20, 20);
    boolMouseClicked = true;
  }
  
  public void mouseReleased() {
    boolMouseClicked = false;
  }
}
