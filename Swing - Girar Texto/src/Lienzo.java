import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.GrayFilter;
import javax.swing.JPanel;

public class Lienzo extends JPanel {

	private String texto = "Gira el texto";
	private double rotar=20;
		
	public Lienzo(int ancho, int alto) {
		setPreferredSize(new Dimension(ancho, alto));
		setFocusable(true);
		setFont(getFont().deriveFont((float)(getFont().getSize() * 4)));
	}
	
	public void girarIzquierda(double angulo) {
		rotar=rotar-angulo;
		repaint();
	}
	public void girarDerecha(double angulo) {
		rotar=rotar+angulo;
		repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		FontMetrics fm = g.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(texto)) / 2;
		int y = (getHeight() / 2) + ((fm.getAscent() - fm.getDescent()) / 2);
		g.setColor(Color.BLACK);
		
		
		((Graphics2D)g).rotate(rotar,getWidth()/2,getHeight()/2);
		g.setColor(Color.black);
		g.drawString(texto,x,y);

		
		
	}
	
}
