import java.util.ArrayList;
import java.util.Scanner;

public class ProductsManager{

    private ArrayList<Product> productsBank;
    private String input;
    private int idGen = 0;

    public ProductsManager(){
        this.productsBank = new ArrayList<>();
    }

    public void createProduct(Scanner sc){
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
                    System.out.println("Preço do produto? (R$)");
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
                    while(true){
                        newProductName = this.input;
                        if(newProductName.equals("")){
                            System.out.println("ERRO: Entrada inválida.");
                            continue;
                        }
                        currentState++;
                        break;
                    }  
                break;
            
                case 1:
                    //garantir que não é vazio
                    while(true){
                        newSellerName = this.input;
                        if(newSellerName.equals("")){
                            System.out.println("ERRO: Entrada inválida.");
                            continue;
                        }
                        currentState++;
                        break;
                    }
                break;

                case 2:
                    //garantir que não é vazio
                    while(true){
                        newProductDescrpt = this.input;
                        if(newProductDescrpt.equals("")){
                            System.out.println("ERRO: Entrada inválida.");
                            continue;
                        }
                        currentState++;
                        break;
                    }
                break;
                
                case 3:
                    //garantir sempre ser float e maior que 0
                    while(true){
                        try{
                            newProductPrice = Float.parseFloat(this.input);
                            if(newProductPrice < 0){
                                System.out.println("ERRO: Preço inválido.");
                                continue;
                            }
                            currentState++;
                            break;
                        }catch(Exception e){
                            System.out.println("ERRO: Entrada inválida.");
                        }
                    }
                break;
                
                case 4:
                    //garantir sempre ser int e maior que 0
                    while(true){
                        try{
                            newProductAmount = Integer.parseInt(this.input);
                            if(newProductAmount < 0){
                                System.out.println("ERRO: Quantidade inválida.");
                                continue;
                            }
                            currentState++;
                            break;
                        }catch(Exception e){
                            System.out.println("ERRO: Entrada inválida.");
                        }
                    }
                break;
            }
            
        }
        
        Product newProduct = new Product(newProductName, newSellerName, newProductDescrpt, newProductPrice, newProductAmount, idGen);
        idGen++;
        this.productsBank.add(newProduct);
        System.out.println("Produto adicionado com sucesso! \n");
    }
    
    public void searchProduct(Scanner sc){
        //garantir que não seja vazio
        while(true){
            System.out.println("Digite o nome do produto: ");
            System.out.println("(Digite X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("ERRO: Entrada vazia.");
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
        //garantir que não seja vazio
        while(true){
            System.out.println("Digite o ID do produto: ");
            System.out.println("(Digite X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("ERRO: Entrada vazia.");
                continue;
            }
            break;
        }

        if(this.input.equals("X")){
            return;
        }

        //checagem de ID
        for(Product product : productsBank){
            if(product.getIdProduct() == Integer.parseInt(this.input)){
                System.out.println("Produto removido \n");
                return;
            }
        }
        System.out.println("Nenhum produto com esse ID encontrado \n");

    }

    public void createOrder(Scanner sc){        
        //garantir que não seja vazio
        while(true){
            System.out.println("Digite o endereço a ser entregue: ");
            System.out.println("(Digite X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("ERRO: Entrada vazia.");
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

        while(true){
            System.out.println("Digite o ID do produto a ser comprado: ");
            System.out.println("(Digite F para fechar o pedido, X para cancelar)");
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("ERRO: Entrada vazia.");
                continue;
            }
            if(this.input.equals("F")){
                break;
            }
            if(this.input.equals("X")){
                return;
            }
            doesHaveProduct = false;
            for(Product product : productsBank){
                if(product.getIdProduct() == Integer.parseInt(this.input)){
                    while(true){
                        System.out.println("Digite a quantidade: ");
                        System.out.println("(Quantidade disponível: " + product.getQntProduct() + ")");
                        this.input = sc.nextLine();
                        if(this.input.equals("")){
                            System.out.println("ERRO: Entrada vazia.");
                            continue;
                        }
                        try{
                            Integer.parseInt(this.input);
                        }catch(Exception e){
                            System.out.println("Entrada inválida.");
                            continue;
                        }
                        break;
                    }
                    newOrder.addProductsOrder(product);
                    doesHaveProduct = true;
                }
            }
            if(!doesHaveProduct){
                System.out.println("ERRO: Nenhum produto com esse ID.");
            }
        }

    }

    public void showAllProducts(){
        for(Product product : productsBank){
            System.out.println(product.toString() + "\n");
        }
    }

    
}
