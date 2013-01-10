selection-manager
=================

Simple, lightweight Java API for selections control. All the interactions with this API are centralized in Selection class.

There is methods for selecting and deselecting items, verify if a specified item is selected, invert and clear the selection and select all items.

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

Note that after calling ```selection.selectAll()```, calls to ```selection.isSelected``` will return true for any parameter. It allows a representation of a full selection without knowing about all the items involved.
