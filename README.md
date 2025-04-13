Documentation for Assignment 2: ArrayList and Linked list
For data structure i've implemented Iterator without using java.util.*, except.
In project, stack is based on MyArrayList, because push and pop at the end is fast. Queue uses MyLinkedList to avoid shifting on dequeue. MinHeap is built on array logic with full heapify control.
Also i've added minimum 5 commits with proper GitHub usage, i've used  memory management tools like resizing arrays, node linking
Here i structured all data: 
public interface MyList<T> extends Iterable<T> {
    void add(T element);
    T get(int index);
    T remove(int index);
    int size();
    boolean isEmpty();
}
Then, i created MyArrayList, which uses a dynamic array:
private void ensureCapacity() {
    if (size == data.length) {
        Object[] newData = new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }
}
For MyLinkedList, I used a custom MyNode class and implemented proper linking:
private class MyNode {
    T data;
    MyNode next;
    MyNode prev;

    MyNode(T data) {
        this.data = data;
    }
}
In Main.java, I tested all the data structures. For each one, I added a few values, performed key operations like add, remove, pop, poll, etc., and printed the results.
MyStack<Integer> stack = new MyStack<>();
stack.push(1);
stack.push(2);
stack.push(3);
System.out.println("Stack pop: " + stack.pop()); // 3
System.out.println("Stack peek: " + stack.peek()); // 2

stack stores elements in reverse order of usage — the last item added comes out first.
queue keeps items in the order they arrived — first in, first out.
MinHeap always keeps the smallest element at the top by reorganizing values after insertions or removals.

MyArrayList: get(1) returns 20, and after removing index 0, the next value is also 20.
MyLinkedList: after removing "two", the remaining elements "one" and "three" are printed(node linkage)
MyStack: pop() returns 3, and peek returns 2, showing LIFO behavior.
MyQueue:  dequeue gives "A", and peek() shows "B", confirming FIFO(first-in first-out) logic.
MyMinHeap: poll returns 1, and peek gives 2, verifying the smallest element is always at the top.

Overall output: 
ArrayList get(1): 20
ArrayList after remove: 20
LinkedList element: one
LinkedList element: three
Stack pop: 3
Stack peek: 2
Queue dequeue: A
Queue peek: B
Heap poll: 1
Heap peek: 2

Process finished with exit code 0
