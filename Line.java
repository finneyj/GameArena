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
	
	private double xStart;						// The X coordinate of the start of this line 
	private double yStart;						// The Y coordinate of the start of this line 
	private double xEnd;						// The X coordinate of the end of this line 
	private double yEnd;						// The Y coordinate of the end of this line
	private double width;						// The thickness of the line
	private double arrowSize;					// Size of the arrowhead on this line
	private int[] arrowX = new int[3];			// Optinal coordinates of an arrowhead on this line (x)
	private int[] arrowY = new int[3];			// Optinal coordinates of an arrowhead on this line (y)

	private int layer;							// The layer this line is drawn on
	private String colour = "WHITE";			// The colour of this line
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
	 * Determines the size of the arrowhead on this line
	 * @return the size of the arrowhead on this line
	 */
	public double getArrowSize()
	{
		return arrowSize;
	}

	/**
	 * Defined the size of the arrowhead on this line, as a proportion to the line's width.
	 * @param size The new size for the arrowhead on this line.
	 */

	public void setArrowSize(double size)
	{
		arrowSize = size;
		this.recalculateArrowhead();
	}

	/**
	 * Determines the length of this line.
	 * @return the lenght of this line.
	 */
	public double getLength()
	{
		double lx = xEnd - xStart;
		double ly = yEnd - yStart;
		
		return Math.sqrt(lx*lx + ly*ly);
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

		this.recalculateArrowhead();
	}

	/**
	 * Defines the width of this line.
	 * @param width The new width of this line, in pixels.
	 */
	public void setWidth(double width)
	{
		this.width = width;
		this.recalculateArrowhead();
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

	/**
	 * Determines the x-coordinates of the points that form this lines arrowhead.
	 * @return An array of three x coorindates.
	 */
	public int[] getArrowX()
	{
		return arrowX;
	}

	/**
	 * Determines the y-coordinates of the points that form this lines arrowhead.
	 * @return An array of three y coorindates.
	 */
	public int[] getArrowY()
	{
		return arrowY;
	}

	/**
	 * Constructor. Creates a Line with the given parameters.
	 * @param x1 The x co-ordinate of the start of the Line (in pixels)
	 * @param y1 The y co-ordinate of the start of the Line (in pixels)
	 * @param x2 The x co-ordinate of the end of the Line (in pixels)
	 * @param y2 The y co-ordinate of the end of the Line (in pixels)
	 * @param thickness The width of the Line (in pixels)
	 * @param col The colour of the Line (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 * @param lay The layer the Line is to be drawn on. Objects with a higher layer number are always drawn on top of those with lower layer numbers.
	 */
	public Line(double x1, double y1, double x2, double y2, double thickness, String col, int lay)
	{
		width = thickness;
		colour = col;
		layer = lay;
		arrowSize = 0;
		this.setLinePosition(x1, y1, x2, y2);
	}	

	/**
	 * Constructor. Creates a Line with the given parameters.
	 * @param x1 The x co-ordinate of the start of the Line (in pixels)
	 * @param y1 The y co-ordinate of the start of the Line (in pixels)
	 * @param x2 The x co-ordinate of the end of the Line (in pixels)
	 * @param y2 The y co-ordinate of the end of the Line (in pixels)
	 * @param thickness The width of the Line (in pixels)
	 * @param col The colour of the Line (Permissable colours are: BLACK, BLUE, CYAN, DARKGREY, GREY, GREEN, LIGHTGREY, MAGENTA, ORANGE, PINK, RED, WHITE, YELLOW or ##RRGGBB)
	 */
	public Line(double x1, double y1, double x2, double y2, double thickness, String col)
	{
		width = thickness;
		colour = col;
		layer = 0;
		arrowSize = 0;
		this.setLinePosition(x1, y1, x2, y2);
	}
	
	private void recalculateArrowhead()
	{
		// Calculate component distances and length
		double lx = xEnd - xStart;
		double ly = yEnd - yStart;
		double length = this.getLength();

		// Calculate normalized vector of this line.
		double dx = lx / length;
		double dy = ly / length;

		// Calculate the line thickness as a proportion of the length
		double arrowSize = width * this.getArrowSize();
		double arrowRatio = 1.0 - (arrowSize / length);

		// Update arrowHead cooridnates
		arrowX[0] = (int) xEnd;
		arrowX[1] = (int) ((xStart + lx * arrowRatio) - dy * arrowSize);
		arrowX[2] = (int) ((xStart + lx * arrowRatio) + dy * arrowSize);

		arrowY[0] = (int) yEnd;
		arrowY[1] = (int) ((yStart + ly * arrowRatio) + dx * arrowSize);
		arrowY[2] = (int) ((yStart + ly * arrowRatio) - dx * arrowSize);
	}
}
