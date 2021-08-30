import java.awt.Color;
import java.util.ArrayList;

public abstract class GameObject {

	protected Color color;
	
	protected ArrayList<Coordinate> coordinates;
	
//Constructor:
	public GameObject(Color color) {
		coordinates = new ArrayList<>();
		this.color = color;
	}
	
//Draw Function:
	public void draw(boolean erase)
	{
		Color color = erase ? null : this.color;
		for(int i=0;i<coordinates.size();i++)
		{
			GameController.getInstance().getGamePane().drawCell(coordinates.get(i), color);
		}
	}
	
//Function to generate co-ordinates:
	abstract public void generateCoordinates();
}
