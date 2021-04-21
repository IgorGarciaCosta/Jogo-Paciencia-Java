package Models;

public class Carta {
    String hierarquia="numero";//caso seja rei, dama ou valete, recebe o nome
    String numero="sem numero";//caso seja numero, recebe o numero.
    String cor="cor";
    String naipe;//espadas(coração invertido), paus (trevo), copas(coração) e ouros (balão)
    boolean faceUp=false;

    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }
    public boolean getFace(){
        return faceUp;
    }

    public void setFace(boolean face){
        faceUp = face;
    }

    public String getHierarquia(){
        return hierarquia;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public void setHierarquia(String hierarquia){
        this.hierarquia = hierarquia;
    }

    public String getNaipe(){
        return naipe;
    }

    public void setNaipe(String naipe){
        this. naipe = naipe;
    }
    
}
