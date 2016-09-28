package lang.string;

import java.io.UnsupportedEncodingException;
	
public class JavaString implements EOString {
	private String s;

	// TODO: as constructors are important and could be in many variants that
	// might not be distinguishable just by positional typed arguments, 
	// should they look more like static methods?
	
	public JavaString(String s) {
		// TODO: Can this be auto-assigned?
		this.s = s;
	}
	public JavaString(CharSequence s) {		
		this.s = s.toString();
	}
	public JavaString(byte[] bytes) throws UnsupportedEncodingException {		
		this.s = new String(bytes, "utf-8");
	}
	
	// FIXME: @Override is always implicit - no other public methods are allowed
	// FIXME: public is always implicit - no other methods are allowed
	@Override
	public char charAt(int pos) {
		return s.charAt(pos);
	}
	public int length() {
		// FIXME: Need a 'wrap' short-hand to avoid this repetetive plumbing
		return s.length();
	}
	public EOString subSequence(int arg0, int arg1) {
		return new JavaString(s.subSequence(arg0, arg1));
	}
	public String toString() {
		return s;
	}
}
