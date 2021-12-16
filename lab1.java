
//Problema 1

/*
	 *  Diseñe un algoritmo que determine el área (A) y el perímetro (P) de un
	 *  rectángulo del que se conoce su base (b) y su altura (h). Considere las
   *  siguientes fórmulas:

                    A = b * h
                    p = 2 * (b + h)
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

public class Propuesto1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtRadio;
	private JTextField txtAltura;
	private JLabel lblRadio;
	private JLabel lblAltura;
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
					Propuesto1 frame = new Propuesto1();
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
	public Propuesto1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblRadio = new JLabel("Radio");
		lblRadio.setBounds(10, 11, 60, 14);
		contentPane.add(lblRadio);

		lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 36, 60, 14);
		contentPane.add(lblAltura);

		txtRadio = new JTextField();
		txtRadio.setBounds(61, 8, 99, 20);
		contentPane.add(txtRadio);
		txtRadio.setColumns(10);

		txtAltura = new JTextField();
		txtAltura.setBounds(61, 36, 99, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(286, 7, 109, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(286, 32, 109, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 189);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActiontEvent
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(e);
		}
	}

	private void actionPerformedBtnProcesar(ActionEvent e) {

    //declaración de variables
		double AL, AT, AB, r, h;

    //entrada de datos
		r = leerRadio();
		h = leerAltura();
		AL = leerAreaLateral(r, h);
		AB = leerAreaDeLaBase(r);
		AT = leerAreaTotal(AB, AL);

    //salida de resultados
		mostrarResultados(AT, AB, AL);
	}

	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtRadio.setText("");
		txtAltura.setText("");
		txtAltura.requestFocus();
	}

	public void mostrarResultados(double AT, double AB, double AL) {
		imprimir("AT     :   " + AT);
		imprimir("AB     :   " + AB);
		imprimir("AL     :   " + AL);
		imprimir("-------------------------------");
		imprimir("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	double leerRadio() {
		return Double.parseDouble(txtRadio.getText());
	}

	double leerAltura() {
		return Double.parseDouble(txtAltura.getText());
	}

	double leerAreaLateral(double r, double h) {
		return 2 * 3.1416 * r * h;
	}

	double leerAreaDeLaBase(double r) {
		return (03.1416 * (r * r));
	}

	double leerAreaTotal(double AB, double AL) {
		return 2 * AB + AL;
	}
}




