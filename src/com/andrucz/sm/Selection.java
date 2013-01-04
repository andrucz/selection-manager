package com.andrucz.sm;

public final class Selection<E> {

	private SelectionState<E> state;
	
	public Selection() {
		state = new EmptySelectionState<E>();
	}
	
	public void select(E element) {
		state = state.select(element);
	}
	
	public void deselect(E element) {
		state = state.deselect(element);
	}
	
	public boolean isSelected(E element) {
		return state.isSelected(element);
	}
	
	public void invert() {
		state = state.invert();
	}
	
	public void clear() {
		state = new EmptySelectionState<E>();
	}
	
	public void selectAll() {
		state = new FullSelectionState<E>();
	}
	
}
