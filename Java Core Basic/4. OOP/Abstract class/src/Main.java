abstract class Animal {
    String name;

    // Constructor cho class Animal
    public Animal(String name) {
        this.name = name;
    }

    // Phương thức trừu tượng: các class con phải triển khai
    abstract void makeSound();

    // Phương thức thông thường: có thể sử dụng trực tiếp
    void eat() {
        System.out.println(name + " is eating");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    // Ghi đè phương thức trừu tượng
    @Override
    void makeSound() {
        System.out.println(name + " says: Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Husky");
        dog.eat();       // Kế thừa phương thức từ Animal
        dog.makeSound();
    }
}
