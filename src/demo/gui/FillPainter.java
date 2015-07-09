package demo.gui;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import com.sun.java.swing.Painter;

/*
 * Fill color for UIManager
 */
public class FillPainter implements Painter<JComponent> {
	private final Color color;

	FillPainter(Color c) {
		color = c;
	}


	@Override
	public void paint(Graphics2D g, Object arg1, int width, int height) {
		g.setColor(color);
		g.fillRect(0, 0, width - 1, height - 1);
		
	}


	
}
