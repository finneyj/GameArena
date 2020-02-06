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
	 * @param col The colour of the Rectangle (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW)
	 */
	public Rectangle(double xPosition, double yPosition, double width, double height, String colour)
	{
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
		this.colour = colour;
	}	
									

	/**
	 * Obtains the current position of this Rectangle.
	 * @return the X coordinate of this Rectangle within the GameArena.
	 */
	public double getXPosition()
	{
		return this.xPosition;
	}

	/**
	 * Obtains the current position of this Rectangle.
	 * @return the Y coordinate of this Rectangle within the GameArena.
	 */
	public double getYPosition()
	{
		return this.yPosition;
	}

	/**
	 * Moves the current position of this Rectangle to the given X co-ordinate
	 * @param x the new x co-ordinate of this Rectangle
	 */
	public void setXPosition(double xPosition)
	{
		this.xPosition = xPosition;
	}

	/**
	 * Moves the current position of this Rectangle to the given Y co-ordinate
	 * @param y the new y co-ordinate of this Rectangle
	 */
	public void setYPosition(double yPosition)
	{
		this.yPosition = yPosition;
	}

	/**
	 * Obtains the width of this Rectangle.
	 * @return the width of this Rectangle,in pixels.
	 */
	public double getWidth()
	{
		return this.width;
	}

	/**
	 * Sets the width of this Rectangle to the given value
	 * @param w the new width of this Rectangle, in pixels.
	 */
	public void setWidth(double width)
	{
		this.width = width;
	}

	/**
	 * Obtains the height of this Rectangle.
	 * @return the height of this Rectangle,in pixels.
	 */
	public double getHeight()
	{
		return this.height;
	}

	/**
	 * Sets the height of this Rectangle to the given value
	 * @param h the new height of this Rectangle, in pixels.
	 */
	public void setHeight(double height)
	{
		this.height = height;
	}

	/**
	 * Obtains the colour of this Rectangle.
	 * @return a textual description of the colour of this Rectangle.
	 */
	public String getColour()
	{
		return this.colour;
	}

	/**
	 * Sets the colour of this Rectangle.
	 * @param c the new colour of this Rectangle, as a String value. Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW.
	 */
	public void setColour(String colour)
	{
		this.colour = colour;
	}
}
