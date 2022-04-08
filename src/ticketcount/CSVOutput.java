package ticketcount;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Robbie Kincaid
 */
public class CSVOutput {
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy");
    Date date = new Date();
    
    private int triage = 0;
    private int repair = 0;
    private int ticketCount = 0;
    private String day = formatter.format(date) + "_Ticket_Count.csv";
    File csvFile = new File(day);
    
    /**
     *
     */
    public CSVOutput(){
        
    }
    
    /**
     *
     * @param triage
     * @param repair
     * @param ticketCount
     */
    public void convertToCSV(int triage, int repair, int ticketCount){
        try {
            FileWriter fileWriter = new FileWriter(csvFile);
            fileWriter.append("Triage Count");
            fileWriter.append(",");
            fileWriter.append("Repair Count");
            fileWriter.append(",");
            fileWriter.append("Total Ticket Count");
            fileWriter.append("\n");
            fileWriter.append(""+triage);
            fileWriter.append(",");
            fileWriter.append(""+repair);
            fileWriter.append(",");
            fileWriter.append(""+ticketCount);
            fileWriter.append("\n");
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Could not write to the file");
        }
    }
}
