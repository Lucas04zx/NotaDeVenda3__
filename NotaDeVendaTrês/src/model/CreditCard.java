package model;

public class CreditCard implements Payment {

    private double feeRate;

    public CreditCard(double feeRate) {
        this.feeRate = feeRate / 100;
    }

    @Override
    public double valueToBePaid(double value) {
        return value + (feeRate * value);
    }

    @Override
    public String toString() {
        return "Cartão de Crédito";
    }
}
