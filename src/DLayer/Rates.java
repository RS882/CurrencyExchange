package DLayer;

import Currency.Currency;
import java.util.HashMap;

public class Rates {
    // Путь к файлу с курсами валют
    private static final String RATES_FILE_PATH = "exchangeRates.txt";
    // Базовая валюта, относительно которой указаны курсы обмена
    private static final String BASE_CURRENCY = "EUR";

    // Хэш-мап для хранения курсов валют (валюта -> курс)
    private static final HashMap<String, Double> rates = new HashMap<>();

    // Статический блок инициализации, где указываются курсы валют
    static {
        // Инициализация курсов валют из файла (можно также реализовать чтение из файла)
        rates.put("CHF", 0.94);
        rates.put("USD", 1.09);
        rates.put("GBP", 0.85);
        rates.put("CAD", 1.46);
    }

    // Метод для получения курса обмена для заданной валюты
    public static double getRate(Currency currency) {
        // Возвращаем курс обмена для указанной валюты
        return rates.get(currency.name());
    }
}