// Create Thread

// Case 1: Ke thua class Thread

public class Main {
    public static void main(String[] args) {
        SheepCounter sheepCounter = new SheepCounter();
        sheepCounter.start();
    }
}

class SheepCounter extends Thread {
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Sheep No." + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

// Case 2: Realizing Runnable Interface

//public class Main {
//    public static void main(String[] args) {
//        Thread thread = new Thread(new SheepCounter());
//        thread.start();
//    }
//}
//
//class SheepCounter implements Runnable {
//    public void run() {
//        for (int i = 0; i <= 10; i++) {
//            System.out.println("Sheep No." + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
//}

// Multi-Thread

//class SheepCounter extends Thread {
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Sheep No." + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//    }
//}
//
//class SomeThingCounter extends Thread {
//    public void run() {
//        for (int i = 1; i <= 10; i++) {
//            System.out.println("Something No." + i);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        SheepCounter sheepCounter = new SheepCounter();
//        SomeThingCounter someThingCounter = new SomeThingCounter();
//
//        sheepCounter.start();
//        someThingCounter.start();
//    }
//}