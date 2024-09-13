import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //teste
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("MM-yyyy");//Aqui muda o jeito de escrever a data tem que ser em ingles e M no mes
        LocalDate date,dateUser;
        Cartao c;
        Scanner sc = new Scanner(System.in);
        String nd,cvv,nc,cdd,vl;
        int e,vn,tn;
        //Boolean cd;

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
                    cdd="Credito";//Caso não precise monstrar para o usuario se ele colocou credito ou debito eu boto de volta o true e false
                    c= new Cartao(nd, nc, cvv, cdd, vl);
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
                    cdd="Debito";
                    c= new Cartao(nd, nc, cvv, cdd, vl);
                    System.out.println(c.toString());
                    System.out.println("Cartão cadastrado com sucesso");
                }    
            }
        }
        sc.close();
    }
}
/*DUVIDAS
1-Eu vou ter que criar um Usuario para guardar o Cartão, tipo dentro do codigo metodo de pagamento ter um usuario para guardar os cartões,ou deixa esse metodo independente
1-Eu faço esse tratamento dos dados no final ou na hora do usuario colocar os dados dele,como esta no codigo,e eu não sei se essa ordem vai importar aqui,porque eu como vamos
fazer em uma tela é só a gente fazer com que a ação não seja concluida
2-eu tenho um try catch que foi feito no CHAT gpt para a data de validade, caso ela não seja colocada no formato certo
, mas eu não sei se ele é necessario
3-Linha22, Não sei se tem como dar erro na escrita do cartão
4-Linha 24,Eu falo para o usurio usar o espaço ou se eu faço um tratamento caso as pessoas não coloquem espaço,em gente que não coloca
5-Linha 27,/não era exatamente essa função que e eu queria ela está pegando o ascii eu queria o numero no digitado mesmo, se souberem
6-Linha 30,poderia ser criado uma exceção mas eu não sei fazer isso,ou talvez não precise já que é só a gente fazer a tela não carregar,se me ajudarem a entender como se faz eu crio, caso seja necessario
7-linha 56,Eu falo para o usurario dar espaço ou so na hora de printar eu faço dar espaço, mas da mais trabalho,mas tipo nao vai fazer diferença porque eu coloquei pra caber os dois
8-Eu crio um tratamento de exceção para caso tenha uma letra no numero do cartão
9-linha 61,poderia ser criado uma exceção ou talvez não precise já que é só a gente fazer a tela não carregar
*/
