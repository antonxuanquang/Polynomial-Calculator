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
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class DisplayArithmeticView extends JPanel{
	
	public Lab1 lab1;
	public Lab1Model model;
	public DisplayArithmeticControl control;
	
	private Term term;
	
	public QTextField tfPolyName, tfSearch;
	public QButton btnAddTerm, btnAddPoly, btnLoad, btnSaveToDb;
	public JPanel panelOfTerms, panelOfPoly;
	public JLabel lblShowingProcess, lblSaveAndLoad;
	private JScrollPane scrollPane;

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
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(180, 28, 569, 85);
		add(scrollPane);
		
		panelOfTerms = new JPanel();
		scrollPane.setViewportView(panelOfTerms);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelOfTerms.setLayout(null);
		
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
		
		lblShowingProcess = new JLabel("");
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
		
		JScrollPane displayScrollPane = new JScrollPane();
		displayScrollPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "List of Polynomials", TitledBorder.LEADING, TitledBorder.TOP, null, lab1.primaryColor));
		displayScrollPane.setBounds(37, 143, 973, 185);
		displayScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		displayScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(displayScrollPane);
		
		panelOfPoly = new JPanel();
		panelOfPoly.setAlignmentY(Component.TOP_ALIGNMENT);
		panelOfPoly.setAlignmentX(Component.LEFT_ALIGNMENT);
		displayScrollPane.setViewportView(panelOfPoly);
		panelOfPoly.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label = new JLabel("=");
		label.setBounds(170, 43, 46, 14);
		label.setForeground(lab1.primaryColor);
		add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 345, 508, 27);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSaveAndLoad = new JLabel("");
		lblSaveAndLoad.setForeground(lab1.primaryColor);
		panel.add(lblSaveAndLoad);		
	}
}
