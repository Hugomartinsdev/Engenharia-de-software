import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import basicClasses.Card;
import basicClasses.Client;

public class ClientsManager{

    private ArrayList<Client> clientsBank;
    private Client loggedInClient;
    private String input;

    public ClientsManager(){
        this.clientsBank = new ArrayList<>();
        this.loggedInClient = null;
    }

    public void createClient(Scanner sc){
        //var novas para a criação de clente
        String newClientName = "";
        int newClientAge = 0;
        String newClientCpf = "";
        String newClientLogin = "";
        String newClientPass = "";

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
                case 3:
                    System.out.println("Seu login?");
                break;
                case 4:
                    System.out.println("Sua senha? (mínimo 8 caracteres)");
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

            //adquirição dos dados do cliente
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
                        for(Client client : this.clientsBank){
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
                case 3:
                    //garantir que não é vazio
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newClientLogin = this.input;
                    currentState++;
                break;
                case 4:
                    //garantir que não é vazio e seja de tamanho mínimo 8
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    if(this.input.length() < 10){
                        System.out.println("\n ERRO: Poucos caracteres \n");
                    }
                    newClientLogin = this.input;
                    currentState++;
                break;
            }
        }
        clientsBank.add(new Client(newClientName, newClientAge, newClientCpf, newClientLogin, newClientPass));
        System.out.println("Conta criada com sucesso! \n");
    }

    public void createCard(Scanner sc){
        //var novas para a criação do cartão
        String newCardType = "";
        String newCardName = "";
        String newCardNumber = "";
        String newCardCvv = "";
        String newCardExpDate = "";
        int newCardOwnerId = 0;

        int currentState = 0;
        while(currentState != 6){
            //instruções para o usuário
            switch(currentState){
                case 0:
                    System.out.println("Seu cartão é credito ou debito?");
                    System.out.println("C - Credito");
                    System.out.println("D - Debito");
                break;
                case 1:
                    System.out.println("Qual o nome do dono?");
                break;
                case 2:
                    System.out.println("Numero do cartão?");
                break;
                case 3:
                    System.out.println("CVV? (Valor de verificação do cartão)");
                break;
                case 4:
                    System.out.println("Data de validade? (mm/aa)");
                break;
                case 5:
                    System.out.println("Digite o CPF do cliente a receber este cartão: ");
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

            //adquirição dos dados do cartão
            switch(currentState){
                case 0:
                    //garantir que não seja vazio e seja C ou D
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newCardType = this.input;
                    if(!(newCardType.equals("C") || newCardType.equals("D"))){
                        System.out.println("\n ERRO: Entrada inválida. (Apenas C e D)\n");
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
                    newCardName = this.input;
                    currentState++;
                break;
                case 2:
                    //garantir que não seja vazio, seja somente número, 
                    //o número seja sempre tamanho 16/19 e que começe com 3-6
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newCardNumber = this.input;
                    try{
                        Long.parseLong(newCardNumber);
                        if(newCardNumber.length() != 16 && newCardNumber.length() != 19){
                            System.out.println("\n ERRO: Quantidade de dígitos inválida. \n");
                            continue;
                        }
                        if(newCardNumber.charAt(0) < 51 || newCardNumber.charAt(0) > 54){
                            System.out.println("\n ERRO: Número de cartão inválido. \n");
                            continue;
                        }
                        currentState++;
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitidos. \n");
                    }
                break;
                case 3:
                    //garantir que não seja vazio, possua somente números e que seja sempre tamanho 3
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newCardCvv = this.input;
                    try{
                        Integer.parseInt(newCardCvv);
                        if(newCardCvv.length() != 3){
                            System.out.println("\n ERRO: Quantidade de dígitos inválida. \n");
                            continue;
                        }
                        currentState++;
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitidos. \n");
                    }
                break;
                case 4:
                    //garantir que não seja vazio, a data seja sempre padronizada e que nao esteja expirada
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newCardExpDate = "01/" + this.input;
                    //localdate.parse() = formatar pra mm/aa, datimeformatter.ofpattern() = a estrutura da formatacao
                    //localdate.parse().isbefore() = ver se a data formatada é antes da data checada
                    //localdate.now() = data de hoje
                    try{
                        if(LocalDate.parse(newCardExpDate, DateTimeFormatter.ofPattern("dd/MM/yy")).isBefore(LocalDate.now())){
                            System.out.println("\n ERRO: Data de validade expirada. \n");
                            continue;
                        }
                    }catch(Exception e){
                        System.out.println("\n ERRO: Formatação inválida. (Apenas mm/aa permitido) \n");
                        continue;
                    }
                    currentState++;
                break;
                case 5:
                    //garantir que não é vazio, sempre possuir somente números, ser tamanho 11 e não repetir
                    if(this.input.equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    try{
                        Long.parseLong(this.input);
                        if(this.input.length() != 11){
                            System.out.println("\n ERRO: CPF de tamanho inválido. \n");
                            continue;
                        }
                        for(Client client : this.clientsBank){
                            if(client.getCpfClient().equals(this.input)){
                                newCardOwnerId = this.clientsBank.indexOf(client);
                                currentState++;
                                break;
                            }
                        }
                        System.out.println("\n ERRO: Nenhum cliente com este CPF encontrado \n");
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitidos. \n");
                    }
                break;
            }
        }
        this.clientsBank.get(newCardOwnerId).addCards(new Card(newCardName, newCardNumber, newCardCvv, newCardExpDate, (newCardType.equals("C") ? true  : false)));
        System.out.println("Cartão cadastrado com sucesso! \n");
    }

    public void logInClient(Scanner sc){
        String tempLogin = "";
        String tempPass = "";

        int currentState = 0;
        while(currentState != 2){
            switch(currentState){
                case 0:
                    System.out.println("Login: ");
                break;
                case 1:
                    System.out.println("Senha: ");
                    System.out.println("(Digite < para voltar)");
                break;
            }
            this.input = sc.nextLine();
            if(this.input.equals("")){
                System.out.println("\n ERRO: Entrada vazia. \n");
                continue;
            }
            switch(currentState){
                case 0:
                    tempLogin = this.input;
                    currentState++;
                break;
                case 1:
                    if(this.input.equals("<")){
                        currentState--;
                        continue;
                    }
                    tempPass = this.input;
                    for(Client client : clientsBank){
                        if(client.getLoginClient().equals(tempLogin) && client.getPassClient().equals(tempPass)){
                            this.loggedInClient = client;
                            System.out.println("Login confirmado \n");
                            return;
                        }
                    }
                    currentState++;
                break;
            }

        }
    }

    public void getLoggedInClientInfo(){
        System.out.println(this.loggedInClient.toString());
    }
    
}
