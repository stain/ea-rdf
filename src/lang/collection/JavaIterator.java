package lang.collection;

import lang.EO;

public class JavaIterator<T extends EO> implements java.util.Iterator<T> {

	// For interoperability with the stateful java.util.Iterator,
	// this class needs to be mutable:	
	//@Mutable
	private Iterator<T> eoIterator;

	public JavaIterator(Iterator<T> eoIterator) {
		this.eoIterator = eoIterator;
	}
	public boolean hasNext() {
		return eoIterator.rest().exists();
	}
	public T next() {
		T t = eoIterator.first();
		//@Mutable
		eoIterator = eoIterator.rest();
		return t;
	}	
}
