package f_hash_table;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    private int size = 7; // HashTable 크기
    private HashTableNode[] hashTableMap; //

    // Constructor
    public HashTable() {
        this.hashTableMap = new HashTableNode[size];
    }

    class HashTableNode {
        String key;     // key 값
        Object value;   // value 값
        HashTableNode next; // 다음 노드

        // Constructor
        public HashTableNode(String key, Object value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // Create Hash
    private int hash(String key) {

        int hash = 0;

        // 매개변수 Key를 Char Array로 변환
        char[] keyChars = key.toCharArray();

        // Char Array 하나 하나 해쉬 계산
        for (char keyChar : keyChars) {
            int ascii = keyChar;
            hash = (hash + (ascii * 23)) % this.size;
        }

        // 생성된 Hash를 반환
        return hash;
    }

    // Insert HashTable Data
    public void set(String key, Object value) {

        // 인덱스 생성
        int index = hash(key);

        // 매개변수 key, value로 새로운 노드를 생성
        HashTableNode newNode = new HashTableNode(key, value);

        // Hash Table Map에 데이터가 없다면
        if (this.hashTableMap[index] == null) {
            // 새로운 노드를 할당
            this.hashTableMap[index] = newNode;
        }
        // Hash Table Map에 데이터가 있다면
        else {
            // Hash Table Map의 첫 노드를 tmp로 할당
            HashTableNode tmp = this.hashTableMap[index];
            // 다음 노드가 비어있지 않을때 까지 순환
            while (tmp.next != null) {
                tmp = tmp.next;
            }

            // 다음 노드가 빈 노드를 찾아 다음 노드를 새 노드로 할당
            tmp.next = newNode;
        }
    }

    // Remove HashTable Data
    public boolean remove(String key) {

        // 인덱스 생성
        int index = hash(key);

        // Hash Table Map의 첫 노드를 tmp로 할당
        HashTableNode tmp = this.hashTableMap[index];

        // 다음 노드가 비어있지 않을때 까지 순환
        while (tmp != null) {
            // 노드의 키값이 매개변수의 키 값이랑 같은지 확인
            if (tmp.key.equals(key)) {
                // 노드의 key, value 값 제거
                tmp.key = null;
                tmp.value = null;

                // 다음 노드가 없으면 HashTable Index 제거
                if (tmp.next == null) {
                    this.hashTableMap[index] = null;
                }
                // 다음 노드가 있으면 tmp를 다음 노드로 할당
                else {
                    tmp = tmp.next;
                }

                // 삭제 성공
                return true;
            }

            // 다음 노드로 할당 하여 순환
            tmp = tmp.next;
        }

        // 삭제 실패
        return false;
    }

    // Find HashTable Data
    public Object get(String key) {

        // 인덱스 생성
        int index = hash(key);

        // Hash Table Map의 첫 노드를 tmp로 할당
        HashTableNode tmp = this.hashTableMap[index];

        // 노드가 비어있지 않을때 까지 순환
        while (tmp != null) {

            // 노드의 키값이 매개변수의 키 값이랑 같은지 확인
            if (tmp.key.equals(key)) {
                // 같으면 값 반환
                return tmp.value;
            }

            // 같지 않으면 다음 노드로 할당 하여 순환
            tmp = tmp.next;
        }

        // 없으면 null 리턴
        return null;
    }

    // Find HashTable All Keys
    public List keys() {

        // 빈 ArrayList 생성
        ArrayList keyList = new ArrayList<>();

        // HashTable의 사이즈만큼 순환
        for (int idx = 0; idx < this.size; idx++) {

            // HashTable의 첫 인덱스를 tmp로 할당
            HashTableNode tmp = this.hashTableMap[idx];
            // tmp가 비어있지 않으면 순환
            while (tmp != null) {
                // tmp의 key값을 ArrayList에 추가
                keyList.add(tmp.key);

                tmp = tmp.next;
            }
        }

        // 키 리스트 반환
        return keyList;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(i + ":");
            HashTableNode tmp = hashTableMap[i];
            while (tmp != null) {
                System.out.println("{ " + tmp.key + " = " + tmp.value + " }");
                tmp = tmp.next;
            }
        }
    }
}
