package basicClasses;

import java.util.ArrayList;

public class Seller extends Client{
    private ArrayList<Product> productsSeller;

    public Seller(String nameCient, int ageClient, String cpfClient, String loginClient, String passClient){
        super(nameCient, ageClient, cpfClient, loginClient, passClient);
        this.productsSeller = new ArrayList<>();
    }

    public ArrayList<Product> getProductsSeller(){
        return productsSeller;
    }
    public Product getProductsFromArray(int index){
        return productsSeller.get(index);
    }
    public void addProducts(Product newOrder){
        this.productsSeller.add(newOrder);
    }
    public String getAllProducts(){
        String output = "";

        if(productsSeller.size() == 0){
            return "Nenhum produto disponível";
        }

        for (Product product : productsSeller){
            output += product.toString() + " ";
        }
        return output;
    }

    @Override
    public String toString(){
        return super.toString() + "\n Produtos: \n" + this.getAllProducts();
    }
    
}
