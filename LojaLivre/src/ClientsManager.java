import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import basicClasses.Card;
import basicClasses.Client;
import basicClasses.Product;

public class ClientsManager{

    private ArrayList<Client> clientsBank;
    private Client loggedInClient;
    private String input;

    public ClientsManager(){
        this.clientsBank = new ArrayList<>();
    }

    public void createClient(Scanner sc){
        //var novas para a criação de clente
        String newClientName = "";
        int newClientAge = 0;
        String newClientCpf = "";

        int currentState = 0;
        while(currentState != 3){
            //instruções para o usuário
            switch(currentState){
                case 0:
                    System.out.println("Qual é o seu nome?");
                break;
                case 1:
                    System.out.println("Sua idade? (anos)");
                break;
                case 2:
                    System.out.println("Seu CPF? (somente números)");
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

            //adquirição dos valores do cliente
            switch(currentState){
                case 0:
                    //garantir que não é vazio
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newClientName = this.input;
                    currentState++;
                break;
                case 1:
                    //garantir que não é vazio e sempre ser int
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    try{
                        newClientAge = Integer.parseInt(this.input);
                        if(newClientAge > 99){
                            System.out.println("\n ERRO: Idade inválida. (Máximo 99 anos)\n");
                            continue;
                        }
                        currentState++;
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitidos. \n");
                    }
                break;
                case 2:
                    //garantir que não é vazio, sempre possuir somente números, ser tamanho 11 e não repetir
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newClientCpf = this.input;
                    try{
                        Long.parseLong(newClientCpf);
                        if(newClientCpf.length() != 11){
                            System.out.println("\n ERRO: CPF de tamanho inválido. \n");
                            continue;
                        }
                        for(Client client : clientsBank){
                            if(client.getCpfClient().equals(newClientCpf)){
                                System.out.println("\n ERRO: Cliente com esse CPF já existe. \n");
                                continue;
                            }
                        }
                        currentState++;
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitidos. \n");
                    }
                break;
            }
        }
        clientsBank.add(new Client(newClientName, newClientAge, newClientCpf));
        System.out.println("Conta criada com sucesso! \n");
    }

    public void createCard(Scanner sc){
        String newCardType;
        String newCardName;
        String newCardNumber;
        String newCardCvv;
        String newCardExpDate;
        //adquirição dos valores do cliente
        
        //garantir que seja C ou D
        while(true){
            System.out.println("Seu cartão é credito ou debito?");
            System.out.println("C - Credito");
            System.out.println("D - Debito");
            newCardType = sc.nextLine();
            if(newCardType.equals("C") || newCardType.equals("D")){
                break;
            }
            System.out.println("\n ERRO: Entrada inválida. (Apenas C e D)\n");
        }
        
        //garantir que não é vazio
        System.out.println("Qual o nome do dono?");
        while(true){
            newCardName = sc.nextLine();
            if(newCardName.equals("")){
                System.out.println("\n ERRO: Entrada vazia. \n");
                continue;
            }
            break;
        }
        
        //garantir que o número seja sempre tamanho 16/19, que começe com 3-6 e que possua somente números
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
    
}
