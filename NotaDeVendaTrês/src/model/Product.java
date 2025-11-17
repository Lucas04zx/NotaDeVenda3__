package model;

public class Product {
    private String description;
    private double unitPrice;
    private int stockQuantity;

    public Product(String code) {
        String[] data = DBMock.selectProduct(code);

        if (data == null)
            throw new IllegalArgumentException("Invalid product code: " + code);

        this.description = data[0];
        this.unitPrice = Double.parseDouble(data[1]);
        this.stockQuantity = Integer.parseInt(data[2]);
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return unitPrice;
    }

    public int getStock() {
        return stockQuantity;
    }

    public boolean hasStock(int quantity) {
        return stockQuantity >= quantity;
    }

    public void decreaseStock(int quantity) {
        stockQuantity -= quantity;
    }
}
