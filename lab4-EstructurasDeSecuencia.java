
/*
Una institución social ha recibido una donación en dinero que lo repartirá entre cinco 
áreas. Cada área recibirá una parte de la donación equivalente a:

     - Centro de salud: 25% de la donación
     - Comedor: 45% del monto recibido por la escuela
     - Biblioteca: 17% del monto total recibido entre el comedor y la escuela
     - Escuela: 35% de la donación
     - Biblioteca: 40% del monto recibido por el centro de salud
     - Asilo de ancianos: lo que queda de la donación 

Dado el importe de la donación, diseñe un algoritmo que determine qué cantidad 
de dinero le corresponde a cada área.
*/


package A_Estructuras_de_Secuencia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Propuesto4 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDonacion;
	private JLabel lblDonacion;
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
					Propuesto4 frame = new Propuesto4();
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
	public Propuesto4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblDonacion = new JLabel("Donaci\u00F3n");
		lblDonacion.setBounds(10, 11, 72, 14);
		contentPane.add(lblDonacion);

		txtDonacion = new JTextField();
		txtDonacion.setBounds(71, 8, 118, 20);
		contentPane.add(txtDonacion);
		txtDonacion.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(199, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(320, 7, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 40, 414, 210);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setText("");
		scpScroll.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actonPerformedBtnBorrar(e);
		}
	}

	private void actionPerformedBtnProcesar(ActionEvent e) {

		double donacion,salud,escuela,comedor,biblioteca,asilo;
		
		donacion = leerDonacion();
		salud = leerSalud(donacion);
		escuela = leerEscuela(donacion);
		comedor = leerComedor(escuela);
		biblioteca = leerBiblioteca(comedor,escuela);
		asilo = leerAsilo(donacion,salud,escuela,comedor,biblioteca);
		
		mostrarResultados(salud,escuela,comedor,biblioteca,asilo);
	}
	private void actonPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtDonacion.setText("");
		txtDonacion.requestFocus();
	}
	public void mostrarResultados(double salud,double escuela,double comedor,double biblioteca,double asilo) {
		txtS.setText("REPARTO DE LA DONACIÓN " + "\n" );
		imprimir("Salud      :  " + salud);
		imprimir("Escuela    :  " + escuela);
		imprimir("Comedor    :  " + comedor);
		imprimir("Biblioteca :  " + biblioteca);
		imprimir("Asilo      :  " + asilo);
		imprimir("-------------------------------------");
		imprimir("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	double leerDonacion() {
		return Double.parseDouble(txtDonacion.getText());
	}
	double leerSalud(double don) {
		return 0.25 * don;
	}
	double leerEscuela(double don) {
		return 0.35 * don;
	}
	double leerComedor(double esc) {
		return 0.45 * esc;
	}
	double leerBiblioteca(double com, double esc) {
		return 0.17 * (com + esc);
	}
	double leerAsilo(double don,double com,double esc,double bib,double sa) {
		return don - (com + esc + bib + sa);
	}
}
