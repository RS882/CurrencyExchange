package DLayer;

import Currency.Currency;
import Model.ExchangeOperation;

public class Main_Test {
    public static void main(String[] args) {
        ExchangeRepository exchangeRepository = new ExchangeRepository();
      //  exchangeRepository.writeNewLine(new ExchangeOperation(Currency.EUR,Currency.CHF,1.9));
        exchangeRepository.addOperation(new ExchangeOperation(Currency.EUR,Currency.GBP,100.50));
    }
}
