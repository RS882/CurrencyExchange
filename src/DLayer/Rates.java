package DLayer;
import Currency.Currency;
import java.util.HashMap;;

public class Rates {
    private static final String BASE_CURRENCY = "EUR";

    // Hash map for storing exchange rates
    private static final HashMap<Currency, Double> rates = new HashMap<>();

    // Static initialization block, where exchange rates are specified
    static {
        rates.put(Currency.USD, 1.09);
        rates.put(Currency.EUR, 1.00);
        rates.put(Currency.GBP, 0.85);
        rates.put(Currency.CHF, 0.94);
        rates.put(Currency.CAD, 1.46);
    }

    // Method for obtaining the exchange rate for a given currency
    public static double getRate(Currency currency) {
        if (rates.containsKey(currency)) {
            return rates.get(currency);
        } else {
            throw new IllegalArgumentException("Exchange rate for " + currency.name() + " not found.");
        }
    }
}