// Array List

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        // Them phan tu vao list
        students.add("John");
        students.add("Jane");
        students.add("Bob");

        // Truy cap phan tu dau tien
        System.out.println("First student: " + students.get(0));

        // Cap nhat phan tu
        students.set(0, "OK");

        // Xoa phan tu
        students.remove("OK");

        // Hien thi list
        System.out.println("Student List: " + students);
    }
}

// Linked List

//public class Main {
//    public static void main(String[] args) {
//        LinkedList<String> queue = new LinkedList<>();
//
//        // Them phan tu vao hang doi
//        queue.addLast("Customer A");
//        queue.addLast("Customer B");
//        queue.addLast("Customer C");
//
//        // Lay phan tu dau tien ra khoi hang doi
//        System.out.println("Serve: " + queue.removeFirst());
//
//        // Hien thi hang doi con lai
//        System.out.println("Remaining: " + queue);
//    }
//}

// Vector

//public class Main {
//    public static void main(String[] args) {
//        Vector<String> loggedInUsers = new Vector<>();
//
//        // Them user vao danh sach
//        loggedInUsers.add("John");
//        loggedInUsers.add("Jane");
//        loggedInUsers.add("Bob");
//
//        // Hien thi danh sach
//        System.out.println("Logged in users: " + loggedInUsers);
//
//        // Xoa user
//        loggedInUsers.remove("John");
//
//        // Hien thi user con lai
//        System.out.println("Logged in users after delete: " + loggedInUsers);
//    }
//}

// Stack

//public class Main {
//    public static void main(String[] args) {
//        Stack<String> actions = new Stack<>();
//
//        // Them action vao ngan xep
//        actions.push("Run");
//        actions.push("Speed Up");
//        actions.push("Stop");
//
//        // Thuc hien undo action cuoi cung
//        System.out.println("Undo: " + actions.pop());
//
//        // Hien thi cac action hien tai
//        System.out.println("Current action: " + actions.peek());
//    }
//}