import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Cupcake> cupcakeMenu = new ArrayList<>();
        Cupcake cupcake = new Cupcake();
        Cupcake redvelvet = new RedVelvet();
        Cupcake chocolate = new Chocolate();

        Scanner scan = new Scanner(System.in);
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description: ");
        cupcake.type();

        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = scan.nextLine();
        double price = Double.parseDouble(priceText);
        cupcake.setPrice(price);
        cupcakeMenu.add(cupcake);

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description: ");
        redvelvet.type();

        System.out.println("How much would you like to charge for the chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
        String redPriceText = scan.nextLine();
        double redPrice = Double.parseDouble(redPriceText);
        redvelvet.setPrice(redPrice);
        cupcakeMenu.add(redvelvet);

        System.out.println("We are deciding on the price for our standard cupcake. Here is the description: ");
        chocolate.type();

        System.out.println("How much would you like to charge for the chocolate cupcake? (Input a numerical number taken to 2 decimal places)");
        String choPriceText = scan.nextLine();
        double choPrice = Double.parseDouble(choPriceText);
        chocolate.setPrice(choPrice);
        cupcakeMenu.add(chocolate);


        ArrayList<Drink> drinkMenu = new ArrayList<>();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        System.out.println("We are deciding on the price for our water. Here is the description: ");
        water.type();

        System.out.println("How much would you like to charge for the water? (Input a numerical number taken to 2 decimal places)");
        String waterText = scan.nextLine();
        double waterPrice = Double.parseDouble(waterText);
        water.setPrice(waterPrice);
        drinkMenu.add(water);

        System.out.println("We are deciding on the price for our soda. Here is the description: ");
        soda.type();

        System.out.println("How much would you like to charge for the soda? (Input a numerical number taken to 2 decimal places)");
        String sodaText = scan.nextLine();
        double sodaPrice = Double.parseDouble(sodaText);
        soda.setPrice(sodaPrice);
        drinkMenu.add(soda);

        System.out.println("We are deciding on the price for our milk. Here is the description: ");
        milk.type();

        System.out.println("How much would you like to charge for the milk? (Input a numerical number taken to 2 decimal places)");
        String milkText = scan.nextLine();
        double milkPrice = Double.parseDouble(milkText);
        milk.setPrice(milkPrice);
        drinkMenu.add(milk);

        new Order(cupcakeMenu, drinkMenu);
    }
}

class Cupcake {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void type() {
        System.out.println("A basic, generic cupcake, with vanilla frosting.");
    }

}

class RedVelvet extends Cupcake {
    @Override
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake {
    @Override
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {
    public double price;
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public void type() {
        System.out.println("Water.");
    }
}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of milk.");
    }

    @Override
    public String toString() {
        return "Milk{" +
                "price=" + price +
                '}';
    }
}