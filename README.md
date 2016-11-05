selection-manager
=================

Simple and lightweight Java API to represent a selection of items. It gives you the ability to represent a selection of all items when your collection is not fully known.

All the interactions with this API are centralized in Selection class.

There are methods to select and deselect items, to verify if an item is selected, invert and clear the selection and select all items.

Example
-------

```java
Selection<Foo> selection = new Selection<Foo>();

selection.select(foo1);
selection.select(foo2);

selection.deselect(foo2);

boolean b = selection.isSelected(foo1);

selection.invert();

selection.clear();

selection.selectAll();
```

Note that after calling ```selection.selectAll()```, calls to ```selection.isSelected``` will return true for any parameter. It allows a representation of a full selection without knowing all the items involved.
