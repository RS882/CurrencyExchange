package ServiceLayer;

import Currency.Currency;
import DLayer.ExchangeRepository;
import DLayer.Rates;
import Model.ExchangeOperation;

import java.util.ArrayList;

public class ExchangeService {

    // Private field 'repository' of type ExchangeRepository,
    // which will be used for interacting with exchange operation data:
    private final ExchangeRepository repository = new ExchangeRepository();


    // Public method that performs currency exchange based on the provided parameters of amount and currencies.
    // Creates a new exchange operation based on the provided parameters.
    // Calls the helper method calculateExchange to compute the exchange amount.
    // Sets the calculated exchange amount in the created operation.
    // repository.addOperation(operation): Adds the operation to the repository for saving the history.

    public ExchangeOperation exchange(double sumIn, Currency currencyIn, Currency currencyOut) {
        ExchangeOperation operation = new ExchangeOperation(currencyIn, currencyOut, sumIn);
        double exchangeRate = Rates.getRate(operation.getCurrencyOut()) /
                Rates.getRate(operation.getCurrencyIn());
        double sumOut = calculateExchange(operation, exchangeRate);

        operation.setSumOut(sumOut);
        operation.setRate(exchangeRate);

        addOperation(operation);

        return operation;
    }

    // Logic for calculating the exchange amount, taking into account the exchange rate and commission:
    private double calculateExchange(ExchangeOperation operation, double exchangeRate) {
        double sumOut = operation.getSumIn() * exchangeRate * (1 - operation.getCOMMISION() / 100);
        return sumOut;
    }

    private void addOperation(ExchangeOperation operation) {
        this.repository.addOperation(operation);
    }

    // Public method that returns the exchange operation for the given identifier:
    public ExchangeOperation getOperation(int id) {
              return this.repository.getOperation(id);
    }


    public ArrayList<ExchangeOperation> getAllOperations() {
        return this.repository.getAllOperations();
    }
}


