package structures;
// Min-heap using array based structure

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;

    public MyMinHeap() {
        heap = new MyArrayList<>();
    }


    public void add(T element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }
    public T poll() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");

        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heapifyDown(0, last);
        }

        return min;
    }

    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }


    // Moves element up to keep heap property
    private void heapifyUp(int index) {
        T value = heap.get(index);
        while (index > 0) {
            int parent = (index - 1) / 2;
            T parentVal = heap.get(parent);
            if (value.compareTo(parentVal) >= 0) break;
            swap(index, parent);
            index = parent;
        }
    }

    // Moves element down to keep heap property
    private void heapifyDown(int index, T value) {
        if (heap.size() > index) {
            heap.remove(index);
        }
        heap.add(index, value);

        int size = heap.size();
        while (index < size) {
            int left = index * 2 + 1;
            int right = index * 2 + 2;
            int smallest = index;

            if (left < size && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                smallest = right;
            }

            if (smallest == index) break;

            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        T valJ = heap.get(j);
        heap.remove(j);
        heap.add(j, temp);
        heap.remove(i);
        heap.add(i, valJ);
    }
}
