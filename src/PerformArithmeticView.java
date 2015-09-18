import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PerformArithmeticView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtResult;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PerformArithmeticView() {
		setLayout(null);
		
		JComboBox firstOperand = new JComboBox();
		firstOperand.setBounds(79, 30, 105, 20);
		add(firstOperand);
		
		JComboBox operator = new JComboBox();
		operator.setBounds(317, 30, 53, 20);
		add(operator);
		
		JComboBox secondOperand = new JComboBox();
		secondOperand.setBounds(492, 30, 105, 20);
		add(secondOperand);
		
		JLabel lblFirstoperand = new JLabel("First Operand");
		lblFirstoperand.setBounds(79, 89, 71, 14);
		add(lblFirstoperand);
		
		JLabel lblSecondOperand = new JLabel("Second Operand");
		lblSecondOperand.setBounds(79, 124, 71, 14);
		add(lblSecondOperand);
		
		JLabel label = new JLabel("=");
		label.setBounds(160, 89, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("=");
		label_1.setBounds(160, 124, 46, 14);
		add(label_1);
		
		textField = new JTextField();
		textField.setBounds(191, 86, 406, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(191, 121, 406, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(79, 174, 518, 20);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblLabelToShow = new JLabel("Label to show process");
		panel.add(lblLabelToShow);
		
		txtResult = new JTextField();
		txtResult.setText("Result");
		txtResult.setBounds(79, 226, 71, 20);
		add(txtResult);
		txtResult.setColumns(10);
		
		JLabel label_2 = new JLabel("=");
		label_2.setBounds(160, 229, 46, 14);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(191, 226, 406, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(618, 226, 105, 20);
		add(btnNewButton);

	}
}
