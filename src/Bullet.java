import java.awt.*;

public class Bullet extends GameObject {

    private Coordinate position;

    //Constructor:
    public Bullet(Coordinate position) {
        super(new Color(180,160,120));

        this.position = position;
        generateCoordinates();
        draw(false);
    }

    @Override
    public void generateCoordinates() {
        coordinates.add(position);
    }
}
