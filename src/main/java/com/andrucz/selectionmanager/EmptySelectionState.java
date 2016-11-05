package com.andrucz.selectionmanager;

final class EmptySelectionState<E> implements SelectionState<E> {

	@Override
	public boolean isSelected(E element) {
		return false;
	}

	@Override
	public SelectionState<E> select(E element) {
		return new SetSelectionState<E>(element);
	}

	@Override
	public SelectionState<E> deselect(E element) {
		return this;
	}

	@Override
	public SelectionState<E> invert() {
		return new FullSelectionState<E>();
	}

}