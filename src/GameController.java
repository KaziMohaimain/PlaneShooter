import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameController {

    private static GameController gameController;

    public static GameController getInstance()
    {
        if(gameController == null)
        {
            gameController = new GameController();
        }
        return gameController;
    }

//*************************************************************
    private boolean gameOver = false;

//*************************************************************
//Reference of gameGrid and titleLabel:
    private GameGrid gamePane;

    private TitleLabel titleLabel;
//*************************************************************

    private ArrayList<Enemy> enemies;

    private Plane plane;

    public ArrayList<Bullet> bullets;

    private GameThread gameThread;

    private EnemyGenerator enemyGenerator;

//Private Constructor:
    private GameController() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        gameThread = new GameThread();
        enemyGenerator = new EnemyGenerator();
    }

    public void init(GameGrid gamePane, TitleLabel titleLabel) {
        this.gamePane = gamePane;
        this.titleLabel = titleLabel;

        plane = new Plane(new Coordinate(gamePane.getRowCount()/2, gamePane.getColumnCount()/2));

        gameThread.start();
        enemyGenerator.start();
    }

//Generate Enemy Function:
    public void generateEnemy()
    {
        Random random = new Random();
        Coordinate c = new Coordinate(1, gamePane.getColumnCount()/2);

        int horizontalVelocity = (int) Math.pow(-1,random.nextInt(2)-1);
        Enemy enemy = new Enemy(c, new Velocity(horizontalVelocity,1));
        enemies.add(enemy);
        gameThread.addObject(enemy);
    }

//Dispose Enemy Function:
    public void disposeEnemy(Enemy enemy)
    {
        enemies.remove(enemy);
        gameThread.removeObject(enemy);
    }

//*************************************************************
    public void fireBullet()
    {
        Bullet bullet = new Bullet(plane.getBulletPosition());

        bullets.add(bullet);
        gameThread.addObject(bullet);
    }

    public void disposeBullet(Bullet bullet)
    {
        bullets.remove(bullet);
        gameThread.removeObject(bullet);
    }

//*************************************************************
//Check Enemy Hit:
    public boolean checkEnemyHit(Bullet bullet)
    {
        boolean result = false;

        for(int i=0;i<enemies.size();i++)
        {
            if(enemies.get(i).checkBulletHit(bullet))
            {
                disposeEnemy(enemies.get(i));
                result = true;
            }
        }

        if(result)
        {
            disposeBullet(bullet);
        }

        return result;
    }
//*************************************************************
//Check Plane Crash:
    public boolean checkPlaneCrash()
    {
        for(Enemy e : enemies)
        {
            if(plane.checkCollisionWithEnemy(e))
            {
                gameIsOver();
                return true;
            }
        }
        return false;
    }
//*************************************************************
//Getter Function:
    public boolean isGameOver() {
        return gameOver;
    }

    public GameGrid getGamePane() {
        return gamePane;
    }

//*************************************************************
//Game Over Function:
    public void gameIsOver()
    {
        gameOver = true;

        titleLabel.setText("Game Over");
    }

//*************************************************************
    public void handleKeyPress(int keyCode)
    {
        if(gameOver)
        {
            return;
        }

        switch(keyCode)
        {
            case KeyEvent.VK_SPACE:
                fireBullet();
                break;

            case KeyEvent.VK_LEFT:
                plane.moveLeft();
                break;

            case KeyEvent.VK_RIGHT:
                plane.moveRight();
                break;

            default:
                break;
        }
    }
}
