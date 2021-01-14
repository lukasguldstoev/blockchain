package wallet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class WalletGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static WalletGUI win;
	protected static JPanel wrap;
	protected static int height = 500;
	protected static int width = 600;
	
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
		win.setTitle("DTU cryptocoin wallet");
		win.setResizable(false);
		win.pack();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);

		
		
	}
	
	public JPanel gui() throws IOException {

		getContentPane().setLayout(new BorderLayout());

		// init and set margin
		wrap = new JPanel();
		wrap.setBackground(new Color(235,235,235));
		wrap.setBorder(null);
		
		/**
		 * describing left area
		 */
 		
		// add left layout
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left,BoxLayout.PAGE_AXIS));
		left.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
		left.setPreferredSize(new Dimension((int) ((width*0.9) - 150), height));
		
		// header left
		JLabel header = new JLabel("DTU wallet");
		header.setMaximumSize(new Dimension(width,50));
		header.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 22));
		left.add(header,BorderLayout.WEST);
	
		
		// my wallet status left
		JPanel walletStatus = new JPanel();
		walletStatus.setLayout(new BoxLayout(walletStatus,BoxLayout.PAGE_AXIS));

		// wallet balance
		JPanel balanceWrap = new JPanel();
		balanceWrap.setMaximumSize(new Dimension(width,30));
		JLabel balance = new JLabel("My Balance:");

		JLabel balanceValue = new JLabel("0.00" + " DTUC");
		balanceWrap.add(balance);
		balanceWrap.add(balanceValue);

		// pending balance in block nonce proccessing
		JPanel pendingWrap = new JPanel();
		pendingWrap.setMaximumSize(new Dimension(width,30));

		JLabel pending = new JLabel("Unconfirmed:");
		JLabel pendingValue = new JLabel("0.00" + " DTUC");
		pendingWrap.add(pending);
		pendingWrap.add(pendingValue);
		
		walletStatus.add(balanceWrap);
		walletStatus.add(pendingWrap);
		left.add(walletStatus);
		
		// my wallet info center
		JPanel addresses = new JPanel();
		addresses.setLayout(new BoxLayout(addresses, BoxLayout.PAGE_AXIS));
		addresses.setMaximumSize(new Dimension(width,50));
		
		// my wallet address
		JLabel myAddress = new JLabel("My Address");
		JPanel hexAddress = new JPanel();
		hexAddress.setBackground(Color.white);
		hexAddress.add(new JLabel("F970E2767D0CFE75876EA857F92E319B"));
		addresses.add(myAddress);
		addresses.add(hexAddress);
		left.add(addresses);

		// send to address area left
		JPanel sendCoins = new JPanel();
		sendCoins.setMaximumSize(new Dimension(width,50));
		sendCoins.setBackground(Color.RED);
		sendCoins.setLayout(new BoxLayout(sendCoins,BoxLayout.PAGE_AXIS));
		JLabel title = new JLabel("Send coins");
		title.setMaximumSize(new Dimension(width,50));
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));	
		sendCoins.add(title);
		
		JPanel inputs = new JPanel();

		JLabel addtitle = new JLabel("Address");
		inputs.add(addtitle);
		JTextField recAdd = new JTextField();
		recAdd.setMaximumSize(new Dimension(width, 30));
		inputs.add(recAdd);
		
		JLabel amtitle = new JLabel("Amount");
		inputs.add(amtitle);
		JTextField amount = new JTextField();
		amount.setMaximumSize(new Dimension(width, 30));
		inputs.add(amount);
		
		JButton submit = new JButton("Send");
		submit.addActionListener(this);
		submit.setActionCommand("send");
		
		
		inputs.add(submit);
		sendCoins.add(inputs);
		
		left.add(sendCoins);
		
		
		/**
		 * describing right area
		 */

		// add right layout
		BufferedImage img = ImageIO.read(this.getClass().getResource("./logo.png"));
		JLabel icon = new JLabel(new ImageIcon(img),SwingConstants.LEFT);
		
		// add logo to the right
		JPanel right = new JPanel();
		right.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
		right.setBackground(new Color(220,220,220));
		right.setPreferredSize(new Dimension(150,height));
		right.add(icon,BorderLayout.WEST);
		
		right.add(new JLabel("Symbol: DTUC"));
		
		
		/**
		 * wrap up
		 */
	
		// add wrapping elements to view
		wrap.add(left);
		wrap.add(right,BorderLayout.EAST);
		
		getContentPane().add(wrap);
		return wrap;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
