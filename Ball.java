/**
 * Models a simple solid sphere. 
 * This class represents a Ball object. When combined with the GameArena class,
 * instances of the Ball class can be displayed on the screen.
 */
public class Ball 
{
	// The following instance variables define the
	// information needed to represent a Ball
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of this Ball
	private double yPosition;			// The Y coordinate of this Ball
	private double size;				// The diameter of this Ball
	private int layer;					// The layer of this ball is on.
	private String colour;				// The colour of this Ball

										// Permissable colours are:
										// BLACK, BLUE, CYAN, DARKGREY, GREY,
										// GREEN, LIGHTGREY, MAGENTA, ORANGE,
										// PINK, RED, WHITE, YELLOW or #RRGGBB 

	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 */
	public Ball(double x, double y, double diameter, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = 0;
	}	

	/**
	 * Constructor. Creates a Ball with the given parameters.
	 * @param x The x co-ordinate of centre of the Ball (in pixels)
	 * @param y The y co-ordinate of centre of the Ball (in pixels)
	 * @param diameter The diameter of the Ball (in pixels)
	 * @param col The colour of the Ball (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 * @param layer The layer this ball is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers.
	 */
	public Ball(double x, double y, double diameter, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = diameter;
		this.colour = col;
		this.layer = layer;
	}	

	/**
	 * Obtains the current position of this Ball.
	 * @return the X coordinate of this Ball within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtains the current position of this Ball.
	 * @return the Y coordinate of this Ball within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}

	/**
	 * Moves the current position of this Ball to the given co-ordinates
	 * @param x the new x co-ordinate of this Ball
	 */
	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	/**
	 * Moves the current position of this Ball to the given co-ordinates
	 * @param y the new y co-ordinate of this Ball
	 */
	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	/**
	 * Obtains the size of this Ball.
	 * @return the diameter of this Ball,in pixels.
	 */
	public double getSize()
	{
		return size;
	}
	
	/**
	 * Sets the diameter of this Ball to the given size.
	 * @param s the new diameter of this Ball, in pixels.
	 */
	public void setSize(double s)
	{
		size = s;
	}

	/**
	 * Obtains the layer of this Ball.
	 * @return the layer of this Ball.
	 */
	public int getLayer()
	{
		return layer;
	}

	/**
	 * Sets the layer of this Ball.
	 * @param l the new layer of this Ball. Higher layer numbers are drawn on top of low layer numbers.
	 */
	public void setLayer(int l)
	{
		layer = l;
	}

	/**
	 * Obtains the colour of this Ball.
	 * @return a textual description of the colour of this Ball.
	 */
	public String getColour()
	{
		return colour;
	}

	/**
	 * Sets the colour of this Ball.
	 * @param c the new colour of this Ball, as a String value. Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or #RRGGBB.
	 */
	public void setColour(String c)
	{
		colour = c;
	}

	/**
	 * Moves this Ball by the given amount.
	 * 
	 * @param dx the distance to move on the x axis (in pixels)
	 * @param dy the distance to move on the y axis (in pixels)
	 */
	public void move(double dx, double dy)
	{
		xPosition += dx;
		yPosition += dy;
	}

	/**
	 * Determines if this Ball is overlapping the given ball.
	 * 
	 * @param b the ball to test for collision
	 * @return true of this ball is overlapping the ball b, false otherwise.
	 */
	public boolean collides(Ball b)
	{
		double dx = b.xPosition - xPosition;
		double dy = b.yPosition - yPosition;
		double distance = Math.sqrt(dx*dx+dy*dy);

		return distance < size/2 + b.size/2;
	}
}
