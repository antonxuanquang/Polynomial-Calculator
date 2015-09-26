package Views;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import Controls.DisplayArithmeticControl;
import Lab1.Lab1;
import Lab1.Lab1Model;
import Interface.Term;
import Theme.QTextField;
import Theme.QButton;

import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayArithmeticView extends JPanel{
	
	public Lab1 lab1;
	public Lab1Model model;
	private DisplayArithmeticControl control;
	
	private Term term;
	
	public QTextField tfPolyName, tfSearch;
	public QButton btnAddTerm, btnAddPoly, btnLoad, btnSaveToDb;
	public JPanel panelOfTerms;
	public JLabel lblShowingProcess;

	/**
	 * Create the panel.
	 */
	public DisplayArithmeticView(Lab1 fromLab1, Lab1Model fromModel) {
		
		lab1 = fromLab1;
		model = fromModel;
		
		setUpPanel();
		control = new DisplayArithmeticControl(this);
		control.setUpActionListeners();
	}
	
	
	private void setUpPanel() {
		setLayout(null);
		
		tfPolyName = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		tfPolyName.setBounds(42, 40, 118, 20);
		add(tfPolyName);
		tfPolyName.setColumns(10);
		
		panelOfTerms = new JPanel();
		panelOfTerms.setBounds(180, 28, 554, 85);
		panelOfTerms.setLayout(null);
		add(panelOfTerms);
		
		btnAddTerm = new QButton("Add Term", lab1.primaryColor, lab1.secondaryColor);
		btnAddTerm.setBounds(752, 44, 127, 20);
		add(btnAddTerm);
		
		btnAddPoly = new QButton("+", lab1.primaryColor, lab1.secondaryColor);
		btnAddPoly.setBounds(889, 44, 121, 20);
		add(btnAddPoly);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 113, 545, 27);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblShowingProcess = new JLabel("Some words to describe the process");
		lblShowingProcess.setForeground(lab1.primaryColor);
		panel_1.add(lblShowingProcess);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(558, 352, 46, 14);
		lblSearch.setForeground(lab1.primaryColor);
		add(lblSearch);
		
		tfSearch = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		tfSearch.setBounds(614, 349, 118, 20);
		add(tfSearch);
		tfSearch.setColumns(10);
		
		btnLoad = new QButton("Load Polynomial", lab1.primaryColor, lab1.secondaryColor);
		btnLoad.setBounds(752, 348, 127, 20);
		add(btnLoad);
		
		btnSaveToDb = new QButton("Save to DB", lab1.primaryColor, lab1.secondaryColor);
		btnSaveToDb.setBounds(889, 348, 121, 20);
		add(btnSaveToDb);
		
		JScrollPane displayScrollPane = new JScrollPane(new ScrollPanel());
		displayScrollPane.setBounds(42, 142, 690, 158);
		displayScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		add(displayScrollPane);
		
		JScrollPane deleteScrollPane = new JScrollPane(new ScrollPanel());
		deleteScrollPane.setBounds(732, 142, 158, 158);
		add(deleteScrollPane);
		
		JScrollBar sBar1 = displayScrollPane.getVerticalScrollBar();
		JScrollBar sBar2 = deleteScrollPane.getVerticalScrollBar();
		sBar2.setModel(sBar1.getModel());
		
		JLabel label = new JLabel("=");
		label.setBounds(170, 43, 46, 14);
		label.setForeground(lab1.primaryColor);
		add(label);
		
	}
}

class ScrollPanel extends JPanel {
	public ScrollPanel() {
		setLayout(new GridLayout(50, 1));
		for (int x = 0; x < 50; x++)
			add(new JLabel("" + (x + 1), JLabel.CENTER));
	}
}
