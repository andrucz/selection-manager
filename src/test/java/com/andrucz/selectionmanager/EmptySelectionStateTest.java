package com.andrucz.selectionmanager;

import org.junit.Before;
import org.junit.Test;

import com.andrucz.selectionmanager.EmptySelectionState;
import com.andrucz.selectionmanager.FullSelectionState;
import com.andrucz.selectionmanager.SelectionState;
import com.andrucz.selectionmanager.SetSelectionState;

import static org.junit.Assert.*;

public final class EmptySelectionStateTest {

	private EmptySelectionState<Foo> state;
	
	@Before
	public void initializeState() {
		state = new EmptySelectionState<Foo>();
	}
	
	@Test
	public void testIsNullSelected() {
		assertFalse(state.isSelected(null));
	}
	
	@Test
	public void testIsSelected() {
		Foo foo = new Foo(1, "andrucz");
		assertFalse(state.isSelected(foo));
	}
	
	@Test
	public void testSelectNull() {
		SelectionState<Foo> newState = state.select(null);
		assertTrue(newState instanceof SetSelectionState);
	}
	
	@Test
	public void testSelect() {
		Foo foo = new Foo(1, "andrucz");
		
		SelectionState<Foo> newState = state.select(foo);
		assertTrue(newState instanceof SetSelectionState);
		
		assertTrue(newState.isSelected(foo));
	}
	
	@Test
	public void testDeselectNull() {
		SelectionState<Foo> newState = state.deselect(null);
		assertSame(state, newState);
	}
	
	@Test
	public void testDeselect() {
		Foo foo = new Foo(1, "andrucz");
		SelectionState<Foo> newState = state.deselect(foo);
		assertSame(state, newState);
	}
	
	@Test
	public void testInvert() {
		SelectionState<Foo> newState = state.invert();
		assertTrue(newState instanceof FullSelectionState);
	}
	
}
