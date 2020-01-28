import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;

/**
 * This class provides a simple window in which grahical objects can be drawn. 
 * @author Joe Finney
 */
public class GameArena extends JFrame implements Runnable, KeyListener
{
	// Size of playarea
	private int arenaWidth;
	private int arenaHeight;

	private boolean exiting = false; 

	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	private boolean space = false;

	private boolean rendered = false;

	/**
	 * Create a view of a GameArena.
	 * 
	 * @param width The width of the playing area, in pixels.
	 * @param height The height of the playing area, in pixels.
	 */
	public GameArena(int width, int height)
	{
		this.setTitle("Let's Play!");
		this.setSize(width, height);
		this.setResizable(false);
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);		
	
		Thread t = new Thread(this);
		t.start();

		this.addKeyListener(this);
	}

	public void run() {
		try {
			while (true) {
				this.repaint();
				Thread.sleep(10);
			}
		} catch (InterruptedException iex) {}
	}

	/**
	 * Update the size of the GameArena.
	 *
	 * @param width the new width of the window in pixels.
	 * @param height the new height of the window in pixels.
	 */
	public void setSize(int width, int height)
	{
		this.arenaWidth = width;
		this.arenaHeight = height;

		super.setSize(arenaWidth + this.getInsets().left + this.getInsets().right, arenaHeight + this.getInsets().top + this.getInsets().bottom);
	}	

	/**
	 * Close this GameArena window.
	 * 
	 */
	public void exit()
	{
		this.exiting = true;
	}

	/**
	 * A method called by the operating system to draw onto the screen - <p><B>YOU DO NOT (AND SHOULD NOT) NEED TO CALL THIS METHOD.</b></p>
	 */
	public void paint (Graphics gr)
	{
		if (!rendered)
		{
			this.setSize(arenaWidth, arenaHeight);
			rendered = true;
		}

		Graphics2D window = (Graphics2D) gr;
		BufferedImage i = new BufferedImage(arenaWidth, arenaHeight, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = i.createGraphics();
		
		window.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		window.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		synchronized (this)
		{
			if (!this.exiting)
			{
				g.clearRect(0,0, arenaWidth, arenaHeight);
				for(Ball b : balls)
				{
					g.setColor(this.getColourFromString(b.getColour()));
					g.fillOval((int)(b.getXPosition() - b.getSize()/2), (int)(b.getYPosition() - b.getSize()/2), (int)b.getSize(), (int)b.getSize());
				}

				for(Rectangle b : rectangles)
				{
					g.setColor(this.getColourFromString(b.getColour()));
					g.fillRect((int)b.getXPosition(), (int)b.getYPosition(), (int)b.getWidth(), (int)b.getHeight());
				}
			}
					
			window.drawImage(i, this.getInsets().left, this.getInsets().top, this);
		}
	}

	//
	// Shouldn't really handle colour this way, but the student's haven't been introduced
	// to constants properly yet, hmmm....
	// 
	private Color getColourFromString(String col)
	{
		Color colour = Color.WHITE;
		col = col.toUpperCase();

		if (col.equals("BLACK"))
			colour = Color.BLACK;	

		if (col.equals("BLUE"))
			colour = Color.BLUE;	

		if (col.equals("CYAN"))
			colour = Color.CYAN;	

		if (col.equals("DARKGREY"))
			colour = Color.DARK_GRAY;	

		if (col.equals("GREY"))
			colour = Color.GRAY;	

		if (col.equals("GREEN"))
			colour = Color.GREEN;	

		if (col.equals("LIGHTGREY"))
			colour = Color.LIGHT_GRAY;	
				
		if (col.equals("MAGENTA"))
			colour = Color.MAGENTA;	

		if (col.equals("ORANGE"))
			colour = Color.ORANGE;	

		if (col.equals("PINK"))
			colour = Color.PINK;	

		if (col.equals("RED"))
			colour = Color.RED;	
		
		if (col.equals("WHITE"))
			colour = Color.WHITE;	

		if (col.equals("YELLOW"))
			colour = Color.YELLOW;	

		return colour;
	}
	
	/**
	 * Adds a given Ball to the GameArena. 
	 * Once a Ball is added, it will automatically appear on the window. 
	 *
	 * @param b the ball to add to the GameArena.
	 */
	public void addBall(Ball b)
	{

		synchronized (this)
		{
			if (balls.size() > 100000)
			{
				System.out.println("\n\n");
				System.out.println(" ********************************************************* ");
				System.out.println(" ***** Only 100000 Objects Supported per Game Arena! ***** ");
				System.out.println(" ********************************************************* ");
				System.out.println("\n");
				System.out.println("-- Joe\n\n");

				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
			else
			{
				balls.add(b);
			}
		}
	}

	/**
	 * Adds a given Rectangle to the GameArena. 
	 * Once a Ball rectangle is added, it will automatically appear on the window. 
	 *
	 * @param r the rectangle to add to the GameArena.
	 */
	public void addRectangle(Rectangle r)
	{

		synchronized (this)
		{
			if (rectangles.size() > 100000)
			{
				System.out.println("\n\n");
				System.out.println(" ********************************************************* ");
				System.out.println(" ***** Only 100000 Objects Supported per Game Arena! ***** ");
				System.out.println(" ********************************************************* ");
				System.out.println("\n");
				System.out.println("-- Joe\n\n");

				this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
			}
			else
			{
				rectangles.add(r);
			}
		}
	}

	/**
	 * Remove a Rectangle from the GameArena. 
	 * Once a Rectangle is removed, it will no longer appear on the window. 
	 *
	 * @param r the rectangle to remove from the GameArena.
	 */
	public void removeRectangle(Rectangle r)
	{
		synchronized (this)
		{
			rectangles.remove(r);
		}
	}

	/**
	 * Remove a Ball from the GameArena. 
	 * Once a Ball is removed, it will no longer appear on the window. 
	 *
	 * @param b the ball to remove from the GameArena.
	 */
	public void removeBall(Ball b)
	{
		synchronized (this)
		{
			balls.remove(b);
		}
	}

	/**
	 * Pause for a 1/50 of a second. 
	 * This method causes your program to delay for 1/50th of a second. You'll find this useful if you're trying to animate your application.
	 *
	 */
	public void pause()
	{
		try { Thread.sleep(20); }
		catch (Exception e) {};
	}

 	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP)
			up = true;		
		if (code == KeyEvent.VK_DOWN)
			down = true;		
		if (code == KeyEvent.VK_LEFT)
			left = true;		
		if (code == KeyEvent.VK_RIGHT)
			right = true;	
		if (code == KeyEvent.VK_SPACE)
			space = true;		
	}
 	
	public void keyReleased(KeyEvent e) 
	{
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_UP)
			up = false;		
		if (code == KeyEvent.VK_DOWN)
			down = false;		
		if (code == KeyEvent.VK_LEFT)
			left = false;		
		if (code == KeyEvent.VK_RIGHT)
			right = false;		
		if (code == KeyEvent.VK_SPACE)
			space = false;		
	}

 	public void keyTyped(KeyEvent e) 
	{
	}

	/** 
	 * Gets the width of the GameArena window, in pixels.
	 * @return the width in pixels
	 */
	public int getArenaWidth()
	{
		return arenaWidth;
	}

	/** 
	 * Gets the height of the GameArena window, in pixels.
	 * @return the height in pixels
	 */
	public int getArenaHeight()
	{
		return arenaHeight;
	}

	/** 
	 * Determines if the user is currently pressing the cursor up button.
	 * @return true if the up button is pressed, false otherwise.
	 */
	public boolean upPressed()
	{
		return up;
	}

	/** 
	 * Determines if the user is currently pressing the cursor down button.
	 * @return true if the down button is pressed, false otherwise.
	 */
	public boolean downPressed()
	{
		return down;
	}

	/** 
	 * Determines if the user is currently pressing the cursor left button.
	 * @return true if the left button is pressed, false otherwise.
	 */
	public boolean leftPressed()
	{
		return left;
	}

	/** 
	 * Determines if the user is currently pressing the cursor right button.
	 * @return true if the right button is pressed, false otherwise.
	 */
	public boolean rightPressed()
	{
		return right;
	}

	/** 
	 * Determines if the user is currently pressing the space bar.
	 * @return true if the space bar is pressed, false otherwise.
	 */
	public boolean spacePressed()
	{
		return space;
	}

	
}
