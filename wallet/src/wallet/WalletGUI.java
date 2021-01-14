package wallet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class WalletGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static WalletGUI win;
	protected static JPanel wrap;
	protected static int height = 500;
	protected static int width = 500;
	
	public static void main(String[] args) throws IOException {
		win = new WalletGUI();
		win.setSize(new Dimension(width,height));
		win.add(win.gui());
	    try {
	        InputStream imageInputStream = win.getClass().getResourceAsStream("./icon.png");
		    BufferedImage bufferedImage = ImageIO.read(imageInputStream);
		    win.setIconImage(bufferedImage);
		} catch (IOException exception) {
		    exception.printStackTrace();
		}
		win.setTitle("DTU cryptocoin");
		win.setResizable(false);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
		
	}
	
	public JPanel gui() throws IOException {

		getContentPane().setLayout(new BorderLayout());

		// init and set margin
		wrap = new JPanel();
		wrap.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		wrap.setBackground(new Color(235,235,235));
		
		BufferedImage img = ImageIO.read(this.getClass().getResource("./logo.png"));
		JLabel icon = new JLabel(new ImageIcon(img));
		icon.setMaximumSize(new Dimension(100,100));
		wrap.add(icon);
		
	
		

		
		getContentPane().add(wrap);
		return wrap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
