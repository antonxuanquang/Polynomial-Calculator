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

import Controls.DisplayArithmeticControl;
import javax.swing.border.MatteBorder;

public class PanelOfTerm extends JPanel {

	private PolyNameNode poly;
	private Lab1Model model;
	private DisplayArithmeticControl control;
	private JLabel lblPolyName;
	private int xCordinate, yCordinate = 0;
	private QButton btnRemove;
	private QTextField tfName;
	
	private Color primaryColor, secondaryColor;
	
	/**
	 * Create the panel.
	 */
	public PanelOfTerm(PolyNameNode poly, DisplayArithmeticControl control) {
		setBorder(new MatteBorder(0, 0, 2, 0, primaryColor));

		this.poly = poly;
		this.control = control;
		model = control.getModel();
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
		label.setBounds(97, 25, 16, 14);
		label.setForeground(primaryColor);
		add(label);
		
		btnRemove = new QButton("Remove", primaryColor, secondaryColor);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.getHeadOfPolyLists().removeByName(lblPolyName.getText());
				control.updatePanelOfPolies(model.getHeadOfPolyLists());
				control.getView().tfSearch.setText("");
				control.view.lab1.performView.control.updateJComboBox(model.getHeadOfPolyLists());
				try {
					control.view.lab1.evaluateView.control.updateJComboBox(model.getHeadOfPolyLists());
				} catch (NullPointerException e) {}
			}
		});
		btnRemove.setBounds(700, 21, 89, 23);
		add(btnRemove);
	}
	
	private void buildTerms(PolyNameNode poly) {
		if (poly.isHavingNoTerm()) {
			JLabel zero = new JLabel("0");
			zero.setForeground(primaryColor);
			zero.setBounds(130, 15, 110, 32);
			add(zero);
		} else {
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
//				currentTerm.changeTFsIntoLabels();
				addTermIntoPanel(xCordinate, yCordinate + 10, currentTerm);
				currentTerm = currentTerm.getPtr();
			}
		}
		setPreferredSize(new Dimension(830, getYCordinate()));
	}
	
	private void addTermIntoPanel (int xCordinate, int yCordinate, Term term) {
		term.setBounds(xCordinate, yCordinate, 110, 32);
		this.add(term);
		term.setLayout(null);
	}
	
	public void removeDeleteBtn() {
		remove(btnRemove);
	}
	
	public int getYCordinate() {
		return yCordinate + 50;
	}
	
	public void replaceLblNameAsTextField() {
		tfName = new QTextField(primaryColor, secondaryColor);
		remove(lblPolyName);
		add(tfName);
		tfName.setBounds(20, 20, 75, 20);
	}
	
	public String getPolyName() {
		return tfName.getText();
	}
	
	public void setPolyName(String name) {
		tfName.setText(name);
	}
}
