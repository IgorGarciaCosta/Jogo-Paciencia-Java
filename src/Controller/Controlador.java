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

        System.out.println("\n\n----------------------------------------------------\n\n");

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
        for (int i = 0; i < tableau1Atual.size(); i++) {
            Carta carta = (Carta) tableau1Atual.get(i);
            viraPrimeiraCartaDaPilha(carta);
            System.out.printf(", ");
        }

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
        } else if (c.getNumero().equals("sem numero")) {// se for K, Q ou J.
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

    public void moveDoDescarteParaTableaus(Carta cartaDoDescarte, Stack<Carta> tableauAtual) {
        Carta cartaDoTableau = new Carta();

        if (tableauAtual.empty()) {// se o tableau está vazio, add apenas um Rei ou um Ás
            if (cartaDoDescarte.getHierarquia().equals("K")) {
                tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
            }
        } else {// se há cartas no tableau, vê se a do descarte é numero ou não.
            cartaDoTableau = tableauAtual.peek();
            if (cartaDoDescarte.getHierarquia().equals("K")) {// se vier um K, so add se houver um A
                if (cartaDoTableau.getHierarquia().equals("A")) {
                    cartaDoDescarte.setFace(true);
                    tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
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
                        }
                    } else if (cartaDoDescarte.getNaipe().equals("Copas")
                            || cartaDoDescarte.getNaipe().equals("Ouros")) {
                        if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
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
                        }
                    } else if (cartaDoDescarte.getNaipe().equals("Copas")
                            || cartaDoDescarte.getNaipe().equals("Ouros")) {
                        if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca na tableau.
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
                        }
                    } else if (cartaDoDescarte.getNaipe().equals("Copas")
                            || cartaDoDescarte.getNaipe().equals("Ouros")) {
                        if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca no tableau
                        }
                    }
                }

            }

            else {// se forem ambas cartas de número.
                int numCartaDeDescarte = Integer.parseInt(cartaDoDescarte.getNumero());
                int numCartaDeTableau = Integer.parseInt(cartaDoTableau.getNumero());
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
                        }
                    }
                } else if (cartaDoDescarte.getNaipe().equals("Copas") || cartaDoDescarte.getNaipe().equals("Ouros")) {
                    if (cartaDoTableau.getNaipe().equals("Espadas") || cartaDoTableau.getNaipe().equals("Paus")) {
                        if (numCartaDeDescarte == (numCartaDeTableau - 1)) {
                            cartaDoDescarte.setFace(true);
                            tableauAtual.push(descarteAtual.pop());// tira do descarte e coloca no tableau
                        }
                    }
                }

            }
        }
    }

    public int perguntaProUsuarioDestino(int numDoTableauAtual) {
        Scanner resp = new Scanner(System.in);
        int selecao = 0;
        int numtableauSelecionado = 0;
        System.out.println(
                "\nDIGITE PARA QUAL PILHA MOVER CARTA:\n\n1 - FUNDACAO1\n2 - FUNDACAO2\n3 - FUNDACAO3\n4 - FUNDACAO4\n5 - TABLEAU1\n6 - TABLEAU2\n7 - TABLEAU3\n8 - TABLEAU4\n9 - TABLEAU5\n10 - TABLEAU6\n11 - TABLEAU7\n12 - VOLTAR");
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
                return 11;
            case 2:
                return 12;
            case 3:
                return 13;
            case 4:
                return 14;
            case 5:
                numtableauSelecionado = 1;
                return 1;
            case 6:
                numtableauSelecionado = 2;
                return 2;
            case 7:
                numtableauSelecionado = 3;
                return 3;
            case 8:
                numtableauSelecionado = 4;
                return 4;
            case 9:
                numtableauSelecionado = 5;
                return 5;
            case 10:
                numtableauSelecionado = 6;
                return 6;
            case 11:
                numtableauSelecionado = 7;
                return 7;
            case 12:
                moverCarta();
                break;

        }

        if (numDoTableauAtual == numtableauSelecionado) {// se tentar mover para o mesmo tableau que está, não permite;
            System.out.println(
                    "#Você está tentando mover para o mesmo tableau de onde tirou a carta, por gentileza, escolha outro.");
            numtableauSelecionado = 0;
            perguntaProUsuarioDestino(numDoTableauAtual);
        }

        return numtableauSelecionado;

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

    public void moveDoTableauParaFundacoes(Stack<Carta> tableauAtual, Stack<Carta> fundacaoAtual) {
        Carta cartaTableau = tableauAtual.peek();

        if (fundacaoAtual.empty()) {// caso a fundação esteja vazia
            if (cartaTableau.getHierarquia().equals("A")) {// se a carta for um Ás
                fundacaoAtual.push(tableauAtual.pop());// tira do descarte e coloca na fundação
                viraCartaDoTabSeForPrimeira(tableauAtual);
            }
        }

        else {// caso a fundação tenha cartas
            Carta cartaFundacao = fundacaoAtual.peek();// olha qual carta está no topo da fundação
            if (cartaFundacao.getHierarquia().equals("A")) {// se a carta da fundação for um Ás, só pode
                                                            // add um 2 de mesmo naipe
                if (cartaTableau.getNumero().equals("2")) {
                    if (cartaTableau.getNaipe().equals(cartaFundacao.getNaipe())) {// se os naipes
                                                                                   // forem iguais
                        fundacaoAtual.push(tableauAtual.pop());// tira do descarte e coloca na fundação
                        viraCartaDoTabSeForPrimeira(tableauAtual);
                    }
                }
            }

            else {// se a primeira carta não for um Ás, add uma carta 1 núm maior de mesmo naipe.
                if (cartaTableau.getNaipe().equals(cartaFundacao.getNaipe())) {
                    int numCartaTableau = Integer.parseInt(cartaTableau.getNumero());
                    int numCartaFundacao = Integer.parseInt(cartaFundacao.getNumero());
                    if ((numCartaTableau - 1) == numCartaFundacao) {
                        fundacaoAtual.push(tableauAtual.pop());// tira do descarte e coloca na fundação
                        viraCartaDoTabSeForPrimeira(tableauAtual);
                    }
                }
            }
        }

    }

    public void confereSeUmDosTableausEstaVazio(Stack<Carta> tableauAtual, Stack<Carta> tableauDestino) {
        if (tableauAtual.empty()) {
            System.out.println("#Tableau de origem vazio, por favor, escolha outro de onde mandar uma carta.");
            moverCarta();
        }
    }

    public void moveDoTableauParaTableaus(Stack<Carta> tableauAtual, Stack<Carta> tableauDestino) {
        Carta cartaDoTableauDestino = new Carta();
        Carta cartaDoTableauOrigem = new Carta();
        if (!tableauDestino.empty())
            cartaDoTableauDestino = tableauDestino.peek();
        if (!tableauAtual.empty())
            cartaDoTableauOrigem = tableauAtual.peek();

        if (tableauDestino.empty()) {// se o tableau está vazio, add apenas um Rei
            if (cartaDoTableauOrigem.getNaipe().equals("K")) {
                tableauDestino.push(tableauAtual.pop());// tira do descarte e coloca na tableau.
                viraCartaDoTabSeForPrimeira(tableauAtual);
            }
        } else {// se há cartas no tableau, vê se a do descarte é numero ou não.
            if (cartaDoTableauOrigem.getHierarquia().equals("K")) {// se vier um K, so add se houver um A
                if (cartaDoTableauDestino.getHierarquia().equals("A")) {
                    cartaDoTableauOrigem.setFace(true);
                    tableauDestino.push(tableauAtual.pop());// tira do descarte e coloca na tableau.
                    viraCartaDoTabSeForPrimeira(tableauAtual);
                }
            }
            if (cartaDoTableauOrigem.getHierarquia().equals("Q")) {
                if (cartaDoTableauDestino.getHierarquia().equals("K")) {// se a que está no tableau é um rei,
                    // confere
                    // o naipe
                    // espadas(coração invertido) preto, paus (trevo)preto, copas(coração)vermelho e
                    // ouros (balão)vermelho
                    if (cartaDoTableauOrigem.getNaipe().equals("Espadas")
                            || cartaDoTableauOrigem.getNaipe().equals("Paus")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Copas")
                                || cartaDoTableauDestino.getNaipe().equals("Ouros")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());// tira do descarte e coloca na tableau.
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    } else if (cartaDoTableauOrigem.getNaipe().equals("Copas")
                            || cartaDoTableauOrigem.getNaipe().equals("Ouros")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Espadas")
                                || cartaDoTableauDestino.getNaipe().equals("Paus")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    }

                }
            } else if (cartaDoTableauOrigem.getHierarquia().equals("J")) {
                if (cartaDoTableauDestino.getHierarquia().equals("Q")) {// se a que está no tableau é um dama,
                    // confere o Naipe
                    if (cartaDoTableauOrigem.getNaipe().equals("Espadas")
                            || cartaDoTableauOrigem.getNaipe().equals("Paus")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Copas")
                                || cartaDoTableauDestino.getNaipe().equals("Ouros")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    } else if (cartaDoTableauOrigem.getNaipe().equals("Copas")
                            || cartaDoTableauOrigem.getNaipe().equals("Ouros")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Espadas")
                                || cartaDoTableauDestino.getNaipe().equals("Paus")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    }
                }

            } else if (cartaDoTableauDestino.getHierarquia().equals("J")) {// se a tableau destino é J, vê se a do
                                                                           // tableau origem é
                                                                           // 10
                int numCartaDeDescarte = Integer.parseInt(cartaDoTableauOrigem.getNumero());
                if (numCartaDeDescarte == 10) {// se a carta do tab. de origem é 10, confere os naipes.
                    if (cartaDoTableauOrigem.getNaipe().equals("Espadas")
                            || cartaDoTableauOrigem.getNaipe().equals("Paus")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Copas")
                                || cartaDoTableauDestino.getNaipe().equals("Ouros")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    } else if (cartaDoTableauOrigem.getNaipe().equals("Copas")
                            || cartaDoTableauOrigem.getNaipe().equals("Ouros")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Espadas")
                                || cartaDoTableauDestino.getNaipe().equals("Paus")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    }
                }

            }

            else if (cartaDoTableauDestino.getHierarquia().equals("Q")) {
                if (cartaDoTableauDestino.getHierarquia().equals("J")) {// se a que está no tableau é um rei,
                    // confere
                    // o naipe
                    // espadas(coração invertido) preto, paus (trevo)preto, copas(coração)vermelho e
                    // ouros (balão)vermelho
                    if (cartaDoTableauOrigem.getNaipe().equals("Espadas")
                            || cartaDoTableauOrigem.getNaipe().equals("Paus")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Copas")
                                || cartaDoTableauDestino.getNaipe().equals("Ouros")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());// tira do descarte e coloca na tableau.
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    } else if (cartaDoTableauOrigem.getNaipe().equals("Copas")
                            || cartaDoTableauOrigem.getNaipe().equals("Ouros")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Espadas")
                                || cartaDoTableauDestino.getNaipe().equals("Paus")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    }

                }
            } else if (cartaDoTableauDestino.getHierarquia().equals("K")) {// se a que está no tableau é um rei
                if (cartaDoTableauOrigem.getHierarquia().equals("Q")) {
                    if (cartaDoTableauOrigem.getNaipe().equals("Espadas")
                            || cartaDoTableauOrigem.getNaipe().equals("Paus")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Copas")
                                || cartaDoTableauDestino.getNaipe().equals("Ouros")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                        }
                    } else if (cartaDoTableauOrigem.getNaipe().equals("Copas")
                            || cartaDoTableauOrigem.getNaipe().equals("Ouros")) {
                        if (cartaDoTableauDestino.getNaipe().equals("Espadas")
                                || cartaDoTableauDestino.getNaipe().equals("Paus")) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());
                        }
                    }
                }

            } else {// se forem ambas cartas de número.
                int numCartaDeDescarte = Integer.parseInt(cartaDoTableauOrigem.getNumero());
                int numCartaDeTableau = Integer.parseInt(cartaDoTableauDestino.getNumero());
                if (cartaDoTableauOrigem.getNaipe().equals("Espadas")
                        || cartaDoTableauOrigem.getNaipe().equals("Paus")) {// se a carta do tab. de origem não é 10,
                                                                            // confere o naipe.
                    if (cartaDoTableauDestino.getNaipe().equals("Copas")
                            || cartaDoTableauDestino.getNaipe().equals("Ouros")) {
                        if (numCartaDeDescarte == (numCartaDeTableau - 1)) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());// tira do descarte e coloca no tableau
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    }
                } else if (cartaDoTableauOrigem.getNaipe().equals("Copas")
                        || cartaDoTableauOrigem.getNaipe().equals("Ouros")) {
                    if (cartaDoTableauDestino.getNaipe().equals("Espadas")
                            || cartaDoTableauDestino.getNaipe().equals("Paus")) {
                        if (numCartaDeDescarte == (numCartaDeTableau - 1)) {
                            cartaDoTableauOrigem.setFace(true);
                            tableauDestino.push(tableauAtual.pop());// tira do descarte e coloca no tableau
                            viraCartaDoTabSeForPrimeira(tableauAtual);
                        }
                    }
                }

            }
        }
    }

    public void viraCartaDoTabSeForPrimeira(Stack<Carta> tableauAtual) {
        Carta primeira = new Carta();
        if (!tableauAtual.empty()) {
            primeira = tableauAtual.peek();
            if (!primeira.getFace()) {
                primeira.setFace(true);
            }
        }

    }

    public Stack<Carta> perguntaETiraCartas(Stack<Carta> tableauEscolhido) {// Pergunta quantas cartas serão tiradas do
        // tableau recebido
        Scanner resp = new Scanner(System.in);
        Stack<Carta> cartasRetiradas = new Stack<Carta>();
        int selecao = 0;

        System.out.printf("\nDIGITE QUANTAS CARTAS QUER RETIRAR DESTE TABLEAU: ");

        try {
            selecao = resp.nextInt();
        }

        catch (InputMismatchException e) {
            System.out.println("#Valor inválido. Digite números.\n");
            moverCarta();
        }

        if (tableauEscolhido.empty()) {
            System.out.println("#O tableau de origem escolhido está vazio, por favor, escolha outro.");
            moverCarta();
        }

        else if (selecao <= tableauEscolhido.size()) {
            Carta cartaAuxiliar = new Carta();
            for (int i = 0; i < selecao; i++) {// preenche a pilha auxiliar
                cartaAuxiliar = tableauEscolhido.peek();
                if (cartaAuxiliar.getFace()) {// carta virada pra cima
                    cartasRetiradas.push(tableauEscolhido.pop());// passa cartas selecionadas pra pilha auxiliar
                } else if (!cartaAuxiliar.getFace()) {// carta virada pra baixo
                    System.out
                            .println("#Você selecionou uma carta virada para baixo. Por gentileza, escolha novamente.");
                    retornaCartas(tableauEscolhido, cartasRetiradas);
                    moverCarta();
                }

            }
            return cartasRetiradas;

        }

        else {
            System.out.println("#Você selecionou mais cartas do que há no tableau. Por favor, escolha novamente.");
            moverCarta();
        }

        return cartasRetiradas;

    }

    public void retornaCartas(Stack<Carta> tableauDeRetorno, Stack<Carta> cartasRetiradas) {// volta as casrtas
                                                                                            // retiradas, caso não
                                                                                            // possam se adicionadas ao
                                                                                            // outro tableau

        Carta cartaAuxiliar = new Carta();
        int size = cartasRetiradas.size();
        for (int i = 0; i < size; i++) {// preenche a pilha auxiliar
            cartaAuxiliar = cartasRetiradas.pop();
            tableauDeRetorno.push(cartaAuxiliar);
        }

    }

    public void perguntaPraQualTableau(Stack<Carta> cartasRetiradas, Stack<Carta> tableauDeOrigem) {
        Scanner resp = new Scanner(System.in);
        int selecao = 0;

        System.out.println(
                "\nDIGITE PARA QUAL TABLEAU MOVER AS CARTAS:\n1 - TABLEAU1\n2 - TABLEAU2\n3 - TABLEAU3\n4 - TABLEAU4\n5 - TABLEAU5\n6 - TABLEAU6\n7 - TABLEAU7\n8 - VOLTAR");

        System.out.printf("Opção escolhida: ");
        try {
            selecao = resp.nextInt();
        }

        catch (InputMismatchException e) {
            System.out.println("#Valor inválido. Digite números.\n");
            moverCarta();
        }

        switch (selecao) {
            case 1:
                adicionaCartasAoTableau(tableau1Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 2:
                adicionaCartasAoTableau(tableau2Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 3:
                adicionaCartasAoTableau(tableau3Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 4:
                adicionaCartasAoTableau(tableau4Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 5:
                adicionaCartasAoTableau(tableau5Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 6:
                adicionaCartasAoTableau(tableau6Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 7:
                adicionaCartasAoTableau(tableau7Atual, cartasRetiradas, tableauDeOrigem);
                break;
            case 8:
                moverCarta();
                break;
            default:
                System.out.println("#Valor inválido");
                moverCarta();

        }
    }

    public void confereCartasPraBaixo() {
        Carta cartaAux = new Carta();
        cartaAux = tableau1Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
        cartaAux = tableau2Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
        cartaAux = tableau3Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
        cartaAux = tableau4Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
        cartaAux = tableau5Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
        cartaAux = tableau6Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
        cartaAux = tableau7Atual.peek();
        if (!cartaAux.getFace())
            cartaAux.setFace(true);
    }

    public void adicionaCartasAoTableau(Stack<Carta> tableauEscolhido, Stack<Carta> cartasRetiradas,
            Stack<Carta> tableauDeOrigem) {
        Carta cartaASerAdicionada = cartasRetiradas.peek();
        Carta primeiraCartaDoTab = new Carta();

        for (int i = 0; i < cartasRetiradas.size(); i++) {// repete enquanto houver cartas para adicionar ao tableau de
                                                          // destino
            if (tableauEscolhido.empty()) {// se o tableau está vazio, add apenas um Rei
                if (cartaASerAdicionada.getNaipe().equals("K")) {
                    tableauEscolhido.push(cartasRetiradas.pop());// tira do descarte e coloca na tableau.
                    viraCartaDoTabSeForPrimeira(cartasRetiradas);
                    System.out.println("tam. do tab. " + tableauEscolhido.size());
                } else if (!cartaASerAdicionada.getNaipe().equals("K")) {
                    retornaCartas(tableauDeOrigem, cartasRetiradas);
                }
            } else {// se há cartas no tableau, vê se a da pilha de cartas retiradas é numero ou
                    // não.
                primeiraCartaDoTab = tableauEscolhido.peek();

                if (cartaASerAdicionada.getHierarquia().equals("Q")) {
                    if (primeiraCartaDoTab.getHierarquia().equals("K")) {// se a que está no tableau é um rei,
                        // confere
                        // o naipe
                        // espadas(coração invertido) preto, paus (trevo)preto, copas(coração)vermelho e
                        // ouros (balão)vermelho
                        if (cartaASerAdicionada.getNaipe().equals("Espadas")
                                || cartaASerAdicionada.getNaipe().equals("Paus")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Copas")
                                    || primeiraCartaDoTab.getNaipe().equals("Ouros")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                                System.out.println("tam. do tab. " + tableauEscolhido.size());
                            }
                        } else if (cartaASerAdicionada.getNaipe().equals("Copas")
                                || cartaASerAdicionada.getNaipe().equals("Ouros")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Espadas")
                                    || primeiraCartaDoTab.getNaipe().equals("Paus")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                                System.out.println("tam. do tab. " + tableauEscolhido.size());
                            } else {
                                retornaCartas(tableauDeOrigem, cartasRetiradas);
                            }
                        }

                        else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }

                    } else {
                        retornaCartas(tableauDeOrigem, cartasRetiradas);
                    }
                } else if (cartaASerAdicionada.getHierarquia().equals("J")) {
                    if (primeiraCartaDoTab.getHierarquia().equals("Q")) {// se a que está no tableau é um dama,
                        // confere o Naipe
                        if (cartaASerAdicionada.getNaipe().equals("Espadas")
                                || cartaASerAdicionada.getNaipe().equals("Paus")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Copas")
                                    || primeiraCartaDoTab.getNaipe().equals("Ouros")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            }
                        } else if (cartaASerAdicionada.getNaipe().equals("Copas")
                                || cartaASerAdicionada.getNaipe().equals("Ouros")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Espadas")
                                    || primeiraCartaDoTab.getNaipe().equals("Paus")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            } else {
                                retornaCartas(tableauDeOrigem, cartasRetiradas);
                            }
                        } else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }
                    } else {
                        retornaCartas(tableauDeOrigem, cartasRetiradas);
                    }

                } else if (cartaASerAdicionada.getHierarquia().equals("K")) {
                    retornaCartas(tableauDeOrigem, cartasRetiradas);
                } else if (primeiraCartaDoTab.getHierarquia().equals("J")) {// se a tableau destino é J, vê se a da
                                                                            // pilha de
                                                                            // cartas retiradas é 10
                    int numCartaASerAdicionada = Integer.parseInt(cartaASerAdicionada.getNumero());
                    if (numCartaASerAdicionada == 10) {// se a carta da pilha de cartas é 10, confere os naipes.
                        if (cartaASerAdicionada.getNaipe().equals("Espadas")
                                || cartaASerAdicionada.getNaipe().equals("Paus")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Copas")
                                    || primeiraCartaDoTab.getNaipe().equals("Ouros")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                                System.out.println("tam. do tab. " + tableauEscolhido.size());
                            }
                        } else if (cartaASerAdicionada.getNaipe().equals("Copas")
                                || cartaASerAdicionada.getNaipe().equals("Ouros")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Espadas")
                                    || primeiraCartaDoTab.getNaipe().equals("Paus")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                                System.out.println("tam. do tab. " + tableauEscolhido.size());
                            } else {
                                retornaCartas(tableauDeOrigem, cartasRetiradas);
                            }
                        } else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }
                    } else {
                        retornaCartas(tableauDeOrigem, cartasRetiradas);
                    }

                } else if (primeiraCartaDoTab.getHierarquia().equals("Q")) {
                    System.out.println("Era um Q");
                    if (cartaASerAdicionada.getHierarquia().equals("J")) {// se a que está no tableau é um rei,
                        if (cartaASerAdicionada.getNaipe().equals("Espadas")
                                || cartaASerAdicionada.getNaipe().equals("Paus")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Copas")
                                    || primeiraCartaDoTab.getNaipe().equals("Ouros")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());// tira do descarte e coloca na tableau.
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            }
                        } else if (cartaASerAdicionada.getNaipe().equals("Copas")
                                || cartaASerAdicionada.getNaipe().equals("Ouros")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Espadas")
                                    || primeiraCartaDoTab.getNaipe().equals("Paus")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            } else {
                                retornaCartas(tableauDeOrigem, cartasRetiradas);
                            }
                        }

                        else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }

                    } else {
                        retornaCartas(tableauDeOrigem, cartasRetiradas);
                    }
                } else if (primeiraCartaDoTab.getHierarquia().equals("K")) {// se a que está no tableau é um rei
                    if (cartaASerAdicionada.getHierarquia().equals("Q")) {
                        if (cartaASerAdicionada.getNaipe().equals("Espadas")
                                || cartaASerAdicionada.getNaipe().equals("Paus")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Copas")
                                    || primeiraCartaDoTab.getNaipe().equals("Ouros")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            }
                        } else if (cartaASerAdicionada.getNaipe().equals("Copas")
                                || cartaASerAdicionada.getNaipe().equals("Ouros")) {
                            if (primeiraCartaDoTab.getNaipe().equals("Espadas")
                                    || primeiraCartaDoTab.getNaipe().equals("Paus")) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            } else {
                                retornaCartas(tableauDeOrigem, cartasRetiradas);
                            }
                        } else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }
                    }

                    else {
                        retornaCartas(tableauDeOrigem, cartasRetiradas);
                    }

                } else if (primeiraCartaDoTab.getHierarquia().equals("anObject")) {
                    retornaCartas(tableauDeOrigem, cartasRetiradas);
                } else if (cartaASerAdicionada.getHierarquia().equals("A")) {
                    retornaCartas(tableauDeOrigem, cartasRetiradas);
                } else {// se forem ambas cartas de número.
                    int numCartaASerAdicionada = Integer.parseInt(cartaASerAdicionada.getNumero());
                    int numCartaDeTableau = Integer.parseInt(primeiraCartaDoTab.getNumero());
                    if (cartaASerAdicionada.getNaipe().equals("Espadas")
                            || cartaASerAdicionada.getNaipe().equals("Paus")) {// se
                                                                               // a
                                                                               // carta
                                                                               // do
                                                                               // tab.
                                                                               // de
                                                                               // origem
                                                                               // não
                                                                               // é
                                                                               // 10,
                                                                               // confere
                                                                               // o
                                                                               // naipe.
                        if (primeiraCartaDoTab.getNaipe().equals("Copas")
                                || primeiraCartaDoTab.getNaipe().equals("Ouros")) {
                            if (numCartaASerAdicionada == (numCartaDeTableau - 1)) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());// tira do descarte e coloca no tableau
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            } else {
                                retornaCartas(tableauDeOrigem, cartasRetiradas);
                            }
                        } else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }
                    } else if (cartaASerAdicionada.getNaipe().equals("Copas")
                            || cartaASerAdicionada.getNaipe().equals("Ouros")) {
                        if (primeiraCartaDoTab.getNaipe().equals("Espadas")
                                || primeiraCartaDoTab.getNaipe().equals("Paus")) {
                            if (numCartaASerAdicionada == (numCartaDeTableau - 1)) {
                                cartaASerAdicionada.setFace(true);
                                tableauEscolhido.push(cartasRetiradas.pop());// tira do descarte e coloca no tableau
                                viraCartaDoTabSeForPrimeira(cartasRetiradas);
                            }
                        } else {
                            retornaCartas(tableauDeOrigem, cartasRetiradas);
                        }
                    } else {
                        retornaCartas(tableauDeOrigem, cartasRetiradas);
                    }

                }
            }

        }

        confereCartasPraBaixo();
    }

    public void moverCarta() {// comporta toda a lógica do movimento das cartas
        jogoJaIniciado = true;
        Scanner resp = new Scanner(System.in);
        int selecao = 0;

        System.out.println(
                "\nDIGITE DE QUAL PILHA MOVER CARTA:\n\n1 - ESTOQUE\n2 - DESCARTE\n3 - TABLEAU1\n4 - TABLEAU2\n5 - TABLEAU3\n6 - TABLEAU4\n7 - TABLEAU5\n8 - TABLEAU6\n9 - TABLEAU7\n10 - MOVER MÚLTIPLAS CARTAS DE UM TABLEAU\n11 - VOLTAR");
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
                    System.out.println("\n#O estoque está vazio. :/");
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

                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau1Atual);
                            break;
                        case 6:// tableau2
                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau2Atual);
                            break;
                        case 7:// tableau3
                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau3Atual);
                            break;
                        case 8:// tableau4
                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau4Atual);
                            break;
                        case 9:// tableau5
                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau5Atual);
                            break;
                        case 10:// tableau6
                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau6Atual);
                            break;
                        case 11:// tableau7
                            moveDoDescarteParaTableaus(cartaDoDescarte, tableau7Atual);
                            break;
                        default:
                            System.out.println("#Valor inválido");
                            moverCarta();
                            break;
                    }
                }

                break;
            case 3:// move cartas do tableau1 para outros tableaus ou fundações
                int pilhaDestino = perguntaProUsuarioDestino(1);
                Stack<Carta> tableauAtual = tableau1Atual;
                Stack<Carta> fundacaoAtual = new Stack();

                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;
            case 4:// move cartas do tableau2 para outros tableaus ou fundações
                pilhaDestino = perguntaProUsuarioDestino(2);
                tableauAtual = tableau2Atual;

                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;
            case 5:// move cartas do tableau3 para outros tableaus ou fundações
                pilhaDestino = perguntaProUsuarioDestino(3);
                tableauAtual = tableau3Atual;
                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;
            case 6:// move cartas do tableau4 para outros tableaus ou fundações
                pilhaDestino = perguntaProUsuarioDestino(4);
                tableauAtual = tableau4Atual;

                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;
            case 7:// move cartas do tableau5 para outros tableaus ou fundações
                pilhaDestino = perguntaProUsuarioDestino(5);
                tableauAtual = tableau5Atual;

                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;
            case 8:// move cartas do tableau6 para outros tableaus ou fundações
                pilhaDestino = perguntaProUsuarioDestino(6);
                tableauAtual = tableau6Atual;

                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;
            case 9:// move cartas do tableau7 para outros tableaus ou fundações
                pilhaDestino = perguntaProUsuarioDestino(7);
                tableauAtual = tableau7Atual;

                if (pilhaDestino > 10) {// é pra uma fundação
                    switch (pilhaDestino) {
                        case 11:// para fundação 1
                            fundacaoAtual = fundacao1Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 12:// para fundação 2
                            fundacaoAtual = fundacao2Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 13:// para fundação 3
                            fundacaoAtual = fundacao3Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                        case 14:// para fundação 4
                            fundacaoAtual = fundacao4Atual;
                            moveDoTableauParaFundacoes(tableauAtual, fundacaoAtual);
                            break;
                    }
                } else if (pilhaDestino < 10) {// é pra um tableau

                    switch (pilhaDestino) {
                        case 1:// para tableau 1
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau1Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau1Atual);// args: tableau atual e tableau de
                                                                                   // destino
                            break;
                        case 2:// para tableau 2
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau2Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau2Atual);
                            break;
                        case 3:// para tableau 3
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau3Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau3Atual);
                            break;
                        case 4:// para tableau 4
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau4Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau4Atual);
                            break;
                        case 5:// para tableau 5
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau5Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau5Atual);
                            break;
                        case 6:// para tableau 6
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau6Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau6Atual);
                            break;
                        case 7:// para tableau 7
                            confereSeUmDosTableausEstaVazio(tableauAtual, tableau7Atual);
                            moveDoTableauParaTableaus(tableauAtual, tableau7Atual);
                            break;
                    }
                }
                break;

            case 10:// mover múltiplas cartas entre tableaus
                Stack<Carta> cartasRetiradas = new Stack<Carta>();
                System.out.println(
                        "\nDIGITE DE QUAL TABLEAU MOVER CARTA:\n\n1 - TABLEAU1\n2 - TABLEAU2\n3 - TABLEAU3\n4 - TABLEAU4\n5 - TABLEAU5\n6 - TABLEAU6\n7 - TABLEAU7\n8 - VOLTAR");
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
                        cartasRetiradas = perguntaETiraCartas(tableau1Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau1Atual);
                        break;
                    case 2:
                        cartasRetiradas = perguntaETiraCartas(tableau2Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau2Atual);
                        break;
                    case 3:
                        cartasRetiradas = perguntaETiraCartas(tableau3Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau3Atual);
                        break;
                    case 4:
                        cartasRetiradas = perguntaETiraCartas(tableau4Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau4Atual);
                        break;
                    case 5:
                        cartasRetiradas = perguntaETiraCartas(tableau5Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau5Atual);
                        break;
                    case 6:
                        cartasRetiradas = perguntaETiraCartas(tableau6Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau6Atual);
                        break;
                    case 7:
                        cartasRetiradas = perguntaETiraCartas(tableau7Atual);
                        perguntaPraQualTableau(cartasRetiradas, tableau7Atual);
                        break;
                    case 8:
                        moverCarta();
                    default:
                        System.out.println("#Valor inválido");
                        moverCarta();
                }

                break;
            case 11:
                exibeJogo();
                break;
            default:
                System.out.println("\n#Valor inválido");
                moverCarta();
        }

    }

}
