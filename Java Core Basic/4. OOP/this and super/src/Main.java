// this

class Animal {
    String name;

    Animal(String name) {
        this.name = name; // 'this' dùng để phân biệt giữa biến instance và tham số
    }

    void display() {
        System.out.println("Animal name: " + this.name);
    }
}

// super

class Parent {
    Parent() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    Child() {
        super(); // Gọi constructor của class cha
        System.out.println("Child");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Dog");
        animal.display();
        Child child = new Child();
    }
}
