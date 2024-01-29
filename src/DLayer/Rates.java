package DLayer;
import Currency.Currency;
import java.util.HashMap;;

public class Rates {
    private static final String BASE_CURRENCY = "EUR";

    // Hash map for storing exchange rates
    private static final HashMap<String, Double> rates = new HashMap<>();

    // Static initialization block, where exchange rates are specified
    static {
        rates.put("USD", 1.09);
        rates.put("EUR", 1.00);
        rates.put("GBP", 0.85);
        rates.put("CHF", 0.94);
        rates.put("CAD", 1.46);
    }

    // Method for obtaining the exchange rate for a given currency
    public static double getRate(Currency currency) {
        if (rates.containsKey(currency.name())) {
            return rates.get(currency.name());
        } else {
            throw new IllegalArgumentException("Exchange rate for " + currency.name() + " not found.");
        }
    }
}