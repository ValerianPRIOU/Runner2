import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {

    double positionX;
    double positionY;
    ImageView imageview;
    //ImageView est un noeud utilisé pour peindre des images chargées avec la classe Image
    //ex : ImageView(Image(...));  --> Peint l'image de classe Image "..."
    //Formats autorisés : BMP,GIF,JPEG,PNG

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public ImageView getImageview() {
        return imageview;
    }

    public StaticThing(double positionX, double positionY, String fileName) {

        this.positionX = positionX;
        this.positionY = positionY;

        this.imageview = new ImageView(fileName);

        this.imageview.setX(positionX);
        this.imageview.setY(positionY);
        //Cette partie permet de donner les coordonnées auxquelles la future image sera placée dans la scene.

    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    //On créée ces deux setters pour pouvoir modifier la position de StaticThing(s) déjà créés.
}
