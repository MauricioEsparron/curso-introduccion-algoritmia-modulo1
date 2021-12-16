


/*
    Diseñe un algoritmo que determine el área de la base (AB), el perímetro de la base 
    (PB) y el área lateral (AL) de un cono del que se conoce el radio de su base (R) y 
    su generatriz (G). Considere las siguientes fórmulas:

                         AB = 3.14 * R ^ 2 
                         AL = (PB * G )/ 2  
                         PB = 6.28 * R 

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

public class Propuesto2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtRadio;
	private JTextField txtGeneratriz;
	private JLabel lblRadio;
	private JLabel lblGeneratriz;
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

		lblRadio = new JLabel("Radio");
		lblRadio.setBounds(10, 11, 87, 14);
		contentPane.add(lblRadio);

		lblGeneratriz = new JLabel("Generatriz");
		lblGeneratriz.setBounds(10, 36, 87, 14);
		contentPane.add(lblGeneratriz);

		txtRadio = new JTextField();
		txtRadio.setBounds(84, 8, 86, 20);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);

		txtGeneratriz = new JTextField();
		txtGeneratriz.setBounds(84, 33, 86, 20);
		contentPane.add(txtGeneratriz);
		txtGeneratriz.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(310, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(310, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 68, 414, 182);
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

		double AB, AL, PB, R, G;

		R = leerRadio();
		G = leerGeneratriz();
		PB = leerPerimetroDeLaBase(R);
		AB = leerAreaDeLaBase(R);
		AL = leerAreaLateral(PB,G);

		mostrarResultados(AB,AL,PB);
	}
	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtRadio.setText("");
		txtGeneratriz.setText("");
		txtGeneratriz.requestFocus();
	}

	public void mostrarResultados(double AB,double AL,double PB) {
		imprimir("AB   :  " + AB);
		imprimir("AL   :  " + AL);
		imprimir("PB   :  " + PB);
		imprimir("------------------------------------");
		imprimir("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	double leerRadio() {
		return Double.parseDouble(txtRadio.getText());
	}

	double leerGeneratriz() {
		return Double.parseDouble(txtGeneratriz.getText());		
	}

	double leerPerimetroDeLaBase(double R) {
		return 6.28 * R;
	}

	double leerAreaDeLaBase(double R) {
		return 3.14 * (R *R);
	}

	double leerAreaLateral(double PB, double G) {
		return (PB * G)/2;
	}
}

