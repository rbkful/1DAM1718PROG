import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Frame extends JFrame {
	Lienzo lienzo;
	JSlider slider;
	int Centrado = 0;

	public Frame() {
		super("Texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		setPreferredSize(new Dimension(700, 500));
		
		lienzo = new Lienzo(500, 500);
		c.add(lienzo);
		JPanel panel = new JPanel();

		JCheckBox cb;
		cb = new JCheckBox("Centrado Vertical");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setCentrado(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		panel.add(cb);


		cb = new JCheckBox("Ascent");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setAscent(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		
		panel.add(cb);

		cb = new JCheckBox("Descent");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setDescent(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setLeading(e.getStateChange() == ItemEvent.SELECTED);
			}
		});
		
		panel.add(cb);

		cb = new JCheckBox("Leading");
		cb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setLeading(e.getStateChange() == ItemEvent.SELECTED);
			}
		});		
		panel.add(cb);

		JComboBox<String> fonts = new JComboBox<String>(
				GraphicsEnvironment.
					getLocalGraphicsEnvironment().
					getAvailableFontFamilyNames());
		fonts.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				lienzo.setFontName((String) e.getItem());
			}
		});
		panel.add(fonts);
		c.add(panel, BorderLayout.NORTH);

		pack();
	}
}
