package lang.string;

import lang.EO;

/**
 * Note - an empty string still exists!
 */
public interface EOString extends CharSequence, EO {	
	
	EOString subSequence(int arg0, int arg1);
	
	class Missing implements EOString {
		public boolean exist() {
			return false;
		}
		public char charAt(int arg0) {
			throw new IllegalStateException("missing");
		}
		@Override
		public int length() {
			throw new IllegalStateException("missing");
		}

		@Override
		public EOString subSequence(int arg0, int arg1) {
			throw new IllegalStateException("missing");
		} 	
	}
	
	class Fake implements EOString {
		public char charAt(int pos) {
			return 0;
		}
		public int length() {
			return 0;
		}
		public EOString subSequence(int from, int to) {
			return this;
		}
	}
}
