public class WhipCream extends CondimentDecorator {
    public WhipCream(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", Whip Cream";
    }

    public double cost() {
        return coffee.cost() + 0.7;
    }
}
