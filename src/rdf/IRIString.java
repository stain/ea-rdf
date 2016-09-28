package rdf;

import lang.string.EOString;

public class IRIString implements IRI {

	private EOString iri;

	public IRIString(EOString iri) {
		this.iri = iri;
	}
	
	@Override
	public EOString iri() {
		return iri;
	}

}
