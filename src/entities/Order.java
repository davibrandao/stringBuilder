package entities;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {


    private static Date moment = new Date();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static Date getMoment() {
        return moment;
    }

    private Client client;

    public Order(OrderStatus status, Client client) {
        this.status = status;
        this.client = client;
    }

    private OrderStatus status;
    List<OrderItem> orderItems = new ArrayList<OrderItem>();

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Double total() {
        double sum = 0;
        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getPrice();
        }
        return sum;
    }
}
