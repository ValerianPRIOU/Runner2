import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {

    @Override
    public ImageView getSpriteHeros() {
        return this.spriteHeros;
    }

    public Hero() {
        super(20,245,"heros");
    }
}
