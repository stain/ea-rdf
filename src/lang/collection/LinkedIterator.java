package lang.collection;

import lang.EO;

public class LinkedIterator<T extends EO> implements Iterator<T> {
	// FIXME: "final" and "private" should always be implicit
	private final EO first;
	private final Iterator rest;

	public LinkedIterator(T first, Iterator<T> rest) {
		if (rest.exists()) {
			// Can't have tail without head
			assert first.exists();
		}
		this.first = first;
		this.rest = rest;		
	}
	
	/**
	 * Adapt a java Iterator as an EO iterator 
	 * <p>
	 * <strong>Warning:</strong>This implementation might 
	 * traverse the whole java iterator at construction time.
	 */
	public LinkedIterator(java.util.Iterator<T> javaIterator) {
		if ( ! javaIterator.hasNext() ) {
			// FIXME: Can't return different instance in Java
			//return new EmptyIterator();
			
			this.first = new EO.Missing(); 
		} else { 
			this.first = javaIterator.next();
		}
		if (javaIterator.hasNext()) {
			// This will traverse the rest of the iterator
			this.rest = new LinkedIterator<>(javaIterator);				
		} else {
			this.rest = new EmptyIterator<>();
		}
	}
	
	public boolean exists() {
		return first.exists();
	}
	public T first() {
		return (T)first;
	}
	public Iterator<T> rest() {
		return rest;
	}
	
}
