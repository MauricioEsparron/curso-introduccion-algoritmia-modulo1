
/*
Una imprenta ha lanzado al mercado la venta al por mayor del cuaderno de 100 
hojas mentor que es distribuido a nivel nacional. El importe compra se calcula 
multiplicando el precio de la docena por la cantidad de docenas adquiridas. Como 
oferta, la imprenta aplica un descuento del 12% del importe compra. El importe a 
pagar se calcula restando el importe de la compra menos el importe del descuento 
y sumando el costo del transporte. Dado el precio de la docena, la cantidad de 
docenas adquiridas y el costo del transporte, diseñe un algoritmo que determine el 
importe compra, el importe del descuento y el importe a pagar que le corresponden 
a un cliente.
*/


package A_Estructuras_de_Secuencia;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Propuesto8 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JLabel lblCostoTransporte;
	private JTextField txtCostoTransporte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto8 frame = new Propuesto8();
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
	public Propuesto8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(412, 11, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(412, 40, 89, 23);
		contentPane.add(btnBorrar);

		JScrollPane scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 109, 491, 170);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setText("");
		scpScroll.setViewportView(txtS);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 15, 73, 14);
		contentPane.add(lblPrecio);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 49, 73, 14);
		contentPane.add(lblCantidad);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(113, 11, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(113, 45, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		lblCostoTransporte = new JLabel("Costo Trasnporte");
		lblCostoTransporte.setBounds(10, 84, 100, 14);
		contentPane.add(lblCostoTransporte);

		txtCostoTransporte = new JTextField();
		txtCostoTransporte.setBounds(113, 76, 86, 20);
		contentPane.add(txtCostoTransporte);
		txtCostoTransporte.setColumns(10);
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

		double precio, costoTransporte, impComp, impPagar, impDesc = 0, descuento = 0.07;
		int cantidad, obsequio = 0;

		precio = leerPrecio();
		cantidad = leerCantidad();
		costoTransporte = leerCostoTransporte();
		impComp = leerImportecompra(precio, cantidad);
		impDesc = leerImporteDescuento(impComp, descuento);
		impPagar = leerimportePagar(impComp, impDesc, costoTransporte);

		mostrarResultados(precio, cantidad, descuento, impComp, impDesc, impPagar);
	}

	private void actioneventBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtCantidad.setText("");
		txtPrecio.setText("");
		txtPrecio.requestFocus();
	}

	public void mostrarResultados(double precio, int cantidad, double descuento, double impComp, double impDesc,
			double impPagar) {
		imprimir("BOLETA");
		imprimir("Importe de la Compra    :  " + impComp);
		imprimir("Importe del Descuento   :  " + impDesc);
		imprimir("Importe a Pagar         :  " + impPagar);
		imprimir("------------------------------------------" + "\n");
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

	private double leerCostoTransporte() {
		return Double.parseDouble(txtCostoTransporte.getText());
	}

	private double leerImportecompra(double pre, int cant) {
		return pre * cant;
	}

	private double leerImporteDescuento(double impComp, double desc) {
		return impComp * desc;
	}

	private double leerimportePagar(double impComp, double desc, double transporte) {
		return impComp - desc + transporte;
	}

}
