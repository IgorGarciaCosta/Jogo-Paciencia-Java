package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Baralho {
    private final List<Carta> listaCartas;
    Stack<Carta> estoque = new Stack<Carta>();
    Stack<Carta> descarte = new Stack<Carta>();
    Stack<Carta> fundacao1 = new Stack<Carta>();
    Stack<Carta> fundacao2 = new Stack<Carta>();
    Stack<Carta> fundacao3 = new Stack<Carta>();
    Stack<Carta> fundacao4 = new Stack<Carta>();
    Stack<Carta> tableau1 = new Stack<Carta>();
    Stack<Carta> tableau2 = new Stack<Carta>();
    Stack<Carta> tableau3 = new Stack<Carta>();
    Stack<Carta> tableau4 = new Stack<Carta>();
    Stack<Carta> tableau5 = new Stack<Carta>();
    Stack<Carta> tableau6 = new Stack<Carta>();
    Stack<Carta> tableau7 = new Stack<Carta>();

    public Baralho() {

        listaCartas = new ArrayList<>();

        String[] naipes = { "Paus", "Ouros", "Copas", "Espadas" };
        int pos = 0;
        Carta c;

        while (pos < 4) {
            for (int i = 2; i <= 10; i++) {
                c = new Carta();
                c.setNumero(i + "");
                c.setNaipe(naipes[pos]);
                listaCartas.add(c);
            }

            c = new Carta();
            c.setHierarquia("J");
            c.setNaipe(naipes[pos]);
            listaCartas.add(c);

            c = new Carta();
            c.setHierarquia("Q");
            c.setNaipe(naipes[pos]);
            listaCartas.add(c);

            c = new Carta();
            c.setHierarquia("K");
            c.setNaipe(naipes[pos]);
            listaCartas.add(c);

            c = new Carta();
            c.setHierarquia("A");
            c.setNaipe(naipes[pos]);
            listaCartas.add(c);

            pos++;
        }
    }

    public void imprimirBaralho() {
        System.out.println("Num. de Cartas:" + listaCartas.size());
        int index = 0;
        while (listaCartas.size() > index) {
            Carta c = listaCartas.get(index);
            System.out.println("Num: " + c.getNumero() + " Hierarq.: " + c.getHierarquia() + " Naipe: " + c.getNaipe());
            index++;
        }
    }

    public List<Carta> getBaralho() {
        return this.listaCartas;
    }

    public Stack<Carta> getStack(String nomeDaStack) {// returna a pilha de cartas de acordo com o nome
        switch (nomeDaStack) {
        case "estoque":
            return estoque;
        case "descarte":
            return descarte;
        case "fundacao1":
            return fundacao1;
        case "fundacao2":
            return fundacao2;
        case "fundacao3":
            return fundacao3;
        case "fundacao4":
            return fundacao4;
        case "tableau1":
            return tableau1;
        case "tableau2":
            return tableau2;
        case "tableau3":
            return tableau3;
        case "tableau4":
            return tableau4;
        case "tableau5":
            return tableau5;
        case "tableau6":
            return tableau6;
        case "tableau7":
            return tableau7;
        }
        return estoque;
    }

    public void setStack(Carta c, String stackDestino) {// recebe a carta e a pilha de destino pra setar a carta lá.
        //Sim, eu me envergonho desse tanto de if, mas o switch bugou, sorry T-T
        if (stackDestino.equals("tableau1")) {
            tableau1.push(c);
        }
        if (stackDestino.equals("tableau2")) {
            tableau2.push(c);
        }
        if (stackDestino.equals("tableau3")) {
            tableau3.push(c);
        }
        if (stackDestino.equals("tableau4")) {
            tableau4.push(c);
        }
        if (stackDestino.equals("tableau5")) {
            tableau5.push(c);
        }
        if (stackDestino.equals("tableau6")) {
            tableau6.push(c);
        }
        if (stackDestino.equals("tableau7")) {
            tableau7.push(c);
        }
        if (stackDestino.equals("estoque")) {
            estoque.push(c);
        }
    }

}
