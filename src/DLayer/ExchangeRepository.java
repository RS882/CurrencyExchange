package DLayer;

import Model.ExchangeOperation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRepository {

    private static final String FILE_PATH = "src/exchangeLog.txt";
    private File file;
    private List<ExchangeOperation> operations = new ArrayList<>();

    public boolean addOperation(ExchangeOperation operation){
        return false;
    }

    public ExchangeOperation getOperation(int id){
        return null;
    }

    public ArrayList<ExchangeOperation> getAllOpertions(){
        return null;
    }



}
