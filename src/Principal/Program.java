/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Entities.Client;
import Entities.Order;
import Entities.OrderItem;
import Entities.Product;
import Enuns.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author joaov
 */
public class Program {
    public static void main(String[] args) throws ParseException{
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Digite seu nome: ");
        String name = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.next();
        System.out.print("Digite a data em que nasceu(dd/MM/yyyy): ");
        Date birthDate = sdf.parse(sc.next());
        
        Client client = new Client(name, email, birthDate);
        
        System.out.println("Informe dados do pedido: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        
        Order order = new Order(new Date(), status, client);
        
        System.out.print("Quantos itens para esse pedido?: ");      
        int n = sc.nextInt();
        for(int i=1 ; i<=n ; i++){
            System.out.println("Entre com o produto #" + i + ":");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Preço do produto: ");
            double productPrice = sc.nextDouble();
            
            Product product = new Product(productName, productPrice);
            
            System.out.print("Quantidade: ");
            int quantity = sc.nextInt();
            
            OrderItem orderItem = new OrderItem(quantity, productPrice, product);
            
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println("Geral:");
        System.out.println(order);
        
        sc.close();
    }
}
