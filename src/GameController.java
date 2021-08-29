import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameController {

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

    public GameController(GameGrid gamePane, TitleLabel titleLabel) {
        this.gamePane = gamePane;
        this.titleLabel = titleLabel;

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        gameThread = new GameThread();

        Enemy enemy = new Enemy(gamePane, new Coordinate(10, 5),
                new Velocity(0,1));
        enemies.add(enemy);

        gameThread.addObject(enemy);

        enemy = new Enemy(gamePane, new Coordinate(10, 30),
                new Velocity(1,1));
        enemies.add(enemy);

        gameThread.addObject(enemy);

        enemy = new Enemy(gamePane, new Coordinate(10, 60),
                new Velocity(1,0));
        enemies.add(enemy);

        gameThread.addObject(enemy);

        //plane = new Plane(gamePane, new Coordinate(gamePane.getRowCount()/2, gamePane.getColumnCount()/2));

        gameThread.start();
    }

//*************************************************************
//Game Over Function:
    public void gameIsOver()
    {
        gameOver = true;

        titleLabel.setText("Game Over");
    }

    public void fireBullet()
    {
        bullets.add(new Bullet(gamePane, plane.getBulletPosition()));
    }

//*************************************************************
    public void handleKeyPress(int keyCode)
    {
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
