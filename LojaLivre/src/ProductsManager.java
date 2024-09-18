import java.util.ArrayList;
import java.util.Scanner;

import basicClasses.Product;
import basicClasses.Order;

public class ProductsManager{

    private ArrayList<Product> productsBank;
    private String input;
    private int idGen = 0;
    Order tempOrder;

    public ProductsManager(){
        this.productsBank = new ArrayList<>();
    }

    public void createProduct(Scanner sc){
        //var novas para a criação de produto
        String newProductName = "";
        String newSellerName = "";
        String newProductDescrpt = "";
        float newProductPrice = 0;
        int newProductAmount = 0;

        int currentState = 0;
        while(currentState != 5){
            //instruções pro usuário
            switch(currentState){
                case 0:
                    System.out.println("Qual é o nome do produto?");
                break;
                case 1:
                    System.out.println("Nome do vendedor?"); 
                break;
                case 2:
                    System.out.println("Descrição do produto?");
                break;
                case 3:
                    System.out.println("Preço do produto? (R$, divida o centavo com ponto)");
                break;
                case 4:
                    System.out.println("Quantidade do produto?");
                break;
            }
            System.out.println("(Digite < para voltar, X para cancelar)");
    
            this.input = sc.nextLine();

            //input de sair ou voltar
            if(this.input.equals("X")){
                return;
            }else if(this.input.equals("<")){
                currentState = (currentState == 0) ? 0 : currentState - 1;
                continue;
            }

            //adquirição dos valores do produto
            switch(currentState){
                case 0:
                    //garantir que não é vazio
                    newProductName = this.input;
                    if(newProductName.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    currentState++;
                break;
                case 1:
                    //garantir que não é vazio
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newSellerName = this.input;
                    currentState++;
                break;
                case 2:
                    //garantir que não é vazio
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newProductDescrpt = this.input;
                    currentState++;
                break;
                case 3:
                    //garantir que não é vazio, sempre ser float e maior que 0
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    try{
                        newProductPrice = Float.parseFloat(this.input);                        
                        if(newProductPrice < 0){
                            System.out.println("\n ERRO: Preço inválido. (Somente valores maiores que zero permitídos)\n");
                            continue;
                        }
                        currentState++;
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números e ponto permitidos. \n");
                    }
                break;
                case 4:
                    //garantir que não é vazio, sempre ser int e maior que 0
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    try{
                        newProductAmount = Integer.parseInt(this.input);
                        if(newProductAmount < 0){
                            System.out.println("\n ERRO: Quantidade inválida. (Somente valores maiores que zero permitídos)\n");
                            continue;
                        }
                        currentState++;
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitídos. \n");
                    }
                break;
            }
            
        }
        this.productsBank.add(new Product(newProductName, newSellerName, newProductDescrpt, newProductPrice, newProductAmount, idGen++));
        System.out.println("Produto adicionado com sucesso! \n");
    }
    
    public void searchProduct(Scanner sc){
        //garantir que não seja vazio
        while(true){
            System.out.println("Digite o nome do produto: ");
            System.out.println("(Digite X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("\n ERRO: Entrada vazia. \n");
                continue;
            }
            break;
        }

        if(this.input.equals("X")){
            return;
        }

        //checagem de nome
        boolean doesHaveProduct = false;
        for(Product product : productsBank){
            if(product.getNameProduct().contains(this.input)){
                System.out.println(product.toString());
                doesHaveProduct = true;
            }
        }

        if(!doesHaveProduct){
            System.out.println("Nenhum produto com esse nome encontrado \n");
        }

    }

    public void deleteProduct(Scanner sc){
        //garantir que sempre seja int e que não seja vazio
        while(true){
            System.out.println("Digite o ID do produto: ");
            System.out.println("(Digite X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("X")){
                return;
            }
            try{
                if(Integer.parseInt(this.input) < 0){
                    System.out.println("\n ERRO: ID inválido. \n");
                    continue;
                }
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
                continue;
            }

            //checagem de ID
            for(Product product : productsBank){
                if(product.getIdProduct() == Integer.parseInt(this.input)){
                    productsBank.remove(product);
                    System.out.println("Produto removido \n");
                    return;
                }
            }
            System.out.println("\n ERRO: Nenhum produto com esse ID encontrado. \n");
        }
    }

    public void createOrder(Scanner sc){        
        //garantir que não seja vazio
        while(true){
            System.out.println("Digite o endereço a ser entregue: ");
            System.out.println("(Digite X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("\n ERRO: Entrada vazia. \n");
                continue;
            }
            break;
        }

        if(this.input.equals("X")){
            return;
        }

        String newOrderAdress = this.input;
        Order newOrder = new Order(newOrderAdress);
        boolean doesHaveProduct;
        ArrayList<Integer> tempQnt = new ArrayList<>();

        //loop pro usuario colocar mais de 1 produto e escolher quando fechar o pedido
        while(true){
            System.out.println("Digite o ID do produto a ser comprado: ");
            System.out.println("(Digite F para fechar o pedido, X para cancelar)");
            this.input = sc.nextLine();

            if(this.input.equals("F")){
                break;
            }
            if(this.input.equals("X")){
                return;
            }
            try{
                if(Integer.parseInt(this.input) < 0){
                    System.out.println("\n ERRO: ID inválido. \n");
                    continue;
                }
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
                continue;
            }

            doesHaveProduct = false;
            for(Product product : productsBank){
                if(product.getIdProduct() == Integer.parseInt(this.input)){
                    while(true){
                        System.out.println("Digite a quantidade: ");
                        System.out.println("(Quantidade disponível: " + product.getQntProduct() + ")");
                        this.input = sc.nextLine();
                        try{
                            if(Integer.parseInt(this.input) < 1){
                                System.out.println("\n ERRO: Quantidade inválida. \n");
                                continue;
                            }
                            if(product.getQntProduct() < Integer.parseInt(this.input)){
                                System.out.println("\n ERRO: Quantidade indisponível. \n");
                                continue;
                            }
                        }catch(Exception e){
                            System.out.println("\n ERRO: Entrada inválida. \n");
                            continue;
                        }
                        break;
                    }
                    tempQnt.add(Integer.parseInt(this.input));
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
        tempOrder = newOrder;
        System.out.println("Pedido criado!");
    }

    public void showAllProducts(){
        for(Product product : productsBank){
            System.out.println(product.toString() + "\n");
        }
    }

    
}
