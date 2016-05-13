import java.awt.*;

public class BallF
{
	public static final int RADIUS = 10;
	public static final int SPEED = 10;
	private int x, y;
	private double dx, dy;

	public BallF(int x, int y)
	{
		this(x,y,0,0);
	}

	public BallF(int x, int y, double dx, double dy)
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}

	public BallF moveLeft()
	{
		return new BallF(x-SPEED, y, dx, dy);
	}

	public BallF moveRight()
	{
		return new BallF(x+SPEED, y, dx, dy);
	}

	public BallF accelerate(double ax, double ay)
	{
		return new BallF(x, y, dx+ax, dy+ay);
	}

	public BallF setVelocity(double dx, double dy)
	{
		return new BallF(x, y, dx, dy);
	}

	public BallF setPosition(int x, int y)
	{
		return new BallF(x, y, 0, 0);
	}

	public BallF move(int dx, int dy)
	{
		return new BallF(x+dx, y+dy, 0, 0);
	}

	public BallF move()
	{
		return new BallF(x+(int)dx, y+(int)dy, dx, dy);
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}

	public Point getLocation()
	{
		return new Point(x,y);
	}

	public void draw(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillOval(x-RADIUS, y-RADIUS, RADIUS*2, RADIUS*2);
	}
}
