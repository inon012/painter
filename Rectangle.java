import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Represent a Rectangle
 * 
 * @author Inon Cohen
 */
public class Rectangle extends Shape {

	private boolean isFilled; // true if the circle is filled, false otherwise

	/**
	 * Construct a Rectangle
	 * 
	 * @param startPoint
	 *            start point to construct the rectangle
	 * @param endPoint
	 *            end point to construct the rectangle
	 * @param color
	 *            color of the rectangle
	 * @param isFilled
	 *            true if the circle is filled, false otherwise
	 */
	public Rectangle(Point startPoint, Point endPoint, Color color, boolean isFilled) {
		super(startPoint, endPoint, color);

		this.isFilled = isFilled;

	}

	/**
	 * Draw the rectangle
	 */
	public void draw(Graphics g) {

		int width = (int) (getEndPoint().getX() - getStartPoint().getX());
		int height = (int) (getEndPoint().getY() - getStartPoint().getY());

		if (isFilled)
			g.fillRect((int) getStartPoint().getX(), (int) getStartPoint().getY(), width, height);
		else
			g.drawRect((int) getStartPoint().getX(), (int) getStartPoint().getY(), width, height);
	}

}
