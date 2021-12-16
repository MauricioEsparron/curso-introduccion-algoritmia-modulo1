
/*
Una tienda ha puesto en oferta la venta de un producto ofreciendo un descuento 
igual al 15% del importe de la compra. El importe de la compra se calcula 
multiplicando el precio del producto por la cantidad de unidades adquiridas. El 
importe a pagar se calcula restando el importe de la compra menos el importe del 
descuento. Dado el precio del producto y la cantidad de unidades adquiridas, diseñe 
un algoritmo que determine el importe de la compra, el importe del descuento y el 
importe a pagar.
*/




package A_Estructuras_de_Secuencia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;

public class Propuesto6 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto6 frame = new Propuesto6();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Propuesto6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 11, 67, 14);
		contentPane.add(lblCantidad);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 36, 67, 14);
		contentPane.add(lblPrecio);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(73, 8, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(73, 33, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(255, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(255, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 189);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}

	private void actionPerformedBtnProcesar(ActionEvent e) {

		double precio, imp_desc, imp_comp, imp_pagar;
		int cantidad;

		precio = leerPrecio();
		cantidad = leerCantidad();
		imp_comp = leerImporteCompra(precio, cantidad);
		imp_desc = leerImporteDescuento(imp_comp);
		imp_pagar = leerImportePagar(imp_comp, imp_desc);

		mostrarResultados(imp_comp, imp_desc, imp_pagar);
	}

	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtPrecio.requestFocus();
	}

	public void mostrarResultados(double imp_comp, double imp_desc, double imp_pagar) {
		imprimir("BOLETA" + "\n");
		imprimir("Importe de la Compra    :  " + imp_comp);
		imprimir("Importe del Descuento   :  " + imp_desc);
		imprimir("Importe a Pagar         :  " + imp_pagar);
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	private int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText());
	}

	private double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText());
	}
	private double leerImportePagar(double imp_comp, double imp_desc) {
		return imp_comp - imp_desc;
	}

	private double leerImporteCompra(double pre, int cant) {
		return pre * cant;
	}

	private double leerImporteDescuento(double imp_comp) {
		return 0.15 * imp_comp;
	}



}
