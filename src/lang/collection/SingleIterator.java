package lang.collection;

import lang.EO;

public class SingleIterator<T extends EO> implements Iterator<T> {
	private T obj;
	public T first() {
		return obj;
	}
	public Iterator<T> rest() {
		return new EmptyIterator();
	}
}
