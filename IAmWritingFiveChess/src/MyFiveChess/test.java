package MyFiveChess;
import java.awt.*;
import javax.swing.*;
public class test {
	
	   public static void main(String[] args)
	   {
	      EventQueue.invokeLater(() ->
	         {
	            JFrame frame = new MyFiveChessFrame();
	            frame.setTitle("五子棋");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.setVisible(true);
	         });
	   }
}


