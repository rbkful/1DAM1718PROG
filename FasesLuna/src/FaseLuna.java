import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FaseLuna extends JFrame implements ActionListener{

	JLabel luna;
	JButton siguiente;
	JButton anterior;
	int fase = 0;
	
	private ImageIcon [] imgFases = new ImageIcon[8];
	private String [] txtFases = {"Luna Nueva", "Luna Creciente",
			"Cuarto Creciente", "Quinto Octante", "Luna Llena",
			"Tercer Octante", "Cuarto Menguante", "Luna Menguante"
	};


	public FaseLuna() {
		super("Fase Luna");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(300, 300));
		
		for (int i=0; i<imgFases.length; i++)
			imgFases[i] = new ImageIcon(getClass().getResource("/img/" + i + ".png"));
		
		Container lunas = getContentPane();
		lunas.setLayout(new BorderLayout());
		lunas.setBackground(Color.BLACK);

		
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		
		JLabel text1 =new JLabel("Luna Nueva");
		p1.add(text1);
		lunas.add(p1, BorderLayout.CENTER);
		lunas.add(luna = new JLabel(txtFases[fase], imgFases[fase], JLabel.CENTER));
		luna.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		luna.setHorizontalTextPosition(JLabel.CENTER);
		luna.setVerticalTextPosition(JLabel.BOTTOM);
		luna.setForeground(Color.WHITE);
		luna.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		
		p2.add(anterior=new JButton("Anterior",
				new ImageIcon(getClass().getResource
						("/img/left-arrow.png"))));
		anterior.setMnemonic('a');
		anterior.setEnabled(false);
		anterior.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fase > 0) {
					fase--;
					luna.setIcon(imgFases[fase]);
					luna.setText(txtFases[fase]);
					if (fase == 0)
						anterior.setEnabled(false);
					if (!siguiente.isEnabled())
						siguiente.setEnabled(true);
				}
			}
		}
		);
		p2.add(siguiente= new JButton("Siguiente", new ImageIcon(getClass().getResource("/img/right-arrow.png"))));
		siguiente.setHorizontalTextPosition(JButton.LEFT);
		siguiente.setMnemonic('s');
		siguiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (fase < 7) {
					fase++;
					luna.setIcon(imgFases[fase]);
					luna.setText(txtFases[fase]);
					if (fase == 7)
						siguiente.setEnabled(false);
					if (!anterior.isEnabled())
						anterior.setEnabled(true);
				}
			}
		});
			
		lunas.add(p2, BorderLayout.SOUTH);
		
		pack();
	}
	

		
	public static void main(String[] args) {

		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						new FaseLuna().setVisible(true);
					}
				}
			);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	
	
}
