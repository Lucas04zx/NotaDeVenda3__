package model;
public class Cash implements Payment {
    private double discountRate;

    public Cash(double discountRate) {
        this.discountRate = discountRate / 100;
    }

    @Override
    public double valueToBePaid(double value) {
        return value - (discountRate * value);
    }

    @Override
    public String toString() {
        return "Pix/Dinheiro";
    }
}
