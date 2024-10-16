class MyClass {
    final int finalVar = 10;
    final void finalMethod() {
        System.out.println("This is a final method.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Truy cập thuộc tính và phương thức final
        MyClass myClass = new MyClass();
        System.out.println(myClass.finalVar);
        myClass.finalMethod();
    }
}
