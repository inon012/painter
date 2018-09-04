import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Represent a Round Rectangle
 * 
 * @author Inon Cohen
 */
public class RoundRectangle extends Shape {

	private boolean isFilled; // true if the circle is filled, false otherwise

	/**
	 * Construct a Round Rectangle
	 * 
	 * @param startPoint
	 *            start point to construct the round rectangle
	 * @param endPoint
	 *            end point to construct round the rectangle
	 * @param color
	 *            color of the round rectangle
	 * @param isFilled
	 *            true if the circle is filled, false otherwise
	 */
	public RoundRectangle(Point startPoint, Point endPoint, Color color, boolean isFilled) {
		super(startPoint, endPoint, color);

		this.isFilled = isFilled;
	}

	/**
	 * Draw the round rectangle
	 */
	public void draw(Graphics g) {
		int width = (int) (getEndPoint().getX() - getStartPoint().getX());
		int height = (int) (getEndPoint().getY() - getStartPoint().getY());

		if (isFilled)
			g.fillRoundRect((int) getStartPoint().getX(), (int) getStartPoint().getY(), width, height,
					Constants.ROUNDNESS, Constants.ROUNDNESS);
		else
			g.drawRoundRect((int) getStartPoint().getX(), (int) getStartPoint().getY(), width, height,
					Constants.ROUNDNESS, Constants.ROUNDNESS);
	}

}
