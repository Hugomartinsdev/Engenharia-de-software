package basicClasses;

import java.util.ArrayList;

public class Order{

    private ArrayList<Product> productsOrder;
    private String adressOrder;
    private ArrayList<Product> productsCart;

    public Order(String adressOrder){
        this.productsOrder = new ArrayList<>();
        this.productsCart = new ArrayList<>();
        this.adressOrder = adressOrder;
    }

    public ArrayList<Product> getProductsOrder(){
        return productsOrder;
    }
    public Product getProductsFromArray(int index){
        return productsOrder.get(index);
    }
    public void addProductsOrder(Product newProduct){
        this.productsOrder.add(newProduct);
    }
    public ArrayList<Product> getProductsArray(){
        return this.productsOrder;
    }
    public String getAllProducts(){
        String output = "";
        for(Product product : productsOrder){
            output += product.toString() + " ";
        }
        return output;
    }
    public float getTotalPrice(){
        float output = 0;
        for(Product product : productsOrder){
            output += product.getPriceProduct() * product.getQntProduct();
        }
        return output;
    }
    
    public void setAdressOrder(String adressOrder){
        this.adressOrder = adressOrder;
    }
    
    
    //Carrinho
    public ArrayList<Product> getProductsCart() {
        return productsCart;
    }

    public Product getProductsFromArrayCart(int index){
        return productsCart.get(index);
    }

    public void addProductsCart(Product newProduct){
        this.productsCart.add(newProduct);
    }

    public String getAllProductsToCart(){
        String output = "";
        for(Product product : productsCart){
            output += product.toString() + " ";
        }
        return output;
    }
    
    public ArrayList<Product> getProductsArrayCart(){
        return this.productsCart;
    }

    public float getTotalPriceToCart(){
        float output = 0;
        for(Product product : productsCart){
            output += product.getPriceProduct() * product.getQntProduct();
        }
        return output;
    }

    @Override
    public String toString(){
        return "Pedido: \n Produtos: " + this.getAllProducts() + "\n Custo total: " + this.getTotalPrice() + "\n Endereço de entrega: " + this.adressOrder + "\n";
    }

}
