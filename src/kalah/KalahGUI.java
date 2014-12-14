package kalah;

import game.Move;
import game.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.util.Arrays;
import java.util.Random;


public class KalahGUI extends JFrame implements MouseListener {
	private int kalahSize = 80;
	private int ballSize = 20;
	private static final long serialVersionUID = 1L;
	private boolean start1 = true;
	
	
	public static Player p1 = Player.ONE;
	public static Player p2 = Player.TWO;
	
	private int[] pits = new int[14];
	//public static KalahState mancalaGame;
	private KalahGame kg = new KalahGame();
	private SimpleBot randomBot = new SimpleBot();
	Random rand = new Random();
	Random randomN = new Random();
	
	// Pits and houses
	Rectangle2D house0 = new Rectangle2D.Double(50, 150, kalahSize, kalahSize*2+20);
	Ellipse2D pit13 = new Ellipse2D.Double(150, 150, kalahSize, kalahSize);
	Ellipse2D pit12 = new Ellipse2D.Double(250, 150, kalahSize, kalahSize);
	Ellipse2D pit11 = new Ellipse2D.Double(350, 150, kalahSize, kalahSize);
	Ellipse2D pit10 = new Ellipse2D.Double(450, 150, kalahSize, kalahSize);
	Ellipse2D pit9 = new Ellipse2D.Double(550, 150, kalahSize, kalahSize);
	Ellipse2D pit8 = new Ellipse2D.Double(650, 150, kalahSize, kalahSize);
	
	Rectangle2D house7 = new Rectangle2D.Double(750, 150, kalahSize, kalahSize*2+20);
	Ellipse2D pit1 = new Ellipse2D.Double(150, 250, kalahSize, kalahSize);
	Ellipse2D pit2 = new Ellipse2D.Double(250, 250, kalahSize, kalahSize);
	Ellipse2D pit3 = new Ellipse2D.Double(350, 250, kalahSize, kalahSize);
	Ellipse2D pit4 = new Ellipse2D.Double(450, 250, kalahSize, kalahSize);
	Ellipse2D pit5 = new Ellipse2D.Double(550, 250, kalahSize, kalahSize);
	Ellipse2D pit6 = new Ellipse2D.Double(650, 250, kalahSize, kalahSize);

	private Ellipse2D[] drawn = new Ellipse2D[14];
	
	
	public KalahGUI() {
		super("Kalah");
		setSize(900,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(this);
		//mancalaGame = new KalahState(pits, p1);
		// how do I initialize using Kalah state??
		Arrays.fill(pits, 1, 7, 4);
	    Arrays.fill(pits, 8, 14, 4);

	    // add drawn pits to array
	   drawn[1] = pit1;
	   drawn[2] = pit2;
	   drawn[3] = pit3;
	   drawn[4] = pit4;
	   drawn[5] = pit5;
	   drawn[6] = pit6;
	   
	   drawn[8] = pit8;
	   drawn[9] = pit9;
	   drawn[10] = pit10;
	   drawn[11] = pit11;
	   drawn[12] = pit12;
	   drawn[13] = pit13;

		
		System.out.println("pit1: " + pits[1]);
		// Choose 1ST Player
		JPanel p2 = new JPanel();
		JLabel txt1 = new JLabel("PLAYER 1");
		JRadioButton r1 = new JRadioButton("MiniMax");
		JRadioButton r2 = new JRadioButton("Intermediate");
		JRadioButton r3 = new JRadioButton("Random");
		JRadioButton r4 = new JRadioButton("Manual");
		ButtonGroup g = new ButtonGroup();
		
		r1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("minimax1");
				// chooses minimax bot as opponent
				
			}
		});
        r2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("intermediate1");
				// chooses intermediate bot as opponent
				
			}
		});
        r3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("random1");
				// chooses random bot as opponent
				
			}
		});
        r3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("manual1");
				// chooses random bot as opponent
				
			}
		});
        
        
		g.add(r1);
		g.add(r2);
		g.add(r3);
		g.add(r4);
		p2.add(txt1);
		p2.add(r1);
		p2.add(r2);
		p2.add(r3);
		p2.add(r4);
		
		
		add(p2, BorderLayout.LINE_START);
		
		// Choose 2ND Player
		JPanel p3 = new JPanel();
		JLabel txt2 = new JLabel("PLAYER 2");
		JRadioButton rr1 = new JRadioButton("MiniMax");
		JRadioButton rr2 = new JRadioButton("Intermediate");
		JRadioButton rr3 = new JRadioButton("Random");
		JRadioButton rr4 = new JRadioButton("Manual");
		ButtonGroup g2 = new ButtonGroup();
		rr1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("minimax2");
				// chooses minimax bot as opponent
				
			}
		});
        rr2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("intermediate2");
				// chooses intermediate bot as opponent
				
			}
		});
        rr3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("random2");
				// chooses random bot as opponent
				
			}
		});
        rr4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("manuel2");
				// chooses random bot as opponent
				
			}
		});
		g2.add(rr1);
		g2.add(rr2);
		g2.add(rr3);
		g2.add(rr4);
		p3.add(txt2);
		p3.add(rr1);
		p3.add(rr2);
		p3.add(rr3);
		p3.add(rr4);
		
		add(p3, BorderLayout.LINE_END);
		
		// Start End game
		JPanel p = new JPanel();
		JButton b1 = new JButton("Start Game");
		JButton b2 = new JButton("End Game");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
				if (r1.isSelected()&&rr1.isSelected()) {
					System.out.println("Minimax vs Minimax");
					start1 = true;
					// initialize game
				} else if (r1.isSelected()&&rr2.isSelected()) {
					System.out.println("Minimax vs Intermediate");
					start1 = true;
					// initialize game
				} else if (r1.isSelected()&&rr3.isSelected()) {
					System.out.println("Minimax vs Random");
					start1 = true;
					// initialize game
				} else if (r1.isSelected()&&rr4.isSelected()) {
					System.out.println("Minimax vs Manual");
					start1 = true;
					// initialize game
				} else if (r2.isSelected()&&rr2.isSelected()) {
					System.out.println("Intermediate vs Intermediate");
					start1 = true;
					// initialize game
				} else if (r3.isSelected()&&rr3.isSelected()) {
					System.out.println("Random vs Random");
					start1 = true;
					// initialize game
				} else if (r4.isSelected()&&rr4.isSelected()) {
					System.out.println("Manual vs Manual");
					start1 = true;
					// initialize game
				} else {
					JOptionPane.showMessageDialog(null, "Please pick your players");
				}
				
				
			}
		});
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("end game");	
				// end game
				JOptionPane.showMessageDialog(null, "You lost?");
			}
		});
		p.add(b1);
		p.add(b2);
		add(p, BorderLayout.SOUTH);

	}
	
	public void radioBtn() {
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	    int i = 0;
	    kg.applyMove(KalahMove.ofInt(1));
	    while (i<14) {
			if ((i!=0) && (i!=7)) {
		    	if ((e.getButton() == 1) && drawn[i].contains(e.getX(), e.getY()) ) {
			    	//start1 = false;
		    	  System.out.println("clicked pit " + i);
			    	
		    	  //kg.applyMove(KalahMove.ofInt(1));
			    	repaint();
			      //JOptionPane.showMessageDialog(null,e.getX()+ "\n" + e.getY());
			    }
			}
			i++;
	   }
	}

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.draw(pit1);
		g2d.draw(pit2);
		g2d.draw(pit3);
		g2d.draw(pit4);
		g2d.draw(pit5);
		g2d.draw(pit6);
		g2d.draw(house7);
		
		g2d.setColor(Color.BLUE);
		g2d.draw(pit8);
		g2d.draw(pit9);
		g2d.draw(pit10);
		g2d.draw(pit11);
		g2d.draw(pit12);
		g2d.draw(pit13);
		g2d.draw(house0);

		// int randomNum = rand.nextInt((max - min) + 1) + min; 56, 206
		
		if (start1) {
			int n = 0;
			int i = 0;
			int k0 = 0;
			int k7 = 0;
			while (n<14) {
				while (i<((KalahState) kg.currentState()).getHouseCount(p1,n)) {
					g2d.setColor(randomColor());
					if (n==0) {
						g2d.fillOval(60+randomN.nextInt(40), 170+randomN.nextInt(120), ballSize, ballSize);
					} else if (n==7) {
						g2d.fillOval(760+randomN.nextInt(40), 170+randomN.nextInt(120), ballSize, ballSize);
					} else if (n>7) {
						g2d.fillOval(160+randomN.nextInt(40)+100*(n-8), 160+randomN.nextInt(40)+100, ballSize, ballSize);
					} else {
						g2d.fillOval(160+randomN.nextInt(40)+100*(n-1), 160+randomN.nextInt(40), ballSize, ballSize);
					}
					i++;
				}
				i=0;
				n++;
			}
		}
	}
	
	public Color randomColor() {
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomC = new Color(r, g, b);
		return randomC;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}