import structures.BST;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();

        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");
        tree.put(6, "Six");
        tree.put(8, "Eight");

        System.out.println("In-order traversal:");
        for (var elem : tree) {
            System.out.println("Key: " + elem.getKey() + ", Value: " + elem.getValue());
        }

        System.out.println("Testing get:");
        System.out.println(tree.get(5));
        System.out.println(tree.get(8));
        System.out.println(tree.get(10));

        System.out.println("Testing delete:");
        tree.delete(7);
        for (var elem : tree) {
            System.out.println("Key: " + elem.getKey() + ", Value: " + elem.getValue());
        }

        System.out.println("Tree size after deletion: " + tree.size());
    }
}

