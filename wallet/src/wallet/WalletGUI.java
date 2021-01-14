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
	protected static int leftWidth = (int)((width*0.9) - 150);
	
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

		// init and set wrapper obj. defaults
		wrap = new JPanel();
		wrap.setBackground(new Color(235,235,235));
		wrap.setBorder(null);
		
		/**
		 * describing left area
		 */
 		
		// add left layout
		JPanel left = new JPanel();
		left.setLayout(new BoxLayout(left,BoxLayout.PAGE_AXIS));
		left.setBorder(BorderFactory.createEmptyBorder(0, 25, 25, 25));
		left.setPreferredSize(new Dimension(leftWidth, height));

		// header wrapper left
		JPanel headerWrapper = new JPanel();
		headerWrapper.setMaximumSize(new Dimension(width,75));
		headerWrapper.setPreferredSize(new Dimension(width,75));
		headerWrapper.setLayout(new BoxLayout(headerWrapper,BoxLayout.LINE_AXIS));
		
		// header
		JLabel header = new JLabel("DTU wallet");
		header.setMaximumSize(new Dimension(300,50));
		header.setFont(new Font(Font.SANS_SERIF, Font.TRUETYPE_FONT, 22));
		
		headerWrapper.add(header);
		left.add(headerWrapper,BorderLayout.NORTH);
	
		
		// my wallet status left
		JPanel walletStatus = new JPanel();
		walletStatus.setLayout(new BoxLayout(walletStatus,BoxLayout.PAGE_AXIS));
		walletStatus.setPreferredSize(new Dimension(width, 100));
		
		// wallet balance
		JPanel balanceWrap = new JPanel();	
		balanceWrap.setLayout(new BoxLayout(balanceWrap,BoxLayout.LINE_AXIS));	
		balanceWrap.setMaximumSize(new Dimension(width,30));
		
		JLabel balance = new JLabel("My Balance:    ");
		balance.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
  		
		JLabel balanceValue = new JLabel("16000.00" + " DTUC");
  		balanceValue.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
		
  		balanceWrap.add(balance);
		balanceWrap.add(balanceValue);

		
		// pending balance in block nonce proccessing
		JPanel pendingWrap = new JPanel();
		pendingWrap.setLayout(new BoxLayout(pendingWrap,BoxLayout.LINE_AXIS));
 		pendingWrap.setMaximumSize(new Dimension(width,30));

		JLabel pending = new JLabel("Unconfirmed:  ");
		pending.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,14));
		
		JLabel pendingValue = new JLabel("0.00" + " DTUC");
		pendingValue.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));
		
		pendingWrap.add(pending);
		pendingWrap.add(pendingValue);
		
		walletStatus.add(balanceWrap);
		walletStatus.add(pendingWrap);
		
		left.add(walletStatus);
		
		
		// my wallet info center
		JPanel addresses = new JPanel();
		addresses.setLayout(new BoxLayout(addresses, BoxLayout.PAGE_AXIS));
		addresses.setMaximumSize(new Dimension(width,100));
		addresses.setPreferredSize(new Dimension(width,100));
		addresses.setMinimumSize(new Dimension(width,100));
		
		// my wallet address
		JPanel myAddressPanel = new JPanel();
		myAddressPanel.setMinimumSize(new Dimension(width,50));
		myAddressPanel.setMaximumSize(new Dimension(width,50));
		myAddressPanel.setPreferredSize(new Dimension(width,50));
		myAddressPanel.setBorder(BorderFactory.createMatteBorder(20, 0, 0, 0, getForeground()));
		
		JLabel myAddress = new JLabel("My Address");
		myAddressPanel.setLayout(new BoxLayout(myAddressPanel, BoxLayout.LINE_AXIS));
		
		myAddressPanel.add(myAddress);
		
		JTextField hexAddress = new JTextField("F970E2767D0CFE75876EA857F92E319B");
		hexAddress.setEditable(false);

		hexAddress.setLayout(new BoxLayout(hexAddress, BoxLayout.LINE_AXIS));
		hexAddress.setMaximumSize(new Dimension(width,30));
		hexAddress.setMinimumSize(new Dimension(width,30));
		hexAddress.setPreferredSize(new Dimension(width,30));
	 
		addresses.add(myAddressPanel);
		addresses.add(hexAddress);
		left.add(addresses);

		
		// send to address area left
		JPanel sendCoins = new JPanel();
		sendCoins.setBackground(Color.red);
 
		sendCoins.setLayout(new BoxLayout(sendCoins,BoxLayout.PAGE_AXIS));
		
		// title
		JLabel title = new JLabel("Send coins"); 
		title.setFont(new Font(Font.SANS_SERIF,Font.BOLD,14));	

		title.setMaximumSize(new Dimension(width,50));
		title.setMinimumSize(new Dimension(width,50));
		title.setPreferredSize(new Dimension(width,50));
		title.setLayout(new BoxLayout(title, BoxLayout.PAGE_AXIS));
		sendCoins.add(title);
		
		
		// inputs wrapper for coin rec info
		JPanel inputs = new JPanel(); 
		inputs.setLayout(new BoxLayout(inputs,BoxLayout.PAGE_AXIS));

		// address
		JLabel addtitle = new JLabel("Address");
 
		addtitle.setLayout(new BoxLayout(addtitle, BoxLayout.PAGE_AXIS));
		inputs.add(addtitle);
		
		JTextField recAdd = new JTextField();
		recAdd.setPreferredSize(new Dimension(width, 30));
		recAdd.setMaximumSize(new Dimension(width, 30));
		
		inputs.add(recAdd);
		
		
		// amount
		JLabel amtitle = new JLabel("Amount");
		amtitle.setLayout(new BoxLayout(amtitle, BoxLayout.LINE_AXIS));
		inputs.add(amtitle);
		
		JTextField amount = new JTextField();
		amount.setPreferredSize(new Dimension(width, 30));
		amount.setMaximumSize(new Dimension(width, 30));
		
		inputs.add(amount);
		
		
		// submit
		JButton submit = new JButton("Send");
		submit.setLayout(new BoxLayout(submit, BoxLayout.LINE_AXIS));
		submit.addActionListener(this);
		submit.setActionCommand("send");
		submit.setBounds(getBounds());
		submit.setMinimumSize(new Dimension(width, 30));
		submit.setMaximumSize(new Dimension(width, 30));
		
		
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
