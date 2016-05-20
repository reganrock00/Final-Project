import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FallCommands extends JComponent implements KeyListener, Runnable
{
	private FallDownEngine engine;
    public boolean leftPressed, rightPressed;
    static boolean spacePressed;

	public FallCommands()
	{
		super();    //calls constructor container
		engine = new FallDownEngine();
 		setPreferredSize(new Dimension(engine.WIDTH, engine.HEIGHT));
 		
 		addKeyListener(this);
 		Thread run = new Thread(this);    //allows multiple things to run
 		run.start();
	}

	public void run()     //runs movement
	{
		while(true)
		{
			try
			{
				Thread.sleep(20);   //temporarily ceases execution, also throws interrupted execution
			}
			catch(Exception ex)
			{
			}
			requestFocus(); //focuses on the input
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
		if(ke.getKeyCode() == KeyEvent.VK_SPACE)
			{
			spacePressed = true;
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
		if(ke.getKeyCode() == KeyEvent.VK_SPACE)
			{
			spacePressed = false;
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
