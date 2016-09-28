package rdf;

import lang.collection.EmptyIterator;
import lang.collection.FilteredIterator;
import lang.collection.Iterator;
import lang.collection.LinkedIterator;

public class MemoryGraph implements Graph, MutableGraph {
	
	private final Iterator<Triple> iterator;

	public MemoryGraph() {
		this(new EmptyIterator<Triple>());
	}
	
	public MemoryGraph(Iterator<Triple> iterator) {
		this.iterator = iterator;
	}

	@Override
	public Triple first() {
		return iterator.first();
	}

	@Override
	public Iterator<Triple> rest() {
		return iterator.rest();
	}

	@Override
	public MutableGraph add(Triple t) {
		// NOTE: Should we even do these 'null tests' in disguise?
		if (! t.exists()) {
			return this; // no change
		}
		return new MemoryGraph(new LinkedIterator<Triple>(t, iterator));
	}

	@Override
	public MutableGraph remove(Triple t) {
		if (! exists() || ! t.exists()) { return this; }  // no change
		if (t.equals(first())) {
			// We can remove it easily
			return new MemoryGraph(rest());
		}
		// We'll have to traverse and filter it out
		return new MemoryGraph(new FilteredIterator(this, t));
	}
	
}
