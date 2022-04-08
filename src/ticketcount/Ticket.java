package ticketcount;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Robbie Kincaid
 */
public class Ticket {
    private int triage = 0;
    private int repair = 0;
    private int ticketCount = 0;
    
    
    /**
     *
     */
    public Ticket(){
        
    }
    
    /**
     *
     * @param triage
     */
    public void setTriage(int triage){
        this.triage = triage;
    }
    
    /**
     *
     * @param repair
     */
    public void setRepair(int repair){
        this.repair = repair;
        
    }
    
    /**
     *
     * @return
     */
    public int getTriage(){
        return triage;
    }
    
    /**
     *
     * @return
     */
    public int getRepair(){
        return repair;
    }
    
    public void addTriage(){
        triage = triage + 1;
    }
    
    public void addRepair(){
        repair = repair + 1;
    }
    
    public int getTicketCount(){
        ticketCount = triage + repair;
        return ticketCount;
    }
    
}
