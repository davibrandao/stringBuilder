package run;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String date = sc.nextLine();
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String processing = sc.nextLine();
        Order order = new Order(OrderStatus.valueOf(processing), new Client(name, email, date1));
        System.out.print("How many items to this order? ");
        double items = sc.nextDouble();

        for (int i = 1; i <= items; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            OrderItem orderItem = new OrderItem(productQuantity, productPrice,
                    new Product(productName, productPrice));
            order.addItem(orderItem);
        }
        System.out.println("ORDER SUMMARY: ");
        System.out.println("Order moment: " + order.getMoment());
        System.out.println("Order status: " + order.getStatus());
        System.out.println("Client: " + order.getClient().toString());
        System.out.println("Order items: ");
        for(int i = 0; i < items; i++)
        {
            System.out.println(order.getOrderItems().get(i).toString());
        }


    }
}