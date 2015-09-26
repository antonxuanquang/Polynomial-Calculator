package Lab1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import Views.DisplayArithmeticView;
import Views.EvaluateArithmeticView;
import Views.PerformArithmeticView;
import Views.ViewController;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

public class Lab1 extends JFrame {
	
	DisplayArithmeticView displayView;
	PerformArithmeticView performView;
	ViewController controllerView;
	EvaluateArithmeticView evaluateView;
	Lab1Model model = new Lab1Model();
	private JPanel contentPane;
	
	final public Color secondaryColor = new Color(36, 96, 104),
			minorColor  = new Color(105, 150, 156),
			primaryColor = new Color(66, 122, 130);
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Lab1();
	}

	/**
	 * Create the frame.
	 */
	public Lab1() {
		setInitialGUI();
	}
	
	private void setInitialGUI() {
		setUpJFrame();
		setUpDisplayPolynomialView();
		setUpPerformPolynomialView();
		setUpViewConroller();
	}

	private void setUpDisplayPolynomialView() {
		displayView = new DisplayArithmeticView(this, model);
		displayView.setBorder(new LineBorder(primaryColor, 4, true));
		displayView.setBounds(-14, -15, 1078, 406);
		contentPane.add(displayView);
	}
	
	public void setUpPerformPolynomialView() {
		try {
			remove(evaluateView);
		} catch (NullPointerException exp) {}
		performView = new PerformArithmeticView(this, model);
		performView.setBorder(new LineBorder(primaryColor, 4, true));
		performView.setBounds(279, 386, 785, 315);
		contentPane.add(performView);
		validate();
		repaint();
	}
	
	public void setUpEvaluatePolynomialView() {
		remove(performView);
		evaluateView = new EvaluateArithmeticView(this, model);
		evaluateView.setBorder(new LineBorder(primaryColor, 4, true));
		evaluateView.setBounds(279, 386, 785, 315);
		contentPane.add(evaluateView);
		validate();
		repaint();
	}
	
	private void setUpViewConroller() {
		controllerView = new ViewController(this);
		controllerView.setBounds(-4, 391, 283, 325);
		contentPane.add(controllerView);
	}

	private void setUpJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1026, 702);
		setVisible(true);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
