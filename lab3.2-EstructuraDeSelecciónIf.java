
/*
 Diseñe un algoritmo que determine la categoría de un estudiante sobre la base de 
su promedio ponderado, de acuerdo con la siguiente tabla:
 
                Promedio               Categoría
                >=17             ->        A
                >=14 pero < 17   ->        B
                >=12 pero < 14   ->        C
                < 12             ->        D

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

public class Propuesto3 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblPromedio;
	private JTextField txtPromedio;
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
		setBounds(100, 100, 413, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPromedio = new JLabel("Promedio");
		lblPromedio.setBounds(10, 11, 65, 14);
		contentPane.add(lblPromedio);

		txtPromedio = new JTextField();
		txtPromedio.setBounds(80, 8, 135, 20);
		contentPane.add(txtPromedio);
		txtPromedio.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(273, 58, 119, 41);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(273, 113, 119, 41);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 39, 253, 261);
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

		int promedio;
		String categoria;

		promedio = leerPromedio();
		categoria = leercategoria(promedio);

		mostrarResultados(categoria);

	}

	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtPromedio.setText("");
		txtPromedio.requestFocus();
	}

	public void mostrarResultados(String categoria) {
		imprimir("Categoria : " + categoria);
		imprimir("-------------------------------------");

	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	int leerPromedio() {
		return Integer.parseInt(txtPromedio.getText());
	}

	String leercategoria(int promedio) {
		if (promedio >= 17)
			return "A";
		if (promedio >= 14)
			return "B";
		if (promedio >= 12)
			return "C";
		return "D";
	}
}










