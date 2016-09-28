package rdf;

import lang.string.EOString;
import lang.string.JavaString;

interface TriplePredicate extends IRI {

	class Fake implements TriplePredicate {
		public EOString iri() {
			return new JavaString("http://example.com/");
		}
	}

}
