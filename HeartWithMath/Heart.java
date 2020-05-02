import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import static java.lang.Math.*;

/**
 * main class to run the application
 * draws hearts using a math formula (spread love with some math)
 */
public class Heart extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root);

        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        //set the center of the drawing
        gc.translate(300, 300);
        canvas.toBack();

        surprise(gc); //draw the hearts

        root.getChildren().add(canvas);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /**
     * this method draws a heart on the canvas with a set radiant
     * @param radiant -> basically says how big the heart will be
     */
    public void drawHeart(GraphicsContext gc, int radiant) {

        gc.setFill(Color.color(Math.random(), Math.random(), Math.random())); //fill the heart with a random color

        /*
        draw the heart in 2pi space
         */
        for(float i = 0; i < 2*PI; i += (float)0.01) {
            var x = radiant * 16 * pow(sin(i), 3);
            var y = -radiant*(13 * cos(i) - 5 * cos(2 * i) - 2 * cos(3 * i) - cos(4 * i));
            gc.fillOval(x, y, 5, 5); //draw the little dot on the graph
        }
    }

    /**
     * draws different hearts of different radiant values
     * animates the hearts => simply changes their colors continuously
     */
    public void surprise(GraphicsContext gc) {

        Timeline timeline1 = new Timeline(
                new KeyFrame(Duration.millis(200), actionEvent1 -> {
                    //draws 17 hearts
                    for(int i = 1; i <= 17; i ++) {
                        drawHeart(gc, i);
                    }
                })
        );

        timeline1.setCycleCount(Transition.INDEFINITE);
        timeline1.play();
    }
}

