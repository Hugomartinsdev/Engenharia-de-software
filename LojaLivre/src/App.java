import java.util.Scanner;

public class App{
    static Scanner sc;
    static ClientsManager clientsManager;
    static ProductsManager productsManager;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        char menuInput = '.';

        clientsManager = new ClientsManager();
        productsManager = new ProductsManager();
        do{
            if(!clientsManager.getIsLoggedIn()){
                System.out.println("\n Bem vindo á Loja Livre!");
                System.out.println("Quer fazer login ou cadastrar conta?");
                System.out.println("(L: login | C: cadastro)");
                String tempInput = sc.nextLine();

                if(tempInput.equals("L")){
                    clientsManager.logInClient(sc);
                }else if(tempInput.equals("C")){
                    clientsManager.createClient(sc);
                }else{
                    System.out.println("\n ERRO: Entrada inválida. (Apenas L e C) \n");
                }
                continue;
            }

            menu();
            menuInput = sc.nextLine().charAt(0);

            switch(menuInput){
                case 'C':
                    clientsManager.createCard(sc);
                break;

                case 'D':
                    clientsManager.getLoggedInClientInfo();
                break;

                case 'P':
                    productsManager.createProduct(sc);
                break;

                case 'S':
                    productsManager.searchProduct(sc);
                break;

                case 'E':
                    productsManager.deleteProduct(sc);
                break;

                case 'O':
                    //clientsManager.addOrderClient(productsManager.createOrder(sc)); eu apaguei ela
                break;

                case 'X':
                    System.out.println("Finalizando...");
                break;

                case 'V':
                    clientsManager.showAllLoggedInOrders();
                break;

                case 'L':
                    clientsManager.logOut();
                break;

                case 'B':
                    clientsManager.addProductsCart(productsManager.createCartOrder(sc));
                break;

                case 'T':
                    clientsManager.showAllCartItensLoggedInOrders();

                case 'H':
                    //Fazer
            
                default:
                    System.out.println("\n ERRO: Comando inválido. \n");
                break;
            }

        }while(menuInput != 'X');

        sc.close();
    }

    public static void menu(){

        System.out.println("-MENU-");
        System.out.println("C: criar cartão e adicionar a conta");
        System.out.println("D: ver dados da conta");
        System.out.println("P: criar produto");
        System.out.println("S: procurar produtos");
        System.out.println("E: apagar produto");
        System.out.println("B: adicionar produto ao carrinho");//criação para ser colocado no carrinho o pedido
        System.out.println("T: ver carrinho");//criação para ver o carrinho
        System.out.println("H: Apagar item do carrinho");
        System.out.println("O: criar pedido");//modificação para o carrinho ser colocado ai,que no caso seria a opção comprar,ainda não feita
        System.out.println("V: ver pedidos da conta");
        System.out.println("L: deslogar da conta");
        System.out.println("X: sair");
        System.out.println("Digite seu comando:");

    }
}