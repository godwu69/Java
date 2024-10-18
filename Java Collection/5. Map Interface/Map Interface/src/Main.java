// HashMap
// Khong duy tri thu tu chen

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Hello");
        hashMap.put(2, "World");
        hashMap.put(3, null); // Cho phep null gia tri
        hashMap.put(null, "OK"); // Cho phep null key

        System.out.println(hashMap);
    }
}

// LinkedHashMap
// Duy tri thu tu chen

//public class Main {
//    public static void main(String[] args) {
//        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
//
//        linkedHashMap.put(1, "Hello");
//        linkedHashMap.put(2, "World");
//        linkedHashMap.put(3, null); // Cho phep null gia tri
//        linkedHashMap.put(null, "OK"); // Cho phep null key
//
//        System.out.println(linkedHashMap);
//    }
//}

// TreeMap
// Luu tru phan tu theo thu su sap xep, chi cho phep null gia tri

//public class Main {
//    public static void main(String[] args) {
//        TreeMap<Integer, String> treeMap = new TreeMap<>();
//
//        treeMap.put(1, "Hello");
//        treeMap.put(2, "World");
//        treeMap.put(3, null); // Cho phep null gia tri
////        treeMap.put(null, "OK"); // Error: khong cho phep null key
//
//        System.out.println(treeMap);
//    }
//}

// HashTable
// Dong bo hoa, khong cho phep null

//public class Main {
//    public static void main(String[] args) {
//        Hashtable<Integer, String> hashtable = new Hashtable<>();
//
//        hashtable.put(1, "Hello");
//        hashtable.put(2, "World");
////        hashtable.put(3, null); // Error: khong cho phep null gia tri
////        hashtable.put(null, "OK"); // Error: khong cho phep null key
//
//        System.out.println(hashtable);
//    }
//}

// ConcurrentHashMap
// Dong bo hoa trong moi truong da luong voi hieu suat tot hon Hashtable, khong cho phep null

//public class Main {
//    public static void main(String[] args) {
//        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
//
//        concurrentHashMap.put(1, "Hello");
//        concurrentHashMap.put(2, "World");
////        concurrentHashMap.put(3, null); // Error: khong cho phep null gia tri
////        concurrentHashMap.put(null, "OK"); // Error: khong cho phep null key
//
//        System.out.println(concurrentHashMap);
//    }
//}