import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Represent a frame for the painter app
 * 
 * @author Inon Cohen
 */
public class PainterFrame extends JFrame implements ActionListener, ItemListener {

	private Canvas canvas; // canvas of the frame

	private JPanel topPanel; // top panel of the frame
	private JButton color; // color button
	private JCheckBox filled; // filled/not filled (select box)
	private JComboBox shape; // shape chooser

	private JPanel bottomPanel; // bottom panel of the frame
	private JButton undo; // undo button
	private JButton clear; // clear button
	private JButton exit; // exit button

	/**
	 * Construct a Painter Frame
	 */
	public PainterFrame() {
		super("Painter");

		canvas = new Canvas();

		// top panel
		topPanel = new JPanel();
		color = new JButton("Set Color");
		shape = new JComboBox(Constants.SHAPES_NAMES);
		filled = new JCheckBox("Filled");

		filled.setEnabled(false);

		color.addActionListener(this);
		shape.addItemListener(this);
		filled.addItemListener(this);

		topPanel.add(color);
		topPanel.add(shape);
		topPanel.add(filled);
		// end of top panel

		// bottom panel
		bottomPanel = new JPanel();
		undo = new JButton("Undo");
		clear = new JButton("Clear");
		exit = new JButton("Exit");

		undo.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);

		bottomPanel.add(undo);
		bottomPanel.add(clear);
		bottomPanel.add(exit);
		// end of bottom panel

		add(canvas, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);

		setSize(Constants.WORLD_SIZE, Constants.WORLD_SIZE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == color) {
			Color c = JColorChooser.showDialog(null, "Select Color", canvas.getColor());
			if (c != null)
				canvas.setColor(c);
		}

		if (e.getSource() == undo)
			canvas.undo();
		if (e.getSource() == clear)
			canvas.clearCanvas();
		if (e.getSource() == exit)
			System.exit(0);
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == filled)
			canvas.setFilled(!canvas.isFilled());

		if (e.getSource() == shape) {
			canvas.setChoosenShape(shape.getSelectedIndex());
			if (shape.getSelectedIndex() == 0)
				filled.setEnabled(false);
			else
				filled.setEnabled(true);
		}
	}
}
