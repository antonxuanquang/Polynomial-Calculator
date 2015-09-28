package Interface;

import java.awt.Color;

import Lab1.Lab1;

public class PolyNameNode implements PolyNameNodeInterface{
	
	private String name;
	private PolyNameNode downPointer;
	private Term rightPointer;
	
	public PolyNameNode() {}
	
	public PolyNameNode(String name) {
		this.name = name;
	}
	
	public String getPolyName() {
		return name;
	}

	public void setPolyName(String s) {
		name = s;
	}

	public PolyNameNode getDownPtr() {
		return downPointer;
	}

	public void setDownPtr(PolyNameNode p) {
		downPointer = p;
	}

	public Term getRightPtr() {
		return rightPointer;
	}

	public void setRightPtr(Term p) {
		rightPointer = p;
	}
	
	public void buildHeadTerm(Color primaryColor, Color secondaryColor) {
		rightPointer = new Term(primaryColor, secondaryColor);
		this.setRightPtr(rightPointer);
		rightPointer.setCoeffAndXYZ(-99, 0, 0, 0);
		rightPointer = this.getRightPtr();
	}
	
	public boolean isEmpty(PolyNameNode poly) {
		return downPointer == this || downPointer == null;
	}
	
	@Override
	public String toString() {
		String result = "";
		result += "PolyName is: " + this.getPolyName() + "\n"
				+ "**************\n";
		Term currentTerm = this.getRightPtr();
		result = result + currentTerm.toString() + "\n";
		currentTerm = currentTerm.getPtr();
		while (currentTerm != this.getRightPtr()) {
			result = result + currentTerm.toString() + "\n";
			currentTerm = currentTerm.getPtr();
		}
		return result;
	}
	
	public void removeTerm (Term previousTerm, Term currentTerm) {
		previousTerm.setPtr(currentTerm.getPtr());
	}
	
	public void swapTwoTerms (Term preCurrentTer, Term currentTerm, 
			Term preNextTerm, Term nextTerm) {
		Term currentTempTerm = currentTerm;
		Term nextTempTerm = nextTerm;
		currentTerm = nextTempTerm;
		nextTerm = currentTempTerm;
		System.out.println("current = " + currentTerm);
		System.out.println("next = " + nextTerm);
	}

}
