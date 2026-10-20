interface MovementStrategy {
    String move();
}

class Walking implements MovementStrategy {
    @Override
    public String move() {
        return "Walking at 5 km/h";
    }
}

class Skateboarding implements MovementStrategy {
    @Override
    public String move() {
        return "Skateboarding at 15 km/h";
    }
}

class Jetpack implements MovementStrategy {
    @Override
    public String move() {
        return "Flying by jetpack at 60 km/h";
    }
}

class Player {
    private final String name;
    private MovementStrategy strategy;

    public Player(String name, MovementStrategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public void setStrategy(MovementStrategy strategy) {
        this.strategy = strategy;
    }

    public void move() {
        System.out.println(name + " is " + strategy.move());
    }
}

public class CityRacer {
    public static void main(String[] args) {
        Player player = new Player("Racer", new Walking());

        System.out.println("Race start");
        player.move();

        player.setStrategy(new Skateboarding());
        player.move();

        player.setStrategy(new Jetpack());
        player.move();

        System.out.println("--- Finish line! ---");
    }
}