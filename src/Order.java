import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Object> order = new ArrayList<>();

        System.out.println("Hello, would you like to place an order? (y/n)");
        String placeOrder = scan.nextLine();


        if (placeOrder.equalsIgnoreCase("y")) {
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu:");
            int itemNum = 0;

            System.out.println("CUPCAKES:");
            for (Cupcake cupcake : cupcakeMenu) {
                itemNum++;

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(itemNum + ":");
                cupcake.type();
                System.out.println("Price:" + cupcake.getPrice());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            for (Drink menu : drinkMenu) {
                itemNum++;

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(itemNum + ":");
                menu.type();
                System.out.println("Price:" + menu.getPrice());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }

            boolean ordering = true;
            while (ordering) {
                System.out.println();
                System.out.println("What would you like to order? Please use the number associated with each item to order.");
                int orderChoice = scan.nextInt();
                scan.nextLine();

                if (orderChoice == 1) {
                    order.add(cupcakeMenu.getFirst());
                    System.out.println("Item added to order.");

                } else if (orderChoice == 2) {
                    order.add(cupcakeMenu.get(1));
                    System.out.println("Item added to order.");

                } else if (orderChoice == 3) {
                    order.add(cupcakeMenu.get(2));
                    System.out.println("Item added to order.");

                } else if (orderChoice == 4) {
                    order.add(drinkMenu.getFirst());
                    System.out.println("Item added to order.");

                } else if (orderChoice == 5) {
                    order.add(drinkMenu.get(1));
                    System.out.println("Item added to order.");

                } else if (orderChoice == 6) {
                        order.add(drinkMenu.get(2));
                    System.out.println("Item added to order.");

                } else {
                    System.out.println("Sorry, this item is not on the menu.");
                }

                System.out.println("Would you like to continue ordering? (y/n)");
                String stillOrder = scan.nextLine();
                if (stillOrder.equalsIgnoreCase("n")) {
                    ordering = false;
                }
            }

            System.out.println(order.getFirst());
            System.out.println(order.get(1));
            double subtotal = 0;

            System.out.println(order.size());

            for (int i = 2; i < order.size(); i++) {
                if (order.get(i).equals(cupcakeMenu.getFirst())) {
                    subtotal += cupcakeMenu.getFirst().getPrice();
                    cupcakeMenu.getFirst().type();
                    System.out.println("Price: $" + cupcakeMenu.getFirst().getPrice());

                } else if (order.get(i).equals(cupcakeMenu.get(1))) {
                    subtotal += cupcakeMenu.get(1).getPrice();
                    cupcakeMenu.get(1).type();
                    System.out.println("Price: $" + cupcakeMenu.get(1).getPrice());

                } else if (order.get(i).equals(cupcakeMenu.get(2))) {
                    subtotal += cupcakeMenu.get(2).getPrice();
                    cupcakeMenu.get(2).type();
                    System.out.println("Price: $" + cupcakeMenu.get(2).getPrice());

                } else if (order.get(i).equals(drinkMenu.getFirst())) {
                    subtotal += drinkMenu.getFirst().getPrice();
                    drinkMenu.getFirst().type();
                    System.out.println("Price: $" + drinkMenu.getFirst().getPrice());

                } else if (order.get(i).equals(drinkMenu.get(1))) {
                    subtotal += drinkMenu.get(1).getPrice();
                    drinkMenu.get(1).type();
                    System.out.println("Price: $" + drinkMenu.get(1).getPrice());

                } else if (order.get(i).equals(drinkMenu.get(2))) {
                    subtotal += drinkMenu.get(2).getPrice();
                    drinkMenu.get(2).type();
                    System.out.println("Price: $" + drinkMenu.get(2).getPrice());

                } else {
                    System.out.println("Broken");
                }
            }

            System.out.println("Subtotal: $" + subtotal);
            new CreateFile();
            new WriteToFile(order);

        } else {
            System.out.println("LOL, ok.");
        }

    }
}

class CreateFile {
   public CreateFile() {
        try {
            File salesData = new File("saleData.txt");
            if (salesData.createNewFile()) {
                System.out.println("File created: " + salesData.getName());
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Uh oh");
        }
    }

}

class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try {
            FileWriter fw = new FileWriter("saleData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);

            for (int i = 0; i < order.size(); i++) {
                salesWriter.println(order.get(i).toString());
            }

            salesWriter.close();
            System.out.println("Successfully wrote to the file");

        } catch (IOException e) {
            System.out.println("Oopsies");
        }
    }
}
