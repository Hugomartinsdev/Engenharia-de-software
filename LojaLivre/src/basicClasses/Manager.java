package basicClasses;

public class Manager{

    private int currentStateMenu;
    private String input;

    public String getInput(){
        return this.input;
    }
    public void setInput(String input){
        this.input = input;
    }

    public int getCurrentStateMenu(){
        return this.currentStateMenu;
    }
    public void initiateMenu(){
        this.currentStateMenu = 0;
    }
    public void increaseMenu(){
        this.currentStateMenu++;
    }
    public void decreaseMenu(){
        this.currentStateMenu = (this.currentStateMenu == 0) ? 0 : this.currentStateMenu - 1;
    }

    public boolean checkIfNull(String input){
        if(input.equals("")){
            System.out.println("\n ERRO: Entrada vazia. \n");
            return false;
        }
        return true;
    }

    public boolean checkSize(String input, int size){
        if(input.length() != size){
            System.out.println("\n ERRO: Quantidade de caracteres incorreta. \n");
            return false;
        }
        return this.checkIfNull(input);
    }

    public boolean checkIfInt(String input){
        try{
            Integer.parseInt(input);
        }catch (Exception e){
            System.out.println("\n ERRO: Somente números permitídos. \n");
            return false;
        }
        if(Integer.parseInt(input) < 0){
            System.out.println("\n ERRO: Valor menor que zero. \n");
            return false;
        }
        return this.checkIfNull(input);
    }

    public boolean checkIfLong(String input){
        try{
            Long.parseLong(input);
        }catch (Exception e){
            System.out.println("\n ERRO: Somente números permitídos. \n");
            return false;
        }
        if(Long.parseLong(input) < 0){
            System.out.println("\n ERRO: Valor menor que zero. \n");
            return false;
        }
        return this.checkIfNull(input);
    }

    public boolean checkIfFloat(String input){
        try{
            Float.parseFloat(input);
        }catch (Exception e){
            System.out.println("\n ERRO: Somente números e ponto permitídos. \n");
            return false;
        }
        if(Float.parseFloat(input) < 0){
            System.out.println("\n ERRO: Valor menor que zero. \n");
            return false;
        }
        return this.checkIfNull(input);
    }
    
}
