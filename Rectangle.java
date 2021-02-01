/**
 * Models a simple, solid rectangle. 
 * This class represents a Rectabgle object. When combined with the GameArena class,
 * instances of the Rectangle class can be displayed on the screen.
 */
public class Rectangle 
{
	// The following instance variables define the
	// information needed to represent a Rectangle
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of this Rectangle
	private double yPosition;			// The Y coordinate of this Rectangle
	private double width;				// The width of this Rectangle
	private double height;				// The height of this Rectangle
	private int layer;				// The layer this Rectangle is on.
	private String colour;				// The colour of this Rectangle

										// Permissable colours are:
										// BLACK, BLUE, CYAN, DARKGREY, GREY,
										// GREEN, LIGHTGREY, MAGENTA, ORANGE,
										// PINK, RED, WHITE, YELLOW 


	/**
	 * Constructor. Creates a Rectangle with the given parameters.
	 * @param x The x co-ordinate position of top left corner of the Rectangle (in pixels)
	 * @param y The y co-ordinate position of top left corner of the Rectangle (in pixels)
	 * @param w The width of the Rectangle (in pixels)
	 * @param h The height of the Rectangle (in pixels)
	 * @param col The colour of the Rectangle (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or #RRGGBB)
	 */
	public Rectangle(double x, double y, double w, double h, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.width = w;
		this.height = h;
		this.colour = col;
		this.layer = 0;
	}	
									
	/**
	 * Constructor. Creates a Rectangle with the given parameters.
	 * @param x The x co-ordinate position of top left corner of the Rectangle (in pixels)
	 * @param y The y co-ordinate position of top left corner of the Rectangle (in pixels)
	 * @param w The width of the Rectangle (in pixels)
	 * @param h The height of the Rectangle (in pixels)
	 * @param col The colour of the Rectangle (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or #RRGGBB)
	 * @param layer The layer this Rectangle is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers.
	 */
	public Rectangle(double x, double y, double w, double h, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.width = w;
		this.height = h;
		this.colour = col;
		this.layer = layer;
	}	
			
	/**
	 * Obtains the current position of this Rectangle.
	 * @return the X coordinate of this Rectangle within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtains the current position of this Rectangle.
	 * @return the Y coordinate of this Rectangle within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}

	/**
	 * Moves the current position of this Rectangle to the given X co-ordinate
	 * @param x the new x co-ordinate of this Rectangle
	 */
	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	/**
	 * Moves the current position of this Rectangle to the given Y co-ordinate
	 * @param y the new y co-ordinate of this Rectangle
	 */
	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

	/**
	 * Obtains the width of this Rectangle.
	 * @return the width of this Rectangle,in pixels.
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * Sets the width of this Rectangle to the given value
	 * @param w the new width of this Rectangle, in pixels.
	 */
	public void setWidth(double w)
	{
		width = w;
	}

	/**
	 * Obtains the height of this Rectangle.
	 * @return the height of this Rectangle,in pixels.
	 */
	public double getHeight()
	{
		return height;
	}

	/**
	 * Sets the height of this Rectangle to the given value
	 * @param h the new height of this Rectangle, in pixels.
	 */
	public void setHeight(double h)
	{
		height = h;
	}

	/**
	 * Obtains the layer of this Rectangle.
	 * @return the layer of this Rectangle.
	 */
	public int getLayer()
	{
		return layer;
	}

	/**
	 * Obtains the colour of this Rectangle.
	 * @return a textual description of the colour of this Rectangle.
	 */
	public String getColour()
	{
		return colour;
	}

	/**
	 * Sets the colour of this Rectangle.
	 * @param c the new colour of this Rectangle, as a String value. Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW.
	 */
	public void setColour(String c)
	{
		colour = c;
	}

	/**
	 * Moves this Rectangle by the given amount.
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
	 * Determines if this Rectangle is overlapping the given rectangle.
	 * 
	 * @param r the rectangle to test for collision
	 * @return true of this rectangle is overlapping the rectangle r, false otherwise.
	 */
	public boolean collides(Rectangle r)
	{
		return (xPosition + width > r.xPosition && xPosition < r.xPosition + r.width) && (yPosition + height > r.yPosition && yPosition < r.yPosition + r.height);
	}
}
