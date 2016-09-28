package rdf;

import lang.EO;
import lang.string.EOString;
import lang.string.JavaString;

interface TripleObject extends IRI, BlankNode, Literal {

	class Fake implements TripleObject {
		@Override
		public EOString iri() {
			return (EOString) new EO.Missing(); 
		}

		@Override
		public EOString blankNodeLabel() {
			return (EOString) new EO.Missing(); 
		}

		@Override
		public EOString literal() {
			return new JavaString("o"); 
		}

		@Override
		public EOString lang() {
			return (EOString) new EO.Missing(); 
		}

		@Override
		public IRI dataType() {
			return new IRI.Fake();
		}
	}
	
}
