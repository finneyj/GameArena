/**
 * Models a simple piece of text. 
 * This class represents a Text object. When combined with the GameArena class,
 * instances of the Text class can be displayed on the screen to show display
 * an appropriate piece of text.
 */
public class Text
{
	// The following instance variables define the
	// information needed to represent a line.
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xPosition;			// The X coordinate of the start of this text 
	private double yPosition;			// The Y coordinate of the start of this text 
	private int size;					// The font size of this text 
	private int layer;					// The layer this text is drawn on
	private String text;				// The actual text to display
	private String colour;				// The colour of this text

										// Permissable colours are:
										// BLACK, BLUE, CYAN, DARKGREY, GREY,
										// GREEN, DARKGREEN, LIGHTGREY, MAGENTA, ORANGE,
										// PINK, RED, WHITE, YELLOW, BROWN 

	/**
	 * Obtains the position of this text on the X axis.
	 * @return the X coordinate of this text within the GameArena.
	 */
	public double getXPosition()
	{
		return xPosition;
	}

	/**
	 * Obtains the position of this text on the Y axis.
	 * @return the Y coordinate of this text within the GameArena.
	 */
	public double getYPosition()
	{
		return yPosition;
	}


	/**
	 * Obtains the width of this text.
	 * @return the width of this text, in points.
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * Change the width of this text to the given value.
	 * @param size The new size of this text, in points.
	 */
	public void setSize(int size)
	{
		this.size = size;
	}

	/**
	 * Obtains the colour of this Text.
	 * @return a textual description of the colour of this Text.
	 */
	public String getColour()
	{
		return colour;
	}

	/**
	 * Obtains the actual text contained in this object.
	 * @return a the text to be displayed.
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * Obtains the layer of this Text.
	 * @return the layer of this Text.
	 */
	public int getLayer()
	{
		return layer;
	}

	/**
	 * Constructor. Creates a new piece of text at the given coordinates.
	 *
	 * @param text The text to display 
	 * @param size The font size of of the text
	 * @param x The x co-ordinate of the text
	 * @param y The y co-ordinate of the text
	 * @param col The colour of the line (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 * @param layer The layer this line is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers. 
	 */
	public Text(String text, int size, double x, double y, String col, int layer)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = size;
		this.text = text;
		this.colour = col;
		this.layer = layer;
	}	

	/**
	 * Constructor. Creates a new piece of text at the given coordinates.
	 * 
	 * @param text The text to display 
	 * @param size The font size of of the text
	 * @param x The x co-ordinate of the text
	 * @param y The y co-ordinate of the text
	 * @param col The colour of the line (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 */
	public Text(String text, int size, double x, double y, String col)
	{
		this.xPosition = x;
		this.yPosition = y;
		this.size = size;
		this.text = text;
		this.colour = col;
		this.layer = 0;
	}	

	/**
	 * Changes the text displayed to that given value
	 * 
	 * @param text The text to display
	 */
	public void setText(String text)
	{
		this.text = text;
	}

	/**
	 * Changes the colour of this text to the given value
	 * 
	 * @param colour The new colour of this text. (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or #RRGGBB)
	 */
	public void setColour(String colour)
	{
		this.colour = colour;
	}

	/**
	 * Moves the current position of this Text to the given co-ordinates
	 * @param x the new x co-ordinate of this Text
	 */
	public void setXPosition(double x)
	{
		this.xPosition = x;
	}

	/**
	 * Moves the current position of this Text to the given co-ordinates
	 * @param y the new y co-ordinate of this Text
	 */
	public void setYPosition(double y)
	{
		this.yPosition = y;
	}

}
