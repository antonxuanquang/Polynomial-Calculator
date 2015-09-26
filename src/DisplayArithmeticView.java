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

import Interface.Term;
import Interface.TermWithPlus;
import Theme.QTextField;
import Theme.QButton;

import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayArithmeticView extends JPanel {
	
	Lab1 lab1;
	
	private QTextField textField, textField_1;
	private QButton btnAddTerm;
	private int xCordinate, yCordinate = 0;
	private JPanel panel;
	
	private Term term;

	/**
	 * Create the panel.
	 */
	public DisplayArithmeticView(Lab1 fromLab1) {
		
		lab1 = fromLab1;
		
		setLayout(null);
		
		textField = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		textField.setBounds(42, 40, 118, 20);
		add(textField);
		textField.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(180, 28, 554, 85);
		add(panel);
		
		btnAddTerm = new QButton("Add Term", lab1.primaryColor, lab1.secondaryColor);
		btnAddTerm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addANewTerm();
			}
		});
		btnAddTerm.setBounds(752, 44, 127, 20);
		add(btnAddTerm);
		
		QButton button = new QButton("+", lab1.primaryColor, lab1.secondaryColor);
		button.setBounds(889, 44, 121, 20);
		add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(106, 113, 545, 27);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSomeWordsTo = new JLabel("Some words to describe the process");
		lblSomeWordsTo.setForeground(lab1.primaryColor);
		panel_1.add(lblSomeWordsTo);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(558, 352, 46, 14);
		lblSearch.setForeground(lab1.primaryColor);
		add(lblSearch);
		
		textField_1 = new QTextField(lab1.primaryColor, lab1.secondaryColor);
		textField_1.setBounds(614, 349, 118, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		QButton btnLoad = new QButton("Load Polynomial", lab1.primaryColor, lab1.secondaryColor);
		btnLoad.setBounds(752, 348, 127, 20);
		add(btnLoad);
		
		QButton btnSaveToDb = new QButton("Save to DB", lab1.primaryColor, lab1.secondaryColor);
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
		panel.setLayout(null);
		
		Term term1 = new Term(lab1.primaryColor, lab1.secondaryColor);
		term1.setBounds(0, 0, 111, 32);
		panel.add(term1);
		term1.setLayout(null);
		
		JLabel label = new JLabel("=");
		label.setBounds(170, 43, 46, 14);
		label.setForeground(lab1.primaryColor);
		add(label);
		
	}
	
	void addANewTerm() {
		TermWithPlus term = new TermWithPlus(lab1.primaryColor, lab1.secondaryColor);
		if (xCordinate == 440) {
			xCordinate = 0;
			yCordinate += 50;
		} else {
			xCordinate += 110;
		}
		term.setBounds(xCordinate, yCordinate, 111, 32);
		panel.add(term);
		term.setLayout(null);
		if (xCordinate == 440 && yCordinate == 50) {
			btnAddTerm.setEnabled(false);
		}
		lab1.validate();
		lab1.repaint();
	}
}

class ScrollPanel extends JPanel {
	public ScrollPanel() {
		setLayout(new GridLayout(50, 1));
		for (int x = 0; x < 50; x++)
			add(new JLabel("" + (x + 1), JLabel.CENTER));
	}
}
