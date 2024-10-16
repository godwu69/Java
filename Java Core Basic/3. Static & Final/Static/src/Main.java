class MyClass {
    static int staticVar = 10;
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Truy cập thuộc tính và phương thức static
        System.out.println(MyClass.staticVar);
        MyClass.staticMethod();
    }
}
