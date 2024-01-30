package ServiceLayer;

import Currency.Currency;
import DLayer.ExchangeRepository;
import DLayer.Rates;
import Model.ExchangeOperation;

import java.util.ArrayList;

public class ExchangeService {

    // Private field 'repository' of type ExchangeRepository,
    // which will be used for interacting with exchange operation data:
    private ExchangeRepository repository;

    public ExchangeService(ExchangeRepository repository) {
        this.repository = repository;
    }


    // Public method that performs currency exchange based on the provided parameters of amount and currencies.
    // Creates a new exchange operation based on the provided parameters.
    // Calls the helper method calculateExchange to compute the exchange amount.
    // Sets the calculated exchange amount in the created operation.
    // repository.addOperation(operation): Adds the operation to the repository for saving the history.

    public double exchange(double sumIn, Currency currencyIn, Currency currencyOut) {
        ExchangeOperation operation = new ExchangeOperation(currencyIn, currencyOut, sumIn);
        double exchangeRate = Rates.getRate(operation.getCurrencyOut()) /
                Rates.getRate(operation.getCurrencyIn());
        double sumOut = calculateExchange(operation, exchangeRate);
        operation.setSumOut(sumOut);
        operation.setRate(exchangeRate);
        addOperation(operation);
        return sumOut;
    }

    // Logic for calculating the exchange amount, taking into account the exchange rate and commission:
    private double calculateExchange(ExchangeOperation operation, double exchangeRate) {
       // double exchangeRate = operation.getRate(operation.getCurrencyIn(), operation.getCurrencyOut());
        double sumOut = calculatedSumOut(operation, exchangeRate);
        return sumOut;
    }

    // Additional methods, if necessary
    private double calculatedSumOut(ExchangeOperation operation, double exchangeRate) {
        double sumOut = operation.getSumIn() * exchangeRate * (1 - operation.getCOMMISION());
        return sumOut;
    }

    private void addOperation(ExchangeOperation operation){
        this.repository.addOperation(operation);
    }

    // Public method that returns the exchange operation for the given identifier:
    public ExchangeOperation getOperation(int id) {
        // Implement this method to retrieve operation by id from the repository
        return null;
    }

    public ArrayList<ExchangeOperation> getAllOperations() {
        // Implement this method to retrieve all operations from the repository
        return null;
    }
}
