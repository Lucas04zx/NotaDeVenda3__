package view;

import java.time.LocalDate;
import model.Sale;
import model.SaleItem;
import model.SalePresenter;

public class ConsoleSalePresenter implements SalePresenter {

    @Override
    public void show(Sale sale) {
        System.out.println("Nota de Venda - " + LocalDate.now());

        System.out.printf("%-15s %-10s %-10s %-10s\n",
                "Produto", "Preço", "Qtd", "Total");

        for (SaleItem item : sale.getItems()) {
            int len = Math.min(item.getProduct().getDescription().length(), 15);

            System.out.printf("%-15s %-10.2f %-10d %-10.2f\n",
                    item.getProduct().getDescription().substring(0, len),
                    item.getProduct().getPrice(),
                    item.getQuantity(),
                    item.getTotalAmount());
        }

        System.out.printf("%37s %.2f\n", "Total", sale.getTotalAmount());
        System.out.printf("%37s %s\n", "Método", sale.paymentMethod());
        System.out.printf("%37s %.2f\n", "Valor Pago", sale.valueToBePaid());
    }
}
