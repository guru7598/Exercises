package Exercise1;

public class Main {
    public static void main(String[] args) {

        System.out.println("--- Observer Pattern ---");
        NewsPublisher publisher = new NewsPublisher();
        publisher.subscribe(new ConsoleSubscriber("Alice"));
        publisher.subscribe(new ConsoleSubscriber("Bob"));
        publisher.addNews("Java 21 released!");

        System.out.println("\n--- Strategy Pattern ---");
        PaymentStrategy payment1 = new CreditCardPayment("1234-5678");
        PaymentStrategy payment2 = new PaypalPayment("test@example.com");
        payment1.pay(100);
        payment2.pay(200);

        System.out.println("\n--- Singleton Pattern ---");
        ConfigurationManager.getInstance().showConfig();

        System.out.println("\n--- Factory Pattern ---");
        Shape s1 = ShapeFactory.getShape("circle");
        Shape s2 = ShapeFactory.getShape("rectangle");
        s1.draw();
        s2.draw();

        System.out.println("\n--- Adapter Pattern ---");
        MediaPlayer player = new MediaAdapter();
        player.play("vlc", "video.vlc");

        System.out.println("\n--- Decorator Pattern ---");
        Coffee coffee = new MilkDecorator(new SimpleCoffee());
        System.out.println(coffee.description() + " costs $" + coffee.cost());
    }
}
