import java.util.LinkedList;

public class GameThread extends Thread {

    LinkedList<AutoMovable> objects;

    public GameThread() {
        objects = new LinkedList<>();
    }

    public void addObject(AutoMovable obj)
    {
        objects.add(obj);
    }

    public void removeObject(AutoMovable obj)
    {
        objects.remove(obj);
    }

    public void run()
    {
        while(true)
        {
            for(AutoMovable obj : objects)
            {
                obj.move();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
