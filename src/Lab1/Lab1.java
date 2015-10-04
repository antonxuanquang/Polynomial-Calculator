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
	
	public DisplayArithmeticView displayView;
	public PerformArithmeticView performView;
	ViewController controllerView;
	public EvaluateArithmeticView evaluateView;
	Lab1Model model = new Lab1Model();
	private JPanel contentPane;
	
	final public Color secondaryColor = new Color(36, 96, 104),
			minorColor  = new Color(105, 150, 156),
			primaryColor = new Color(66, 122, 130);
	private JPanel panel;
	public JPanel panel_1;
	private JPanel panel_2;
	

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
		panel = new JPanel();
		panel.setBounds(-14, -15, 1078, 406);
		contentPane.add(panel);
		panel.setLayout(null);
		displayView = new DisplayArithmeticView(this, model);
		displayView.setBounds(0, 0, 1078, 406);
		panel.add(displayView);
		displayView.setBorder(new LineBorder(primaryColor, 4, true));
	}
	
	public void setUpPerformPolynomialView() {
		panel_1.removeAll();
		performView = new PerformArithmeticView(this, model);
		performView.setBounds(0, 0, 857, 365);
		panel_1.add(performView);
		performView.setBorder(new LineBorder(primaryColor, 4, true));
		validate();
		repaint();
	}
	
	public void setUpEvaluatePolynomialView() {
		panel_1.removeAll();
		evaluateView = new EvaluateArithmeticView(this, model);
		evaluateView.setBounds(0, 0, 857, 365);
		panel_1.add(evaluateView);
		evaluateView.setBorder(new LineBorder(primaryColor, 4, true));
		validate();
		repaint();
	}
	
	private void setUpViewConroller() {
		controllerView = new ViewController(this);
		controllerView.setBounds(0, 0, 212, 363);
		panel_2.add(controllerView);
	}

	private void setUpJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds(100, 100, 1026, 763);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(207, 387, 857, 368);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(-4, 391, 212, 363);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}
}
