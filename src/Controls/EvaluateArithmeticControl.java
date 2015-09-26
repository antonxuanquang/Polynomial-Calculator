package Controls;

import Lab1.Lab1Model;
import Views.EvaluateArithmeticView;

public class EvaluateArithmeticControl {
	
	private EvaluateArithmeticView view;
	private Lab1Model model;
	
	public EvaluateArithmeticControl (EvaluateArithmeticView fromView) {
		view = fromView;
		model = view.model;
	}

}
