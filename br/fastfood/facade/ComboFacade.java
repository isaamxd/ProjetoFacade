package br.fastfood.facade;

import br.fastfood.model.Bebida;
import br.fastfood.model.Burger;
import br.fastfood.model.Combo;
import br.fastfood.model.ItemCombo;
import br.fastfood.model.Sobremesa;

public class ComboFacade {
    private Combo combo;

    public void criarCombo(int codigo) {
        if (codigo < 1 || codigo > 3) {
            System.out.println("Código inválido! Use 1, 2 ou 3.");
            combo = null;
            return;
        }

        switch (codigo) {
            case 1:
                ItemCombo burger1 = new Burger("Big Cheddar", 18.00);
                ItemCombo bebida1 = new Bebida("Coca-Cola", 8.00);
                ItemCombo sobremesa1 = new Sobremesa("Sundae", 9.90);
                combo = new Combo(burger1, bebida1, sobremesa1);
                break;
            case 2:
                ItemCombo burger2 = new Burger("Mega Bacon", 16.00);
                ItemCombo bebida2 = new Bebida("Guaraná", 7.50);
                ItemCombo sobremesa2 = new Sobremesa("Torta de Maçã", 9.00);
                combo = new Combo(burger2, bebida2, sobremesa2);
                break;
            case 3:
                ItemCombo burger3 = new Burger("Mini Burger", 12.00);
                ItemCombo bebida3 = new Bebida("Suco Laranja", 6.00);
                ItemCombo sobremesa3 = new Sobremesa("Sorvete", 4.90);
                combo = new Combo(burger3, bebida3, sobremesa3);
                break;
            default:
                System.out.println("Código de combo inválido!");
                combo = null;
                break;
        }
    }

    public void exibirItens() {
        if (combo == null) {
            System.out.println("Nenhum combo criado ainda!");
            return;
        }

        System.out.println("\n=== Detalhes do Pedido ===");
        exibirItem("Burger", combo.getBurger());
        exibirItem("Bebida", combo.getBebida());
        exibirItem("Sobremesa", combo.getSobremesa());
        System.out.println("==========================");
    }

    private void exibirItem(String tipo, ItemCombo item) {
        if (item == null) {
            System.out.printf("%-12s: %s%n", tipo, "—");
        } else {
            System.out.printf("%-12s: %s - R$ %.2f%n", tipo, item.getNome(), item.getPreco());
        }
    }

    public double getPrecoTotal() {
        if (combo == null) return 0.0;
        return combo.getPrecoTotal();
    }
}
