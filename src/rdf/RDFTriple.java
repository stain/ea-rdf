package rdf;

import lang.EO;
import lang.string.EOString;
import lang.string.JavaString;

public class RDFTriple implements Triple {
	public class RDFString implements TripleSubject,TriplePredicate,TripleObject {
		
		private EOString str;
		
		public RDFString(EOString s) {
			this.str = s;
		}
		
		public EOString blankNodeLabel() {
			if (str.toString().startsWith("_:")) {
				return new JavaString(str.subSequence(2, str.length()));
			}
			return (EOString) new EO.Missing();
		}
		public EOString iri() {
			if (str.toString().startsWith("<")) {
				return new JavaString(str.subSequence(1, str.length()-1));
			}
			return new EOString.Missing();
		}
		public EOString literal() {
			String str2 = str.toString();
			if (str2.startsWith("\"")) {
				int end = str2.lastIndexOf("\"");
				if (end < 0) { 
					throw new IllegalStateException("Not a valid Literal:" + s);
				}				
				return str.subSequence(1, end);
			}
			return new EOString.Missing();
		}
		
		@Override
		public EOString lang() {
			String str2 = str.toString();
			if (str2.startsWith("\"")) {
				int end = str2.lastIndexOf("@");
				if (end < 0 || end < str2.lastIndexOf("\"")) { 
					return (EOString) new EO.Missing();
				}				
				return str.subSequence(end, str.length());
			}
			return new EOString.Missing();			
		}

		@Override
		public IRI dataType() {
			String str2 = str.toString();
			if (str2.startsWith("\"")) {
				int end = str2.lastIndexOf("^");
				if (end < 0 || end < str2.lastIndexOf("\"")) { 
					return new EOString.Missing();
				}
				return str.subSequence(end, str.length());
			}
			return new IRI.Missing();			
		}

	}
	private TripleSubject s;
	private TriplePredicate p;
	private TripleObject o;
	
	public RDFTriple(String s, String p, String o) {
		this(new JavaString(s), new JavaString(p), new JavaString(o));
	}
	public RDFTriple(EOString s, EOString p, EOString o) {
		this.s = new RDFString(s);
		this.p = new RDFString(s);
		this.o = new RDFString(s);
	}
	
	@Override
	public TripleSubject subject() {
		return s;
	}
	@Override
	public TriplePredicate predicate() {
		return p;
	}
	@Override
	public TripleObject object() {
		return o;
	}
	
}
