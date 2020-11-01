import java.io.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class TxtToXls
{
 private static BufferedReader bufferedReader;
 public static void main(String[] args) throws IOException{
 bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Mr__.Solanki\\Desktop\\vipin.txt"));
        //Can put source text file at place of Pradip.txt
  FileOutputStream fos = new FileOutputStream("NewExcel.xls");
  HSSFWorkbook wbook = new HSSFWorkbook();
  HSSFSheet fs = wbook.createSheet("First Sheet");
  Row row = null;
  Cell cell = null;
  String line = null;
  String[] temp;
  String delimiter = ",";
   int j=0,k=0;
                while ((line = bufferedReader.readLine()) != null) {
     
         temp = line.split(delimiter);
    
         System.out.println(""+temp.length);
    
         for(int i =0; i < temp.length ; i++){
          
          
          if(k==0)
          {
           row = fs.createRow(j);
          }
          if(i%2==0)
          {
          cell=row.createCell(k);
          cell.setCellValue(temp[i]);
          k=k+1;
          }
          else
          {
          cell=row.createCell(1);
          cell.setCellValue(temp[i]); 
          j=j+1;
          k=k-1;
          }
 
         }
         System.out.println();
        }
  
                wbook.write(fos);
   fos.close();
 }

}