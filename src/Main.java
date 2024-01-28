import Currency.Currency;
import Model.ExchangeOperation;

public class Main {
    public static void main(String[] args) {
        ExchangeOperation exchangeOperation =new ExchangeOperation(
               Currency.EUR,Currency.USD,1000.22342432        );
        System.out.println(exchangeOperation);

    }
}
