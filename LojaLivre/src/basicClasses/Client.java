package basicClasses;

import java.util.ArrayList;

public class Client{
    private String nameCient, cpfClient, loginClient, passClient;
    private int ageClient;
    private ArrayList<Card> cardsClient;
    private ArrayList<Order> ordersClient;
    private Order cartClient;

    public Client(String nameCient, int ageClient, String cpfClient, String loginClient, String passClient){
        this.nameCient = nameCient;
        this.ageClient = ageClient;
        this.cpfClient = cpfClient;
        this.loginClient = loginClient;
        this.passClient = passClient;
        this.cardsClient = new ArrayList<>();
        this.ordersClient = new ArrayList<>();
        this.cartClient = null;
    }

    public String getNameCient(){
        return nameCient;
    }
    public void setNameCient(String nameClient){
        this.nameCient = nameClient;
    }

    public int getAgeClient(){
        return ageClient;
    }
    public void setAgeClient(int ageClient){
        this.ageClient = ageClient;
    }

    public String getCpfClient(){
        return cpfClient;
    }
    public void setCpfClient(String cpfClient){
        this.cpfClient = cpfClient;
    }

    public String getLoginClient(){
        return loginClient;
    }
    public void setLoginClient(String loginClient){
        this.loginClient = loginClient;
    }

    public String getPassClient(){
        return passClient;
    }
    public void setPassClient(String passClient){
        this.passClient = passClient;
    }

    public ArrayList<Card> getCardsClient(){
        return cardsClient;
    }
    public Card getCardsFromArray(int index){
        return cardsClient.get(index);
    }
    public void addCards(Card newCard){
        this.cardsClient.add(newCard);
    }
    public String getAllCards(){
        String output = "";

        if(cardsClient.size() == 0){
            return "Nenhum cartão disponível";
        }

        for (Card card : cardsClient){
            output += card.toString() + " ";
        }
        return output;
    }

    public ArrayList<Order> getOrdersClient(){
        return ordersClient;
    }
    public Order getOrdersFromArray(int index){
        return ordersClient.get(index);
    }
    public void addOrders(Order newOrder){
        this.ordersClient.add(newOrder);
    }
    public String getAllOrders(){
        String output = "";

        if(ordersClient.size() == 0){
            return "Nenhum pedido disponível";
        }

        for (Order order : ordersClient){
            output += order.toString() + " ";
        }
        return output;
    }


    //para o carrinho
    
    public Order getCartClient(){
        return cartClient;
    }
    public void setCart(Order newCart){
        this.cartClient = newCart;
    }

    @Override
    public String toString(){
        return nameCient + ": \n Idade: " + ageClient + "\n Cpf: " + cpfClient + "\n Cartões: \n " + 
               this.getAllCards() + "\n Pedidos: \n " + this.getAllOrders();
    }

}