package rdf;

import lang.collection.Iterator;

public interface MutableGraph extends Graph {
	MutableGraph add(Triple t);
	MutableGraph remove(Triple t);
	
	public class Fake implements MutableGraph {
		private Graph fakeGraph = new Graph.Fake();
		public Triple first() {
			return fakeGraph.first();
		}
		public Iterator<Triple> rest() {
			return fakeGraph.rest();
		}
		public MutableGraph add(Triple t) {
			return this;
		}
		public MutableGraph remove(Triple t) {
			return this;
		}
	}
}
