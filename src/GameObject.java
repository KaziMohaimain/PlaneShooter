import java.awt.Color;
import java.util.ArrayList;

public abstract class GameObject {

	protected Color color;
	
	protected GameGrid gameGrid;
	
	protected ArrayList<Coordinate> coordinates;
	
//Constructor:
	public GameObject(GameGrid gameGrid, Color color) {
		coordinates = new ArrayList<>();
		this.color = color;
		this.gameGrid = gameGrid;
	}
	
//Draw Function:
	public void draw(boolean erase)
	{
		Color color = erase ? null : this.color;
		for(int i=0;i<coordinates.size();i++)
		{
			gameGrid.drawCell(coordinates.get(i), color);
		}
	}
	
//Function to generate co-ordinates:
	abstract public void generateCoordinates();
}
