import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Represent a Line
 * 
 * @author Inon Cohen
 */
public class Line extends Shape {

	/**
	 * Construct a Line
	 * 
	 * @param startPoint
	 *            start point of the line
	 * @param endPoint
	 *            end point of the line
	 * @param color
	 *            color of the line
	 */
	public Line(Point startPoint, Point endPoint, Color color) {
		super(startPoint, endPoint, color);

		// override the reordering of the points in shape constructor
		setStartPoint(startPoint);
		setEndPoint(endPoint);
	}

	/**
	 * Draw the line
	 */
	public void draw(Graphics g) {
		g.drawLine((int) getStartPoint().getX(), (int) getStartPoint().getY(), (int) getEndPoint().getX(),
				(int) getEndPoint().getY());
	}

}
