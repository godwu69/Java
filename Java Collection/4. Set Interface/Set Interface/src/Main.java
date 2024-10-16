// HashSet

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("World");
        hashSet.add("OK");
        hashSet.add("Hello"); //Them phan tu trung lap

        System.out.println("HashSet: " + hashSet);
    }
}

// LinkedHashSet

//public class Main {
//    public static void main(String[] args) {
//        Set<String> linkedHashSet = new LinkedHashSet<>();
//
//        linkedHashSet.add("Hello");
//        linkedHashSet.add("World");
//        linkedHashSet.add("OK");
//        linkedHashSet.add("Hello"); //Them phan tu trung lap
//
//        System.out.println("LinkedHashSet: " + linkedHashSet);
//    }
//}

// TreeSet

//public class Main {
//    public static void main(String[] args) {
//        Set<String> treeSet = new TreeSet<String>();
//
//        treeSet.add("Hello");
//        treeSet.add("World");
//        treeSet.add("OK");
//        treeSet.add("Hello"); //Them phan tu trung lap
//
//        System.out.println("TreeSet: " + treeSet);
//    }
//}