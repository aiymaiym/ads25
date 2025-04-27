import structures.*;
// Test file for all data structures

public class Main {
    public static void main(String[] args) {
        // MyArrayList
        MyList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        System.out.println("ArrayList get(1): " + arrayList.get(1));
        arrayList.remove(0);
        System.out.println("ArrayList after remove: " + arrayList.get(0));

        // MyLinkedList
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        linkedList.remove(1);
        for (String s : linkedList) {
            System.out.println("LinkedList element: " + s);
        }

        // MyStack
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack peek: " + stack.peek());

        // MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue peek: " + queue.peek());

        // MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.add(5);
        heap.add(2);
        heap.add(8);
        heap.add(1);
        System.out.println("Heap poll: " + heap.poll());
        System.out.println("Heap peek: " + heap.peek());
        TestHash();
    }
    // TestHashTable - testing put, get, remove, contains, getK
    public static void TestHash(){
        MyHashTable<String, Integer> table = new MyHashTable<>();
        //put
        table.put("Arman", 18);
        table.put("Alina", 21);
        //get
        System.out.println("Arman's age: " + table.get("Arman" ));
        System.out.println("Alina's age: " + table.get("Alina" ));
        //contains
        System.out.println("Contains 18: " + table.contains(18));
        System.out.println("Contains 30: " + table.contains(30));
        //getKey
        System.out.println("Key for value 21: " + table.getKey(21));
        System.out.println("Key for value 30: " + table.getKey(30));
        //remove
        System.out.println("Remove Arman: " + table.remove("Arman"));
        System.out.println("After remove Arman: " + table.get("Arman"));
        System.out.println("Contains 18 after remove: " + table.contains(18));
    }
}
