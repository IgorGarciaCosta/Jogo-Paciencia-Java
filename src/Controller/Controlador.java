package Controller;

import java.util.*;
import Models.Baralho;
import Models.Carta;
import java.util.List;

public class Controlador {
    static boolean jogoJaIniciado = false;
    static int numDeCartasDoEstoque = 1;
    static Baralho b = new Baralho();
    static public Stack<Carta> estoqueAtual = new Stack<Carta>();
    static public Stack<Carta> descarteAtual = new Stack<Carta>();
    static public Stack<Carta> fundacao1Atual = new Stack<Carta>();
    static public Stack<Carta> fundacao2Atual = new Stack<Carta>();
    static public Stack<Carta> fundacao3Atual = new Stack<Carta>();
    static public Stack<Carta> fundacao4Atual = new Stack<Carta>();
    static public Stack<Carta> tableau1Atual = new Stack<Carta>();
    static public Stack<Carta> tableau2Atual = new Stack<Carta>();
    static public Stack<Carta> tableau3Atual = new Stack<Carta>();
    static public Stack<Carta> tableau4Atual = new Stack<Carta>();
    static public Stack<Carta> tableau5Atual = new Stack<Carta>();
    static public Stack<Carta> tableau6Atual = new Stack<Carta>();
    static public Stack<Carta> tableau7Atual = new Stack<Carta>();

    private final List<Carta> baralho = b.getBaralho();// coloca o baralho completo no obj baralho.

    public List<Carta> shuffle() {// mistura as cartas antes do jogo começar.
        Collections.shuffle(baralho);
        return baralho;
    }

    public void exibeJogo() {
        if (!jogoJaIniciado) {// se o jogo não tinha já começado, inicializa o baralho e as pilhas.
            // primeiro preenche as pilhas
            prenchePilhas();
        }

        // pega as pilhas do objeto b.
        estoqueAtual = b.getStack("estoque");
        descarteAtual = b.getStack("descarte");
        fundacao1Atual = b.getStack("fundacao1");
        fundacao2Atual = b.getStack("fundacao2");
        fundacao3Atual = b.getStack("fundacao3");
        fundacao4Atual = b.getStack("fundacao4");
        tableau1Atual = b.getStack("tableau1");
        tableau2Atual = b.getStack("tableau2");
        tableau3Atual = b.getStack("tableau3");
        tableau4Atual = b.getStack("tableau4");
        tableau5Atual = b.getStack("tableau5");
        tableau6Atual = b.getStack("tableau6");
        tableau7Atual = b.getStack("tableau7");

        System.out.printf("1 - ESTOQUE == ");
        for (int i = 0; i < estoqueAtual.size(); i++) {
            System.out.printf(" [<>], ");
        }
        System.out.printf("\n2 - DESCARTE == ");
        for (int i = 0; i < descarteAtual.size(); i++) {
            System.out.printf(" [<>], ");
        }
        System.out.printf("\n3 - FUNDACAO1 == ");
        for (int i = 0; i < fundacao1Atual.size(); i++) {
            System.out.printf(" [<>], ");
        }
        System.out.printf("\n4 - FUNDACAO2 == ");
        for (int i = 0; i < fundacao2Atual.size(); i++) {
            System.out.printf(" [<>], ");
        }
        System.out.printf("\n5 - FUNDACAO3 == ");
        for (int i = 0; i < fundacao3Atual.size(); i++) {
            System.out.printf(" [<>], ");
        }
        System.out.printf("\n6 - FUNDACAO4 == ");
        for (int i = 0; i < fundacao4Atual.size(); i++) {
            System.out.printf(" [<>], ");
        }
        System.out.printf("\n7 - TABLEAU1 == ");
        for (int i = 0; i < tableau1Atual.size(); i++) {
            viraPrimeiraCartaDaPilha(tableau1Atual);
        }
        System.out.printf("\n8 - TABLEAU2 == ");
        for (int i = 0; i < tableau2Atual.size(); i++) {
            if (i == tableau2Atual.size() - 1) {
                viraPrimeiraCartaDaPilha(tableau2Atual);
            } else
                System.out.printf(" [<>], ");

        }
        System.out.printf("\n9 - TABLEAU3 == ");
        for (int i = 0; i < tableau3Atual.size(); i++) {
            if (i == tableau3Atual.size() - 1) {
                viraPrimeiraCartaDaPilha(tableau3Atual);
            } else
                System.out.printf(" [<>], ");
        }
        System.out.printf("\n10 - TABLEAU4 == ");
        for (int i = 0; i < tableau4Atual.size(); i++) {
            if (i == tableau4Atual.size() - 1) {
                viraPrimeiraCartaDaPilha(tableau4Atual);
            } else
                System.out.printf(" [<>], ");
        }
        System.out.printf("\n11 - TABLEAU5 == ");
        for (int i = 0; i < tableau5Atual.size(); i++) {
            if (i == tableau5Atual.size() - 1) {
                viraPrimeiraCartaDaPilha(tableau5Atual);
            } else
                System.out.printf(" [<>], ");
        }
        System.out.printf("\n12 - TABLEAU6 == ");
        for (int i = 0; i < tableau6Atual.size(); i++) {
            if (i == tableau6Atual.size() - 1) {
                viraPrimeiraCartaDaPilha(tableau6Atual);
            } else
                System.out.printf(" [<>], ");
        }
        System.out.printf("\n13 - TABLEAU7 == ");
        for (int i = 0; i < tableau7Atual.size(); i++) {
            if (i == tableau7Atual.size() - 1) {
                viraPrimeiraCartaDaPilha(tableau7Atual);
            } else
                System.out.printf(" [<>], ");
        }

    }

    public void viraPrimeiraCartaDaPilha(Stack<Carta> pilhaRecebida) {
        if (!pilhaRecebida.empty()) {
            Carta c = pilhaRecebida.peek();
            c.setFace(true);
            if (c.getHierarquia().equals("numero")) {// se for carta de número.
                System.out.printf(c.getNumero() + " " + c.getNaipe());
            } else if (c.getNumero().equals("sem numero")) {// se for K, D ou J.
                System.out.printf(c.getHierarquia() + " " + c.getNaipe());
            }
        }
    }

    public void prenchePilhas() {// status inicial do jogo
        List<Carta> baralhoMisturado = shuffle();
        int index = 0;
        Carta c = baralhoMisturado.get(index);

        // PREENCHE AS PILHAS
        b.setStack(c, "tableau1");// tableau1
        index++;
        for (int i = 0; i < 2; i++) {// tableau2
            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau2");
            index++;
        }
        for (int i = 0; i < 3; i++) {// tableau3
            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau3");
            index++;
        }
        for (int i = 0; i < 4; i++) {// tableau4
            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau4");
            index++;
        }
        for (int i = 0; i < 5; i++) {// tableau5
            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau5");
            index++;
        }
        for (int i = 0; i < 6; i++) {// tableau6
            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau6");
            index++;
        }
        for (int i = 0; i < 7; i++) {// tableau7
            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau7");
            index++;
        }
        for (int i = 0; i < 24; i++) {// estoque
            c = baralhoMisturado.get(index);
            b.setStack(c, "estoque");
            index++;
        }
        //////
    }

    public void moverCarta() {
        jogoJaIniciado = true;
        Scanner resp = new Scanner(System.in);
        int selecao = 0;
        System.out.println(
                "\nDIGITE DE QUAL PILHA MOVER CARTA:\n\n1 - ESTOQUE\n2 - DESCARTE\n3 - TABLEAU1\n4 - TABLEAU2\n5 - TABLEAU3\n6 - TABLEAU4\n7 - TABLEAU5\n8 - TABLEAU6\n9 - TABLEAU7");
        System.out.printf("\nOpção escolhida: ");

        try {
            selecao = resp.nextInt();
        }

        catch (InputMismatchException e) {
            System.out.println("#Valor inválido. Digite números.\n");
            moverCarta();
        }

        switch (selecao) {
        case 1:
            if (estoqueAtual.empty())
                System.out.println("\nO estoque está vazio. :/");
            else {
                for (int i = 0; i < numDeCartasDoEstoque; i++) {
                    descarteAtual.push(estoqueAtual.pop());
                    System.out.println(estoqueAtual.size());
                }
            }
            break;
        case 2:
        case 3:
        case 4:
        case 5:
        case 6:
        case 7:
        case 8:
        case 9:
        default:
            System.out.println("#Valor inválido");
            moverCarta();

        }

    }

    public void finalizaJogo() {
        jogoJaIniciado = false;
    }

    public void reiniciar() {
        jogoJaIniciado = false;
    }

    public void numDeCartasViradasDoEstoque(int selecaoDeNumDeCartas) {
        numDeCartasDoEstoque = selecaoDeNumDeCartas;
    }

}
