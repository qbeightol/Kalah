package kalah;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.JTextComponent;


public class KalahGUI extends JFrame {
	private int kalahSize = 80;

	private static final long serialVersionUID = 1L;
	
	public KalahGUI() {
		super("Kalah");
		setSize(900,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Start End game
		JPanel p = new JPanel();
		JButton b1 = new JButton("Start Game");
		JButton b2 = new JButton("End Game");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("start game");
				// initialize game
				
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
		
		// Choose 1ST Player
		JPanel p2 = new JPanel();
		JLabel txt1 = new JLabel("PLAYER 1");
		JRadioButton r1 = new JRadioButton("MiniMax Bot");
		JRadioButton r2 = new JRadioButton("Intermediate Bot");
		JRadioButton r3 = new JRadioButton("Random Bot");
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
		g.add(r1);
		g.add(r2);
		g.add(r3);
		p2.add(txt1);
		p2.add(r1);
		p2.add(r2);
		p2.add(r3);
		
		
		add(p2, BorderLayout.LINE_START);
		
		// Choose 2ND Player
				JPanel p3 = new JPanel();
				JLabel txt2 = new JLabel("PLAYER 2");
				JRadioButton rr1 = new JRadioButton("MiniMax Bot");
				JRadioButton rr2 = new JRadioButton("Intermediate Bot");
				JRadioButton rr3 = new JRadioButton("Random Bot");
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
				g2.add(rr1);
				g2.add(rr2);
				g2.add(rr3);
				p3.add(txt2);
				p3.add(rr1);
				p3.add(rr2);
				p3.add(rr3);
				
				add(p3, BorderLayout.LINE_END);

	}
	
	public void radioBtn() {
		
	}

	// this function works but makes the buttons appear super slowly...why?? is it my computer?
//	public void paint(Graphics g) {
//		Graphics2D g2d = (Graphics2D) g;
//		g2d.setColor(Color.RED);
//		g2d.drawOval(150, 150, kalahSize, kalahSize);
//		g2d.drawOval(250, 150, kalahSize, kalahSize);
//		g2d.drawOval(350, 150, kalahSize, kalahSize);
//		g2d.drawOval(450, 150, kalahSize, kalahSize);
//		g2d.drawOval(550, 150, kalahSize, kalahSize);
//		g2d.drawOval(650, 150, kalahSize, kalahSize);
//		g2d.drawRect(50, 150, kalahSize, kalahSize*2+20);
//		
//		g2d.setColor(Color.BLUE);
//		g2d.drawOval(150, 250, kalahSize, kalahSize);
//		g2d.drawOval(250, 250, kalahSize, kalahSize);
//		g2d.drawOval(350, 250, kalahSize, kalahSize);
//		g2d.drawOval(450, 250, kalahSize, kalahSize);
//		g2d.drawOval(550, 250, kalahSize, kalahSize);
//		g2d.drawOval(650, 250, kalahSize, kalahSize);
//		g2d.drawRect(750, 150, kalahSize, kalahSize*2+20);
//
//
//	}
	
}