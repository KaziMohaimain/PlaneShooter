import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

//Private Constructor:
    private GameController() {
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();

        gameThread = new GameThread();
    }

    public void init(GameGrid gamePane, TitleLabel titleLabel) {
        this.gamePane = gamePane;
        this.titleLabel = titleLabel;

        plane = new Plane(new Coordinate(gamePane.getRowCount()/2, gamePane.getColumnCount()/2));

        generateEnemy();

        gameThread.start();
    }

    public void generateEnemy()
    {
        Coordinate c = new Coordinate(1, gamePane.getColumnCount()/2);
        Enemy enemy = new Enemy(c, new Velocity(0,1));
        enemies.add(enemy);
        gameThread.addObject(enemy);
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

    public void fireBullet()
    {
        bullets.add(new Bullet(plane.getBulletPosition()));
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
