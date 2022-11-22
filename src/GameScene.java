import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;

public class GameScene extends Scene {

    Camera ecranDeJeux;
    private Hero Megaman;

    private static StaticThing backgroundLeft;
    private static StaticThing backgroundRight;

    public GameScene(Parent parent, double x, double y, boolean b) {
        super(parent, x, y, b);
        this.backgroundLeft = new StaticThing(0,0,"file:src/resources/images/desert.png");
        this.backgroundRight = new StaticThing(0,0,"file:src/resources/images/desert.png");
        //positionX et Y pour les coordonnées auxquelles l'image va apparaître. Donc 0;0 si on la veut à l'origine (au coin en haut à gauche).
        //desert.png est de dimension 800x400 donc si on veut l'afficher en entier on aura besoin d'une scene/camera de dimensions 800x400.
        //On crée deux instances de desert.png pour l'instant aux mêmes coordonnées pour créer plus tard un défilement et donner l'illusion de déplacement.
        this.Megaman = new Hero();

        AnimationTimer rafraichissement = new AnimationTimer(){
            @Override
            public void handle(long l){
                GameScene.defilement(l);
                Megaman.deplacement(l);
            }
            //Création d'un timer permettant de refresh la scene pour chaque frames.
        };
        rafraichissement.start();
        //Démarrage du timer.
    }

    public static StaticThing getBackgroundLeft() {
        return backgroundLeft;
    }

    public static StaticThing getBackgroundRight() {
        return backgroundRight;
    }

    public Hero getMegaman() { return Megaman; }

    private static void defilement(long l){

        int vitesse = 3;
        double xl = backgroundLeft.getPositionX();
        //Position de l'image de backgroundLeft
        double xr = backgroundRight.getPositionX();

        if (xl < 4){
            backgroundLeft.getImageview().setX(800);
            //L'image de backgroundLeft fait maintenant 800 en longueur.
            backgroundLeft.setPositionX(800);
            //L'image background Left "démarre" maintenant au 800e pixel sur l'axe des x : l'image de backgroundLeft est donc complètement à droite.
            backgroundRight.getImageview().setX(0);
            //On "efface" l'image de backgroundRight.
            backgroundRight.setPositionX(0);
            //On fait démarrer cette image tout à gauche.

            //Au début de l'animation de défilement, on place backgroundLeft tout à droite et on le ramène progressivement à gauche pour faire courir notre héros
            //de la gauche vers la droite.
        }
        else {
            backgroundLeft.getImageview().setX(xl - vitesse);
            backgroundLeft.setPositionX(xl - vitesse);
            backgroundRight.getImageview().setX(xr - vitesse);
            backgroundRight.setPositionX(xr - vitesse);

            //De cette façon, plus la vitesse est élevée et plus l'image défilera rapidement.
        }
    }



}
