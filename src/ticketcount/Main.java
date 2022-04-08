package ticketcount;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Robbie Kincaid
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int triage = 0;
        int repair = 0;
        
        Ticket tickets = new Ticket();
        CSVOutput csv = new CSVOutput();
        
        // Setting up the window
        JFrame frame = new JFrame("Ticket Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        
        // Top menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        menuBar.add(menu1);
        JMenuItem item1 = new JMenuItem("Export Count as CSV");
        menu1.add(item1);
        
        // Whitespace for text to display
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        
        // Scroll bar
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(300, 300));
        
        // Program entry text
        textArea.append("Welcome to the tracker. Please use the buttons below to track your tickets.");
        textArea.append("\n");
        textArea.append("You can display totals at any time and export a CSV via the File menu.");
        textArea.append("\n");
        textArea.append("\n");
        
        // Handle clicks on the Export Count as CSV button
        item1.addActionListener(e ->
        {
            csv.convertToCSV(tickets.getTriage(), tickets.getRepair(), tickets.getTicketCount());
            textArea.append("\n");
            textArea.append("Ticket totals CSV file exported!");
            textArea.append("\n");
        });
        
        // Bottom panel
        JPanel panel = new JPanel();
        JButton triageButton = new JButton("Track Triage Ticket!");
        // Handle Triage button click
        triageButton.addActionListener(e ->
        {
            tickets.addTriage();
            textArea.append("Tracked one Triage ticket!");
            textArea.append("\n");
        });
        
        JButton repairButton = new JButton("Track Repair Ticket!");
        // Handle Repair button click
        repairButton.addActionListener(e ->
        {
            tickets.addRepair();
            textArea.append("Tracked one Repair ticket!");
            textArea.append("\n");
        });
        
        JButton ticketCountButton = new JButton("Display Total");
        // Handle ticketCount button click
        ticketCountButton.addActionListener(e ->
        {
            tickets.getTicketCount();
            textArea.append("\n");
            textArea.append("Triage: " + tickets.getTriage() + ". Repair: " + tickets.getRepair() + ".");
            textArea.append("\n");
            if (tickets.getTicketCount() == 1){
                textArea.append("That's 1 ticket for the day.");
            }
            else {
                textArea.append("That's a total of " + tickets.getTicketCount() + " tickets today.");
            }
            textArea.append("\n");
        });
        
        panel.add(triageButton);
        panel.add(repairButton);
        panel.add(ticketCountButton);
        
        // Add the components to the frame
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, scroller);
        frame.setVisible(true);
    }
    
}
