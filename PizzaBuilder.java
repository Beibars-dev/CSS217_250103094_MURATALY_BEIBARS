interface Pizza {
    String getDescription();
    double getCost();
}

class PlainPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Plain Dough & Sauce";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

abstract class ToppingDecorator implements Pizza {
    protected final Pizza pizza;

    protected ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}

class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }
}

class Pineapple extends ToppingDecorator {
    public Pineapple(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Pineapple";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }
}

public class PizzaBuilder {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Pineapple(pizza);

        System.out.println("Description: " + pizza.getDescription());
        System.out.printf("Total cost:  $%.2f%n", pizza.getCost());
        
        Pizza doubleCheese = new Cheese(new Cheese(new Olives(new PlainPizza())));
        System.out.println("\nDescription: " + doubleCheese.getDescription());
        System.out.printf("Total cost:  $%.2f%n", doubleCheese.getCost());
    }
}
