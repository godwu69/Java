interface Food {
    void use();
}

class Pizza implements Food {
    public void use() {
        System.out.println("Eating Pizza");
    }
}

class Chips implements Food {
    public void use() {
        System.out.println("Eating Chips");
    }
}

abstract class FoodCreator {
    public abstract Food createFood(); // Factory method

    public void Eating() {
        Food food = createFood();
        food.use();
    }
}

class CreatorPizza extends FoodCreator {
    public Food createFood() {
        return new Pizza();
    }
}

class CreatorChips extends FoodCreator {
    public Food createFood() {
        return new Chips();
    }
}