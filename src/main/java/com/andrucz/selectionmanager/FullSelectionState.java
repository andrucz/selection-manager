package com.andrucz.selectionmanager;

final class FullSelectionState<E> implements SelectionState<E> {

	@Override
	public boolean isSelected(E element) {
		return true;
	}

	@Override
	public SelectionState<E> select(E element) {
		return this;
	}

	@Override
	public SelectionState<E> deselect(E element) {
		return new NegateSetSelectionState<E>(element);
	}

	@Override
	public SelectionState<E> invert() {
		return new EmptySelectionState<E>();
	}

}
