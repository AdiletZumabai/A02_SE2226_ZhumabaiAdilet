import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Select a coffee type:");
        System.out.println("1. Espresso");
        System.out.println("2. Latte");
        int choice = scanner.nextInt();

        Coffee coffee;


        if (choice == 1) {
            coffee = new Espresso();
        } else if (choice == 2) {
            coffee = new Latte();
        } else {
            System.out.println("Invalid choice. Defaulting to Espresso.");
            coffee = new Espresso();
        }


        while (true) {
            System.out.println("Do you want to add condiments?");
            System.out.println("1. Milk");
            System.out.println("2. Sugar");
            System.out.println("3. Whip Cream");
            System.out.println("4. Done (Proceed to checkout)");

            int condimentChoice = scanner.nextInt();

            if (condimentChoice == 4) {
                break;
            }

            switch (condimentChoice) {
                case 1:
                    coffee = new Milk(coffee);
                    break;
                case 2:
                    coffee = new Sugar(coffee);
                    break;
                case 3:
                    coffee = new WhipCream(coffee);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }


        System.out.println("Customized Coffee: " + coffee.getDescription() + ", Cost: $" + coffee.cost());


        scanner.close();
    }
}
