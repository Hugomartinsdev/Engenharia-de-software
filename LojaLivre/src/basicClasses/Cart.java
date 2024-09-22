package basicClasses;

import java.util.ArrayList;

public class Cart {
    Order clientItens;
    ArrayList<Order>clientOrder;
    public Cart(Order item) {
        this.clientItens = clientItens;//pode até ser em branco que da certo mas ta ai por preucação
        this.clientOrder = new ArrayList<>();
    }

    public void setClientItens(Order clientItens) {
        this.clientItens = clientItens;
    }

    public void addCartToOrder(Order clientOrder){
        clientOrder.addCartToOrder(clientOrder);
    }

    public void showAllProducts(){
       for (Order order : clientOrder) {
        System.out.println(order.toString()+"\n");
       }
    }

    public String toString(){
        return "Carinho: \n Produtos: \n" + clientItens.getAllProducts() + "\n Custo total: " + clientItens.getTotalPrice() +"\n";
    }

    public int getIdProduct() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdProduct'");
    }

    

}
