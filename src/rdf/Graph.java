package rdf;

import lang.collection.EmptyIterator;
import lang.collection.Iterator;

interface Graph extends Iterator<Triple> {
	
	class Fake implements Graph {
		
		@Override
		public Triple first() {
			return new Triple.Fake();
		}
		@Override
		public Iterator<Triple> rest() {
			return new EmptyIterator<>();
		}
	}
}
