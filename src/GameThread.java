import java.util.ArrayList;
import java.util.LinkedList;

public class GameThread extends Thread {

    LinkedList<AutoMovable> objects;

    ArrayList<AutoMovable> deadObjects;

    ArrayList<AutoMovable> newObjects;

    public GameThread() {
        objects = new LinkedList<>();
        deadObjects = new ArrayList<>();
        newObjects = new ArrayList<>();
    }

    public void addObject(AutoMovable obj)
    {
        newObjects.add(obj);
    }

    public void removeObject(AutoMovable obj)
    {
        deadObjects.add(obj);
    }

    public void run()
    {
        while(true)
        {
            objects.addAll(newObjects);
            newObjects.clear();

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
