import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameGrid extends JPanel {

	private final int rowCount = 60;
	
	private final int columnCount = 90;

	private JPanel[][] cells;
	
	private final Color NORMAL_CELL_CLR = new Color(50, 75, 48);
	
	public GameGrid()
	{
		setLayout(new GridLayout(this.rowCount, this.columnCount, 1, 1));
		this.setBackground(new Color(21, 20, 13));
		
		cells = new JPanel[rowCount][];
		for(int i=0;i<rowCount;i++)
		{
			cells[i] = new JPanel[columnCount];
			
			for(int j=0;j<columnCount;j++)
			{
				cells[i][j] = new JPanel();
				cells[i][j].setBackground(NORMAL_CELL_CLR);
				add(cells[i][j]);
			}
		}
	}
	
//Getter Functions:
	public int getRowCount()
	{
		return rowCount;
	}
	
	public int getColumnCount()
	{
		return columnCount;
	}
	
	public void drawCell(Coordinate coordinate, Color color)
	{
		if(color == null)
		{
			color = this.NORMAL_CELL_CLR;
		}
		
		cells[coordinate.getRow()][coordinate.getColumn()].setBackground(color);
	}
}
