
/*
Una empresa de transportes aplica un descuento igual al 7% del importe de la
compra. El importe de la compra se calcula multiplicando el precio del pasaje por la 
cantidad de pasajes adquiridos. El importe a pagar se calcula restando el importe
de la compra menos el importe del descuento. Como incentivo adicional, la empresa 
obsequia 3 chocolates por cada pasaje adquirido. Dado el precio del pasaje y la 
cantidad de pasajes adquiridos, diseñe un algoritmo que determine el importe de la 
compra, el importe del descuento, el importe a pagar y la cantidad de chocolates 
de obsequio que le corresponden a un cliente.
*/



package A_Estructuras_de_Secuencia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Propuesto7 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JLabel lblPrecio;
	private JLabel lblCantidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto7 frame = new Propuesto7();
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
	public Propuesto7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 11, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 45, 89, 23);
		contentPane.add(btnBorrar);

		JScrollPane scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 79, 414, 171);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setText("");
		scpScroll.setViewportView(txtS);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 15, 46, 14);
		contentPane.add(lblPrecio);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 49, 46, 14);
		contentPane.add(lblCantidad);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(66, 12, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(66, 46, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actioneventBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actioneventBtnBorrar(e);
		}

	}

	private void actioneventBtnProcesar(ActionEvent e) {

		double precio, impComp, impPagar, impDesc = 0, descuento = 0.07;
		int cantidad, obsequio = 0;

		precio = leerPrecio();
		cantidad = leerCantidad();
		impComp = leerImportecompra(precio, cantidad);
		impDesc = leerImporteDescuento(impComp, descuento);
		impPagar = leerimportePagar(impComp, impDesc);
		obsequio = leerObsequio(cantidad);

		mostrarResultados(impComp, impDesc, impPagar, obsequio);
	}

	private void actioneventBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtPrecio.requestFocus();
	}

	public void mostrarResultados( double impComp, double impDesc,
			double impPagar, int obsequio) {
		imprimir("BOLETA" + "\n");
		imprimir("Importe de la Compra    :  " + impComp);
		imprimir("Importe del Descuento   :  " + impDesc);
		imprimir("Importe a Pagar         :  " + impPagar);
		imprimir("Chocolates a obsequiar  :  " + obsequio);

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

	private double leerImportecompra(double pre, int cant) {
		return pre * cant;
	}

	private double leerImporteDescuento(double impComp, double desc) {
		return impComp * desc;
	}

	private double leerimportePagar(double impComp, double desc) {
		return impComp - desc;
	}

	private int leerObsequio(int cant) {
		return 3 * cant;
	}

}
