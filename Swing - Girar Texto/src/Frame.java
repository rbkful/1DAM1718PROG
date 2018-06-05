
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

public class Frame extends JFrame {

	Lienzo lienzo;
	int angulo=90;
	public Frame() {
		super("Swing Text Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(lienzo = new Lienzo(500, 500));
		pack();
		Action izda = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lienzo.girarIzquierda(angulo);
			}
		};
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
		getRootPane().getInputMap().put(key, "izda");
		getRootPane().getActionMap().put("izda", izda);
		
		Action dcha = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lienzo.girarDerecha(angulo);
				
			}
		};
		key = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
		getRootPane().getInputMap().put(key, "dcha");
		getRootPane().getActionMap().put("dcha", dcha);
	}
	
}
