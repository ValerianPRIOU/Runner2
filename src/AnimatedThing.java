import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.concurrent.TimeUnit;

public abstract class AnimatedThing {

    double posXHeros;
    double posYHeros;
    ImageView spriteHeros;
    int attitude;

    int indexCourse;
    int maxIndexCourse = 5;
    //Parcequ'il y a 6 sprites de course.

    int delai = 15;
    //délai entre deux frames.


    public AnimatedThing(double posXHeros, double posYHeros, String fileName) {

        this.posXHeros = posXHeros;
        this.posYHeros = posYHeros;

        Image spriteHerosImage = new Image("file:src/resources/images/heros.png");
        this.spriteHeros = new ImageView(spriteHerosImage);
        //Mise sous forme d'"Image" du sprite pour pouvoir utiliser ImageView.

        this.spriteHeros.setX(posXHeros);
        this.spriteHeros.setY(posYHeros);

        this.spriteHeros.setViewport(new Rectangle2D(0,0,75,100));
        //Rectangle2D(minX, minY, width, height)
    }

    public void setPosXHeros(double posXHeros) {
        this.posXHeros = posXHeros;
    }

    public void setPosYHeros(double posYHeros) {
        this.posYHeros = posYHeros;
    }

    public void setSpriteHeros(ImageView spriteHeros) {
        this.spriteHeros = spriteHeros;
    }

    public void setIndexCourse(int indexCourse) {
        this.indexCourse = indexCourse;
    }

    public double getPosXHeros() {
        return posXHeros;
    }

    public double getPosYHeros() {
        return posYHeros;
    }

    public int getIndexCourse() {
        return indexCourse;
    }

    public abstract ImageView getSpriteHeros();

    public void deplacement(long l) {
        //(update)

        int index = getIndexCourse();

        if(index == maxIndexCourse) {
            setIndexCourse(0);
            //Lorsqu'on arrive à la fin de l'animation on recommence à 0.
        }
        else {
            setIndexCourse(index + 1);
            //On incrémente l'index pour afficher un sprite différent, 6 au total pour la course.
        }

        posXHeros = getPosXHeros();
        spriteHeros.setViewport(new Rectangle2D(getIndexCourse()*85,0,85,100));
        //getIndexCourse() incrémente de 0 à 5 pour sélectionner les différentes parties de l'image contenant les sprites, ils sont tous séparés par 85 pixels.
    }
}
