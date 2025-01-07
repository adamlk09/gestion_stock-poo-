package ma.adam;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private static final int MAX_PRODUCTS = 100;
    private List<Product> products = new ArrayList<>();

    public String addProduct(Product product) {
        if (products.size() >= MAX_PRODUCTS) {
            return "Erreur: Capacité maximale atteinte.";
        }
        if (products.stream().anyMatch(p -> p.getCode() == product.getCode())) {
            return "Erreur: Un produit avec ce code existe déjà.";
        }
        products.add(product);
        return "Produit ajouté avec succès.";
    }

    public String modifyProduct(int code, String newNom, int newQuantity, double newPrice) {
        for (Product product : products) {
            if (product.getCode() == code) {
                product.setNom(newNom);
                product.setQuantity(newQuantity);
                product.setPrice(newPrice);
                return "Produit modifié avec succès : " + product;
            }
        }
        return "Erreur: Produit introuvable.";
    }

    public String deleteProduct(int code) {
        if (products.removeIf(p -> p.getCode() == code)) {
            return "Produit supprimé avec succès.";
        }
        return "Erreur: Produit introuvable.";
    }

    public String displayProducts() {
        if (products.isEmpty()) {
            return "Aucun produit dans le stock.";
        }
        StringBuilder sb = new StringBuilder("Liste des produits :\n");
        for (Product product : products) {
            sb.append(product).append("\n");
        }
        return sb.toString();
    }

    public String searchProduct(int code) {
        return products.stream()
                .filter(p -> p.getCode() == code)
                .findFirst()
                .map(Product::toString)
                .orElse("Erreur: Produit introuvable.");
    }

    public double calculateTotalStockValue() {
        return products.stream()
                .mapToDouble(Product::calculateTotal)
                .sum();
    }
}
