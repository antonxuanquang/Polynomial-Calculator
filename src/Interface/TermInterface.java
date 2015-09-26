package Interface;
/**
 * Protocol for PolyNodeInterface
 * 
 * @author James Comer
 */
public interface TermInterface {
	// Method signatures
	public int getCoeff();

	public void setCoeff(int c);

	public int getXPower();

	public void setXPower(int ix);

	public int getYPower();

	public void setYPower(int iy);

	public int getZPower();

	public void setZPower(int iz);

	public Term getPtr();

	public void setPtr(Term p);
}