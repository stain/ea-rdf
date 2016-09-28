package lang.collection;

import lang.EO;

/**
 * An iterator is a linked list-like way to traverse a collection. 
 * <p>
 * An Iterator instance corresponds to a reader being in a particular position.
 * <p>
 * {@link #first()} is the head of the list - the value of the current position.
 * <p>
 * {@link #rest()} is the rest of the list - moving to the next position.
 * <p>
 * If there is no 
 *  
 * @param T the type of objects this iterator wraps 
 */
public interface Iterator<T extends EO> extends EO, Iterable<T> {
	/**
	 * Head value of the list.
	 * <p>
	 * The head will not {@link EO#exists()} if this iterator is pass the end of the collection. 
	 * 
	 * @return Value at this position.
	 */
	T first();
	/**
	 * Rest of the list.
	 * <p>
	 * The rest will not {@link EO#exists()} if this iterator is at the end of the collection.
	 * 
	 * @see EmptyIterator
	 *  
	 * @return
	 */
	Iterator<T> rest();
	
	default java.util.Iterator<T> iterator() {
		return new JavaIterator(this);
	}
}
