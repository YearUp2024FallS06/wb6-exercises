package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

  public static void main(String[] args) {

            // Test Order 1
            Order order1 = new Order(1, "John Doe");
            LineItem item1 = new LineItem(101, "Laptop", 999.99, 1);
            LineItem item2 = new LineItem(102, "Mouse", 19.99, 2);

            order1.addItem(item1);
            order1.addItem(item2);

            System.out.println("Order 1 Total: $" + order1.getTotal()); // Expected: $1039.97

            // Test Order 2
            Order order2 = new Order(2, "Jane Smith");
            LineItem item3 = new LineItem(103, "Desk Chair", 89.99, 1);
            LineItem item4 = new LineItem(104, "Desk Lamp", 29.99, 1);
            LineItem item5 = new LineItem(105, "Monitor", 199.99, 2);

            order2.addItem(item3);
            order2.addItem(item4);
            order2.addItem(item5);

            System.out.println("Order 2 Total: $" + order2.getTotal()); // Expected: $519.96

            // Test Order 3 - Empty Order
            Order order3 = new Order(3, "Alice Johnson");

            System.out.println("Order 3 Total: $" + order3.getTotal()); // Expected: $0.0

            // Test Order 4 - Order with a high quantity of one item
            Order order4 = new Order(4, "Bob Lee");
            LineItem item6 = new LineItem(106, "USB Cable", 5.99, 50);

            order4.addItem(item6);

            System.out.println("Order 4 Total: $" + order4.getTotal()); // Expected: $299.5


            List<Order> allOrders = new ArrayList<>();
            allOrders.add(order1);
            allOrders.add(order2);
            allOrders.add(order3);
            allOrders.add(order4);


            allOrders.stream()
                    .filter( order -> order.getTotal() < 500)
                    .forEach( order -> System.out.println(order));

            System.out.println("-------------------------");




            System.out.println("------------");
            double salesTotal = 0;

// loop through all orders
            for(Order order: allOrders){
                salesTotal += order.getTotal();
            }

            System.out.println("Total: $" + salesTotal);
        }

    }

