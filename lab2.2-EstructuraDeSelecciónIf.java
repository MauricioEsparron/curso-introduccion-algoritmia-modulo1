
/*
Dado un número decimal, diseñe un algoritmo que determine si el número es 
Positivo, Negativo o Cero.
*/









package B_Estructura_de_Seleccion_if;

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

public class Propuesto2 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNumero;
	private JLabel lblNumero;
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
					Propuesto2 frame = new Propuesto2();
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
	public Propuesto2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 16, 62, 14);
		contentPane.add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setBounds(81, 13, 86, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(276, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(276, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 64, 414, 186);
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

		double numero;
		String tipo_numero;
		
		numero = leerNumero();
		tipo_numero = leerTipoDeNumero(numero);
		
		mostrarResultados(tipo_numero,numero);
	}
	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtNumero.setText("");
		txtNumero.requestFocus();
	}
	public void mostrarResultados(String tipo_numero,double numero) {
		imprimir("TIPO DE NÚMERO" + "\n");	
		imprimir("El número ingresado es : " + numero + " es " + tipo_numero);
		imprimir("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	private double leerNumero() {
		return Double.parseDouble(txtNumero.getText());
	}
	private String leerTipoDeNumero(double num) {
		if(num == 0)
			return  " neutro ";
		if(num < 0)
			return " Negativo ";
		return " Positivo ";
	}
}


