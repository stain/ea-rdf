package lang.collection;

import lang.EO;

public class EmptyIterator<T extends EO> implements Iterator<T> {
	public T first() {
		// TODO: How should this be legally upcast? Use T.Fake ? 
		return (T)new EO.Missing();
	}
	public Iterator<T> rest() {
		return this;
	}
	public boolean exists() {
		return false;
	}
	
}
