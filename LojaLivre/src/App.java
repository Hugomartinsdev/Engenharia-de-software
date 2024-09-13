import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Aqui muda o jeito de escrever a data tem que sr e M no mes
        LocalDate date,dateUser;
        Client buyer;
        Card c;
        Scanner sc = new Scanner(System.in);
        String nd,cvv,nc, vl,nm,cpf;
        boolean cdd;
        int e,vn,tn,age;//por enquanto o id será um cont ou eu faço a pesquisa do cartão,pretendenmos usar um banco de dados e conectar com o cpf

        System.out.println("Qual é o seu nome?");//ver se tem possivel para aceitar acento
        nm=sc.nextLine();
        System.out.println("Sua idade?");
        age=sc.nextInt();
        sc.nextLine();
        System.out.println("CPF");//criar um lenght para CPF>11 caracteres, ou fazer um char de 11
        cpf=sc.nextLine();

        //buyer = new Client(nm, age, cpf);//criação sem cartão

        System.out.println("Seu cartão é credito ou debito?");
        System.out.println("1-Credito");
        System.out.println("2-Debito");

        e=sc.nextInt();
        if(e==1){
            sc.nextLine();
            System.out.println("qual o nome do dono: ");
            nd=sc.nextLine();
            System.out.println("Numero do cartão");//
            nc=sc.nextLine();

            vn=nc.charAt(0);
            tn=nc.length();


            //FAZER O TRATAMENTO DOS DIAS OU TENTAR FAZER OCM QUE PEGUE SO MES E ANO
            if (vn < 51 || vn > 54) {//não pode ser menor que 3 e maior que 6 o primeiro digito do cartão
                System.out.println("Número de cartão invalido"); 
                System.out.println("Por favor digite corretamente o seu número de cartão");  
            }else if(tn != 16 && tn != 19){//eu deixo isso para sinalisar o erro do usario ou não
                System.out.println("Quantidade do numero do cartão errado");
            }
            else if(vn>50 && vn <55 || tn == 16 || tn == 19){
                System.out.println("CVV(Valor de verificação do cartão)");
                cvv=sc.nextLine();
                System.out.println("Data de validade,digitar como no exemplo dd/mm/aaaa");
                vl=sc.nextLine();
                dateUser= LocalDate.parse(vl,formater);
                date= LocalDate.now();
                if(dateUser.isBefore(date)){
                    System.out.println("Cartão com data de validade expirada");
                }else{
                    cdd = true;
                    c = new Card(nd, nc, cvv, vl, cdd);
                    System.out.println(c.toString());
                    System.out.println("Cartão cadastrado com sucesso");
                }    
            }
        }else{
            sc.nextLine();
            System.out.println("qual o nome do cartão");
            nd=sc.nextLine();
            System.out.println("Numero do cartão");
            nc=sc.nextLine();
            vn=nc.charAt(0);
            tn=nc.length();

    //FAZER O TRATAMENTO DOS DIAS OU TENTAR FAZER OCM QUE PEGUE SO MES E ANO

            if (vn < 51 || vn > 54) {//não pode ser menor que 3 e maior que 6,
                System.out.println("Número de cartão invalido"); 
                System.out.println("Por favor digite corretamente o seu número de cartão");  
            }else if(tn != 16 && tn != 19){//eu deixo isso para sinalisar o erro do usario ou não
                System.out.println("Quantidade do numero do cartão errado");
            }
            else if(vn>50 && vn <55 || tn == 16 || tn == 19){
                System.out.println("CVV(Valor de veificação do cartão)");
                cvv=sc.nextLine();
                System.out.println("Data de validade,digitar como no exemplo dd/mm/aaaa");
                vl=sc.nextLine();
                dateUser= LocalDate.parse(vl,formater);
                date= LocalDate.now();
                if(dateUser.isBefore(date)){
                    System.out.println("Cartão com data de validade invalida");
                }else{
                    cdd=false;
                    c= new Card(nd, nc, cvv, vl, cdd);
                    System.out.println(c.toString());
                    System.out.println("Cartão cadastrado com sucesso");

                    buyer = new Client(nm, age, cpf,c);//tentativa de criar usuario com cartão
                    buyer.addCards(c);
                    
                    System.out.println(buyer.getAllCards());//mostra ó os dados do usuario
                    System.out.println("teste\n");
                    System.out.println(buyer.toString());//mostra os dados do usuario e do cartão
                }    
            }
        }
        sc.close();
    }
}