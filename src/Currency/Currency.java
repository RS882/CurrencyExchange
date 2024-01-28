package Currency;

/**
 * Enum with currency names
 *
 * if the currency name is incorrect, the exception IllegalArgumentExceptionis passed on
 */
public enum Currency {
    USD,EUR,GBP,CHF,CAD;
    public static Currency get(String str) throws IllegalArgumentException{
            return Currency.valueOf(str);
    }
}
