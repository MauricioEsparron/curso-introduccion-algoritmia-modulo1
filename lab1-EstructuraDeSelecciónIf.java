
/*
De un partido de fútbol jugado entre dos equipos A y B se tienen los goles anotados 
por cada equipo. Diseñe un algoritmo que determine el resultado del partido entre 
Ganó A, Ganó B o Empate.
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

public class Propuesto1 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtEquipoA;
	private JTextField txtEquipoB;
	private JLabel lblEquipoA;
	private JLabel lblEquipoB;
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

		lblEquipoA = new JLabel("Equipo A");
		lblEquipoA.setBounds(10, 11, 62, 14);
		contentPane.add(lblEquipoA);

		lblEquipoB = new JLabel("Equipo B");
		lblEquipoB.setBounds(10, 36, 62, 14);
		contentPane.add(lblEquipoB);

		txtEquipoA = new JTextField();
		txtEquipoA.setBounds(72, 8, 86, 20);
		contentPane.add(txtEquipoA);
		txtEquipoA.setColumns(10);

		txtEquipoB = new JTextField();
		txtEquipoB.setBounds(72, 36, 86, 20);
		contentPane.add(txtEquipoB);
		txtEquipoB.setColumns(10);

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

		int equipoA,equipoB;
		String ganador;
		equipoA = leerEquipoA();
		equipoB = leerEquipoB();
		ganador = leerGanador(equipoA,equipoB);
		
		mostrarResultados(ganador,equipoA,equipoB);
	}
	private void actionPerformedBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtEquipoA.setText("");
		txtEquipoB.setText("");
		txtEquipoB.requestFocus();
	}
	public void mostrarResultados(String ganador,int A,int B) {
		imprimir("RESULTADOS DEL PARTIDO" + "\n");
		imprimir("Equipo A anoto       :  " + A);
		imprimir("Equipo B anoto       :  " + B);
		imprimir("El equipo ganador es :  " + ganador);
		imprimir("");
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}


	private int leerEquipoB() {
		return Integer.parseInt(txtEquipoB.getText());
	}

	private int leerEquipoA() {
		return Integer.parseInt(txtEquipoA.getText());
	}
	private String leerGanador(int A,int B) {
		if(A > B)
			return  " A";
		if(A < B)
			return " B";
		return "empate";
	}
}




