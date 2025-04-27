package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size;

    private static class Node {
        private Object key;
        private Object value;
        private Node left, right;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public BST() {
        size = 0;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        @SuppressWarnings("unchecked")
        int cmp = ((K) node.key).compareTo(key);
        if (cmp > 0) {
            node.left = put(node.left, key, value);
        } else if (cmp < 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key) {
        Node node = get(root, key);
        if (node == null) return null;
        @SuppressWarnings("unchecked")
        V value = (V) node.value;
        return value;
    }

    private Node get(Node node, K key) {
        if (node == null) return null;
        @SuppressWarnings("unchecked")
        int cmp = ((K) node.key).compareTo(key);
        if (cmp > 0) {
            return get(node.left, key);
        } else if (cmp < 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node node, K key) {
        if (node == null) return null;
        @SuppressWarnings("unchecked")
        int cmp = ((K) node.key).compareTo(key);
        if (cmp > 0) {
            node.left = delete(node.left, key);
        } else if (cmp < 0) {
            node.right = delete(node.right, key);
        } else {
            size--;
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;
            Node t = node;
            node = min(t.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<Entry<K, V>> {
        private Stack<Node> stack = new Stack<>();

        public BSTIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Entry<K, V> next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = stack.pop();
            pushLeft(node.right);
            @SuppressWarnings("unchecked")
            K key = (K) node.key;
            @SuppressWarnings("unchecked")
            V value = (V) node.value;
            return new Entry<>(key, value);
        }
    }
}
