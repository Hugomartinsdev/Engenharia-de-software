package basicClasses;

import java.util.ArrayList;

public class Cart {
    Order clientItems;
    public Cart(Order clientItems) {
        this.clientItems = clientItems;
    }
    
    public void addCartToOrder(){
        
    }
    public Order getClientItems() {
        return clientItems;
    }
    public void setClientItems(Order clientItems) {
        this.clientItems = clientItems;
    }
    
    public void addItensToCart(Product item){
        clientItems.addProductsOrder(item);
    }
    //ligar com talvez com o pedido como object


}
