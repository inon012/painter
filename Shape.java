import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * Represent a Shape
 * 
 * @author Inon Cohen
 */
public abstract class Shape {

	private Point startPoint; // start point to draw the shape
	private Point endPoint; // end point to draw the shape
	private Color color; // color of the shape

	/**
	 * Construct a Shape
	 * 
	 * @param startPoint
	 *            start point to construct the shape
	 * @param endPoint
	 *            end point to construct the shape
	 * @param color
	 *            color of the shape
	 */
	public Shape(Point startPoint, Point endPoint, Color color) {
		Point p1 = new Point(startPoint);
		Point p2 = new Point(endPoint);

		/*
		 * making sure that the start point will be the top-left corner of the shape,
		 * and the end point will be the bottom-right corner of the shape
		 */
		if (startPoint.getX() > endPoint.getX()) {
			p1.setLocation(endPoint.getX(), p1.getY());
			p2.setLocation(startPoint.getX(), p2.getY());
		}
		if (startPoint.getY() > endPoint.getY()) {
			p1.setLocation(p1.getX(), endPoint.getY());
			p2.setLocation(p2.getX(), startPoint.getY());
		}

		this.startPoint = p1;
		this.endPoint = p2;
		this.color = color;
	}

	/**
	 * Abstract method for drawing the shape
	 */
	public abstract void draw(Graphics g);

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}
