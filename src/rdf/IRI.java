package rdf;

import lang.string.EOString;
import lang.string.JavaString;

public interface IRI {
	EOString iri();

	public class Fake implements IRI {
		public EOString iri() {
			return new JavaString("http://example.com/");
		}
	}
}
