import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import basicClasses.Client;
import basicClasses.Card;

public class App{

    static Scanner sc;
    static Client tempClient;
    static ProductsManager productsManager;
    public static void main(String[] args){
        
        sc = new Scanner(System.in);
        char menuInput;

        tempClient = new Client(null, 0, null); //cliente temporario pra testar as funções
        productsManager = new ProductsManager();

        do{

            menu();
            menuInput = sc.nextLine().charAt(0);

            switch(menuInput){
                case 'A':
                    createClient();
                break;

                case 'C':
                    createCard();
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
    
    public static void createClient(){
        //adquirição dos valores do cliente
        //garantir que não é vazio
        System.out.println("Qual é o seu nome?");
        String newClientName;
        while(true){
            newClientName = sc.nextLine();
            if(newClientName.equals("")){
                System.out.println("\n ERRO: Entrada vazia. \n");
                continue;
            }
            break;
        }

        //garantir sempre ser int
        int newClientAge;
        while(true){
            System.out.println("Sua idade? (anos)");
            try{
                newClientAge = Integer.parseInt(sc.nextLine());
                if(newClientAge > 99){
                    System.out.println("\n ERRO: Idade inválida. \n");
                    continue;
                }
                break;
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
            }
        }

        //garantir sempre possuir somente números e ser tamanho 11
        String newClientCpf;
        while(true){
            System.out.println("Seu CPF? (somente números)");
            newClientCpf = sc.nextLine();
            try{
                Long.parseLong(newClientCpf);
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
                continue;
            }
            if(newClientCpf.length() == 11){
                break;
            }
            System.out.println("\n ERRO: CPF inválido. \n");
        }

        tempClient = new Client(newClientName, newClientAge, newClientCpf);
        System.out.println("Conta criada com sucesso! \n");
    }

    public static void createCard(){
        //adquirição dos valores do cliente
        
        //garantir que seja C ou D
        String newCardType;
        while(true){
            System.out.println("Seu cartão é credito ou debito?");
            System.out.println("C - Credito");
            System.out.println("D - Debito");
            newCardType = sc.nextLine();
            if(newCardType.equals("C") || newCardType.equals("D")){
                break;
            }
            System.out.println("\n ERRO: Entrada inválida. \n");
        }

        //garantir que não é vazio
        System.out.println("Qual o nome do dono?");
        String newCardName;
        while(true){
            newCardName = sc.nextLine();
            if(newCardName.equals("")){
                System.out.println("\n ERRO: Entrada vazia. \n");
                continue;
            }
            break;
        }
        
        //garantir que o número seja sempre tamanho 16/19, que começe com 3-6 e que possua somente números
        String newCardNumber;
        while(true){
            System.out.println("Numero do cartão?");
            newCardNumber = sc.nextLine();
            try{
                Long.parseLong(newCardNumber);
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
                continue;
            }
            if(newCardNumber.length() != 16 && newCardNumber.length() != 19){
                System.out.println("\n ERRO: Quantidade de dígitos inválida. \n");
                continue;
            }
            if(newCardNumber.charAt(0) < 51 || newCardNumber.charAt(0) > 54){
                System.out.println("\n ERRO: Número de cartão inválido. \n");
                continue;
            }
            break;
        }

        //garantir que possua somente números e que seja sempre tamanho 3
        System.out.println("CVV? (Valor de verificação do cartão)");
        String newCardCvv;
        while(true){
            newCardCvv = sc.nextLine();
            try{
                Integer.parseInt(newCardCvv);
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
                continue;
            }
            if(newCardCvv.length() != 3){
                System.out.println("\n ERRO: Quantidade de dígitos inválida. \n");
                continue;
            }
            break;
        }

        //garantir que a data seja sempre padronizada e que nao esteja expirada
        String newCardExpDate;
        while(true){
            System.out.println("Data de validade? (mm/aa)");
            newCardExpDate = "01/" + sc.nextLine();
            //localdate.parse() = formatar pra mm/aa, datimeformatter.ofpattern() = a estrutura da formatacao
            //localdate.parse().isbefore() = ver se a data formatada é antes da data checada
            //localdate.now() = data de hoje
            try{
                if(LocalDate.parse(newCardExpDate, DateTimeFormatter.ofPattern("dd/MM/yy")).isBefore(LocalDate.now())){
                    System.out.println("\n ERRO: Data de validade expirada. \n");
                    continue;
                }
            }catch(Exception e){
                System.out.println("\n ERRO: Entrada inválida. \n");
                continue;
            }
            break;
        }

        Card newCard = new Card(newCardName, newCardNumber, newCardCvv, newCardExpDate, (newCardType.equals("C") ? true  : false));
        tempClient.addCards(newCard);
        System.out.println("Cartão cadastrado com sucesso! \n");
    }

    public static void menu(){

        System.out.println("-MENU-");
        System.out.println("A: criar conta");
        System.out.println("C: criar cartão e adicionar a conta");
        System.out.println("D: ver dados do cliente");
        System.out.println("P: criar produto");
        System.out.println("S: procurar produtos");
        System.out.println("E: apagar produto");
        System.out.println("O: criar pedido");
        System.out.println("V: ver dados do pedido");
        System.out.println("X: sair");
        System.out.println("Digite seu comando:");

    }
}