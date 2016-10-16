import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Canvas 
{
	private JPanel canvasPanel;
	private JLabel statusBar;
	
	public Canvas()
	{
		canvasPanel = new JPanel();
		canvasPanel.setBackground(Color.WHITE);
		statusBar = new JLabel();
		canvasPanel.add(statusBar);
		canvasPanel.addMouseListener(new MouseHandler());
		canvasPanel.addMouseMotionListener(new MouseHandler());
	}
	
	public JPanel getCanvasPanel()
	{
		return canvasPanel;
	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener 
	{
		@Override
		public void mouseMoved(MouseEvent event) 
		{
			Painter.getStatusLabel().setText(String.format("Moved at [%d, %d]", event.getX(), event.getY()));
		}
		
		public void mouseDragged(MouseEvent arg0) {}
		public void mouseEntered(MouseEvent e) 	  {}
		public void mouseExited(MouseEvent e)     {}
		public void mousePressed(MouseEvent e)    {}
		public void mouseReleased(MouseEvent e)   {}
		public void mouseClicked(MouseEvent e)    {}
	}
	
}
