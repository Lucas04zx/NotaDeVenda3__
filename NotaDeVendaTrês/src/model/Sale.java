package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

    private List<SaleItem> saleItems;
    private Payment paymentMethod;

    public Sale() {
        saleItems = new ArrayList<>();
    }

    public boolean addItem(String code, int quantity) {
        SaleItem item = new SaleItem(code, quantity);

        if (!item.getProduct().hasStock(quantity)) {
            System.out.println("Estoque insuficiente: " + item.getProduct().getDescription());
            return false;
        }

        item.getProduct().decreaseStock(quantity);
        return saleItems.add(item);
    }

    public double getTotalAmount() {
        double total = 0;

        for (SaleItem item : saleItems) {
            total += item.getTotalAmount();
        }

        return total;
    }

    public List<SaleItem> getItems() {
        return saleItems;
    }

    public void createPayment(String code) {
        paymentMethod = DBMock.selectPayment(code);
    }

    public double valueToBePaid() {
        if (paymentMethod == null)
            throw new IllegalStateException("Payment method not defined");

        return paymentMethod.valueToBePaid(getTotalAmount());
    }

    public String paymentMethod() {
        return paymentMethod == null ? "" : paymentMethod.toString();
    }
}
