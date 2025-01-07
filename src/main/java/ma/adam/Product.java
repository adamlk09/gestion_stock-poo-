package ma.adam;

public class Product {
    private int code;
    private String nom;
    private int quantity;
    private double price;

    // Constructors
    public Product(int code, String nom, int quantity, double price) {
        this.code = code;
        this.nom = nom;
        this.quantity = quantity > 0 ? quantity : throwIllegalArgument("La quantité doit être positive.");
        this.price = price > 0 ? price : throwIllegalArgument("Le prix doit être positif.");
    }

    public Product() {}

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new IllegalArgumentException("La quantité doit être positive.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Le prix doit être positif.");
        }
    }

    public double calculateTotal() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("Product{Code=%d, Nom='%s', Quantity=%d, Price=%.2f}", code, nom, quantity, price);
    }

    private int throwIllegalArgument(String message) {
        throw new IllegalArgumentException(message);
    }
}
