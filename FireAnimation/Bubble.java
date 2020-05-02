import javafx.animation.PathTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import java.util.Random;

/**
 * define a bubble -> component of the fire
 * the bubble needs to move upwards and fade as it goes
 */
public class Bubble extends Circle {

    //coordinates of the bubble
    private double x;
    private double y;

    //the coordinates to form the trajectory of the bubble -> randomly chosen
    private double nextX;
    private double nextY;

    //the r in the rgb spectrum which will give the impression of fading while updating
    private int r = 0;

    public Bubble(int x, int y) {
        this.x = x;
        this.y = y;
        nextX = (new Random()).nextDouble();
        nextY = (new Random()).nextDouble();

        //set the initial radius of the bubble
        setRadius(15);
    }

    /**
     * make the bubble move and fade as it updates
     */
    public void update() {

        /*
        calculate the trajectory of the bubbles such that it is in "area" of the fire
         */
        x = x + (nextX - 0.5) * 0.4; //make the bubbles also go on the other half of the x and reduce area
        y = y - nextY - 0.1; //the bubbles must go up => subtract

        //create the illusion of fading by increasing the red color
        if(r < 255) {
            r++;
            /*
            create the illusion of sparks and leave them float and spread
            if you want a more realistic fire, just set the radius outside this if statement
             */
            setRadius(getRadius() - 0.057);
        }

        //setRadius(getRadius() - 0.057);

        //move the bubble
        Path path = new Path();
        path.getElements().add(new MoveTo(x, y));
        PathTransition pt = new PathTransition();
        pt.setNode(this);
        pt.setPath(path);
        pt.play();
    }

    /**
     * draw the bubble
     */
    public void draw() {
        setCenterX(x);
        setCenterY(y);
        setFill(Color.rgb(r, 0, 0));
        setStroke(null);
    }
}

