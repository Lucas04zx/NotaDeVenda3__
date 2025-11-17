package model;

public class SaleItem {
    private Product product;
    private int quantity;

    public SaleItem(String productCode, int quantity) {
        this.product = new Product(productCode);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getTotalAmount() {
        return quantity * product.getPrice();
    }
}
