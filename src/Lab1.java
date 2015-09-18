import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;

public class Lab1 extends JFrame {
	
	DisplayArithmeticView displayView;
	PerformArithmeticView performView;
	ViewController controllerView;
	EvaluateArithmeticView evaluateView;
	private JPanel contentPane;

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
		setBounds(100, 100, 1050, 720);
	}
	
	private void setInitialGUI() {
		setUpJFrame();
		setUpDisplayPolynomialView();
		setUpPerformPolynomialView();
		setUpViewConroller();
	}

	private void setUpDisplayPolynomialView() {
		displayView = new DisplayArithmeticView(this);
		displayView.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		displayView.setBounds(-14, -15, 1078, 406);
		contentPane.add(displayView);
	}
	
	public void setUpPerformPolynomialView() {
		try {
			remove(evaluateView);
		} catch (NullPointerException exp) {}
		performView = new PerformArithmeticView();
		performView.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
		performView.setBounds(279, 386, 785, 315);
		contentPane.add(performView);
		validate();
		repaint();
	}
	
	public void setUpEvaluatePolynomialView() {
		remove(performView);
		evaluateView = new EvaluateArithmeticView();
		evaluateView.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));
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
