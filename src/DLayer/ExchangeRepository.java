package DLayer;

import Model.ExchangeOperation;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRepository {

    private static final String FILE_PATH = "src/DLayer/exchangeLog.txt";

    private File file;
    private static List<ExchangeOperation> operations = new ArrayList<>();

    public ExchangeRepository() {
        this.file = new File(FILE_PATH);
    }

    private void printError(Exception e) {
        System.err.println("Error: File is not found" + e.getMessage());
    }
    public void writeNewLine(ExchangeOperation operation)  {
        try(FileWriter writer = new FileWriter(this.file, true);) {
            writer.write(operation.getCSV() + "\n") ;
        }catch (Exception e){
            printError(e);
        }
    }

    public boolean addOperation(ExchangeOperation operation){
        boolean result = this.operations.add(operation);
        if (result) {
            writeNewLine(operation );
        }
        return result;

    }

    public static ExchangeOperation getOperation(int id){
        for ( ExchangeOperation operation : operations) {
            if (operation.getId() == id){
                return operation;
            }
        }
        return null;
    }

    public static ArrayList<ExchangeOperation> getAllOperations(){
        return null;
    }
}
