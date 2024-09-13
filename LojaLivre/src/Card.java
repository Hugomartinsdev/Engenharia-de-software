public class Card{
    private String nameOwnerCard, numCard, cvvCard, expDateCard;
    private boolean isCreditCard;
    
    //Lembrar como faz a comparação para ver que o dono do cartão seja o mesmo do cliente
    //Será que faço var / os cartoes só podem começar com 3,4,5,6
    // botar na opção 1 ou credito depenendo da resposta colocar true ou false,true é credito
    //ver se crio ou aqui ou dentro do main um  String para dizer que esta expirado ou não ou só mando a mensagem

    public Card(String nameOwnerCard, String numCard, String cvvCard, String expDateCard, boolean isCreditCard){
        this.nameOwnerCard = nameOwnerCard;
        this.numCard = numCard;
        this.cvvCard = cvvCard;
        this.expDateCard = expDateCard;
        this.isCreditCard = isCreditCard;
    }

    public String getNameOwnerCard(){
        return nameOwnerCard;
    }
    public void setNameOwnerCard(String nameOwnerCard){
        this.nameOwnerCard = nameOwnerCard;
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

    public String getIsCreditCard(){
        return (isCreditCard ? "credito" : "débito");
    }
    public void setIsCredito(boolean isCreditCard){
        this.isCreditCard = isCreditCard;
    }

    public String getExpDateCard(){
        return expDateCard;
    }
    public void setExpDateCard(String expDateCard){
        this.expDateCard = expDateCard;
    }

    @Override
    public String toString(){
        return "Cartao: \n Dono: " + nameOwnerCard + "\n Numero do Cartão: " + numCard + "\n CVV: " + cvvCard + 
               "\n Tipo do Cartão: " + (isCreditCard ? "Credito" : "Debito") + "\n Validade: " + expDateCard + "\n";
    }
    
    
}
