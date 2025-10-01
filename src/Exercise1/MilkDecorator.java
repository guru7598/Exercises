package Exercise1;

public class MilkDecorator implements Coffee {
    private Coffee coffee;
    public MilkDecorator(Coffee coffee) { this.coffee = coffee; }
    @Override
    public double cost() { return coffee.cost() + 2.0; }
    @Override
    public String description() { return coffee.description() + ", Milk"; }
}
