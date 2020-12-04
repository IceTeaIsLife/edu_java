package Practice_25_26;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomHashTable<Integer, String> hashTable = new CustomHashTable<>();
        for (int i = 1; i <= 5; i++) {
            hashTable.add(i, "value_"+i);
        }
        System.out.println(hashTable.get(3));
        System.out.println(hashTable.remove(4));
        System.out.println(hashTable.get(4));
        for (ArrayList<Node<Integer, String>> value
                : hashTable
             ) {
            if (!value.isEmpty())
            {
                for (Node<Integer, String> integerStringNode : value) {
                    System.out.println(integerStringNode.getKey() + " : " + integerStringNode.getValue());
                }
            }
        }
    }
}
