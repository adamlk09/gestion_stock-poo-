package ma.adam;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int code;
    private String nom;
    private int quantity;
    private double price;

    private static final int MAX_PRODUCTS = 10; // Maximum capacity for products
    private static List<Product> products = new ArrayList<>();

    // Constructor
    public Product(int code, String nom, int quantity, double price) {
        this.code = code;
        this.nom = nom;
        this.quantity = quantity;
        this.price = price;
    }

    public Product() {}

    // Getters
    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("La quantité doit être positive.");
        }
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Le prix doit être positif.");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "Code=" + code +
                ", Nom='" + nom + '\'' +
                ", Quantity=" + quantity +
                ", Price=" + price +
                '}';
    }

    public double calculateTotal() {
        return price * quantity;
    }

    // Add a new product
    public static String addProduct(Product product) {
        if (products.size() >= MAX_PRODUCTS) {
            return "Erreur: Capacité maximale atteinte. Impossible d'ajouter un produit.";
        }

        if (isCodeExists(product.getCode())) {
            return "Erreur: Un produit avec ce code existe déjà.";
        }

        if (product.getQuantity() <= 0 || product.getPrice() <= 0) {
            return "Erreur: La quantité et le prix doivent être positifs.";
        }

        products.add(product);
        return "Produit ajouté avec succès!";
    }

    // Check if a product code already exists
    public static boolean isCodeExists(int code) {
        return products.stream().anyMatch(p -> p.getCode() == code);
    }

    // Modify a product
    public static String modifyProduct(int code, String newNom, int newQuantity, double newPrice) {
        for (Product p : products) {
            if (p.getCode() == code) {
                if (newQuantity > 0) p.setQuantity(newQuantity);
                if (newPrice > 0) p.setPrice(newPrice);
                p.setNom(newNom);
                return "Produit modifié: " + p;
            }
        }
        return "Produit introuvable.";
    }

    // Delete a product
    public static String deleteProduct(int code) {
        boolean removed = products.removeIf(p -> p.getCode() == code);
        return removed ? "Produit supprimé avec succès." : "Produit introuvable.";
    }

    // Display all products
    public static String displayProducts() {
        if (products.isEmpty()) {
            return "Aucun produit dans le stock.";
        }
        StringBuilder sb = new StringBuilder("Liste des produits:\n");
        products.forEach(p -> sb.append(p).append("\n"));
        return sb.toString();
    }

    // Search for a product
    public static String searchProduct(int code) {
        for (Product p : products) {
            if (p.getCode() == code) {
                return "Produit trouvé: " + p;
            }
        }
        return "Produit introuvable.";
    }

    // Calculate the total stock value
    public static double calculateTotalStockValue() {
        return products.stream().mapToDouble(Product::calculateTotal).sum();
    }
}
