import java.awt.*;
import java.util.ArrayList;

public class Plane extends GameObject {

    private Coordinate head;

    public Plane(Coordinate head) {
        super(new Color(100,150,120));
        this.head = head;
        generateCoordinates();
        draw(false);
    }

    @Override
    public void generateCoordinates() {
        coordinates.add(head);

        coordinates.add(new Coordinate(head.getRow()+1,head.getColumn()));
        coordinates.add(new Coordinate(head.getRow()-1,head.getColumn()));
        coordinates.add(new Coordinate(head.getRow(),head.getColumn()+1));
        coordinates.add(new Coordinate(head.getRow(),head.getColumn()-1));

        coordinates.add(new Coordinate(head.getRow()+2,head.getColumn()));

        coordinates.add(new Coordinate(head.getRow()+2,head.getColumn()-1));
        coordinates.add(new Coordinate(head.getRow()+2,head.getColumn()-2));
        coordinates.add(new Coordinate(head.getRow()+3,head.getColumn()-1));

        coordinates.add(new Coordinate(head.getRow()+2,head.getColumn()+1));
        coordinates.add(new Coordinate(head.getRow()+2,head.getColumn()+2));
        coordinates.add(new Coordinate(head.getRow()+3,head.getColumn()+1));
    }

//Move Functions:
    public void moveLeft()
    {
        if(head.getColumn() == 2)
            return;

        move(0,-1);
    }

    public void moveRight()
    {
        if(head.getColumn() == GameController.getInstance().getGamePane().getColumnCount()-3)
            return;

        move(0,1);
    }

    public void moveUp()
    {
        if(head.getRow() == 1)
            return;

        move(-1,0);
    }

    public void moveDown()
    {
        if(head.getRow() == GameController.getInstance().getGamePane().getRowCount()-4)
            return;

        move(1,0);
    }

    public void move(int vR, int vC)
    {
        draw(true);

        for(int i=0;i<coordinates.size();i++)
        {
            Coordinate c = coordinates.get(i);
            c.setRow(c.getRow() + vR);
            c.setColumn(c.getColumn() + vC);
        }

        if(!GameController.getInstance().checkPlaneCrash())
        {
            draw(false);
        }
    }
//*************************************************************

    public Coordinate getBulletPosition()
    {
        return new Coordinate(head.getRow()-2, head.getColumn());
    }

//Check collision with enemy:
    public Boolean checkCollisionWithEnemy(Enemy enemy)
    {
        ArrayList<Coordinate> enemyCoordinates = enemy.getCoordinates();
        for(Coordinate ec: enemyCoordinates)
        {
            for(Coordinate pc: coordinates)
            {
                if(ec.getRow() == pc.getRow() && ec.getColumn() == pc.getColumn())
                {
                    return true;
                }
            }
        }

        return false;
    }
//*************************************************************

}
