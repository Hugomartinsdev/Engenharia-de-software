import java.util.ArrayList;

public class Order{

    private ArrayList<Product> productsOrder;
    private String adressOrder;

    public Order(String adressOrder){
        this.productsOrder = new ArrayList<>();
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
    public String getAllProducts(){
        String output = "";

        for (Product product : productsOrder){
            output += product.toString() + " ";
        }
        return output;
    }

    public String getAdressOrder(){
        return adressOrder;
    }
    public void setAdressOrder(String adressOrder){
        this.adressOrder = adressOrder;
    }

    @Override
    public String toString(){
        return "Pedido: \n Produtos: " + getAllProducts() + "\n Endereço de entrega: " + this.adressOrder + "\n";
    }

    
    
}
