import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Represent a Circle
 * 
 * @author Inon Cohen
 */
public class Circle extends Shape {

	private boolean isFilled; // true if the circle is filled, false otherwise

	/**
	 * Construct a Circle
	 * 
	 * @param startPoint
	 *            start point to construct the circle
	 * @param endPoint
	 *            end point to construct the circle
	 * @param color
	 *            color of the circle
	 * @param isFilled
	 *            true if the circle is filled, false otherwise
	 */
	public Circle(Point startPoint, Point endPoint, Color color, boolean isFilled) {
		super(startPoint, endPoint, color);

		this.isFilled = isFilled;
	}

	/**
	 * Draw the Circle
	 */
	public void draw(Graphics g) {
		int width = (int) (getEndPoint().getX() - getStartPoint().getX());
		int height = (int) (getEndPoint().getY() - getStartPoint().getY());

		if (isFilled)
			g.fillOval((int) getStartPoint().getX(), (int) getStartPoint().getY(), width, height);
		else
			g.drawOval((int) getStartPoint().getX(), (int) getStartPoint().getY(), width, height);
	}

}
