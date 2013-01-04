package com.andrucz.sm;

import org.junit.Test;

import static org.junit.Assert.*;

public final class NegateSetSelectionStateTest {
	
	@Test
	public void testIsNullSelected_True() {
		Foo foo1 = new Foo(1, "andrucz");
		NegateSetSelectionState<Foo> state = new NegateSetSelectionState<Foo>(foo1);
		
		assertTrue(state.isSelected(null));
	}
	
	@Test
	public void testIsNullSelected_False() {
		NegateSetSelectionState<Foo> state = new NegateSetSelectionState<Foo>((Foo) null);
		assertFalse(state.isSelected(null));
	}
	
	@Test
	public void testIsSelected() {
		Foo foo1 = new Foo(1, "andrucz");
		Foo foo2 = new Foo(2, "bruna");
		
		NegateSetSelectionState<Foo> state = new NegateSetSelectionState<Foo>(foo2);
		
		assertTrue(state.isSelected(foo1));
		assertFalse(state.isSelected(foo2));
	}
	
	@Test
	public void testSelectNull_Constructor() {
		Foo foo1 = new Foo(1, "andrucz");
		NegateSetSelectionState<Foo> state = new NegateSetSelectionState<Foo>((Foo) null);
		
		assertFalse(state.isSelected(null));
		assertTrue(state.isSelected(foo1));
	}
	
}
