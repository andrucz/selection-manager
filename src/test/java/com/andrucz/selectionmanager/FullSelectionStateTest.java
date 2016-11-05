package com.andrucz.selectionmanager;

import org.junit.Before;
import org.junit.Test;

import com.andrucz.selectionmanager.EmptySelectionState;
import com.andrucz.selectionmanager.FullSelectionState;
import com.andrucz.selectionmanager.NegateSetSelectionState;
import com.andrucz.selectionmanager.SelectionState;

import static org.junit.Assert.*;

public final class FullSelectionStateTest {

	private FullSelectionState<Foo> state;
	
	@Before
	public void initializeState() {
		state = new FullSelectionState<Foo>();
	}
	
	@Test
	public void testIsNullSelected() {
		assertTrue(state.isSelected(null));
	}
	
	@Test
	public void testIsSelected() {
		Foo foo = new Foo(1, "andrucz");
		assertTrue(state.isSelected(foo));
	}
	
	@Test
	public void testSelectNull() {
		SelectionState<Foo> newState = state.select(null);
		assertSame(state, newState);
	}
	
	@Test
	public void testSelect() {
		Foo foo = new Foo(1, "andrucz");
		
		SelectionState<Foo> newState = state.select(foo);
		assertSame(state, newState);
	}
	
	@Test
	public void testDeselectNull() {
		SelectionState<Foo> newState = state.deselect(null);
		assertTrue(newState instanceof NegateSetSelectionState);
		assertFalse(newState.isSelected(null));
	}
	
	@Test
	public void testDeselect() {
		Foo foo = new Foo(1, "andrucz");
		SelectionState<Foo> newState = state.deselect(foo);
		assertTrue(newState instanceof NegateSetSelectionState);
		assertFalse(newState.isSelected(foo));
	}
	
	@Test
	public void testInvert() {
		SelectionState<Foo> newState = state.invert();
		assertTrue(newState instanceof EmptySelectionState);
	}
	
}
