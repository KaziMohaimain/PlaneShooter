import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements KeyListener {

	private GameController gameController;

	public MainFrame() {

		initFrame();
		
		TitleLabel titleLabel = new TitleLabel();
		
		GameGrid gamePane = new GameGrid();

		add(titleLabel,BorderLayout.NORTH);
		
		add(gamePane);
		
		this.setVisible(true);

		gameController = new GameController(gamePane, titleLabel);
	}
	
	private void initFrame()
	{
		this.setTitle("PlaneShooter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 800);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(new Color(20, 54, 79));
		setContentPane(contentPane);
		
		this.setFocusable(true);
		this.addKeyListener(this);
	}

	
	@Override
	public void keyPressed(KeyEvent e)
	{
		gameController.handleKeyPress(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}

}