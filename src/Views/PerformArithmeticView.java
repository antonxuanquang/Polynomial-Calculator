package Views;
import javax.swing.JPanel;

import Controls.DisplayArithmeticControl;
import Controls.PerformArithmeticControl;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Theme.QButton;
import Theme.QTextField;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class PerformArithmeticView extends JPanel {

	public Lab1 lab1;
	public Lab1Model model;
	public PerformArithmeticControl control;
	
	public JComboBox firstOperand, operator, secondOperand;
	public QButton btnSave;
	public JPanel panelOfFirstTerm, panelOfSecondTerm, panelResultTerm;
	public JLabel lblShowingProcess;

	 /**
	 * Create the panel.
	 */
	public PerformArithmeticView(Lab1 fromLab1, Lab1Model fromModel) {
		lab1 = fromLab1;
		model = fromModel;
		
		buildUpGUI();		
		
		control = new PerformArithmeticControl(this);
		control.setActionListeners();
	}
	
	private void buildUpGUI() {
		setLayout(null);
		
		firstOperand = new JComboBox();
		firstOperand.setBounds(79, 30, 159, 20);
		firstOperand.setForeground(lab1.primaryColor);
		firstOperand.addItem("**Choose a polynomial");
		add(firstOperand);
		
		operator = new JComboBox();
		operator.setBounds(261, 30, 153, 20);
		operator.setForeground(lab1.primaryColor);
		operator.addItem("**Choose an operator");
		operator.addItem("+");
		operator.addItem("-");
		operator.addItem("*");
		operator.setEnabled(false);
		add(operator);
		
		secondOperand = new JComboBox();
		secondOperand.setBounds(438, 30, 159, 20);
		secondOperand.setForeground(lab1.primaryColor);
		secondOperand.addItem("**Choose a polynomial");
		secondOperand.setEnabled(false);
		add(secondOperand);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 293, 587, 20);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblShowingProcess = new JLabel("");
		lblShowingProcess.setForeground(lab1.primaryColor);
		panel.add(lblShowingProcess);
		
		btnSave = new QButton("Save", lab1.primaryColor, lab1.secondaryColor);
		btnSave.setBounds(617, 293, 105, 20);
		btnSave.setVisible(false);
		add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(57, 64, 665, 66);
		add(scrollPane);
		
		panelOfFirstTerm = new JPanel();
		scrollPane.setViewportView(panelOfFirstTerm);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(57, 135, 665, 66);
		add(scrollPane_1);
		
		panelOfSecondTerm = new JPanel();
		scrollPane_1.setViewportView(panelOfSecondTerm);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(null);
		scrollPane_2.setBounds(57, 206, 665, 84);
		add(scrollPane_2);
		
		panelResultTerm = new JPanel();
		scrollPane_2.setViewportView(panelResultTerm);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	}
}
