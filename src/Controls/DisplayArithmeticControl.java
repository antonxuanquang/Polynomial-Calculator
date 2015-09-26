package Controls;

import Lab1.Lab1Model;
import Views.DisplayArithmeticView;

public class DisplayArithmeticControl {
	
	private DisplayArithmeticView view;
	private Lab1Model model;
	
	public DisplayArithmeticControl (DisplayArithmeticView fromView) {
		view = fromView;
		model = view.model;
	}

}
