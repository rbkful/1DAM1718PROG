import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class ventana extends JFrame implements ActionListener   {
	
	JTextField tModelo;
	JComboBox cMotor;
	DefaultComboBoxModel<String> modeloCombo;
	JTextField tPotencia;
	JButton bAgregar;
	JButton bEliminar;
	JButton bLimpiar;
	JButton bGuardar;
	DefaultTableModel mTabla=null;
	JComboBox<String> txt;
	JTable tabla;
	
	ArrayList<String> fMarcas =new ArrayList<String>();
	

	String[] aMarca = new String[] {
            "Marca", "Modelo", "Motor", "Potencia"
        };
	
	public void leerFichero() throws IOException {
		BufferedReader entrada=new BufferedReader
				(new FileReader("marcas.txt"));
		
		while (entrada.ready()) {
			String linea=entrada.readLine();
			modeloCombo.addElement(linea);
		}
		txt.setModel(modeloCombo);
		entrada.close();
	}
	
	public void eliminarTabla() {
		int fila=tabla.getSelectedRow();
		if(fila!=-1)
		{
			mTabla.removeRow(fila);
			tabla.setModel(mTabla);
		}else
		{
			JOptionPane.showMessageDialog(tabla, 
					"No has seleccionado ninguna fila", "Aviso", JOptionPane.ERROR_MESSAGE);
		}

       
	}

	
	public void limpiarTexto() {
		tModelo.setText("");
		tPotencia.setText("");
	}
	
	public void guardarFichero() {
		
		
		if(mTabla.getRowCount()>0) {
			JFileChooser fc=new JFileChooser();
			int resultado = fc.showSaveDialog(this);
		if(resultado ==JFileChooser.APPROVE_OPTION) {
			File f=fc.getSelectedFile();
			PrintWriter out=null;
			try {
				out=new PrintWriter(f);
				
				for (int i = 0; i < mTabla.getRowCount(); i++) {
					out.print(mTabla.getValueAt(i, 0)+ "\t");
					out.print(mTabla.getValueAt(i, 1)+ "\t");
					out.print(mTabla.getValueAt(i, 2)+ "\t");
					out.print(mTabla.getValueAt(i, 3)+ "\n");
				}
			
			}catch (IOException e) {
				e.printStackTrace();
			}finally {
				if (out!=null)
					out.close();
			}
			
		}
		}else {
		
			JOptionPane.showMessageDialog(tabla, 
				"No hay datos", "Aviso", JOptionPane.ERROR_MESSAGE);
		
		}
	}
	
	
	public  ventana(String vehiculos)  {
		super("Lista de Vehiculos con JTable");
		
		modeloCombo=new DefaultComboBoxModel<>();
		Container conten = getContentPane();
		

		conten.setLayout(new BoxLayout(conten, BoxLayout.Y_AXIS));

		
		JLabel marca=new JLabel("Marca");
		conten.add(marca);
		txt=new JComboBox<String>();
		txt.setPreferredSize(new Dimension(250, 52));
		conten.add(txt);
		
		JLabel modelo=new JLabel("Modelo");
		tModelo=new JTextField(20);
		conten.add(modelo);
		conten.add(tModelo);
		
		JLabel motor = new JLabel("Motor");
		cMotor = new JComboBox();
		cMotor .addItem("gasolina");
		cMotor .addItem("electico");
		cMotor .addItem("diesel");
		cMotor .addItem("hibidro");
		cMotor .setPreferredSize(new Dimension(250, 52));
		conten.add(motor);
		conten.add(cMotor);
		
		JLabel potencia=new JLabel("Potencia");
		tPotencia=new JTextField(20);
		conten.add(potencia);
		conten.add(tPotencia);
		
		JPanel panel=new JPanel(new FlowLayout());
        bAgregar=new JButton("Agregar");
        bAgregar.addActionListener(this);
        bAgregar.setActionCommand("Agregar");
        panel.add(bAgregar);
    		
    		bEliminar=new JButton("Eliminar");
        bEliminar.addActionListener(this);
        bEliminar.setActionCommand("Eliminar");
        panel.add(bEliminar);
    		
    		bLimpiar=new JButton("Limpiar");
        bLimpiar.addActionListener(this);
        bLimpiar.setActionCommand("Limpiar");
        panel.add(bLimpiar);
    		
    		
    		bGuardar=new JButton("Guardar");
        bGuardar.addActionListener(this);
        bGuardar.setActionCommand("Guardar");
        panel.add(bGuardar);
    		
        conten.add(panel);
    		
    		JScrollPane panel2=new JScrollPane();
    		panel2.setPreferredSize(new Dimension(500, 500));
    		//componente intermediario entre los datos
    		//y el componte 
    		 mTabla=new
    				DefaultTableModel(aMarca,0);
    		tabla=new JTable(mTabla);
    		panel2.setViewportView(tabla);
    		conten.add(panel2);
    		tabla.setModel(mTabla);
    		
    		pack();
    		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
    		try {
				leerFichero();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
	}
	public static void main(String[] args) {
		(new ventana("vehiculos")).setVisible(true);

	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if (actionCommand.equals("Agregar")) {
			String marca=(String) txt.getSelectedItem();
			String modelo=tModelo.getText();
			String motor=(String) cMotor.getSelectedItem();
			String potencia=(String) tPotencia.getText();
			if(modelo.equals("")||potencia.equals(""))
			{
				//tabla objeto al que me centra la ventana
				//faltan datos mensaje
				//error tipo imagena mostrar
				JOptionPane.showMessageDialog(tabla, 
						"Faltan datos", "Aviso", JOptionPane.ERROR_MESSAGE);
			}else {
			//boton agregar
			/*String fila[]=new String[]{"","hfgh","hgf","fdhd"};
			modeloTabla.addRow(fila);*/
			String fila[]=new String[]{marca,modelo, motor, potencia};
			mTabla.addRow(fila);
			}
		
		}
		else if (actionCommand.equals("Limpiar")) {
			limpiarTexto();
		}
		else if (actionCommand.equals("Eliminar")) {
			eliminarTabla();
		}
		else if (actionCommand.equals("Guardar")) {
			guardarFichero();
		}

		
	}
	

}	

