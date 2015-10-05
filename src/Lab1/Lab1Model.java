package Lab1;
import Interface.PolyNameNode;
import Interface.Term;

public class Lab1Model {
	
	PolyNameNode polyLinkedList;
	
	public Lab1Model() {
		polyLinkedList = new PolyNameNode("Head");
		polyLinkedList.setDownPtr(polyLinkedList);
		polyLinkedList.setRightPtr(null);
	}
	
	public PolyNameNode getHeadOfPolyLists() {
		return polyLinkedList;
	}
	
	public void adjustPointerTo(PolyNameNode polyLink) {
		polyLinkedList = polyLink;
	}
}
