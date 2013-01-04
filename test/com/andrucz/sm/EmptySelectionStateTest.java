package com.andrucz.sm;

import org.junit.Before;
import org.junit.Test;
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
		Foo foo = new Foo(1, "john");
		assertFalse(state.isSelected(foo));
	}
	
	@Test
	public void testSelectNull() {
		SelectionState<Foo> newState = state.select(null);
		assertTrue(newState instanceof SetSelectionState);
	}
	
	@Test
	public void testSelect() {
		Foo foo = new Foo(1, "john");
		SelectionState<Foo> newState = state.select(foo);
		assertTrue(newState instanceof SetSelectionState);
	}
	
	@Test
	public void testDeselectNull() {
		SelectionState<Foo> newState = state.deselect(null);
		assertSame(state, newState);
	}
	
	@Test
	public void testDeselect() {
		Foo foo = new Foo(1, "john");
		SelectionState<Foo> newState = state.deselect(foo);
		assertSame(state, newState);
	}
	
	@Test
	public void testInvert() {
		SelectionState<Foo> newState = state.invert();
		assertTrue(newState instanceof FullSelectionState);
	}
	
}
