package basicClasses;

public class Card{
    private String nameOwnerCard, numCard, cvvCard, expDateCard,nameCard;
    private boolean cardType;
    
    //Lembrar como faz a comparação para ver que o dono do cartão seja o mesmo do cliente
    //Será que faço var / os cartoes só podem começar com 3,4,5,6
    // botar na opção 1 ou credito depenendo da resposta colocar true ou false,true é credito
    //ver se crio ou aqui ou dentro do main um  String para dizer que esta expirado ou não ou só mando a mensagem

    public Card(String nameOwnerCard, String nameCard,String numCard, String cvvCard, String expDateCard, boolean cardType){
        this.nameOwnerCard = nameOwnerCard;
        this.nameCard = nameCard;
        this.numCard = numCard;
        this.cvvCard = cvvCard;
        this.expDateCard = expDateCard;
        this.cardType = cardType;
    }

    public String getNameOwnerCard(){
        return nameOwnerCard;
    }
    public void setNameOwnerCard(String nameOwnerCard){
        this.nameOwnerCard = nameOwnerCard;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getNumCard(){
        return numCard;
    }
    public void setNumCard(String numCard){
        this.numCard = numCard;
    }

    public String getCvvCard(){
        return cvvCard;
    }
    public void setCvvCard(String cvvCard){
        this.cvvCard = cvvCard;
    }

    public String getCardType(){
        return (cardType ? "Crédito" : "Débito");
    }
    public void setCardType(boolean cardType){
        this.cardType = cardType;
    }

    public String getExpDateCard(){
        return expDateCard;
    }
    public void setExpDateCard(String expDateCard){
        this.expDateCard = expDateCard;
    }

    @Override
    public String toString(){
        return "Cartao: \n Dono: " + nameOwnerCard + " \n Nome do Cartão: " + nameCard+"\n Numero do Cartão: " + numCard + "\n CVV: " + cvvCard + 
        "\n Tipo do Cartão: " + (cardType ? "Credito" : "Debito") + "\n Validade: " + expDateCard + "\n";
    }
    
    
}
