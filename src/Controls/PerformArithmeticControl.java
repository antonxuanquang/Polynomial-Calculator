package Controls;

import Lab1.Lab1Model;
import Views.PerformArithmeticView;

public class PerformArithmeticControl {
	
	private PerformArithmeticView view;
	private Lab1Model model;
	
	public PerformArithmeticControl (PerformArithmeticView fromView) {
		view = fromView;
		model = view.model;
	}

}
