package rdf;

import lang.EO;

interface Triple extends EO {
	TripleSubject subject();
	TriplePredicate predicate();
	TripleObject object();	
	
	class Fake implements Triple{
		@Override
		public TripleSubject subject() {
			return new TripleSubject.Fake();
		}

		@Override
		public TriplePredicate predicate() {
			return new TriplePredicate.Fake();
		}

		@Override
		public TripleObject object() {
			return new TripleObject.Fake();
		}

	}
}
