
/*

Diseñe un algoritmo que determine el área (A) y el volumen (V) de una esfera de la 
que se conoce su radio (r). Considere las siguientes fórmulas:

𝐴 = 12.57 * 𝑟 ^ 2
𝑉 = (12.57 * 𝑟 ^ 3)/3

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

public class Propuesto3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtRadio;
	private JLabel lblRadio;
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
					Propuesto3 frame = new Propuesto3();
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
	public Propuesto3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRadio = new JLabel("Radio");
		lblRadio.setBounds(10, 11, 60, 14);
		contentPane.add(lblRadio);

		txtRadio = new JTextField();
		txtRadio.setBounds(59, 8, 96, 20);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(189, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(316, 7, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 48, 414, 202);
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
		double r,A,V;
		
	r = leerRadio();
	A = leerArea(r);
	V = leerVolumen(r);
	
	mostrarResultados(A,V);
	
	}
	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtRadio.setText("");
	}

	public void mostrarResultados(double A,double V) {
		imprimir("A   :  " + A);
		imprimir("V   :  " + V);
		imprimir("-----------------------------------");
		imprimir("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	double leerRadio() {
		return Double.parseDouble(txtRadio.getText());
	}

	double leerArea(double r) {
		return 12.57 * (r * r);
	}

	double leerVolumen(double r) {
		return (12.57 * (r * r * r)) / 3;
	}
}
