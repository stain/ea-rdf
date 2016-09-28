package rdf;

import lang.string.EOString;

public interface Literal {
	EOString literal();
	EOString lang();
	IRI dataType();
}
