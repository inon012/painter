import java.awt.Color;

/**
 * Constants Class for the Painter app
 * 
 * @author Inon Cohen
 */
public class Constants {

	public static final int WORLD_SIZE = 500; // Frame size

	public static final Color CANVAS_BACKGROUND = Color.WHITE; // Canvas background

	// serial numbers of the shapes
	public static final int LINE = 0;
	public static final int CIRCLE = 1;
	public static final int RECTANGLE = 2;
	public static final int ROUND_RECTANGLE = 3;
	// Name of all shapes (order by serial number)
	public static final String SHAPES_NAMES[] = { "Line", "Circle", "Rectangle", "Round Rectangle" };


	public static final int ROUNDNESS = 20; // Roundness parameter for the round rectangle

}
