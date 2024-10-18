//Synchronous

public class Main {
    public static void main(String[] args) {
        System.out.println("You are jumping!");
        jump();
        System.out.println("You are doing backflips 10,000 times!!!");
        backFlip();
        System.out.println("You are done!");
    }

    public static void jump(){
        try {
            Thread.sleep(1000);
            System.out.println("You are in the sky!");
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void backFlip(){
        try {
            Thread.sleep(5000);
            System.out.println("You are falling!");
            Thread.sleep(1000);
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}

// Asynchronous

//import java.util.concurrent.CompletableFuture;
//
//public class Main{
//    public static void main(String[] args) {
//        System.out.println("You are starting to run");
//        CompletableFuture<Void> running = CompletableFuture.runAsync(Main::running);
//        System.out.println("You are speeding up to 10,000km/h !!!");
//        CompletableFuture<Void> speedUp = CompletableFuture.runAsync(Main::speedUp);
//
//        CompletableFuture.allOf(running, speedUp).join();
//        System.out.println("You are stopped running");
//
//    }
//
//    public static void running(){
//        try {
//            Thread.sleep(6000);
//            System.out.println("You are slowed down!");
//        } catch (InterruptedException ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public static void speedUp(){
//        try {
//            Thread.sleep(4000);
//            System.out.println("You are out of stamina!");
//        } catch (InterruptedException ex){
//            System.out.println(ex.getMessage());
//        }
//    }
//}

// Synchronized

//public class Main {
//    private int bankBalance = 2000000;
//    public static void main(String[] args) {
//        Main main = new Main();
//        Thread momMoney = new Thread(main::banking);
//        momMoney.setName("Mom");
//        Thread dadMoney = new Thread(main::banking);
//        dadMoney.setName("Dad");
//
//        momMoney.start();
//        dadMoney.start();
//
//        try {
//            momMoney.join();
//            dadMoney.join();
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("Last bank balance: " + main.bankBalance + "$");
//        System.out.println("You are out of money!!!");
//
//    }
//
//    public synchronized void banking() {
//        System.out.println("You banked 1000000$ to " + Thread.currentThread().getName() + " account!");
//        bankBalance -= 1000000;
//        System.out.println("Finished banking money. Current balance: " + bankBalance + "$");
//    }
//}