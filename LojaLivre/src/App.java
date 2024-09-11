import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");//Aqui muda o jeito de escrever a data tem que ser em ingles
        LocalDate date,dateUser;
        Comprador usuario;
        Cartao c;
        Scanner sc = new Scanner(System.in);
        String n,cp,nd,cvv,nc,cdd,vl;
        int i,e,cont=0,vn,tn;
        //Boolean cd;

       /*  System.out.println("Qual é o seu nome?");//ver se tem possivel para aceitar acento
        n=sc.nextLine();
        System.out.println("Sua idade?");
        i=sc.nextInt();
        sc.nextLine();
        System.out.println("CPF");//criar um lenght para CPF>11 caracteres, ou fazer um char de 11
        cp=sc.nextLine();

        cont++;
        usuario= new Comprador(n, i, cp, cont);
        System.out.println(usuario.toString());
        System.out.println();*/
        System.out.println("Seu cartão é credito ou debito?");
        System.out.println("1-Credito");
        System.out.println("2-Debito");

        e=sc.nextInt();
        if(e==1){
            sc.nextLine();
            System.out.println("qual o nome do cartão");//não sei se tem problema se escrever errado
            nd=sc.nextLine();
            System.out.println("Numero do cartão");//ver se eu falo para o usurio usar o espaço ou se eu faço um tratamento caso as pessoas não coloquem espaço
            nc=sc.nextLine();

            vn=nc.charAt(0);//não exatamente isso que e queria mas da para usar, ela está pegando o ascii eu queria o numero no digitado mesmo
            tn=nc.length();

            if (vn < 51 || vn > 54) {//não pode ser menor que 3 e maior que 6, poderia ser criado uma exceção mas eu não sei fazer isso,ou talvez não precise já que é só a gente fazer a tela não carregar
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
                    cdd="Credito";//Caso não precise escrever eu boto de volta o true e false
                    c= new Cartao(nd, nc, cvv, cdd, vl);
                    System.out.println(c.toString());
                    System.out.println("Cartão cadastrado com sucesso");
                }    
            }
        }else{
            sc.nextLine();
            System.out.println("qual o nome do cartão");
            nd=sc.nextLine();
            System.out.println("Numero do cartão");// tem que fazer aqueles negocio dos numeros de novo e tem que fazer o lenght também e tem que te espaço, eu vou fazer com string, ou so na hora de printar eu faço dar espaço, mas da mais trabalho
            nc=sc.nextLine();
            vn=nc.charAt(0);//não exatamente isso que e queria mas da para usar, ela está pegando o ascii eu queria o numero no digitado mesmo
            tn=nc.length();

            if (vn < 51 || vn > 54) {//não pode ser menor que 3 e maior que 6, poderia ser criado uma exceção mas eu não sei fazer isso,ou talvez não precise já que é só a gente fazer a tela não carregar
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
        //talvez fazer uma variavel toda vez do cadastro para testar a data e comparar com o cartão
        sc.close();
    }
}
/*DUVIDAS
1-Eu faço esse tratamento dos dados no final ou na hora do usuario colocar os dados dele,como esta no codigo,e eu não sei se essa ordem vai importar aqui,porque eu como vamos
fazer em uma tela é só a gente fazer com que a ação não seja concluida
2-eu tenho um try catch que foi feito no CHAT gpt para a data de validade, caso ela não seja colocada no formato certo
, mas eu não sei se ele é necessario
*/
