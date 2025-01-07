package ma.adam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("-----GESTION DE STOCK-----");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Modifier un produit");
            System.out.println("3. Supprimer un produit");
            System.out.println("4. Afficher la liste de produits");
            System.out.println("5. Rechercher un produit");
            System.out.println("6. Calculer la valeur totale d'un stock");
            System.out.println("7. Quitter");
            System.out.print("Veuillez choisir une option: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Entrez le code du produit: ");
                        int codeAdd = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Entrez le nom du produit: ");
                        String nomAdd = scanner.nextLine();
                        System.out.print("Entrez la quantité: ");
                        int quantityAdd = scanner.nextInt();
                        System.out.print("Entrez le prix: ");
                        double priceAdd = scanner.nextDouble();
                        System.out.println(manager.addProduct(new Product(codeAdd, nomAdd, quantityAdd, priceAdd)));
                    }
                    case 2 -> {
                        System.out.print("Entrez le code du produit à modifier: ");
                        int codeMod = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Entrez le nouveau nom du produit: ");
                        String nomMod = scanner.nextLine();
                        System.out.print("Entrez la nouvelle quantité: ");
                        int quantityMod = scanner.nextInt();
                        System.out.print("Entrez le nouveau prix: ");
                        double priceMod = scanner.nextDouble();
                        System.out.println(manager.modifyProduct(codeMod, nomMod, quantityMod, priceMod));
                    }
                    case 3 -> {
                        System.out.print("Entrez le code du produit à supprimer: ");
                        int codeDel = scanner.nextInt();
                        System.out.println(manager.deleteProduct(codeDel));
                    }
                    case 4 -> System.out.println(manager.displayProducts());
                    case 5 -> {
                        System.out.print("Entrez le code du produit à rechercher: ");
                        int codeSearch = scanner.nextInt();
                        System.out.println(manager.searchProduct(codeSearch));
                    }
                    case 6 -> System.out.println("Valeur totale du stock: " + manager.calculateTotalStockValue());
                    case 7 -> {
                        System.out.println("Quitter le programme. À bientôt!");
                        return;
                    }
                    default -> System.out.println("Option invalide, veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Erreur: Veuillez entrer un nombre valide.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
