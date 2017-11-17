package game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;



public class WeiQiArea extends JPanel{
//	private int size;
	private int lastx, lasty;
	private int [][]board;
	private int [][]board2;
	
	public WeiQiArea() {
		board = new int [660][660];
		board2 = new int [400][400];
		setBackground(Color.orange);
		setVisible(true);
		MyMouseListener ml = new MyMouseListener();
		addMouseListener(ml);
		addMouseMotionListener(ml);
	}
	
	public void paint(Graphics g) {
		for(int i = 30;i <= 570;i += 30)
			g.drawLine(30,i,570,i);
		for(int j = 30;j <= 570;j += 30)
			g.drawLine(j,30,j,570);
		//five points
		g.fillOval(117,117,6,6);
		g.fillOval(117,477,6,6);
		g.fillOval(477,117,6,6);
		g.fillOval(477,477,6,6);
		g.fillOval(297,297,6,6);
		g.setXORMode(getBackground());
		g.setColor(getForeground());;
		g.setColor(Color.orange);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {
		private int x, y;
		private int count = 1;
		@Override
		public void mouseDragged(MouseEvent e) {
//			Graphics g = getGraphics();
//			g.setXORMode(Color.WHITE);
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

		@Override
		public void mouseClicked(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			lastx = (x + 15)/30 * 30 - 10;
			lasty = (y + 15)/30 * 30 - 10;
			if(lastx >= 0 && lastx <= 570 && lasty >= 0 && lasty <= 570) {
				Graphics g = getGraphics();
				if(count%2 == 1) {
					if(board2[lastx/30][lasty/30] == 0) {
						g.setColor(Color.black);
						g.fillOval(lastx, lasty, 20, 20);
						board2[lastx/30][lasty/30] = 1;
						count++;
					}
				
				}
				if(count%2 == 0) {
					if(board2[lastx/30][lasty/30] == 0) {
						g.setColor(Color.white);
						g.fillOval(lastx, lasty, 20, 20);
						board2[lastx/30][lasty/30] = 1;
						count++;
					}
					
				}
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			
		}
		
	}

}
