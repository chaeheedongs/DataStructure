package f_hash_table;

import java.util.List;

public class HashTableTest {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("HashTable Set");
        System.out.println("-----------------------");
        HashTable hashTable = new HashTable();
        hashTable.set("Apple", 1);
        hashTable.set("Banana", 2);
        hashTable.set("Coconut", 3);
        hashTable.print();



        System.out.println();
        System.out.println("HashTable Remove");
        System.out.println("-----------------------");
        boolean isDelete = hashTable.remove("Apple");
        System.out.println("isDelete = " + isDelete);


        System.out.println();
        System.out.println("Find HashTable Value");
        System.out.println("-----------------------");
        System.out.println("find Apple : " + hashTable.get("Apple"));
        System.out.println("find Banana : " + hashTable.get("Banana"));
        System.out.println("find Coconut : " + hashTable.get("Coconut"));
        System.out.println("find Durian : " + hashTable.get("Durian")); // null



        System.out.println();
        System.out.println("Find HashTable Keys");
        System.out.println("-----------------------");
        List keys = hashTable.keys();
        System.out.println("keys = " + keys);
    }
}