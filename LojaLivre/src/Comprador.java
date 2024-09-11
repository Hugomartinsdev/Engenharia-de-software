public class Comprador {
    String nome;
    int idade;
    String cpf;//Será que faço em char?
    int id;//se não der certo crio um ArrayList so para armazenar o cartão do cliente
    public Comprador(String nome, int idade, String cpf,int id) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    @Override
    public String toString() {
        return "Comprador [nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", id=" + id + "]";
    }
}
