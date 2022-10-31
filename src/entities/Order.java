package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    public static SimpleDateFormat fmt2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> item = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

   public void addItem(OrderItem item){
        this.item.add(item);
   }
   public void removeItem(OrderItem item){
        this.item.add(item);
   }
   public Double total(){
        Double sum = 0.0;
        for (OrderItem c: item){
            sum += c.subTotal();
        }
       return sum;
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: ");
        sb.append(fmt2.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client +"\n");
        sb.append("Order items: \n");
        for (OrderItem c : item) {
            sb.append(c+"\n");
        }
        sb.append("Total price: $" + String.format("%.2f",total()));
        return sb.toString();
    }
}
