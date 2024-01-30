package Model;

import Currency.Currency;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class data model for exchange obeparation
 * id -operation
 * currencyIn-changeable currency
 * currencyOut- currency of exchange
 * sumIn-the amount being changed
 * currencyOut-the amount exchanged
 * dateOfOperation - date and time of operation
 * COMMISION -transaction fee
 * rate -exchange rate
 *
 */
public class ExchangeOperation {
    private static int idOfOperation = 1;
    private int id;
    private Currency currencyIn;
    private Currency currencyOut;
    private double sumIn;
    private double sumOut;
    private LocalDateTime dateOfOperation;
    private final double COMMISION = 3;
    private double rate;

    public ExchangeOperation(Currency currencyIn, Currency currencyOut, double sumIn) {
        this.id = idOfOperation++;
        this.currencyIn = currencyIn;
        this.currencyOut = currencyOut;
        this.sumIn = sumIn;
        this.dateOfOperation = LocalDateTime.now();
        this.rate = 0;
        this.sumOut = 0;

    }

    public void setSumOut(double sumOut) {
        this.sumOut = sumOut;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getId() {
        return this.id;
    }

    public Currency getCurrencyIn() {
        return this.currencyIn;
    }

    public Currency getCurrencyOut() {
        return this.currencyOut;
    }

    public double getSumIn() {
        return this.sumIn;
    }

    public double getSumOut() {
        return this.sumOut;
    }

    public LocalDateTime getDateOfOperation() {
        return this.dateOfOperation;
    }

    public double getCOMMISION() {
        return this.COMMISION;
    }

    public double getRate(Currency currencyIn, Currency currencyOut) {
        return this.rate;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

                return String.format(
                "#%d. %s Exchange " +
                       "%.2f%s to %.2f%s. Exchange rate - %.4f. Commision - %.2f%%.%n",
                this.id,
                this.dateOfOperation.format(formatter),
                this.sumIn,
                this.currencyIn,
                this.sumOut,
                this.currencyOut,
                this.rate,
                this.COMMISION);
    }

    public String getCSV() {
        StringBuilder res = new StringBuilder();
        res.append(this.id + ",")
                .append(this.dateOfOperation + ",")
                .append(this.sumIn + ",")
                .append(this.currencyIn + ",")
                .append(this.sumOut + ",")
                .append(this.currencyOut + ",")
                .append(this.rate + ",")
                .append(this.COMMISION + ",");
        return res.toString();
    }

}


