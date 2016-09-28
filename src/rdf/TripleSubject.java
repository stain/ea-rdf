package rdf;

import lang.string.EOString;
import lang.string.JavaString;

interface TripleSubject extends BlankNode, IRI {
	
	class Fake implements TripleSubject {
		@Override
		public EOString blankNodeLabel() {
			return new JavaString("b1");
		}

		@Override
		public EOString iri() {
			return (EOString) new EOString.Missing();
		}
	}
	
}
