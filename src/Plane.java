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


    public void moveLeft()
    {
        if(coordinates.get(0).getColumn() == 2)
            return;

        draw(true);

        for(int i=0;i<coordinates.size();i++)
        {
            Coordinate c = coordinates.get(i);
            c.setColumn(c.getColumn() - 1);
        }

        if(!GameController.getInstance().checkPlaneCrash())
        {
            draw(false);
        }
    }

    public void moveRight()
    {
        if(coordinates.get(0).getColumn() == GameController.getInstance().getGamePane().getColumnCount()-3)
            return;

        draw(true);

        for(int i=0;i<coordinates.size();i++)
        {
            Coordinate c = coordinates.get(i);
            c.setColumn(c.getColumn() + 1);
        }

        if(!GameController.getInstance().checkPlaneCrash())
        {
            draw(false);
        }
    }

    public Coordinate getBulletPosition()
    {
        return new Coordinate(coordinates.get(0).getRow()-2, coordinates.get(0).getColumn());
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
