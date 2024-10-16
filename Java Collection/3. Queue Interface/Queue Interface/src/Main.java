// Queue Interface

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        // Them phan tu vao hang doi
        queue.offer("Hello");
        queue.offer("World");
        queue.offer("OK");

        // Lay phan tu dau tien ma khong xoa
        System.out.println("First Element: " + queue.peek());

        // Lay va xoa phan tu dau tien
        System.out.println("Get and delete: " + queue.poll());

        // Hien thi hang doi con lai sau khi xoa
        System.out.println("Remaining after delete: " + queue);
    }
}

// Deque Interface

//public class Main {
//    public static void main(String[] args) {
//        Deque<String> deque = new ArrayDeque<>();
//
//        // Them phan tu vao dau va cuoi hang doi
//        deque.addFirst("OK");
//        deque.addFirst("Hello");
//        deque.addLast("World");
//
//        // Lay phan tu dau va cuoi ma khong xoa
//        System.out.println("First Element: " + deque.peekFirst());
//        System.out.println("Last Element: " + deque.peekLast());
//
//        // Lay va xoa phan tu dau tien
//        System.out.println("Delete First Element: " + deque.pollFirst());
//
//        // Lay va xoa phan tu cuoi cung
//        System.out.println("Delete Last Element: " + deque.pollLast());
//
//        // Hien thi phan tu con lai sau khi xoa
//        System.out.println("Deque after delete: " + deque);
//    }
//}

// PriorityQueue trong Queue Interface

//public class Main {
//    public static void main(String[] args) {
//        Queue<Integer> priorityQueue = new PriorityQueue<>();
//
//        // Them phan tu vao hang doi
//        priorityQueue.offer(10);
//        priorityQueue.offer(20);
//        priorityQueue.offer(5);
//        priorityQueue.offer(15);
//
//        // Phan tu co do uu tien cao nhat se duoc lay ra truoc (sap xep tho thu tu tu nhien)
//        System.out.println("Get and delete: " + priorityQueue.poll());
//        System.out.println("Get and delete: " + priorityQueue.poll());
//        System.out.println("Get and delete: " + priorityQueue.poll());
//        System.out.println("Get and delete: " + priorityQueue.poll());
//    }
//}