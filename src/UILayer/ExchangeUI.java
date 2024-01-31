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

        System.out.print("Введите валюту для обмена (USD, EUR, GBP, CHF, CAD): ");
        String currencyInStr = scanner.next();
        Currency currencyIn = Currency.get(currencyInStr);

        System.out.print("Введите валюту, которую вы хотите приобрести (USD, EUR, GBP, CHF, CAD): ");
        String currencyOutStr = scanner.next();
        Currency currencyOut = Currency.get(currencyOutStr);

        double sumOut = exchangeService.exchange(sumIn, currencyIn, currencyOut);

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
