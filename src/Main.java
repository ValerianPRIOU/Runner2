import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Flash");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene theScene = new GameScene(pane,800,400, true);
        //Mise en place de la scene et de son environnement.
        //x et y correspondent à la taille de la scene (de la fenêtre d'affichage).

        pane.getChildren().add(GameScene.getBackgroundLeft().getImageview());
        pane.getChildren().add(GameScene.getBackgroundRight().getImageview());
        //Recupere les images background left/right pour les afficher.

        pane.getChildren().add(theScene.getMegaman().getSpriteHeros());


        primaryStage.setScene(theScene);
        primaryStage.show();
        //On mets theScene en primaryStage pour pavoir l'afficher par la suite.



    }


    public static void main(String[] args) {
        launch(args);
    }
    //main commun pour toutes les applications JFX.
}