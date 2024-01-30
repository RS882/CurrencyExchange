package UILayer;

import Currency.Currency;
import DLayer.ExchangeRepository;
import Model.ExchangeOperation;

public class ExchangeUI {

    //Приватное поле repository типа ExchangeRepository,
// которое будет использоваться для взаимодействия с данными об операциях обмена:
    private ExchangeRepository repository;

    // Конструктор:
    public  ExchangeService (ExchangeRepository repository) {
        this.repository = repository;
    }
    // Публичный метод, выполняющий обмен валюты на основе переданных параметров суммы и валют.
    // Создание новой операции обмена валюты на основе переданных параметров.
    // Вызов вспомогательного метода calculateExchange для вычисления суммы для обмена.
    //Установка рассчитанной суммы обмена в созданной операции.
    //repository.addOperation(operation): Добавление операции в репозиторий для сохранения истории:

    public double exchange(double sumIn, Currency currencyIn, Currency currencyOut) {
        ExchangeOperation operation = new ExchangeOperation(currencyIn, currencyOut, sumIn);
        double sumOut = calculateExchange(operation);
        operation.setSumOut(sumOut);
        // Сохранение операции в репозитории
        repository.addOperation(operation);
        return sumOut;
    }
    // Логика вычисления суммы для обмена, учета курса обмена и комиссии:
    private double calculateExchange(ExchangeOperation operation) {
        return calculatedSumOut;
    }
    // Публичный метод, возвращающий операцию обмена по заданному идентификатору:
    public ExchangeOperation getOperation(int id) {
        return repository.getOperation(id);
    }
    // Публичный метод, врзвращающий метод всех операций:
    public List getAllOperations() {
        return repository.getAllOperations(); }

    // Дополнительные методы, если необходимо
    private double calculatedSumOut (ExchangeOperation operation){
        double exchangeRate = operation.getRate(operation.getCurrencyIn(), operation.getCurrencyOut());
        double sumOut = operation.getSumIn() * exchangeRate * (1 - operation.getCOMMISION()){
            return sumOut;
        }
    }
}
