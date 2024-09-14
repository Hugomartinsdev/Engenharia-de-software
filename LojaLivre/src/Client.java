import java.util.ArrayList;

public class Client{
    private String nameCient, cpfClient;
    private int ageClient;
    private ArrayList<Card> cardsClient;

    public Client(String nameCient, int ageClient, String cpfCliente) {
        this.nameCient = nameCient;
        this.ageClient = ageClient;
        this.cpfClient = cpfCliente;
        this.cardsClient = new ArrayList<>();
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

    public Card getCartaoFromArray(int index){
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

    @Override
    public String toString(){
        return "Cliente: \n Nome: " + nameCient + "\n Idade: " + ageClient + "\n Cpf: " + cpfClient + "\n Cartões: \n " + 
               this.getAllCards();
    }
}
