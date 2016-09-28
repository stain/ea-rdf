package lang;

/**
 * An elegant object.
 * <p>
 * Base for all EO interfaces.
 * 
 */
public interface EO {
	default boolean exists() { 
		return true;
	}
	
	class Missing implements EO {
		public boolean exists() {
			return false;
		} 		
	}

	class Fake implements EO {
	}

	class Test {
		public void test(EO eo) {
			boolean exists = eo.exists();
			// doh.. but we'll leave this test here in case 
			// we change away from native "boolean"
			assert exists == true || exists == false;
		}
	}
}
