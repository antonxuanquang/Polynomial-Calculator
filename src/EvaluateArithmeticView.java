import javax.swing.JPanel;
import javax.swing.JLabel;

import Theme.QTextField;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class EvaluateArithmeticView extends JPanel {
	private QTextField textField;
	private QTextField textField_1;
	private QTextField textField_2;
	private QTextField textField_3;
	
	Lab1 lab1;

	/**
	 * Create the panel.
	 */
	public EvaluateArithmeticView(Lab1 fromLab1) {
		lab1 = fromLab1;
		
		setLayout(null);
		
		JLabel lblPolynomialName = new JLabel("Polynomial Name");
		lblPolynomialName.setBounds(84, 57, 85, 14);
		lblPolynomialName.setForeground(lab1.primaryColor);
		add(lblPolynomialName);
		
		JLabel label = new JLabel(":");
		label.setBounds(179, 57, 46, 14);
		label.setForeground(lab1.primaryColor);
		add(label);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(84, 78, 46, 14);
		lblX.setForeground(lab1.primaryColor);
		add(lblX);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(84, 103, 46, 14);
		lblY.setForeground(lab1.primaryColor);
		add(lblY);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setBounds(84, 128, 46, 14);
		lblZ.setForeground(lab1.primaryColor);
		add(lblZ);
		
		JLabel label_1 = new JLabel("=");
		label_1.setBounds(179, 78, 46, 14);
		label_1.setForeground(lab1.primaryColor);
		add(label_1);
		
		JLabel label_2 = new JLabel("=");
		label_2.setBounds(179, 103, 46, 14);
		label_2.setForeground(lab1.primaryColor);
		add(label_2);
		
		JLabel label_3 = new JLabel("=");
		label_3.setBounds(179, 128, 46, 14);
		label_3.setForeground(lab1.primaryColor);
		add(label_3);
		
		textField = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		textField.setBounds(216, 75, 122, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		textField_1.setColumns(10);
		textField_1.setBounds(216, 100, 122, 20);
		add(textField_1);
		
		textField_2 = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		textField_2.setColumns(10);
		textField_2.setBounds(216, 125, 122, 20);
		add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(216, 54, 122, 17);
		add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(84, 202, 583, 24);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblShowSomeResult = new JLabel("Show some result here");
		lblShowSomeResult.setForeground(lab1.primaryColor);
		panel.add(lblShowSomeResult);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setForeground(lab1.primaryColor);
		lblResult.setBounds(84, 253, 46, 14);
		add(lblResult);
		
		JLabel label_4 = new JLabel("=");
		label_4.setBounds(179, 253, 46, 14);
		label_4.setForeground(lab1.primaryColor);
		add(label_4);
		
		textField_3 = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		textField_3.setColumns(10);
		textField_3.setBounds(216, 250, 410, 20);
		add(textField_3);
		
		JButton btnNewButton = new JButton("Evaluate");
		btnNewButton.setBounds(216, 153, 122, 23);
		add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(378, 89, 368, 31);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblChosenPolynomialGoes = new JLabel("Chosen Polynomial goes here");
		lblChosenPolynomialGoes.setForeground(lab1.primaryColor);
		panel_1.add(lblChosenPolynomialGoes);

	}

}
