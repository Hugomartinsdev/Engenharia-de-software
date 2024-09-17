package basicClasses;

public class Product{

    private String nameProduct, nameSellerProduct, descrptProduct;
    private float priceProduct;
    private int qntProduct, idProduct;

    public Product(String nameProduct, String nameSellerProduct, String descrptProduct, float priceProduct, int qntProduct, int idProduct){
        this.nameProduct = nameProduct;
        this.nameSellerProduct = nameSellerProduct;
        this.descrptProduct = descrptProduct;
        this.priceProduct = priceProduct;
        this.qntProduct = qntProduct;
        this.idProduct = idProduct;
    }

    public String getNameProduct(){
        return this.nameProduct;
    }
    public void setNameProduct(String nameProduct){
        this.nameProduct = nameProduct;
    }

    public String getNameSellerProduct(){
        return this.nameSellerProduct;
    }
    public void setNameSellerProduct(String nameSellerProduct){
        this.nameSellerProduct = nameSellerProduct;
    }
    
    public String getDescrptProduct(){
        return this.descrptProduct;
    }
    public void setDescrptProduct(String descrptProduct){
        this.descrptProduct = descrptProduct;
    }

    public float getPriceProduct(){
        return this.priceProduct;
    }
    public void setPriceProduct(float priceProduct){
        this.priceProduct = priceProduct;
    }

    public int getQntProduct(){
        return this.qntProduct;
    }
    public void setQntProduct(int qntProduct){
        this.qntProduct = qntProduct;
    }

    public int getIdProduct(){
        return this.idProduct;
    }

    @Override
    public String toString(){
        return this.nameProduct + ": \n Nome do vendedor: " + this.nameSellerProduct + "\n Descrição: "
                + this.descrptProduct + "\n Preço: R$" + this.priceProduct + "\n Quantidade: " 
                + this.qntProduct + "\n ID: " + this.idProduct + "\n";
    }

}
