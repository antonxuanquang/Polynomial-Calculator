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
		while (currentPoly != getHeadOfPolyLists()) {
			if (currentPoly.getPolyName().equals(name)) {
				return true;
			}
			currentPoly = currentPoly.getDownPtr();
		}
		return false;
	}
	
	public void addPoly(PolyNameNode poly) {
		poly.setDownPtr(polyLinkedList.getDownPtr());
		polyLinkedList.setDownPtr(poly);
	}
	
	@Override
	public String toString() {
		String result = "";
		PolyNameNode currentPoly = polyLinkedList.getDownPtr();
		while (currentPoly != getHeadOfPolyLists()) {
			System.out.println(currentPoly);
			result += currentPoly.getPolyName() + "\n";
			currentPoly = currentPoly.getDownPtr();
		}
		return result;
	}

}
