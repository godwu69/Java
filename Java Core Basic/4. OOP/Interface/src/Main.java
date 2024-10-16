interface Swim {
    void swim(); // Phương thức trừu tượng
}

interface MakeSound {
    void makeSound(); // Phương thức trừu tượng
}

class Dog implements Swim, MakeSound {
    String name;

    public Dog(String name) {
        this.name = name;
    }

    // Ghi đè phương thức từ interface Swim
    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }

    // Ghi đè phương thức từ interface MakeSound
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Husky");
        dog.swim();
        dog.makeSound();
    }
}
