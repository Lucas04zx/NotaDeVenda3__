package model;

public class DebitCard implements Payment {
    private double discountRate;

    public DebitCard(double discountRate) {
        this.discountRate = discountRate / 100;
    }

    @Override
    public double valueToBePaid(double value) {
        return value - (value * discountRate);
    }

    @Override
    public String toString() {
        return "Cartão de Débito";
    }
}
