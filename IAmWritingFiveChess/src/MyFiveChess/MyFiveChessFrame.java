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
class ImageComponent extends JComponent implements MouseListener, Runnable
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
   private String string = "It's Black";
   //保存游戏最多运行时间
   int maxTime = 0;
   //倒计时线程
  // Thread t = new Thread(this);
   
   //保存黑方与白方剩余时间
   int whiteTime = 0;
   int blackTime = 0;
   
   public ImageComponent(IRobot iRobot)
   {
	   this.iRobot = iRobot;    
	   addMouseListener(this);
	   image = new ImageIcon("background.jpg").getImage();
	   System.out.println(image.getAccelerationPriority());
   }

   public void paint(Graphics g)
   {
      if (image == null) return;
     
      g.drawImage(image, 0, 0, null);
      
      g.setFont(new Font("宋体", 0, 16));
      g.drawString("Black time: （秒） " + blackTime*60, 28, 444);
      g.drawString("White time: （秒） " + whiteTime*60, 250, 444);
      g.setFont(new Font("Times New Roman", 0, 27));
      g.drawString(string, 135, 34);
      
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

@SuppressWarnings("deprecation")
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	if (x>400 && x<470 && y>50 && y<80) {
		int restart = JOptionPane.showConfirmDialog(this, "是否确认重新开始游戏");
		if (restart == 0) {
			allchess = new int[16][16];
			string = "It's Black";
			isBlack = true;
			blackTime = maxTime;
			whiteTime = maxTime;
		
			this.repaint();
		}
	}
	if (x>400 && x<470 && y>100 && y<130) {
		String input = JOptionPane.showInputDialog("请输入最大下棋时间（单位分），0代表无限制：");
		try {
			maxTime = Integer.parseInt(input) * 60;
			if (maxTime < 0) {
				JOptionPane.showMessageDialog(this, "请输入正确信息！");
			}

				if (maxTime == 0) {				
         			int haha = JOptionPane.showConfirmDialog(this, "设置完成是否重新开始游戏");
			        if (haha == 0) {
			        	allchess = new int[16][16];
						string = "It's Black";
						isBlack = true;
						blackTime = 11111;
						whiteTime = 11111;
						this.repaint();
					}
				    if(haha == 1 ){
				    	blackTime = 11111;
						whiteTime = 11111;
						this.repaint();
					}
				}
				
				if (maxTime > 0) {
					int haha = JOptionPane.showConfirmDialog(this, "设置完成是否重新开始游戏");
			        if (haha == 0) {
			        	allchess = new int[16][16];
						string = "It's Black";
						isBlack = true;
						blackTime = maxTime;
						whiteTime = maxTime;
						//t.resume();
						this.repaint();
				}
			        else {
			        	blackTime = maxTime;
						whiteTime = maxTime;
						this.repaint();
					}
				
				}
		} catch (NumberFormatException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "请输入正确信息！");
		}
	}
	if (x>400 && x<470 && y>150 && y<180) {
		JOptionPane.showMessageDialog(this, "五子棋你都不会下么，如果不会，请参见百度，谢谢!");
	}
	if (x>400 && x<470 && y>250 && y<280) {
		int abandoning = JOptionPane.showConfirmDialog(this, "已经决定了么");
		if (abandoning == 0) {
			if(isBlack) JOptionPane.showMessageDialog(this, "黑方认输");
			canPlay = false;
			System.exit(0);
		}
	
	}
	if (x>400 && x<470 && y>300 && y<330) {
		JOptionPane.showMessageDialog(this, "本软件由杨易大佬与曾鑫开发，若有问题，请自行解决.");
	}
	if (x>400 && x<470 && y>350 && y<380) {
		int Continue = JOptionPane.showConfirmDialog(this, "不再玩一会么");
		if(Continue == 0) {
			JOptionPane.showMessageDialog(this, "大爷再见，欢迎下次再来。");
		    System.exit(0);
		}
	}
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
			string = "It's White";
			
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
	string = "It's Black";
	
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
	//?????ж?
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

@Override
public void run() {
	// TODO Auto-generated method stub
	if (maxTime > 0) {
		while(true)
			if (isBlack) {
				blackTime--;
			}else {
				whiteTime--;
			}
		
	}
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(whiteTime +"and"+blackTime);
}

}