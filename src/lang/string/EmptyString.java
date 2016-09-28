package lang.string;

public class EmptyString implements EOString {
	@Override
	public char charAt(int arg0) {
		return 0;
	}
	@Override
	public int length() {
		return 0;
	}
	@Override
	public EmptyString subSequence(int arg0, int arg1) {
		return this;
	}
	@Override
	public String toString() {
		return "";
	}
}
