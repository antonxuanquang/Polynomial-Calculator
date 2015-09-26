package Lab1;
import Interface.PolyNameNode;

public class Lab1Model {
	
	PolyNameNode polyLinkedList;
	
	public Lab1Model() {
		polyLinkedList = new PolyNameNode("Head");
		polyLinkedList.setDownPtr(polyLinkedList);
		polyLinkedList.setRightPtr(null);
	}

}
