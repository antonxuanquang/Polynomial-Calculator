package Interface;
/**
 * Protocol for PolyNameNodeInterface
 * 
 * @author James Comer
 */
public interface PolyNameNodeInterface {
	// Method signatures
	public String getPolyName();

	public void setPolyName(String s);

	public PolyNameNode getDownPtr();

	public void setDownPtr(PolyNameNode p);

	public Term getRightPtr();

	public void setRightPtr(Term p);
}