package fiveChess;
import javax.swing.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FiveChessFrame extends JFrame implements MouseListener {

	int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	int height = Toolkit.getDefaultToolkit().getScreenSize().height;	
	Image bgimage = null;
	
	public FiveChessFrame() {
		// TODO Auto-generated constructor stub
		this.setTitle("Îå×ÓÆå");
		this.setSize(500, 500);
		this.setLocation((width - 500)/2 , (height - 500)/2);		
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
			bgimage = getToolkit().getImage("C://Users//10703//eclipse-workspace"
					+ "//IAmWritingFiveChess//background.jpg");
			
		
	}

	     
	
	     public void paint(Graphics g) {
		g.drawImage(bgimage, 1, 20, this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
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

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
