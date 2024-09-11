public class Cartao {
    String nomeDono;//Lembrar como faz a comparação para ver que o dono do cartão seja o mesmo do cliente
    String numeroDoCartão;//Será que faço var / os cartoes só podem começar com 3,4,5,6
    String cvv;
    String tipo;// botar na opção 1 ou credito depenendo da resposta colocar true ou false,true é credito
    String validade;//ver se crio ou aqui ou dentro do main um  String para dizer que esta expirado ou não ou só mando a mensagem
    public Cartao(String nomeDono, String numeroDoCartão, String cvv, String tipo, String validade) {
        this.nomeDono = nomeDono;
        this.numeroDoCartão = numeroDoCartão;
        this.cvv = cvv;
        this.tipo = tipo;
        this.validade = validade;
    }
    public String getNomeDono() {
        return nomeDono;
    }
    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }
    public String getNumeroDoCartão() {
        return numeroDoCartão;
    }
    public void setNumeroDoCartão(String numeroDoCartão) {
        this.numeroDoCartão = numeroDoCartão;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String gettipo() {
        return tipo;
    }
    public void settipo(String tipo) {
        this.tipo = tipo;
    }
    public String getValidade() {
        return validade;
    }
    public void setValidade(String validade) {
        this.validade = validade;
    }
    @Override
    public String toString() {
        return "Cartao [nomeDono=" + nomeDono + ", numeroDoCartão=" + numeroDoCartão + ", cvv=" + cvv + ", tipo="
                + tipo + ", validade=" + validade + "]";
    }
    
    
}
