package rdf;

import lang.string.EOString;

public class TestElegant {

	public static void main(String[] args) {
		MutableGraph g = new MemoryGraph();
		// TODO: Avoid 'new' - RDFTriple as a function
		// TODO: keys to know which is s/p/o ?
		Triple t = new RDFTriple(/*s*/"_:s",/*p*/"<http://example.com/p>",/*o*/"object");
		g = g.add(t); // TODO: Shortcut for such re-assignment for immutable objects?
		
		Triple retrieved = g.iterator().next();

		EOString label = retrieved.subject().blankNodeLabel();
		assert label.exists();
		assert 's' == label.charAt(1);
		
		
	}

}
