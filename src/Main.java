import structures.*;
// Test file for all data structures

public class Main {
    public static void main(String[] args) {
        // MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList get(1): " + arrayList.get(1)); // 20
        arrayList.remove(0);
        System.out.println("ArrayList after remove: " + arrayList.get(0)); // 20

        // MyLinkedList
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.remove(1);
        for (String s : linkedList) {
            System.out.println("LinkedList element: " + s); // one, three
        }

        // MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop: " + stack.pop()); // 3
        System.out.println("Stack peek: " + stack.peek()); // 2

        // Тест MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue dequeue: " + queue.dequeue()); // A
        System.out.println("Queue peek: " + queue.peek()); // B

        // MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(1);
        System.out.println("Heap poll: " + heap.poll()); // 1
        System.out.println("Heap peek: " + heap.peek()); // 2
    }
}
