import com.tam.utility.FileUtil.ExcelManager;
import com.tam.utility.FileUtil.ReadJson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;

public class Rough {

    public static void main(String[] args) throws IOException {
//        ReadJson readJson = new ReadJson("Opportunity");
//        JSONArray searchQueries = (JSONArray) readJson.getArrayObject();
//        System.out.println(searchQueries);
//
//        JSONObject users = (JSONObject) searchQueries.get(1);
//        System.out.println(users);

        //ExcelManager excelManager = new ExcelManager("Opportunity","TC 002");
//        System.out.println(excelManager.getCellData(1,0));
//        System.out.println(excelManager.getCellData(1,1));
//        System.out.println(excelManager.numOfRows());

        //iterate rows
//        for(int i=1; i<=excelManager.numOfRows();i++){
//            System.out.println(excelManager.getCellData(i,0));
//        }

        //iterate columns
//        for(int i=0; i<excelManager.numOfColumns();i++){
//            System.out.println(excelManager.getCellData(1,i));          //need to replace the hardcoded 1 with some String
//        }

//        System.out.println(excelManager.getDataByColumnName("Country"));
//        System.out.println(excelManager.getDataByColumnName("City"));
//        System.out.println(excelManager.getDataByColumnName("Phone"));
//        System.out.println(excelManager.getDataByColumnName("FirstName"));

//        ExcelManager excelManager1 = new ExcelManager("LoginData","UK Sales Rep");
//        System.out.println(excelManager1.getDataByColumnName("Username"));
//        System.out.println(excelManager1.getDataByColumnName("Password"));
//
//        ExcelManager excelManager2 = new ExcelManager("LoginData","US Sales Rep");
//        System.out.println(excelManager2.getDataByColumnName("Username"));
//        System.out.println(excelManager2.getDataByColumnName("Password"));

        ExcelManager excelManager = new ExcelManager("Opportunity");
        System.out.println(excelManager.listOfColumns());
    }
}
