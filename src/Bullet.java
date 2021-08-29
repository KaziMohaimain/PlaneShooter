import java.awt.*;

public class Bullet extends GameObject {

    private Coordinate position;

    //Constructor:
    public Bullet(GameGrid gameGrid, Coordinate position) {
        super(gameGrid, new Color(180,160,120));

        this.position = position;
        generateCoordinates();
        draw(false);
    }

    @Override
    public void generateCoordinates() {
        coordinates.add(position);
    }
}
