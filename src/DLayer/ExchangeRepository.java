package DLayer;

import Model.ExchangeOperation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Currency.Currency;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ExchangeRepository {

    private static final String FILE_PATH = "src/DLayer/exchangeLog.txt";

    private File file;


    public ExchangeRepository() {
        this.file = new File(FILE_PATH);
    }

    private void printError(Exception e) {
        System.err.println("Error: File is not found" + e.getMessage());
    }
    private void writeNewLine(ExchangeOperation operation)  {
        try(FileWriter writer = new FileWriter(this.file, true);) {
            writer.write(operation.getCSV() + "\n") ;
        }catch (IOException e){
            printError(e);
        }
    }

    public void addOperation(ExchangeOperation operation){
        writeNewLine(operation );

    }
    public ArrayList<ExchangeOperation> getAllOperations() {
        ArrayList<ExchangeOperation> result = new ArrayList<>();
        try (Scanner scan = new Scanner(this.file);) {
            while (scan.hasNextLine()) {
                String res[] = scan.nextLine().split(",");
                ExchangeOperation operation = new ExchangeOperation(

                        Integer.parseInt(res[0]),
                        Currency.get(res[1]),
                        Currency.get(res[2]),
                        Double.parseDouble(res[3]),
                        Double.parseDouble(res[4]),
                        parseDataTime(res[5]),
                        Double.parseDouble(res[6]),
                        Double.parseDouble(res[7])

                );
                result.add(operation);
            }


        } catch (FileNotFoundException e) {
            printError(e);
        }

        return result;
    }
    public ExchangeOperation getOperation(int id) {
        ArrayList<ExchangeOperation> arr = getAllOperations();
        for (ExchangeOperation el : arr        ) {
            if(el.getId()==id){
                return el;
            }
        }
        return null;
    }


  private LocalDateTime parseDataTime(String str){
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy HH:mm:ss"));
     return LocalDateTime.parse(str,formatter);
  }


}
