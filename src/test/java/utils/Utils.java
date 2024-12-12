package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class Utils {
    static  String  UsersfilePath="./src/test/resources/users.json";
    static String costDetailsFilePath=System.getProperty("user.dir")+"/src/test/resources/testdata/cost_details.xlsx";
    public static int randomNumber(int min,int max)
    {
        double random = Math.random()*(max-min)+min;
        return (int) random;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Double.valueOf("10.0").intValue());



    }

    public static void setUserInfo( JSONObject object) throws IOException, ParseException {
        JSONParser parser = new JSONParser() ;
       JSONArray users= (JSONArray) parser.parse(new FileReader(UsersfilePath));
       users.add(object);
        FileWriter fw = new FileWriter(UsersfilePath);
        fw.write(String.valueOf(users));
        fw.flush();
        fw.close();
    }
    public static JSONObject getLastUserInfo() throws IOException, ParseException {
        JSONParser parser = new JSONParser() ;
        JSONArray users= (JSONArray) parser.parse(new FileReader(UsersfilePath));
        JSONObject object = (JSONObject) users.get(users.size()-1);
        return object;

    }
   public static String[] getCostData(int rowNumber) throws IOException {
       File fileCheck = new File(costDetailsFilePath);
       String cell_string_val="";
       if (!fileCheck.exists()) {
           System.out.println("File not found at: " + fileCheck.getAbsolutePath());
           System.exit(1);
       }

       String[] str= new String[6];
       try {

           FileInputStream file = new FileInputStream(costDetailsFilePath);
           XSSFWorkbook workbook = new XSSFWorkbook(file);
           // XSSFSheet sheet = workbook.getSheetAt(0);
           XSSFSheet sheet = workbook.getSheet("Sheet1");
          // int total_row=sheet.getLastRowNum();
           int total_column=sheet.getRow(0).getLastCellNum();
           XSSFRow row=sheet.getRow(rowNumber);
           for(int i =0;i<6;i++) {
               XSSFCell cell = row.getCell(i);
               cell_string_val = cell.toString();
               str[i]= cell_string_val;
           }

           workbook.close();
           file.close();

       } catch (Exception e) {
           e.printStackTrace();
           System.exit(1); // Optional: Handle clean exit if needed
       }

return str;
   }


}
