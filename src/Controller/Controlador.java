package Controller;

import java.util.Stack;
import java.util.*;
import Models.Baralho;
import Models.Carta;
import java.util.List;

public class Controlador {
    static public boolean jogoJaIniciado = false;
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

    public List<Carta> shuffle() {// mistura as cartas antes do jogo começar.
        b = new Baralho();
        final List<Carta> baralho = b.getBaralho();// coloca o baralho completo no obj baralho.
        Collections.shuffle(baralho);
        return baralho;
    }

    public void exibeCartaTableau(Carta carta, Stack<Carta> tableauAtual, int i) {
        if (!carta.getFace()) {
            System.out.printf("[<>], ");
        } else {
            // carta = (Carta) tableauAtual.get(i - 1);
            viraPrimeiraCartaDaPilha(carta);
            System.out.printf(", ");
        }
    }

    public void exibeJogo() {
        if (!jogoJaIniciado) {// se o jogo não tinha já começado, inicializa o baralho e as pilhas.
            setStatusDeInicio(true);
            // primeiro preenche as pilhas
            preenchePilhas();
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
            Carta c = descarteAtual.get(i);
            viraPrimeiraCartaDaPilha(c);
            System.out.printf(", ");
        }

        System.out.printf("\n3 - FUNDACAO1 == ");

        for (int i = 0; i < fundacao1Atual.size(); i++) {
            Carta c = fundacao1Atual.get(i);
            viraPrimeiraCartaDaPilha(c);
            System.out.printf(", ");
        }
        System.out.printf("\n4 - FUNDACAO2 == ");
        for (int i = 0; i < fundacao2Atual.size(); i++) {
            Carta c = fundacao2Atual.get(i);
            viraPrimeiraCartaDaPilha(c);
            System.out.printf(", ");
        }
        System.out.printf("\n5 - FUNDACAO3 == ");
        for (int i = 0; i < fundacao3Atual.size(); i++) {
            Carta c = fundacao3Atual.get(i);
            viraPrimeiraCartaDaPilha(c);
            System.out.printf(", ");
        }
        System.out.printf("\n6 - FUNDACAO4 == ");
        for (int i = 0; i < fundacao4Atual.size(); i++) {
            Carta c = fundacao4Atual.get(i);
            viraPrimeiraCartaDaPilha(c);
            System.out.printf(", ");
        }

        System.out.printf("\n7 - TABLEAU1 == ");
        Carta c = (Carta) tableau1Atual.get(0);
        viraPrimeiraCartaDaPilha(c);
        System.out.printf(", ");

        System.out.printf("\n8 - TABLEAU2 == ");

        for (int i = 0; i < tableau2Atual.size(); i++) {
            Carta carta = (Carta) tableau2Atual.get(i);
            exibeCartaTableau(carta, tableau2Atual, i);
        }

        System.out.printf("\n9 - TABLEAU3 == ");
        for (int i = 0; i < tableau3Atual.size(); i++) {
            Carta carta = (Carta) tableau3Atual.get(i);
            exibeCartaTableau(carta, tableau3Atual, i);
        }
        System.out.printf("\n10 - TABLEAU4 == ");
        for (int i = 0; i < tableau4Atual.size(); i++) {
            Carta carta = (Carta) tableau4Atual.get(i);
            exibeCartaTableau(carta, tableau4Atual, i);
        }
        System.out.printf("\n11 - TABLEAU5 == ");
        for (int i = 0; i < tableau5Atual.size(); i++) {
            Carta carta = (Carta) tableau5Atual.get(i);
            exibeCartaTableau(carta, tableau5Atual, i);
        }
        System.out.printf("\n12 - TABLEAU6 == ");
        for (int i = 0; i < tableau6Atual.size(); i++) {
            Carta carta = (Carta) tableau6Atual.get(i);
            exibeCartaTableau(carta, tableau6Atual, i);
        }
        System.out.printf("\n13 - TABLEAU7 == ");
        for (int i = 0; i < tableau7Atual.size(); i++) {
            Carta carta = (Carta) tableau7Atual.get(i);
            exibeCartaTableau(carta, tableau7Atual, i);
        }

    }

    public void viraPrimeiraCartaDaPilha(Carta cartaRecebida) {
        Carta c = cartaRecebida;
        c.setFace(true);
        if (c.getHierarquia().equals("numero")) {// se for carta de número.
            System.out.printf(c.getNumero() + " " + c.getNaipe());
        } else if (c.getNumero().equals("sem numero")) {// se for K, D ou J.
            System.out.printf(c.getHierarquia() + " " + c.getNaipe());
        }
    }

    public void preenchePilhas() {// status inicial do jogo

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
            if (i == 1)
                c.setFace(true);
        }
        for (int i = 0; i < 3; i++) {// tableau3

            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau3");
            index++;
            if (i == 2)
                c.setFace(true);
        }
        for (int i = 0; i < 4; i++) {// tableau4

            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau4");
            index++;
            if (i == 3)
                c.setFace(true);
        }
        for (int i = 0; i < 5; i++) {// tableau5

            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau5");
            index++;
            if (i == 4)
                c.setFace(true);
        }
        for (int i = 0; i < 6; i++) {// tableau6

            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau6");
            index++;
            if (i == 5)
                c.setFace(true);
        }
        for (int i = 0; i < 7; i++) {// tableau7

            c = baralhoMisturado.get(index);
            b.setStack(c, "tableau7");
            index++;
            if (i == 6)
                c.setFace(true);
        }
        for (int i = 0; i < 24; i++) {// estoque
            c = baralhoMisturado.get(index);
            b.setStack(c, "estoque");
            index++;
        }
        //////
    }

    public void finalizaJogo() {
        jogoJaIniciado = false;
        System.exit(0);
    }

    public void reiniciar() {
        jogoJaIniciado = false;
        exibeJogo();
    }

    public void numDeCartasViradasDoEstoque(int selecaoDeNumDeCartas) {
        numDeCartasDoEstoque = selecaoDeNumDeCartas;
    }

    public boolean getStatusDeInicio() {
        return jogoJaIniciado;
    }

    public void setStatusDeInicio(boolean b) {
        jogoJaIniciado = b;
    }

    public void moveDoDescarteParaTableaus(Carta cartaDoTableau, Carta cartaDoDescarte, Stack<Carta> tableauAtual) {
        System.out.println("Carta do desc.: " + cartaDoDescarte.getHierarquia() + cartaDoDescarte.getNumero()
                + cartaDoDescarte.getNaipe());
        System.out.println("Carta do Tab.: " + cartaDoTableau.getHierarquia() + cartaDoTableau.getNumero()
                + cartaDoTableau.getNaipe());

        cartaDoTableau = tableauAtual.peek();
        if (tableauAtual.empty()) {// se o tableau está vazio, add apenas um Rei ou um Ás
            if (cartaDoDescarte.getNaipe().equals("K") || cartaDoDescarte.getNaipe().equals("A")) {
                tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
                System.out.println("tam. do tab. " + tableauAtual.size());
            }
        } else {// se há cartas no tableau, vê se a do descarte é numero ou não.
            if (cartaDoDescarte.getHierarquia().equals("K")) {// se vier um K, so add se houver um A
                if (cartaDoTableau.getHierarquia().equals("A")) {
                    cartaDoDescarte.setFace(true);
                    tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
                    System.out.println("tam. do tab. " + tableauAtual.size());
                }
            }
            if (cartaDoDescarte.getHierarquia().equals("Q")) {
                if (cartaDoTableau.getHierarquia().equals("K")) {// se a que está no tableau é um rei,
                                                                 // confere
                                                                 // o naipe
                    // espadas(coração invertido) preto, paus (trevo)preto, copas(coração)vermelho e
                    // ouros (balão)vermelho
                    if (cartaDoDescarte.getNaipe().equals("Espadas") || cartaDoDescarte.getNaipe().equals("Paus")) {
                        if (cartaDoTableau.getNaipe().equals("Copas") || cartaDoTableau.getNaipe().equals("Ouros")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    } else if (cartaDoDescarte.getNaipe().equals("Copas")
                            || cartaDoDescarte.getNaipe().equals("Ouros")) {
                        if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    }

                }
            } else if (cartaDoDescarte.getHierarquia().equals("J")) {
                if (cartaDoTableau.getHierarquia().equals("Q")) {// se a que está no tableau é um dama,
                                                                 // confere o Naipe
                    if (cartaDoDescarte.getNaipe().equals("Espadas") || cartaDoDescarte.getNaipe().equals("Paus")) {
                        if (cartaDoTableau.getNaipe().equals("Copas") || cartaDoTableau.getNaipe().equals("Ouros")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    } else if (cartaDoDescarte.getNaipe().equals("Copas")
                            || cartaDoDescarte.getNaipe().equals("Ouros")) {
                        if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    }
                }

            } else if (cartaDoTableau.getHierarquia().equals("J")) {// se a tableau é J, vê se a do descartte é 10
                int numCartaDeDescarte = Integer.parseInt(cartaDoDescarte.getNumero());
                if (numCartaDeDescarte == 10) {// se a carta do descarte é 10, confere os naipes.
                    if (cartaDoDescarte.getNaipe().equals("Espadas") || cartaDoDescarte.getNaipe().equals("Paus")) {
                        if (cartaDoTableau.getNaipe().equals("Copas") || cartaDoTableau.getNaipe().equals("Ouros")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca no tableau
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    } else if (cartaDoDescarte.getNaipe().equals("Copas")
                            || cartaDoDescarte.getNaipe().equals("Ouros")) {
                        if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca no tableau
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    }
                }

            }

            else {// se forem ambas cartas de número.
                int numCartaDeDescarte = Integer.parseInt(cartaDoDescarte.getNumero());
                int numCartaDeTableau = Integer.parseInt(cartaDoTableau.getNumero());
                System.out.println("Nums. das cartas desc tab: " + numCartaDeDescarte + " " + numCartaDeTableau);
                if (cartaDoDescarte.getNaipe().equals("Espadas") || cartaDoDescarte.getNaipe().equals("Paus")) {// se
                                                                                                                // a
                                                                                                                // carta
                                                                                                                // do
                                                                                                                // descarte
                                                                                                                // não
                                                                                                                // é
                                                                                                                // 10,
                                                                                                                // confere
                                                                                                                // o
                                                                                                                // naipe
                    if (cartaDoTableau.getNaipe().equals("Copas") || cartaDoTableau.getNaipe().equals("Ouros")) {
                        if (numCartaDeDescarte == (numCartaDeTableau - 1)) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca no tableau
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    }
                } else if (cartaDoDescarte.getNaipe().equals("Copas") || cartaDoDescarte.getNaipe().equals("Ouros")) {
                    if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                        if (numCartaDeDescarte == (numCartaDeTableau - 1)) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca no tableau
                            System.out.println("tam. do tab. " + tableauAtual.size());
                        }
                    }
                }

            }
        }
    }

    public void perguntaProUsuarioTableauDestino(int numDoTableauAtual) {
        Scanner resp = new Scanner(System.in);
        int selecao = 0;
        int numtableauSelecionado = 0;
        System.out.println(
                "\nDIGITE PARA QUAL PILHA MOVER CARTA:\n\n1 - FUNDACAO1\n2 - FUNDACAO2\n3 - FUNDACAO3\n4 - FUNDACAO4\n5 - TABLEAU1\n6 - TABLEAU2\n7 - TABLEAU3\n8 - TABLEAU4\n9 - TABLEAU5\n10 - TABLEAU6\n11 - TABLEAU7");
        System.out.printf("\nOpção escolhida: ");

        try {
            selecao = resp.nextInt();
        }

        catch (InputMismatchException e) {
            System.out.println("#Valor inválido. Digite números.\n");
            moverCarta();
        }

        switch (selecao) {
        case 5:
            numtableauSelecionado = 1;
            break;
        case 6:
            numtableauSelecionado = 2;
            break;
        case 7:
            numtableauSelecionado = 3;
            break;
        case 8:
            numtableauSelecionado = 4;
            break;
        case 9:
            numtableauSelecionado = 5;
            break;
        case 10:
            numtableauSelecionado = 6;
            break;
        case 11:
            numtableauSelecionado = 7;
            break;

        }

        if (numDoTableauAtual == numtableauSelecionado) {// se tentar mover para o mesmo tableau que está, não permite;
            System.out.println(
                    "#Você está tentando mover para o mesmo tableau de onde tirou a carta, por gentileza, escolha outro.");
            perguntaProUsuarioTableauDestino(numDoTableauAtual);
        }
    }

    public void moveDoDescarteParaFundacoes(Carta cartaDoDescarte, Stack<Carta> fundacaoAtual) {
        if (fundacaoAtual.empty()) {// caso a fundação esteja vazia
            if (cartaDoDescarte.getHierarquia().equals("A")) {// se a carta for um Ás
                fundacaoAtual.push(descarteAtual.pop());// tira do descarte e coloca na fundação
            }
        }

        else {// caso a fundação tenha cartas
            Carta cartaDaFundacao = fundacaoAtual.peek();// olha qual carta está no topo da fundação
            if (cartaDaFundacao.getHierarquia().equals("A")) {// se a carta da fundação for um Ás, só pode
                                                              // add um 2 de mesmo naipe
                if (cartaDoDescarte.getNumero().equals("2")) {
                    if (cartaDoDescarte.getNaipe().equals(cartaDaFundacao.getNaipe())) {// se os naipes
                                                                                        // forem iguais
                        fundacaoAtual.push(descarteAtual.pop());// tira do descarte e coloca na fundação
                    }
                }
            }

            else {// se a primeira carta não for um Ás, add uma carta 1 núm maior de mesmo naipe.
                if (cartaDoDescarte.getNaipe().equals(cartaDaFundacao.getNaipe())) {
                    int numCartaDeDescarte = Integer.parseInt(cartaDoDescarte.getNumero());
                    int numCartaDeFundacao = Integer.parseInt(cartaDaFundacao.getNumero());
                    if ((numCartaDeDescarte - 1) == numCartaDeFundacao) {
                        fundacaoAtual.push(descarteAtual.pop());// tira do descarte e coloca na fundação
                    }
                }
            }
        }
    }

    public void moverCarta() {// comporta toda a lógica do movimento das cartas
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

        switch (selecao) {// seleciona de qual pilha movera uma carta
        case 1:// move carta do estoque para o descarte
            if (estoqueAtual.empty())
                System.out.println("\nO estoque está vazio. :/");
            else {
                for (int i = 0; i < numDeCartasDoEstoque; i++) {
                    descarteAtual.push(estoqueAtual.pop());
                }
            }
            break;
        case 2:// move carta do descarte para tableaus ou fundações.
            if (descarteAtual.empty())
                System.out.println("\nA pilha de descarte está vazia. :/");
            else {
                Scanner respFund1 = new Scanner(System.in);
                int selecaoFund = 0;
                System.out.println(
                        "\nDIGITE PARA QUAL PILHA MOVER CARTA:\n\n1 - FUNDACAO1\n2 - FUNDACAO2\n3 - FUNDACAO3\n4 - FUNDACAO4\n5 - TABLEAU1\n6 - TABLEAU2\n7 - TABLEAU3\n8 - TABLEAU4\n9 - TABLEAU5\n10 - TABLEAU6\n11 - TABLEAU7");
                System.out.printf("\nOpção escolhida: ");

                try {
                    selecaoFund = respFund1.nextInt();
                }

                catch (InputMismatchException e) {
                    System.out.println("#Valor inválido. Digite números.\n");
                    moverCarta();
                }

                Carta cartaDoDescarte = descarteAtual.peek();// olha a primeira carta do descarte

                switch (selecaoFund) {
                case 1:// fundação1
                    moveDoDescarteParaFundacoes(cartaDoDescarte, fundacao1Atual);
                    break;
                case 2:// fundação2
                    moveDoDescarteParaFundacoes(cartaDoDescarte, fundacao2Atual);
                    break;
                case 3:// fundação3
                    moveDoDescarteParaFundacoes(cartaDoDescarte, fundacao3Atual);
                    break;
                case 4:// fundação4
                    moveDoDescarteParaFundacoes(cartaDoDescarte, fundacao4Atual);
                    break;
                case 5:// tableau1
                    Carta cartaDoTableau = tableau1Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau1Atual);
                    break;
                case 6:// tableau2
                    cartaDoTableau = tableau2Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau2Atual);
                    break;
                case 7:// tableau3
                    cartaDoTableau = tableau3Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau3Atual);
                    break;
                case 8:// tableau4
                    cartaDoTableau = tableau4Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau4Atual);
                    break;
                case 9:// tableau5
                    cartaDoTableau = tableau5Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau5Atual);
                    break;
                case 10:// tableau6
                    cartaDoTableau = tableau6Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau6Atual);
                    break;
                case 11:// tableau7
                    cartaDoTableau = tableau7Atual.peek();
                    moveDoDescarteParaTableaus(cartaDoTableau, cartaDoDescarte, tableau7Atual);
                    break;
                default:
                    System.out.println("valor do selecaoFund: " + selecaoFund);
                    System.out.println("#Valor inválido");
                    moverCarta();
                    break;
                }
            }
            break;
        case 3:// move cartas do tableau1 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(1);
            break;
        case 4:// move cartas do tableau2 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(2);
            break;
        case 5:// move cartas do tableau3 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(3);
            break;
        case 6:// move cartas do tableau4 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(4);
            break;
        case 7:// move cartas do tableau5 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(5);
            break;
        case 8:// move cartas do tableau6 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(6);
            break;
        case 9:// move cartas do tableau7 para outros tableaus ou fundações
            perguntaProUsuarioTableauDestino(7);
            break;
        default:
            System.out.println("#Valor inválido");
            moverCarta();
        }

    }

}
