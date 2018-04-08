package MyFiveChess;

import robot.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MyFiveChessFrame extends JFrame
{
   public MyFiveChessFrame(IRobot robot)
   {
      add(new ImageComponent(robot));
      pack();
   }
}

/**
 * A component that displays a tiled image
 */
class ImageComponent extends JComponent implements MouseListener
{
   private static final int DEFAULT_WIDTH = 500;
   private static final int DEFAULT_HEIGHT = 500;
   int x;
   int y;
   int allchess[][] = new int[16][16];   
   boolean isBlack = true;               
   boolean canPlay = true;
   private Image image;
   private IRobot iRobot;
   
   public ImageComponent(IRobot iRobot)
   {
	   this.iRobot = iRobot;
     
	   addMouseListener(this);
	   image = new ImageIcon("C:\\Users\\10703\\eclipse-workspace\\IAmWritingFiveChess\\background.jpg").getImage();
   }

   public void paint(Graphics g)
   {
      if (image == null) return;

      int imageWidth = image.getWidth(null);
      int imageHeight = image.getHeight(null);
      
      g.drawImage(image, 0, 0, null);
      
      g.setFont(new Font("宋体", 0, 16));
      g.drawString("Black time: Unlimited", 28, 444);
      g.drawString("White time: Unlimited", 250, 444);
      
      for (int i = 0; i < 16; i++) {
		g.drawLine(10, 50 + i*24, 369, 50 + i*24);
		g.drawLine(10 + i*24, 50, 10 + i*24, 410);
	}
      
      
      for (int i = 0; i < 16; i++) {
  		for(int j = 0; j < 16; j++)
  		{
  			if(allchess[i][j] == 1) {
  			int tempx = i * 24 + 10;
  			int tempy = j * 24 + 50;
  			g.fillOval(tempx-7, tempy-7, 14, 14);
  			}
  			if (allchess[i][j] == 2) {
  				int tempx = i * 24 + 10;
  	  			int tempy = j * 24 + 50;
  	  			g.setColor(Color.WHITE);
  	  			g.fillOval(tempx-7, tempy-7, 14, 14);
  	  			g.setColor(Color.BLACK);
  	  			g.drawOval(tempx-7, tempy-7, 14, 14);
			}
  		}
  		
  	}
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	//System.out.println("X" + e.getX());
	//System.out.println("Y" + e.getY());
	if (canPlay == true) { 
	 x = e.getX();
	 y = e.getY();
	if (x>10 && x<369 && y>49 && y<408) {
        float xxx = (float) 24.0;
		x = Math.round((x - 10)/xxx);
		y = Math.round((y - 49)/xxx);
		if(allchess[x][y] == 0)
		{
		if (isBlack == true) {
			allchess[x][y] = 1;
			iRobot.retrieveGameBoard(allchess);
			isBlack = false;				
			
		boolean winFlag = this.checkWin();
		if (winFlag == true) {
			JOptionPane.showMessageDialog(this, "Game over"+(allchess[x][y]==1 ? "Black" : "White") + "winned");
			canPlay = false;
	    	}
		this.repaint();
		}
		else {
			RobotAction();
		  }
		}
		else {
			JOptionPane.showMessageDialog(this, "Please play chess in the chessboard");
		}
		
	}
		
	}
}

void RobotAction(){
	
	Pair pair = iRobot.getDeterminedPos();
	x = pair.x;
	y= pair.y;
	allchess[x][y] = 2;
	isBlack = true;
	
	boolean winFlag = this.checkWin();
	if (winFlag == true) {
		JOptionPane.showMessageDialog(this, "Game over"+(allchess[x][y]==1 ? "Black" : "White") + " winned");
		canPlay = false;
	}
	
	this.repaint();
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

private boolean checkWin() {
		
	boolean flag = false;
	int count = 1;
	int color = allchess[x][y];
	int i = 1;
	
	while(((x+i)<16)&&color == allchess[x+i][y]) {
		count++;
	    i++;
		}
	i = 1;
	while(((x-i)>=1)&&color == allchess[x-i][y]) {
		count++;
	    i++;
		}
	if(count>=5)
		{flag = true;}
	//�����ж�
	int count2 = 1;
	int i2 = 1;
	while(((y+i2)<16)&&color == allchess[x][y+i2]) {
		count2++;
	    i2++;
		}
	i = 1;
	while(((y-i2)>=1)&&color == allchess[x][y-i2]) {
		count2++;
	    i2++;
		}
	if(count2>=5)
		{flag = true;}
	
	int count3 = 1;
	int i3 = 1;
	while(((y-i3)>=1)&&((x+i3)<16)&&color == allchess[x+i3][y-i3]) {
		count3++;
	    i3++;
		}
	i = 1;
	while(((x-i3)>=1)&&((y+i3)<16)&&color == allchess[x-i3][y+i3]) {
		count3++;
	    i3++;
		}
	if(count3>=5)
		{flag = true;}

	int count4 = 1;
	int i4 = 1;
	while(((y-i4)>=1)&&((x-i4)>=1)&&color == allchess[x-i4][y-i4]) {
		count4++;
	    i4++;
		}
	i = 1;
	while(((x+i4)<16)&&((y+i4)<16)&&color == allchess[x+i4][y+i4]) {
		count4++;
	    i4++;
		}
	if(count4>=5)
		{flag = true;}
	
	return flag;
	
   }

}