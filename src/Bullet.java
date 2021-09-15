import java.awt.*;

public class Bullet extends GameObject implements AutoMovable {

    private Coordinate position;

    private final Velocity velocity = new Velocity(0,-2);

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
        coordinates.add(new Coordinate(position.getRow()+1, position.getColumn()));
    }

    @Override
    public void move() {
        draw(true);
        if(checkoutOfBoundary())
        {
            GameController.getInstance().disposeBullet(this);
            return;
        }

        for(Coordinate c : coordinates)
        {
            c.setRow(c.getRow() + velocity.getVerticalVelocity());
        }

        if(!GameController.getInstance().checkEnemyHit(this))
        {
            draw(false);
        }
    }

    @Override
    public Velocity getVelocity() {
        return velocity;
    }

    @Override
    public boolean checkoutOfBoundary() {
        int nextRow = position.getRow() + getVelocity().getVerticalVelocity();

        if(nextRow < 0)
        {
            return true;
        }

        return false;
    }

//Getter Function:
    public Coordinate getPosition() {
        return position;
    }
}
