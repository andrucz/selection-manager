package com.andrucz.sm;

interface SelectionState<E> {
	
	boolean isSelected(E element);
	
	SelectionState<E> select(E element);
	
	SelectionState<E> deselect(E element);
	
	SelectionState<E> invert();

}
