import java.util.ArrayList;
import java.util.LinkedList;

public class GameThread extends Thread {

    LinkedList<AutoMovable> objects;

    ArrayList<AutoMovable> deadObjects;

    public GameThread() {
        objects = new LinkedList<>();
        deadObjects = new ArrayList<>();
    }

    public void addObject(AutoMovable obj)
    {
        objects.add(obj);
    }

    public void removeObject(AutoMovable obj)
    {
        deadObjects.add(obj);
    }

    public void run()
    {
        while(true)
        {
            for(AutoMovable obj : objects)
            {
                obj.move();
            }

            objects.removeAll(deadObjects);
            deadObjects.clear();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
