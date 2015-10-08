package Views;
import javax.swing.JPanel;

import Controls.DisplayArithmeticControl;
import Controls.EvaluateArithmeticControl;
import Lab1.Lab1;
import Lab1.Lab1Model;

import javax.swing.JLabel;

import Theme.QButton;
import Theme.QTextField;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class EvaluateArithmeticView extends JPanel {
	
	public Lab1 lab1;
	public Lab1Model model;
	public EvaluateArithmeticControl control;
	
	public QTextField xTF, yTF, zTF;
	public JComboBox cbPolynomials;
	public JLabel lblResult;
	public JPanel panelOfEvaluatingPoly;
	public QButton btnEvaluate;
	
	

	/**
	 * Create the panel.
	 */
	public EvaluateArithmeticView(Lab1 fromLab1, Lab1Model fromModel) {
		lab1 = fromLab1;
		model = fromModel;
		
		buildUpGUI();
		
		control = new EvaluateArithmeticControl(this);
		control.setUpListener();
	}
	
	private void buildUpGUI() {
		setLayout(null);
		
		JLabel lblPolynomialName = new JLabel("Polynomial Name");
		lblPolynomialName.setBounds(66, 57, 103, 14);
		lblPolynomialName.setForeground(lab1.primaryColor);
		add(lblPolynomialName);
		
		JLabel label = new JLabel(":");
		label.setBounds(179, 57, 46, 14);
		label.setForeground(lab1.primaryColor);
		add(label);
		
		JLabel lblX = new JLabel("x");
		lblX.setBounds(66, 78, 46, 14);
		lblX.setForeground(lab1.primaryColor);
		add(lblX);
		
		JLabel lblY = new JLabel("y");
		lblY.setBounds(66, 103, 46, 14);
		lblY.setForeground(lab1.primaryColor);
		add(lblY);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setBounds(66, 128, 46, 14);
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
		
		xTF = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		xTF.setTabSize(0);
		xTF.setBounds(216, 75, 41, 20);
		add(xTF);
		xTF.setColumns(10);
		
		yTF = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		yTF.setTabSize(0);
		yTF.setColumns(10);
		yTF.setBounds(216, 100, 41, 20);
		add(yTF);
		
		zTF = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		zTF.setTabSize(0);
		zTF.setColumns(10);
		zTF.setBounds(216, 125, 41, 20);
		add(zTF);
		
		cbPolynomials = new JComboBox();
		cbPolynomials.setBounds(216, 54, 157, 17);
		add(cbPolynomials);
		
		btnEvaluate = new QButton("Evaluate", lab1.primaryColor, lab1.secondaryColor);
		btnEvaluate.setBounds(216, 153, 157, 23);
		btnEvaluate.setEnabled(false);
		add(btnEvaluate);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(378, 89, 368, 31);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblResult = new JLabel("");
		lblResult.setForeground(lab1.primaryColor);
		panel_1.add(lblResult);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(66, 199, 680, 130);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
		
		panelOfEvaluatingPoly = new JPanel();
		scrollPane.setViewportView(panelOfEvaluatingPoly);
	}
}
