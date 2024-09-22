import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import basicClasses.Card;
import basicClasses.Cart;
import basicClasses.Client;
import basicClasses.Manager;
import basicClasses.Order;
import basicClasses.Product;
import basicClasses.Seller;

public class ClientsManager extends Manager{

    private ArrayList<Client> clientsBank;
    private boolean isLoggedIn;
    private Client loggedInClient;

    public ClientsManager(){
        this.clientsBank = new ArrayList<>();
        this.isLoggedIn = false;
        this.loggedInClient = null;
    }

    public void createClient(Scanner sc){
        //var novas para a criação de clente
        String newClientName = "";
        int newClientAge = 0;
        String newClientCpf = "";
        String newClientLogin = "";
        String newClientPass = "";

        this.initiateMenu();
        while(this.getCurrentStateMenu() != 5){
            //instruções para o usuário
            switch(this.getCurrentStateMenu()){
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

            this.setInput(sc.nextLine());

            //input de sair ou voltar
            if(this.getInput().equals("X")){
                return;
            }else if(this.getInput().equals("<")){
                this.decreaseMenu();
                continue;
            }

            //adquirição dos dados do cliente
            switch(this.getCurrentStateMenu()){
                case 0:
                    //garantir que não é vazio
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }
                    newClientName = this.getInput();
                    increaseMenu();;
                break;
                case 1:
                    //garantir que não é vazio, sempre ser int, maior que 0 e menor que 99
                    if(!this.checkIfInt(this.getInput())){
                        continue;
                    }
                    newClientAge = Integer.parseInt(this.getInput());
                    if(newClientAge > 99){
                        System.out.println("\n ERRO: Idade inválida. (Máximo 99 anos) \n");
                        continue;
                    }
                    this.increaseMenu();
                break;
                case 2:
                    //garantir que não é vazio, sempre possuir somente números, ser tamanho 11 e não repetir
                    if(!this.checkIfLong(this.getInput())){
                        continue;
                    }
                    if(!this.checkSize(this.getInput(), 11)){
                        continue;
                    }
                    newClientCpf = this.getInput();
                    for(Client client : this.clientsBank){
                        if(client.getCpfClient().equals(newClientCpf)){
                            System.out.println("\n ERRO: Cliente com esse CPF já existe. \n");
                            continue;
                        }
                    }
                    this.increaseMenu();
                break;
                case 3:
                    //garantir que não é vazio
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }
                    newClientLogin = this.getInput();
                    this.increaseMenu();
                break;
                case 4:
                    //garantir que não é vazio e seja de tamanho mínimo 8
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }
                    if(!this.checkSize(this.getInput(), 8)){
                        continue;
                    }
                    newClientPass = this.getInput();
                    this.increaseMenu();
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

        this.initiateMenu();
        while(this.getCurrentStateMenu() != 5){
            //instruções para o usuário
            switch(this.getCurrentStateMenu()){
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

            //adquirição dos dados do cartão
            switch(this.getCurrentStateMenu()){
                case 0:
                    //garantir que não seja vazio e seja C ou D
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }
                    newCardType = this.getInput();
                    if(!(newCardType.equals("C") || newCardType.equals("D"))){
                        System.out.println("\n ERRO: Entrada inválida. (Apenas C e D)\n");
                        continue;
                    }
                    this.increaseMenu();
                break;
                case 1:
                    //garantir que não é vazio
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    } 
                    newCardName = this.getInput();
                    this.increaseMenu();
                break;
                case 2:
                    //garantir que não seja vazio, sempre possuir somente números, 
                    //o número seja sempre tamanho 16/19 e que começe com 3-6
                    if(!this.checkIfLong(this.getInput())){
                        continue;
                    }
                    if(!(this.checkSize(this.getInput(), 16) || this.checkSize(this.getInput(), 19))){
                        //pra apagar a duplicação de erro
                        System.out.print(String.format("\033[%dA", 3));
                        System.out.print("\033[2K");
                        continue;
                    }
                    newCardNumber = this.getInput();
                    if(newCardNumber.charAt(0) < 51 || newCardNumber.charAt(0) > 54){
                        System.out.println("\n ERRO: Número de cartão inválido. \n");
                        continue;
                    }
                    this.increaseMenu();
                break;
                case 3:
                    //garantir que não seja vazio, possua somente números e que seja sempre tamanho 3
                    if(this.getInput().equals("")){
                        System.out.println("\n ERRO: Entrada vazia. \n");
                        continue;
                    }
                    newCardCvv = this.getInput();
                    try{
                        Integer.parseInt(newCardCvv);
                        if(newCardCvv.length() != 3){
                            System.out.println("\n ERRO: Quantidade de dígitos inválida. \n");
                            continue;
                        }
                        this.increaseMenu();
                    }catch(Exception e){
                        System.out.println("\n ERRO: Somente números permitidos. \n");
                    }
                break;
                case 4:
                    //garantir que não seja vazio, a data seja sempre padronizada e que nao esteja expirada
                    if(!this.checkIfNull(this.getInput())){
                        continue;
                    }
                    newCardExpDate = "01/" + this.getInput();

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
                    this.increaseMenu();
                break;
            }
        }
        this.loggedInClient.addCards(new Card(newCardName, newCardNumber, newCardCvv, newCardExpDate, (newCardType.equals("C") ? true  : false)));
        System.out.println("Cartão cadastrado com sucesso! \n");
    }

    public void addProductToSeller(Product newProduct){
        if(this.loggedInClient.getClass() == Client.class){
            int tempId = this.clientsBank.indexOf(loggedInClient);
            this.clientsBank.remove(loggedInClient);
            Seller newSeller = new Seller(this.loggedInClient.getNameCient(), this.loggedInClient.getAgeClient(),
            this.loggedInClient.getCpfClient(), this.loggedInClient.getLoginClient(), this.loggedInClient.getPassClient());
            this.clientsBank.add(tempId, newSeller);
            this.loggedInClient = newSeller;
        }

        ((Seller) this.loggedInClient).addProducts(newProduct);

    }

    public void logInClient(Scanner sc){
        String tempLogin = "";
        String tempPass = "";

        this.initiateMenu();
        while(this.getCurrentStateMenu() != 2){
            switch(this.getCurrentStateMenu()){
                case 0:
                    System.out.println("Login: ");
                break;
                case 1:
                    System.out.println("Senha: ");
                break;
            }
            System.out.println("(Digite < para voltar, X para cancelar)");
            this.setInput(sc.nextLine());

            if(this.getInput().equals("X")){
                return;
            }else if(this.getInput().equals("<")){
                this.decreaseMenu();
                continue;
            }

            //garantir que não seja vazio
            if(!this.checkIfNull(this.getInput())){
                continue;
            }

            switch(this.getCurrentStateMenu()){
                case 0:
                    tempLogin = this.getInput();
                    this.increaseMenu();
                break;
                case 1:
                    tempPass = this.getInput();
                    for(Client client : clientsBank){
                        if(client.getLoginClient().equals(tempLogin) && client.getPassClient().equals(tempPass)){
                            this.loggedInClient = client;
                            isLoggedIn = true;
                            System.out.println("Login confirmado \n");
                            return;
                        }
                    }
                    System.out.println("\n ERRO: login ou senha incorretos \n");
                    this.decreaseMenu();
                break;
            }
        }
    }
    
    public void logOut(){
        this.loggedInClient = null;
        this.isLoggedIn = false;
    }

    public void addOrderClient(Order newOrder){
        if(newOrder.equals(null)){
            return;
        }
        this.loggedInClient.addOrders(newOrder);
    }

    public void addProductsCart(Cart newProduct){//teste para adicionar o produto no carrinho
        if(newProduct.equals(null)){
            return;
        }
        this.loggedInClient.addCart(newProduct);
    }

    public void addCartToOrder(Cart newOrder){//para adicionar o carrinho no pedido
        if(newOrder.equals(null)){
            return;
        }
        this.loggedInClient.addCartToOrder(newOrder);
    }

    public void showAllLoggedInOrders(){
        for(Order order : this.loggedInClient.getOrdersClient()){
            System.out.println(order.toString() + "\n");
        }
    }

    public void showAllCartItensLoggedInOrders(){
        for(Cart cart : this.loggedInClient.getCartClient()){
            System.out.println(cart.toString() + "\n");
        }
    }

    public void showOrder(){
        this.loggedInClient.showAllProducts();
    }

    public boolean getIsLoggedIn(){
        return this.isLoggedIn;
    }

    public void getLoggedInClientInfo(){
        System.out.println(this.loggedInClient.toString());
    }

    public String getLoggedInClientName(){
        return this.loggedInClient.getNameCient();
    }

    
}
