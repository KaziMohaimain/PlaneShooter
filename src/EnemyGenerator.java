public class EnemyGenerator extends Thread {

    public void run()
    {
        while(true)
        {
            GameController.getInstance().generateEnemy();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
