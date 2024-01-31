package UILayer;
import Currency.Currency;
import DLayer.ExchangeRepository;
import Model.ExchangeOperation;
import ServiceLayer.ExchangeService;
import java.util.Scanner;

public class ExchangeUI {
    private static final ExchangeService exchangeService = new ExchangeService();

    public static void run() {
        int choice;
        do {
            System.out.println("1. Обмен валюты");
            System.out.println("2. Получить информацию об операции");
            System.out.println("3. Получить историю операций");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    exchange();
                    break;
                case 2:
                    getOperation();
                    break;
                case 3:
                    getAllOperations();
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный ввод. Попробуйте снова.");
            }
        } while (choice != 4);
    }
    public static void exchange() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите сумму для обмена: ");
        double sumIn = scanner.nextDouble();

        if ((sumIn) < 0) {
            System.out.println("Отрицательная сумма. Попробуйте снова.");
        }

        System.out.println("Выберите валюту для обмена: ");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. GBP");
        System.out.println("4. CHF");
        System.out.println("5. CAD");
        System.out.print("Выберите действие: ");

        int currencyInChoice = scanner.nextInt();
        Currency currencyIn;

        switch (currencyInChoice) {
            case 1:
                currencyIn = Currency.USD;
                break;
            case 2:
                currencyIn = Currency.EUR;
                break;
            case 3:
                currencyIn = Currency.GBP;
                break;
            case 4:
                currencyIn = Currency.CHF;
                break;
            case 5:
                currencyIn = Currency.CAD;
                break;
            default:
                System.out.println("Неверный выбор валюты. Попробуйте снова.");
                return;
        }

        System.out.println("Выберите валюту, которую вы хотите приобрести: ");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. GBP");
        System.out.println("4. CHF");
        System.out.println("5. CAD");
        System.out.print("Выберите действие: ");

        int currencyOutChoice = scanner.nextInt();
        Currency currencyOut;

        switch (currencyOutChoice) {
            case 1:
                currencyOut = Currency.USD;
                break;
            case 2:
                currencyOut = Currency.EUR;
                break;
            case 3:
                currencyOut = Currency.GBP;
                break;
            case 4:
                currencyOut = Currency.CHF;
                break;
            case 5:
                currencyOut = Currency.CAD;
                break;
            default:
                System.out.println("Неверный выбор валюты. Попробуйте снова.");
                return;
        }
        ExchangeOperation sumOut = exchangeService.exchange(sumIn, currencyIn, currencyOut);

        System.out.println("Вы получите " + sumOut + " " + currencyOut);
    }
    public static void getOperation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID операции: ");
        int id = scanner.nextInt();

        ExchangeOperation operation = ExchangeRepository.getOperation(id);

        if (operation != null) {
            System.out.println(operation);
        } else {
            System.out.println("Операция с ID " + id + " не найдена.");
        }
    }
    private static void getAllOperations() {
        assert ExchangeRepository.getAllOperations() != null;
        for (ExchangeOperation operation : ExchangeRepository.getAllOperations()) {
            System.out.println(operation);
        }
    }
}
