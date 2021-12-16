
/*
Una empresa paga a sus empleados por horas trabajadas. El sueldo bruto se 
calcula multiplicando las horas trabajadas por la tarifa horaria del empleado. Por 
ley, todo empleado esta sujeto a un descuento igual al 15% del sueldo bruto. El 
sueldo neto se calcula restando el sueldo bruto menos el importe del descuento. 
Dado el número de horas trabajadas y la tarifa horaria de un empleado, diseñe un 
algoritmo que determine el sueldo bruto, el descuento y el sueldo neto del 
empleado. 
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

public class Propuesto9 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtS;
	private JTextField txtTarifa;
	private JTextField txtHorasTrabajadas;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JLabel lblTarifa;
	private JLabel lblHorasTrabajadas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto9 frame = new Propuesto9();
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
	public Propuesto9() {
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

		txtS =  new JTextArea();
		txtS.setText("");
		scpScroll.setViewportView(txtS);

		lblTarifa = new JLabel("Tarifa");
		lblTarifa.setBounds(10, 15, 89, 14);
		contentPane.add(lblTarifa);

		lblHorasTrabajadas = new JLabel("Horas Trabajadas");
		lblHorasTrabajadas.setBounds(10, 49, 97, 14);
		contentPane.add(lblHorasTrabajadas);

		txtTarifa = new JTextField();
		txtTarifa.setBounds(120, 12, 86, 20);
		contentPane.add(txtTarifa);
		txtTarifa.setColumns(10);

		txtHorasTrabajadas = new JTextField();
		txtHorasTrabajadas.setBounds(117, 46, 89, 20);
		contentPane.add(txtHorasTrabajadas);
		txtHorasTrabajadas.setColumns(10);
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

		double tarifaHoraria, sueldoBruto, sueldoNeto, impDesc, descuento = 0.15;
		int horasTrabajadas;

		tarifaHoraria = leerTarifaHoraria();
		horasTrabajadas = leerHorasTrabajadas();
		sueldoBruto = leerSueldoBruto(horasTrabajadas, tarifaHoraria);
		impDesc = leerImporteDescuento(descuento, sueldoBruto);
		sueldoNeto = leerSueldoNeto(sueldoBruto, descuento);

		mostrarResultados(sueldoBruto, descuento, sueldoNeto);
	}

	private void actioneventBtnBorrar(ActionEvent e) {
		txtS.setText("");
		txtHorasTrabajadas.setText("");
		txtTarifa.setText("");
		txtTarifa.requestFocus();
	}

	public void mostrarResultados(double sueldoBruto, double descuento, double sueldoNeto) {
		imprimir("BOLETA" + "\n");
		imprimir("Sueldo Bruto            :  " + sueldoBruto);
		imprimir("descuento               :  " + descuento);
		imprimir("Sueldo neto             :  " + sueldoNeto);

	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	private int leerHorasTrabajadas() {
		return Integer.parseInt(txtHorasTrabajadas.getText());
	}

	private double leerTarifaHoraria() {
		return Double.parseDouble(txtTarifa.getText());
	}

	private double leerSueldoBruto(int horTrab, double tarifa) {
		return horTrab * tarifa;
	}

	private double leerImporteDescuento(double desc, double sueldoBruto) {
		return desc * sueldoBruto;
	}

	private double leerSueldoNeto(double sueldoBruto, double impDesc) {
		return sueldoBruto - impDesc;
	}

}
