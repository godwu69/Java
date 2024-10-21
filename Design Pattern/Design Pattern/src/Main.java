public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);

        FoodCreator pizzaCreator = new CreatorPizza();
        pizzaCreator.Eating();

        FoodCreator chipsCreator = new CreatorChips();
        chipsCreator.Eating();
    }
}

