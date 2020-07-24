/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import Enuns.OrderStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
/**
 *
 * @author joaov
 */

public class Order {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    private Date moment;
    private OrderStatus status;
    private Client client;
    
    private List<OrderItem> itens = new ArrayList<>();
    
    public Order(){
    }
    public Order(Date moment, OrderStatus status, Client client){
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
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }    
    public List<OrderItem> getItens() {
        return itens;
    }
    
    public void addItem(OrderItem item){
        itens.add(item);
    }
    public void removeItem(OrderItem item){
        itens.remove(item);
    }
    public Double total(){
        double soma = 0.0;
        for (OrderItem x: itens){
            soma += x.subTotal();
        }   
        return soma;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Status do pedido: ");
        sb.append(status + "\n");
        sb.append("Cliente: " + client + "\n");
        sb.append("Ordem de itens: \n");
        for(OrderItem x: itens){
            sb.append(x + "\n");
        }
        sb.append("Valor total: R$" + String.format("%.2f", total()));
        
        return sb.toString();
    }
    
    
    
    
}
