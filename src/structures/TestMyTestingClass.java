import structures.*;
import java.util.Random;

public class TestMyTestingClass {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Integer> table = new MyHashTable<>(100);
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(100000);
            String name = "Name" + random.nextInt(1000);
            MyTestingClass obj = new MyTestingClass(id, name);
            table.put(obj, i);
        }

        for (int i = 0; i < 100; i++) {
            int count = 0;
            MyHashTable.HashNode<MyTestingClass, Integer> current = table.getChainArray()[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            System.out.println("Chain " + i + " has " + count + " elements");
        }
    }
}
