import java.util.ArrayList;
import java.util.Scanner;

import basicClasses.Product;
import basicClasses.Manager;
import basicClasses.Order;

public class ProductsManager extends Manager{

    private ArrayList<Product> productsBank;
    private int idGen = 1;

    public ProductsManager(){
        this.productsBank = new ArrayList<>();
    }

    public void createProduct(Scanner sc, String sellerName){
        //var novas para a criação de produto
        String newProductName = "";
        String newProductDescrpt = "";
        float newProductPrice = 0;
        int newProductAmount = 0;

        this.initiateMenu();
        while(this.getCurrentStateMenu() != 4){
            //instruções pro usuário
            switch(this.getCurrentStateMenu()){
                case 0:
                    System.out.println("Qual é o nome do produto?");
                break;
                case 1:
                    System.out.println("Descrição do produto?");
                break;
                case 2:
                    System.out.println("Preço do produto? (R$, divida o centavo com ponto)");
                break;
                case 3:
                    System.out.println("Quantidade do produto?");
                break;
            }
            System.out.println("(Digite < para voltar, X para cancelar)");

            this.setInput(sc.nextLine());

            //input de sair ou voltar
            if(this.getInput().equals("X")){
                return;
            }else if(this.getInput().equals("<")){
                this.decreaseMenu();
                continue;
            }

            //adquirição dos valores do produto
            switch(this.getCurrentStateMenu()){
                case 0:
                    //garantir que não é vazio
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }                       
                    newProductName = this.getInput();
                    this.increaseMenu();
                break;
                case 1:
                    //garantir que não é vazio
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }
                    newProductDescrpt = this.getInput();
                    this.increaseMenu();
                break;
                case 2:
                    //garantir que não é vazio, sempre ser float e maior que 0
                    if(!this.checkIfFloat(this.getInput())){
                        continue;
                    }
                    newProductPrice = Float.parseFloat(this.getInput());
                    this.increaseMenu();
                break;
                case 3:
                    //garantir que não é vazio, sempre ser int e maior que 0
                    if(!this.checkIfInt(this.getInput())){
                        continue;
                    }
                    newProductAmount = Integer.parseInt(this.getInput());
                    this.increaseMenu();
                break;
            }
            
        }
        this.productsBank.add(new Product(newProductName, sellerName, newProductDescrpt, newProductPrice, newProductAmount, idGen++));
        System.out.println("Produto adicionado com sucesso! \n");
    }
    
    public void searchProduct(Scanner sc){
        while(true){
            System.out.println("Digite o nome do produto: ");
            System.out.println("(Digite X para cancelar)");
            this.setInput(sc.nextLine());

            if(this.getInput().equals("X")){
                return;
            }

            //garantir que não seja vazio
            if(!this.checkIfNull(this.getInput())){
                continue;
            }
            break;
        }

        //checagem de nome
        boolean doesHaveProduct = false;
        for(Product product : productsBank){
            if(product.getNameProduct().contains(this.getInput())){
                System.out.println(product.toString());
                doesHaveProduct = true;
            }
        }

        if(!doesHaveProduct){
            System.out.println("Nenhum produto com esse nome encontrado \n");
        }
    }

    public void deleteProduct(Scanner sc){
        while(true){
            System.out.println("Digite o ID do produto: ");
            System.out.println("(Digite X para cancelar)");
            this.setInput(sc.nextLine());
            
            if(this.getInput().equals("X")){
                return;
            }
            
            //garantir que não é vazio, sempre see int e maior que 0
            if(this.checkIfInt(getInput())){
                continue;
            }
            break;
        }

        //checagem de ID
        for(Product product : productsBank){
            if(product.getIdProduct() == Integer.parseInt(this.getInput())){
                productsBank.remove(product);
                System.out.println("Produto removido \n");
                return;
            }
        }
        System.out.println("\n ERRO: Nenhum produto com esse ID encontrado. \n");
    }

    public Order createOrder(Scanner sc){        
        while(true){
            System.out.println("Digite o endereço a ser entregue: ");
            System.out.println("(Digite X para cancelar)");
            this.setInput(sc.nextLine());

            if(this.getInput().equals("X")){
                return null;
            }

            //garantir que não seja vazio
            if(!this.checkIfNull(this.getInput())){
                continue;
            }
            break;
        }

        String newOrderAdress = this.getInput();
        Order newOrder = new Order(newOrderAdress);
        boolean doesHaveProduct;
        ArrayList<Integer> tempQnt = new ArrayList<>();

        //loop pro usuario colocar mais de 1 produto e escolher quando fechar o pedido
        while(true){
            System.out.println("Digite o ID do produto a ser comprado: ");
            System.out.println("(Digite F para fechar o pedido, X para cancelar)");
            this.setInput(sc.nextLine());

            if(this.getInput().equals("F")){
                break;
            }
            if(this.getInput().equals("X")){
                return null;
            }

            //garantir que não é vazio, sempre ser int e maior que 0
            if(!checkIfInt(this.getInput())){
                continue;
            }

            doesHaveProduct = false;
            for(Product product : productsBank){
                if(product.getIdProduct() == Integer.parseInt(this.getInput())){
                    while(true){
                        System.out.println("Digite a quantidade: ");
                        System.out.println("(Quantidade disponível: " + product.getQntProduct() + ")");
                        this.setInput(sc.nextLine());

                        //garantir que não é vazio, sempre ser int, maior que 0 e que o produto possua essa quantidade                   
                        if(!this.checkIfInt(this.getInput())){
                            continue;
                        }
                        if(product.getQntProduct() < Integer.parseInt(this.getInput())){
                            System.out.println("\n ERRO: Quantidade indisponível. \n");
                            continue;
                        }
                        break;
                    }
                    tempQnt.add(Integer.parseInt(this.getInput()));
                    newOrder.addProductsOrder(product);
                    doesHaveProduct = true;
                }
            }
            if(!doesHaveProduct){
                System.out.println("\n ERRO: Nenhum produto com esse ID. \n");
            }
        }

        //subtrair os produtos do banco de dados
        for(int i = 0; i < productsBank.size(); i++){
            if(!newOrder.getProductsArray().contains(productsBank.get(i))){
                continue;
            }
            for(int j = 0; j < newOrder.getProductsArray().size(); j++){
                if(!productsBank.get(i).equals(newOrder.getProductsArray().get(j))){
                    continue;
                }
                productsBank.get(i).setQntProduct(productsBank.get(i).getQntProduct() - tempQnt.get(j));

                //abominação. crime. infelizmente tive que recorrer a isso.
                //isso é so um clone mas que altera a quantidade do produto pra ser a quantidade certa
                newOrder.getProductsArray().set(j, new Product(productsBank.get(i).getNameProduct(), productsBank.get(i).getNameSellerProduct(), productsBank.get(i).getDescrptProduct(), 
                                                               productsBank.get(i).getPriceProduct(), tempQnt.get(j), productsBank.get(i).getIdProduct()));
                if(productsBank.get(i).getQntProduct() == 0){
                    productsBank.remove(productsBank.get(i));
                }
                break;
            }
        }
        System.out.println("Pedido criado!");
        return newOrder;
    }

    public void showAllProducts(){
        for(Product product : productsBank){
            System.out.println(product.toString() + "\n");
        }
    }
    
}
