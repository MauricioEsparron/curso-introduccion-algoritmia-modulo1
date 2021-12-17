
/*
Una empresa paga a sus vendedores un sueldo bruto que se calcula sumando un 
sueldo básico más una comisión. El sueldo básico es S/. 350.75. La comisión es 
igual al 5% del importe total vendido en el mes. Por ley, todo empleado está sujeto 
a un descuento igual al 15% del sueldo bruto. El sueldo neto se calcula restando el 
sueldo bruto menos el importe del descuento. Dado el importe total vendido en el 
mes, diseñe un algoritmo que imprima la boleta de un vendedor indicando el sueldo 
básico, la comisión, el sueldo bruto, el descuento y el sueldo neto.
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
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Prpuesto99 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtImporteDelMes;
	private JLabel lblImporteDelMes;
	private JTextArea txtS;
	private JButton btnProcesar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prpuesto99 frame = new Prpuesto99();
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
	public Prpuesto99() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblImporteDelMes = new JLabel("Importe del Mes");
		lblImporteDelMes.setBounds(10, 11, 101, 14);
		contentPane.add(lblImporteDelMes);

		txtImporteDelMes = new JTextField();
		txtImporteDelMes.setBounds(103, 8, 119, 20);
		contentPane.add(txtImporteDelMes);
		txtImporteDelMes.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(232, 7, 133, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(375, 7, 133, 23);
		contentPane.add(btnBorrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 498, 237);
		contentPane.add(scrollPane);

		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformewdBtnProcesar(e);
		}
		if (e.getSource() == btnBorrar) {
			actionePerformedBtnBorrar(e);
		}
	}

	private void actionPerformewdBtnProcesar(ActionEvent e) {
 
		
		double sueldoBruto, sueldoBasico, comision, descuento, sueldoNeto, importeDelMes;

		importeDelMes = leerImporteDelMes();
		sueldoBasico = leerSueldoBasico();
		comision = leerComision(importeDelMes);
		sueldoBruto = leerSueldoBruto(sueldoBasico, comision);
		descuento = leerDescuento(sueldoBruto);
		sueldoNeto = leerSueldoNeto(sueldoBruto, descuento);

		mostrarResultados(sueldoBasico, sueldoBruto, descuento, sueldoNeto);
	}

	private void actionePerformedBtnBorrar(ActionEvent e) {
		txtImporteDelMes.setText("");
		txtS.setText("");
		txtImporteDelMes.requestFocus();
	}

	public void mostrarResultados(double sueldoBasico, double sueldoBruto, double descuento, double sueldoNeto) {
		imprimir("sueldo Básico         : " + sueldoBasico);
		imprimir("sueldo Bruto          : " + sueldoBruto);
		imprimir("descuento             : " + descuento);
		imprimir("sueldo Neto           : " + sueldoNeto);
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	double leerImporteDelMes() {
		return Double.parseDouble(txtImporteDelMes.getText());
	}

	double leerSueldoBasico() {
		return 350.75;
	}

	double leerComision(double impDelMes) {
		return 0.05 * impDelMes;
	}

	double leerSueldoBruto(double sueldoBasico, double comision) {
		return sueldoBasico + comision;
	}

	double leerDescuento(double sueldoBruto) {
		return 0.15 * sueldoBruto;
	}

	double leerSueldoNeto(double sueldoBruto, double descuento) {
		return sueldoBruto - descuento;
	}

}
