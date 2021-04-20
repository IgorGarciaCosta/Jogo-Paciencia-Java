package View;

import java.util.InputMismatchException;
import java.util.Scanner;
import Controller.Controlador;

public class App {
    public static void main(String[] args) throws Exception {
        while (true) {
            menu();
        }
    }

    public static void menu() {
        Controlador controle = new Controlador();
        Scanner resp = new Scanner(System.in);
        int selecao = 0;
        int selecaoDeNumDeCartas = 1;
        System.out.println(
                "\n\nJOGO DE PACIÊNCIA\n\nDigite uma das opções [1-5]:\n1 - MOVER CARTA\n2 - EXIBIR JOGO\n3 - ALTERAR QUANT. DE CARTAS A VIRAR DO ESTOQUE\n4 - REINICIAR\n5 - FINALIZAR");
        System.out.printf("\nOpção escolhida: ");

        try {
            selecao = resp.nextInt();
        }

        catch (InputMismatchException e) {
            System.out.println("#Valor inválido. Digite números.\n");
            menu();
        }

        switch (selecao) {
        case 1:
            if (controle.getStatusDeInicio()) {
                controle.moverCarta();
                controle.exibeJogo();
            } else {
                System.out.println("#Você tentou mover uma carta sem iniciar o jogo. Por gentileza, selecione 'EXIBIR JOGO' antes.");
            }
            break;

        case 2:
            // System.out.println("Baralho completo:\n");
            // Baralho b;
            // b=new Baralho();
            // b.imprimirBaralho();
            controle.exibeJogo();
            break;

        case 3:
            System.out.printf("VIRAR 1 OU 3 CARTAS DO ESTOQUE? ");
            try {
                selecaoDeNumDeCartas = resp.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("#Valor inválido. Digite números.\n");
                menu();
            }
            if (selecaoDeNumDeCartas != 1 && selecaoDeNumDeCartas != 3) {
                System.out.println("#Valor inválido");
                menu();
            } else
                controle.numDeCartasViradasDoEstoque(selecaoDeNumDeCartas);

            break;

        case 4:
            controle.reiniciar();
            break;

        case 5:
            System.out.println("\nObrigado por jogar!");
            controle.finalizaJogo();
            break;

        default:
            System.out.println("#Valor inválido");
            menu();
        }
    }

}
