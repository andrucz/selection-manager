package com.andrucz.selectionmanager;

import java.util.HashSet;
import java.util.Set;

final class SetSelectionState<E> implements SelectionState<E> {

	private Set<E> elements;
	
	SetSelectionState(E element) {
		elements = new HashSet<E>();
		elements.add(element);
	}
	
	SetSelectionState(Set<E> elements) {
		this.elements = elements;
	}
	
	@Override
	public boolean isSelected(E element) {
		return elements.contains(element);
	}

	@Override
	public SelectionState<E> select(E element) {
		elements.add(element);
		return this;
	}

	@Override
	public SelectionState<E> deselect(E element) {
		elements.remove(element);
		
		if (elements.isEmpty()) {
			return new EmptySelectionState<E>();
		}
		
		return this;
	}

	@Override
	public SelectionState<E> invert() {
		return new NegateSetSelectionState<E>(elements);
	}

}
