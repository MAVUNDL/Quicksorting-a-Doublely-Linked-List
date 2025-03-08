# Quicksorting a Doubly-Linked List

A quicksort on an array is an efficient method of sorting a list of items. The same approach can be applied to a **Doubly-Linked List**, although in practice, it is not as efficient due to the nature of linked lists.

## Quicksort Algorithm for a Doubly-Linked List

The basic algorithm for quicksort is as follows:

1. Choose a **pivot** element (the first element in the list).
2. Split the list into three smaller lists:
   - A list containing elements **smaller** than the pivot.
   - A list containing elements **greater** than the pivot.
   - A list containing elements **equal** to the pivot.
3. Recursively call quicksort on the list of **smaller** elements.
4. Recursively call quicksort on the list of **greater** elements.
5. Merge the smaller list, the equal list, and the greater list together.

## Functions to Implement

To implement quicksort on a **Doubly-Linked List**, the following functions are required:

1. `splitEqual(...)` — Returns a new list of items that are **equal** to the given element.
2. `splitLess(...)` — Returns a new list of items that are **less than** the given element.
3. `splitGreater(...)` — Returns a new list of items that are **greater than** the given element.
4. `merge(...)` — Merges two sorted lists such that the resulting list remains sorted.
5. `quicksort(...)` — Implements the quicksort algorithm using the above functions.

> **Note:** These functions should return **new lists** and should **not modify** the existing list.

## Merging Example

The `merge()` function is responsible for merging two sorted lists while maintaining order. For example:

- **List 1**: `[1, 3, 5]`
- **List 2**: `[2, 4, 6]`
- **Merged Result**: `[1, 2, 3, 4, 5, 6]`

## Example Test Output

You have been provided with a test class that you can use to validate your solution. The output of your test program should resemble the following:

### Random Numbers and Inserts
```
List1: <> <-> <7> <-> <21> <-> <82> <-> <33> <-> <68> <-> <>
List2: <> <-> <68> <-> <33> <-> <82> <-> <21> <-> <7> <-> <>
4th item in list 1: 33
Node: <33>
List1 without item: <> <-> <7> <-> <21> <-> <82> <-> <68> <-> <>
Removed item as expected: true
```

### Testing AddBefore and AddAfter
```
List: <> <-> <54> <-> <1> <-> <6> <-> <30> <-> <>
```

### Merge and Sorted Sort Test
```
List1: <> <-> <6> <-> <9> <-> <>
List2: <> <-> <2> <-> <8> <-> <>
List3 (merged): <> <-> <2> <-> <6> <-> <8> <-> <9> <-> <>
SortedList: <> <-> <2> <-> <6> <-> <8> <-> <9> <-> <>
```

### Sorting Random List
```
Unsorted List: <> <-> <40> <-> <15> <-> <32> <-> <0> <-> <92> <-> <52> <-> <13> <->
Sorted List: <> <-> <0> <-> <3> <-> <13> <-> <15> <-> <32> <-> <40> <-> <52> <-> <>
```

## Conclusion

By implementing the above functions, you will be able to perform quicksort on a **Doubly-Linked List**. While this method is not the most efficient due to the nature of linked lists, it provides a great opportunity to practice data structures and algorithm implementation.
