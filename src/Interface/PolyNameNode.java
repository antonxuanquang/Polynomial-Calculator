package Interface;

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

}
