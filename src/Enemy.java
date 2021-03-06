import java.awt.Color;
import java.util.ArrayList;

public class Enemy extends GameObject implements AutoMovable {

	private Coordinate center;

	private Velocity velocity;
	
//Constructor:
	public Enemy(Coordinate center, Velocity velocity) {
		super(new Color(100,120,150));

		this.center = center;
		this.velocity = velocity;

		generateCoordinates();
		draw(false);
	}

//Getter Function:
	public ArrayList<Coordinate> getCoordinates()
	{
		return coordinates;
	}

	@Override
	public void generateCoordinates() {
		//coordinates.add(center);
		coordinates.add(new Coordinate(center.getRow()+1,center.getColumn()));
		coordinates.add(new Coordinate(center.getRow()-1,center.getColumn()));
		coordinates.add(new Coordinate(center.getRow(),center.getColumn()+1));
		coordinates.add(new Coordinate(center.getRow(),center.getColumn()-1));
	}

//Methods inherited from the AutoMovable Interface;
	@Override
	public void move() {
		checkoutOfBoundary();

		draw(true);

		for(int i=0;i<coordinates.size();i++)
		{
			Coordinate current = coordinates.get(i);
			current.setColumn(current.getColumn() + velocity.getHorizontalVelocity());
			current.setRow(current.getRow() + velocity.getVerticalVelocity());
		}

		center.setColumn(center.getColumn() + velocity.getHorizontalVelocity());
		center.setRow(center.getRow() + velocity.getVerticalVelocity());

		draw(false);
	}

	@Override
	public Velocity getVelocity() {
		return velocity;
	}

	@Override
	public boolean checkoutOfBoundary() 
	{
		int nexCenterRow = center.getRow() + getVelocity().getVerticalVelocity();
		int nexCenterColumn = center.getColumn() + getVelocity().getHorizontalVelocity();

		if(nexCenterColumn < 1 || nexCenterColumn > GameController.getInstance().getGamePane().getColumnCount()-2)
		{
			velocity.setHorizontalVelocity(-1 * velocity.getHorizontalVelocity());
		}
		if(nexCenterRow < 1 || nexCenterRow > GameController.getInstance().getGamePane().getRowCount()-2)
		{
			velocity.setVerticalVelocity(-1 * velocity.getVerticalVelocity());
		}
		return false;
	}

	public boolean checkBulletHit(Bullet bullet)
	{
		int horizontalDistance = Math.abs(center.getColumn() - bullet.getPosition().getColumn());
		int verticalDistance = Math.abs(center.getRow() - bullet.getPosition().getRow());

		if(horizontalDistance <= 1 && verticalDistance <= 1)
		{
			draw(true);
			return true;
		}

		return false;
	}
}
