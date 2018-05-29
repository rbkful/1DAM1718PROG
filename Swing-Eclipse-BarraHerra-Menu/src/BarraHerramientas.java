import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class BarraHerramientas extends JFrame{
	
	public BarraHerramientas() {
	super("Eclipse");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setPreferredSize(new Dimension(500, 500));
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	JMenu menu;
	JMenuItem menuItem;
	menu = new JMenu("File");
	menu.setMnemonic(KeyEvent.VK_S);
	menuBar.add(menu);
	menuItem = new JMenuItem("New", new ImageIcon(getClass().getResource("/img/folder.png")));
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.SHIFT_MASK | KeyEvent.CTRL_MASK));
	
	menuItem = new JMenuItem("Open File");
	menu.add(menuItem);

	menuItem = new JMenuItem("Open Projects from File System");
	menu.add(menuItem);
	menu.add(new JSeparator());
	
	menuItem = new JMenuItem("Close");
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,  KeyEvent.CTRL_MASK));
	menuItem = new JMenuItem("Close All");
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.ALT_MASK | KeyEvent.CTRL_MASK));
	menu.add(new JSeparator());
	
	menuItem = new JMenuItem("Save", new ImageIcon(getClass().getResource("/img/save.png")));
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.ALT_MASK | KeyEvent.CTRL_MASK));
	menuItem = new JMenuItem("Save As...", new ImageIcon(getClass().getResource("/img/saveas.png")));
	menu.add(menuItem);
	menuItem = new JMenuItem("Save All", new ImageIcon(getClass().getResource("/img/saveall.png")));
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.SHIFT_MASK | KeyEvent.CTRL_MASK));
	menuItem = new JMenuItem("Revert");
	menu.add(menuItem);
	menu.add(new JSeparator());
	
	menuItem = new JMenuItem("Move");
	menu.add(menuItem);
	menuItem = new JMenuItem("Rename...", new ImageIcon(getClass().getResource("/img/rename.png")));
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke("F2"));
	menuItem = new JMenuItem("Refresh...", new ImageIcon(getClass().getResource("/img/refresh.png")));
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke("F5"));
	menuItem = new JMenuItem("Convert Line Delimiters To");
	menu.add(menuItem);
	menu.add(new JSeparator());

	menuItem = new JMenuItem("Print", new ImageIcon(getClass().getResource("/img/print.png")));
	menu.add(menuItem);
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_MASK));
	menu.add(new JSeparator());

	menuItem = new JMenuItem("Import...", new ImageIcon(getClass().getResource("/img/import.png")));
	menu.add(menuItem);
	menuItem = new JMenuItem("Export...", new ImageIcon(getClass().getResource("/img/export.png")));
	menu.add(menuItem);
	menu.add(new JSeparator());

	menuItem = new JMenuItem("Exit");
	menu.add(menuItem);
		
	setJMenuBar(menuBar);
	menuBar.setEnabled(false);
	
	ImageIcon img = new ImageIcon(getClass().getResource("/img/folder.png"));
	ImageIcon img2 = new ImageIcon(getClass().getResource("/img/save.png"));
	ImageIcon img3 = new ImageIcon(getClass().getResource("/img/saveas.png"));
	ImageIcon img4 = new ImageIcon(getClass().getResource("/img/saveall.png"));
	ImageIcon img5 = new ImageIcon(getClass().getResource("/img/rename.png"));
	ImageIcon img6 = new ImageIcon(getClass().getResource("/img/refresh.png"));
	ImageIcon img7 = new ImageIcon(getClass().getResource("/img/print.png"));
	ImageIcon img8 = new ImageIcon(getClass().getResource("/img/import.png"));
	ImageIcon img9 = new ImageIcon(getClass().getResource("/img/export.png"));
	
	
	JMenuBar menuBar2 = new JMenuBar();
	setJMenuBar(menuBar);
	menuBar.setEnabled(false);
	JMenu menu2;
	

	
	menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.ALT_MASK | KeyEvent.CTRL_MASK));
	menuItem.setActionCommand("barra");
	menu.add(menuItem);
	;
	
	JToolBar toolBar = new JToolBar();
	
	JButton b = new JButton(img);
	b.setActionCommand("folder");
	toolBar.add(b);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);
	
	JButton b2 = new JButton (img2);
	b.setActionCommand("save");
	toolBar.add(b2);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);
	
	JButton b3=new JButton(img3);
	b.setActionCommand("saveas");
	toolBar.add(b3);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);

	
	JButton b4=new JButton(img4);
	b.setActionCommand("saveall");
	toolBar.add(b4);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);

	
	JButton b5=new JButton(img5);
	b.setActionCommand("rename");
	toolBar.add(b5);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);

	
	JButton b6=new JButton(img6);
	b.setActionCommand("refresh");
	toolBar.add(b6);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);

	
	JButton b7=new JButton(img7);
	b.setActionCommand("print");
	toolBar.add(b7);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);

	
	JButton b8=new JButton(img8);
	b.setActionCommand("import");
	toolBar.add(b8);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);

	
	JButton b9=new JButton(img9);
	b.setActionCommand("export");
	toolBar.add(b9);
	add(toolBar, BorderLayout.NORTH);
	toolBar.setFloatable(false);
	pack();

}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						new BarraHerramientas().setVisible(true);
					}
				}
			);
		}

	}

