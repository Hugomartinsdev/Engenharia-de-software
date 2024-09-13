import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");//Aqui muda o jeito de escrever a data tem que ser em ingles e M no mes
        LocalDate date,dateUser;
        Card c;
        Scanner sc = new Scanner(System.in);
        String nd,cvv,nc, vl;
        boolean cdd;
        int e,vn,tn;
        //Boolean cd;

        System.out.println("Seu cartão é credito ou debito?");
        System.out.println("1-Credito");
        System.out.println("2-Debito");

        e=sc.nextInt();
        if(e==1){
            sc.nextLine();
            System.out.println("qual o nome do cartão");
            nd=sc.nextLine();
            System.out.println("Numero do cartão");//
            nc=sc.nextLine();

            vn=nc.charAt(0);
            tn=nc.length();

            if (vn < 51 || vn > 54) {//não pode ser menor que 3 e maior que 6 o primeiro digito do cartão
                System.out.println("Número de cartão invalido"); 
                System.out.println("Por favor digite corretamente o seu número de cartão");  
            }else if(tn != 16 && tn != 19){//eu deixo isso para sinalisar o erro do usario ou não
                System.out.println("Quantidade do numero do cartão errado");
            }
            else if(vn>50 && vn <55 || tn == 16 || tn == 19){
                System.out.println("CVV(Valor de verificação do cartão)");
                cvv=sc.nextLine();
                System.out.println("Data de validade,digitar como no exemplo dd-mm-aaaa");
                vl=sc.nextLine();
                dateUser= LocalDate.parse(vl,formater);
                date= LocalDate.now();
                if(dateUser.isAfter(date)){
                    System.out.println("Cartão com data de validade expirada");
                }else{
                    cdd = true;//Caso não precise monstrar para o usuario se ele colocou credito ou debito eu boto de volta o true e false
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
            vn=nc.charAt(0);//não exatamente isso que e queria mas da para usar, ela está pegando o ascii eu queria o numero digitado mesmo
            tn=nc.length();

            if (vn < 51 || vn > 54) {//não pode ser menor que 3 e maior que 6,
                System.out.println("Número de cartão invalido"); 
                System.out.println("Por favor digite corretamente o seu número de cartão");  
            }else if(tn != 16 && tn != 19){//eu deixo isso para sinalisar o erro do usario ou não
                System.out.println("Quantidade do numero do cartão errado");
            }
            else if(vn>50 && vn <55 || tn == 16 || tn == 19){
                System.out.println("CVV(Valor de veificação do cartão)");
                cvv=sc.nextLine();
                System.out.println("Data de validade,digitar como no exemplo dd-mm-aaaa");
                vl=sc.nextLine();
                dateUser= LocalDate.parse(vl,formater);
                date= LocalDate.now();
                if(dateUser.isAfter(date)){
                    System.out.println("Cartão com data de validade invalida");
                }else{
                    cdd=false;
                    c= new Card(nd, nc, cvv, vl, cdd);
                    System.out.println(c.toString());
                    System.out.println("Cartão cadastrado com sucesso");
                }    
            }
        }
        sc.close();
    }
}

