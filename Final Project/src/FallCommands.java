import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FallCommands extends JComponent implements KeyListener, Runnable
{
	private FallDownEngine engine;
	private boolean leftPressed, rightPressed;

	public FallCommands()
	{
		super();    //calls constructor container
		engine = new FallDownEngine();
 		setPreferredSize(new Dimension(engine.WIDTH, engine.HEIGHT));
 		
 		addKeyListener(this);
 		Thread run = new Thread(this);    //allows multiple things top run
 		run.start();
	}

	public void run()     //runs movement
	{
		while(true)
		{
			try
			{
				Thread.sleep(20);
			}
			catch(Exception ex)
			{
			}
			requestFocus();
			update();
			repaint();
		}
	}

	public void paint(Graphics g)
	{
		synchronized(g)
		{
			engine.draw(g);
		}
	}

	public void update()
	{
		if(leftPressed)
			{
			engine.moveLeft();
			}
		if(rightPressed)
			{
			engine.moveRight();
			}
		engine.update();
	}

	public void keyPressed(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			{
			leftPressed = true;
			}
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			{
			rightPressed = true;
			}
	}

	public void keyReleased(KeyEvent ke)
	{
		if(ke.getKeyCode() == KeyEvent.VK_LEFT)
			{
			leftPressed = false;
			}
		else if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
			{
			rightPressed = false;
			}
	}

	public void keyTyped(KeyEvent ke)
	{
	}
}
