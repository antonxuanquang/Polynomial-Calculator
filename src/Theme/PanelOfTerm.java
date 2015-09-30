package Theme;

import javax.swing.JPanel;

import Interface.PolyNameNode;
import Interface.Term;
import Lab1.Lab1Model;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class PanelOfTerm extends JPanel {

	private PolyNameNode poly;
	private Lab1Model model;
	private JLabel lblPolyName;
	private int xCordinate, yCordinate = 0;
	
	private Color primaryColor, secondaryColor;
	
	/**
	 * Create the panel.
	 */
	public PanelOfTerm(PolyNameNode poly, Lab1Model fromModel) {

		this.poly = poly;
		model = fromModel;
		
		Term temp = poly.getFirstTerm();
		primaryColor = temp.primaryColor;
		secondaryColor = temp.secondaryColor;
		
		buildFixedComponents();
		buildTerms(poly);
	}

	private void buildFixedComponents() {
		setLayout(null);
		lblPolyName = new JLabel(poly.getPolyName());
		lblPolyName.setBounds(20, 20, 82, 24);
		lblPolyName.setForeground(primaryColor);
		add(lblPolyName);
		
		JLabel label = new JLabel("=");
		label.setBounds(97, 25, 46, 14);
		add(label);
		
		QButton btnNewButton = new QButton("Remove", primaryColor, secondaryColor);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				model.getHeadOfPolyLists().removeByName(lblPolyName.getText());
			}
		});
		btnNewButton.setBounds(700, 21, 89, 23);
		add(btnNewButton);
	}
	
	private void buildTerms(PolyNameNode poly) {
		Term currentTerm = poly.getFirstTerm();
		currentTerm.addPlusLabel(false);
		while (currentTerm != poly.getRightPtr()) {
			if (xCordinate == 550) {
				xCordinate = 110;
				yCordinate += 50;
			} else {
				xCordinate += 110;
			}
			currentTerm.setTFsEnable(false);
			addTermIntoPanel(xCordinate, yCordinate + 10, currentTerm);
			currentTerm = currentTerm.getPtr();
			System.out.println(yCordinate);
		}
		setPreferredSize(new Dimension(830, getYCordinate()));
	}
	
	private void addTermIntoPanel (int xCordinate, int yCordinate, Term term) {
		term.setBounds(xCordinate, yCordinate, 110, 32);
		this.add(term);
		term.setLayout(null);
	}
	
	public int getYCordinate() {
		return yCordinate + 50;
	}
}
