import java.awt.Color;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleLabel extends JLabel {
	
//Constructor:
	public TitleLabel() {
		setFont(new Font("Ink Free", Font.BOLD,75));
		setText("PLAY");
		setForeground(new Color(224, 208, 81));

		setHorizontalAlignment(JLabel.CENTER);
		setPreferredSize(new Dimension(1200, 100));
	}

}
