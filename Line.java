/**
 * Models a simple line. 
 * This class represents a Line object. When combined with the GameArena class,
 * instances of the Line class can be displayed on the screen.
 */
public class Line 
{
	// The following instance variables define the
	// information needed to represent a line.
	// Feel free to more instance variables if you think it will 
	// support your work... 
	
	private double xStart;			// The X coordinate of the start of this line 
	private double yStart;			// The Y coordinate of the start of this line 
	private double xEnd;			// The X coordinate of the end of this line 
	private double yEnd;			// The Y coordinate of the end of this line
	private double width;			// The thickness of the line
	private int layer;				// The layer this line is drawn on
	private String colour = "WHITE";	// The colour of this line

										// Permissable colours are:
										// BLACK, BLUE, CYAN, DARKGREY, GREY,
										// GREEN, DARKGREEN, LIGHTGREY, MAGENTA, ORANGE,
										// PINK, RED, WHITE, YELLOW, BROWN 

	/**
	 * Obtains the start position of this line on the X axis.
	 * @return the X coordinate of the start of this line within the GameArena.
	 */
	public double getXStart()
	{
		return xStart;
	}

	/**
	 * Obtains the end position of this line on the X axis.
	 * @return the X coordinate of the end of this line within the GameArena.
	 */
	public double getXEnd()
	{
		return xEnd;
	}


	/**
	 * Obtains the start position of this line on the Y axis.
	 * @return the Y coordinate of the start of this line within the GameArena.
	 */
	public double getYStart()
	{
		return yStart;
	}

	/**
	 * Obtains the end position of this line on the Y axis.
	 * @return the Y coordinate of the end of this line within the GameArena.
	 */
	public double getYEnd()
	{
		return yEnd;
	}

	/**
	 * Moves the current position of this line to the given X and Y co-ordinates
	 * @param x1 the new x co-ordinate of the start of this line
	 * @param y1 the new y co-ordinate of the start of this line
	 * @param x2 the new x co-ordinate of the end of this line 
	 * @param y2 the new y co-ordinate of the end of this line 
	 */
	public void setLinePosition(double x1, double y1, double x2, double y2)
	{
		this.xStart = x1;
		this.xEnd = x2;
		this.yStart = y1;
		this.yEnd = y2;
	}


	/**
	 * Obtains the width of this line.
	 * @return the width of this line, in pixels.
	 */
	public double getWidth()
	{
		return width;
	}

	/**
	 * Obtains the colour of this Line.
	 * @return a textual description of the colour of this Line.
	 */
	public String getColour()
	{
		return colour;
	}

	/**
	 * Obtains the layer of this Line.
	 * @return the layer of this Line.
	 */
	public int getLayer()
	{
		return layer;
	}


	public Line(double x1, double y1, double x2, double y2, double thickness, String col, int lay)
	{
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;

		width = thickness;
		colour = col;
		layer = lay;
	}	

	public Line(double x1, double y1, double x2, double y2, double thickness, String col)
	{
		xStart = x1;
		yStart = y1;
		xEnd = x2;
		yEnd = y2;

		width = thickness;
		colour = col;
		layer = 0;
	}	
}
