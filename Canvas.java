import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Represent a Canvas for drawing shapes
 * 
 * @author Inon Cohen
 */
public class Canvas extends JPanel {

	private Point startPoint; // start point of the current drawing
	private Point endPoint; // end point of the current drawing

	private Color color; // current color for the canvas
	private boolean isFilled; // true if the current shape should be filled, false otherwise

	private int choosenShape; // shape type to draw

	private ArrayList<Shape> shapes; // all the shapes that were painted


	public Canvas() {
		super();
		setBackground(Constants.CANVAS_BACKGROUND);

		shapes = new ArrayList<Shape>();
		isFilled = false;
		color = Color.BLACK;

		MouseHandler mouseHandler = new MouseHandler();

		addMouseMotionListener(mouseHandler);
		addMouseListener(mouseHandler);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}

	public void setChoosenShape(int choosenShape) {
		this.choosenShape = choosenShape;
	}

	/**
	 * Clear the canvas
	 */
	public void clearCanvas() {
		shapes.clear();
		repaint();
	}

	/**
	 * Undo the last shape that were painted
	 */
	public void undo() {
		int size = shapes.size();
		if (size == 0)
			return;
		shapes.remove(size - 1);
		repaint();
	}

	/**
	 * Create the shape to draw
	 * @return the shape that was created
	 */
	public Shape createShape() {

		if (choosenShape == Constants.CIRCLE)
			return new Circle(startPoint, endPoint, color, isFilled);
		if (choosenShape == Constants.RECTANGLE)
			return new Rectangle(startPoint, endPoint, color, isFilled);
		if (choosenShape == Constants.ROUND_RECTANGLE)
			return new RoundRectangle(startPoint, endPoint, color, isFilled);

		return new Line(startPoint, endPoint, color);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Shape shape : shapes) {
			g.setColor(shape.getColor());
			shape.draw(g);
		}

		// temporary shape to draw (dragged mouse)
		if (endPoint != null) {
			Shape tempShape = createShape();
			g.setColor(tempShape.getColor());
			tempShape.draw(g);
		}
	}

	// Mouse event handling
	private class MouseHandler extends MouseAdapter {

		// handle event when mouse dragged
		public void mouseDragged(MouseEvent e) {
			endPoint = new Point(e.getPoint());
			repaint();
		}

		// handle event when mouse pressed
		public void mousePressed(MouseEvent e) {
			startPoint = new Point(e.getPoint());
			endPoint = startPoint;
			repaint();
		}

		// handle event when mouse released
		public void mouseReleased(MouseEvent e) {
			endPoint = new Point(e.getPoint());
			shapes.add(createShape());
			startPoint = null;
			endPoint = null;
			repaint();
		}
	}
}
