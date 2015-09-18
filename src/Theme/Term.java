package Theme;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Term extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public Term() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 28, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(40, 13, 22, 17);
		add(lblX);
		
		textField_1 = new JTextField();
		textField_1.setBounds(48, 0, 14, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(63, 14, 22, 17);
		add(lblY);
		
		textField_2 = new JTextField();
		textField_2.setBounds(71, 1, 14, 20);
		textField_2.setColumns(10);
		add(textField_2);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setBounds(86, 14, 22, 17);
		add(lblZ);
		
		textField_3 = new JTextField();
		textField_3.setBounds(94, 1, 14, 20);
		textField_3.setColumns(10);
		add(textField_3);

	}

}
