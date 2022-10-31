package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import static entities.Client.fmt1;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner tec = new Scanner(System.in);

        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String nameClient = tec.nextLine();
        System.out.print("Email: ");
        String email = tec.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = fmt1.parse(tec.nextLine());
        Client c1 = new Client(nameClient,email,birthDate);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(tec.nextLine());

        Order order1 = new Order(new Date(),orderStatus,c1);
        System.out.print("How many items to this order? ");
        int n = tec.nextInt();
        for (int i = 1; i<= n; i++){
            System.out.println("Enter #"+i+" intem data: ");
            tec.nextLine();
            System.out.print("Product name: ");
            String nameProduct = tec.nextLine();
            System.out.print("Product price: ");
            Double priceProduct = tec.nextDouble();
            System.out.print("Quantity: ");
            int quantity = tec.nextInt();
            Product p1 = new Product(nameProduct,priceProduct);
            OrderItem item1 = new OrderItem(quantity,priceProduct,p1);
            order1.addItem(item1);
        }
        System.out.println(order1);

    }
}
