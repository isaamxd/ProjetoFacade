package br.fastfood.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import br.fastfood.facade.ComboFacade;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔════════════════════════════════╗");
        System.out.println("║   LANCHONETE FAST-FOOD         ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.println("\n=== MENU DE COMBOS ===");
        System.out.println("1 - Combo Master    (R$ 35,90)");
        System.out.println("2 - Super Combo     (R$ 32,50)");
        System.out.println("3 - Combo Kids      (R$ 22,90)");
        System.out.println("0 - Sair");

        boolean continuar = true;
        ComboFacade facade = new ComboFacade();

        while (continuar) {
            try {
                System.out.print("\nSua escolha: ");
                int escolha = scanner.nextInt();

                if (escolha == 0) {
                    System.out.println("Obrigado pela preferência!");
                    continuar = false;
                } else if (escolha >= 1 && escolha <= 3) {
                    facade.criarCombo(escolha);
                    facade.exibirItens();
                    System.out.printf("\nTotal a pagar: R$ %.2f\n",
                                      facade.getPrecoTotal());
                } else {
                    System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
