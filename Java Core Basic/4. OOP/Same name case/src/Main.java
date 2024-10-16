// Case 1: Cùng tên khác kiểu trả về
// interface InterfaceA {
//       int getValue(); // Phương thức trả về kiểu int
// }
// interface InterfaceB {
//       double getValue(); // Phương thức trả về kiểu double
// }

// Cách 1: Đổi tên phương thức
interface InterfaceA {
    int getIntValue(); // Đổi tên phương thức
}

interface InterfaceB {
    double getDoubleValue(); // Đổi tên phương thức
}

class Case1Method1 implements InterfaceA, InterfaceB {
    @Override
    public int getIntValue() { // Triển khai cho InterfaceA
        return 5;
    }

    @Override
    public double getDoubleValue() { // Triển khai cho InterfaceB
        return 5.0;
    }
}

// Cách 2: Tạo cách gọi rõ ràng cho từng interface

interface InterfaceC {
    int getValue(int num1); // Phương thức trả về kiểu int
}

interface InterfaceD {
    double getValue(double num2); // Phương thức trả về kiểu double
}

class Case1Method2 implements InterfaceC, InterfaceD {
    @Override
    public int getValue(int num1) {
        return num1;
    }

    @Override
    public double getValue(double num2) {
        return num2;
    }
}

// Case 2: Cùng tên cùng kiểu trả về

interface InterfaceE {
    int getValue(); // Phương thức trả về kiểu int
}

interface InterfaceF {
    int getValue(); // Phương thức trả về kiểu int
}

class Case2 implements InterfaceE, InterfaceF {
    public int getValue() {
        return 5;
    }
}

public class Main {
    public static void main(String[] args) {
        Case1Method1 c1m1 = new Case1Method1();
        Case1Method2 c1m2 = new Case1Method2();
        Case2 c2 = new Case2();
        System.out.println(c1m1.getIntValue());
        System.out.println(c1m1.getDoubleValue());
        System.out.println(c1m2.getValue(5));
        System.out.println(c1m2.getValue(5.0));
        System.out.println(c2.getValue());
    }
}