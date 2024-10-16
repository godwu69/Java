// Private

//class Parent {
//    private void display() {
//        System.out.println("Parent display");
//    }
//}
//
//class Child extends Parent {
//    // Không thể ghi đè phương thức private
//    // void display() { // Lỗi: display() không thể được truy cập
//    //     System.out.println("Child display");
//    // }
//}

// Static

class Parent {
    static void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {
    static void display() {
        System.out.println("Child display");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent.display();
        Child.display();

        // Gọi thông qua class cha
        Parent parent = new Child();
        parent.display();
    }
}

