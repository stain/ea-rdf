package lang.collection;

import lang.EO;

public class FilteredIterator<T extends EO> implements Iterator<T> {

	private Iterator<T> it;
	private T removedValue;

	public FilteredIterator(Iterator<T> it, T removedValue) {
		assert removedValue.exists();
		assert it.exists();
		this.it = it;
		this.removedValue = removedValue;
	}

	@Override
	public boolean exists() {
		return first().exists();
	}
	
	@Override
	public T first() {
		if (removedValue.equals(it.first())) {
			// skip it
			return rest().first();
		} else { 
			return it.first();
		}
	}

	@Override
	public Iterator<T> rest() {
		if (! it.rest().exists()) {
			return new EmptyIterator<>();
		}
		return new FilteredIterator(it.rest(), removedValue);
	}

}
