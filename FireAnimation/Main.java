import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;

/**
 * main class for running the application
 * animates a fire
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Group root = new Group();
        ArrayList<Bubble> bubbles = new ArrayList<>();

        //generate bubble every 10 milliseconds, add it to the array and to the root
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            Bubble bubble = new Bubble(300, 580);
            bubbles.add(bubble);
            root.getChildren().add(bubble);

            //draw and update all the bubbles
            for(Bubble b : bubbles) {
                b.update();
                b.draw();
            }

        }));

        tl.setCycleCount(Transition.INDEFINITE);
        tl.play();

        stage.setScene(new Scene(root, 600, 600, Color.BEIGE));
        stage.show();
        stage.setResizable(false);
    }
}
