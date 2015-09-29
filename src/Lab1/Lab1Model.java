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
	
	public boolean isInPolyLinkedList(String name) {
		PolyNameNode currentPoly = polyLinkedList.getDownPtr();
		currentPoly = currentPoly.getDownPtr();
		while (currentPoly != polyLinkedList.getDownPtr()) {
			if (currentPoly.getPolyName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public void addPoly(PolyNameNode poly) {
		
	}
	
	@Override
	public String toString() {
		String result = "";
		PolyNameNode currentPoly = polyLinkedList.getDownPtr();
		while (currentPoly != getHeadOfPolyLists()) {
			result += currentPoly.getPolyName();
			currentPoly = currentPoly.getDownPtr();
		}
		System.out.println(result);
		return result;
	}

}
