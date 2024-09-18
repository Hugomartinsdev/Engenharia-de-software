import java.util.Scanner;

public class App{
    static Scanner sc;
    static ClientsManager clientsManager;
    static ProductsManager productsManager;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        char menuInput;

        clientsManager = new ClientsManager();
        productsManager = new ProductsManager();

        do{
            menu();
            menuInput = sc.nextLine().charAt(0);

            switch(menuInput){
                case 'A':
                    clientsManager.createClient(sc);
                break;

                case 'C':
                    clientsManager.createCard(sc);
                break;

                case 'D':
                    System.out.println(tempClient.toString());
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
                    productsManager.createOrder(sc);
                break;

                case 'X':
                    System.out.println("Finalizando...");
                break;

                case 'V':
                    System.out.println(productsManager.tempOrder.toString());
                break;
            
                default:
                    System.out.println("\n ERRO: Comando inválido. \n");
                break;
            }

        }while(menuInput != 'X');

        sc.close();
    }

    public static void menu(){

        System.out.println("-MENU-");
        System.out.println("A: criar conta");
        System.out.println("C: criar cartão e adicionar a conta");
        System.out.println("D: ver dados da conta");
        System.out.println("P: criar produto");
        System.out.println("S: procurar produtos");
        System.out.println("E: apagar produto");
        System.out.println("O: criar pedido");
        System.out.println("V: ver dados do pedido");
        System.out.println("X: sair");
        System.out.println("Digite seu comando:");

    }
}