package com.andrucz.selectionmanager;

import java.util.HashSet;
import java.util.Set;

final class NegateSetSelectionState<E> implements SelectionState<E> {

	private final Set<E> elements;
	
	NegateSetSelectionState(E element) {
		elements = new HashSet<E>();
		elements.add(element);
	}
	
	NegateSetSelectionState(Set<E> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean isSelected(E element) {
		return !elements.contains(element);
	}

	@Override
	public SelectionState<E> select(E element) {
		elements.remove(element);
		
		if (elements.isEmpty()) {
			return new FullSelectionState<E>();
		}
		
		return this;
	}

	@Override
	public SelectionState<E> deselect(E element) {
		elements.add(element);
		return this;
	}

	@Override
	public SelectionState<E> invert() {
		return new SetSelectionState<E>(elements);
	}

}
