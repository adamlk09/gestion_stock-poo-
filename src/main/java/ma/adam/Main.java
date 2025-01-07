package ma.adam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Add some default products
        System.out.println(Product.addProduct(new Product(101, "Laptop", 10, 1000.00)));
        System.out.println(Product.addProduct(new Product(102, "Phone", 20, 500.00)));

        while (choice != 7) {
            try {
                System.out.println("\n-----GESTION DE STOCK-----");
                System.out.println("1. Ajouter un produit");
                System.out.println("2. Modifier un produit");
                System.out.println("3. Supprimer un produit");
                System.out.println("4. Afficher la liste de produits");
                System.out.println("5. Rechercher un produit");
                System.out.println("6. Calculer la valeur totale du stock");
                System.out.println("7. Quitter");
                System.out.print("Veuillez choisir une option: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Code: ");
                        int code = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nom: ");
                        String nom = scanner.nextLine();
                        System.out.print("Quantité: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Prix: ");
                        double price = scanner.nextDouble();
                        System.out.println(Product.addProduct(new Product(code, nom, quantity, price)));
                        break;
                    case 2:
                        System.out.print("Code produit à modifier: ");
                        int modCode = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nouveau nom: ");
                        String newNom = scanner.nextLine();
                        System.out.print("Nouvelle quantité: ");
                        int newQuantity = scanner.nextInt();
                        System.out.print("Nouveau prix: ");
                        double newPrice = scanner.nextDouble();
                        System.out.println(Product.modifyProduct(modCode, newNom, newQuantity, newPrice));
                        break;
                    case 3:
                        System.out.print("Code produit à supprimer: ");
                        int delCode = scanner.nextInt();
                        System.out.println(Product.deleteProduct(delCode));
                        break;
                    case 4:
                        System.out.println(Product.displayProducts());
                        break;
                    case 5:
                        System.out.print("Code produit à rechercher: ");
                        int searchCode = scanner.nextInt();
                        System.out.println(Product.searchProduct(searchCode));
                        break;
                    case 6:
                        System.out.println("Valeur totale du stock: " + Product.calculateTotalStockValue());
                        break;
                    case 7:
                        System.out.println("Au revoir!");
                        break;
                    default:
                        System.out.println("Option invalide.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erreur: Entrée invalide.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        scanner.close();
    }
}
