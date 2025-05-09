package structures;

public class MyHashTable<K, V> {
    public static class HashNode<K, V> {
        private K key;
        private V value;
        public HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int H = 10;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[H];
        size = 0;
    }
    public MyHashTable(int H){
        this.H = H;
        chainArray = new HashNode[H];
        size = 0;
    }
    private int hash(K key){
        return Math.abs(key.hashCode()) % H;
    }
    public void put(K key, V value){
        int index = hash(key);
        HashNode<K,V> head = chainArray[index];

        while (head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = chainArray[index];
        chainArray[index] = newNode;
        size++;
    }
    public V get(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public boolean contains(V value){
        for(int i = 0; i < H; i++){
            HashNode<K, V> current = chainArray[i];
            while(current != null){
                if(current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for(int i = 0; i < H; i++){
            HashNode<K, V> current = chainArray[i];
            while (current != null){
                if (current.value.equals(value)){
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }
    public V remove(K key){
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;

        while (head != null){
            if(head.key.equals(key)){
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null){
            return null;
        }

        size--;

        if(prev != null){
            prev.next = head.next;
        }
        else{
            chainArray[index] = head.next;
        }
        return head.value;
    }

    public HashNode<K, V>[] getChainArray() {
        return chainArray;
    }



}
