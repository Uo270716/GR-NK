package SnmpProyect;
import com.ireasoning.protocol.snmp.*;

/**
 * Class represents itObjetosInfo mib object in NK_MIB
 */
public class ItObjetosInfoGroup extends SnmpBaseGroup implements ItObjetosInfoGroupMBean
{
    // SnmpOID: .1.3.6.1.4.1.47454.1.2.1.0
    protected int _itDirRequests = 0;
    // SnmpOID: .1.3.6.1.4.1.47454.1.2.2.0
    protected int _itFrecSondeo = 2; // DEFVAL is "2"
    
    /**
     * Constructor
     * @param root SnmpOID tree root
     * @param oid the SnmpOID of this group
     * @param args the objects passed from caller for Initialization purpose
     */
    public ItObjetosInfoGroup(OIDTreeNode root, String oid, Object [] args)
    {
        super(root, oid);
        // TODO: Add your implementation
    }
    
    /**
     * Gets new itDirRequests value
     */
    public synchronized int getItDirRequests()
    {
        // TODO: Add your implementation
        return this._itDirRequests;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItDirRequestsValue(Object newValue, SnmpPdu pdu) 
    {
    	// Adicional para mi diseño
    	if (!(newValue instanceof Integer)) {
	        throw new SnmpException("Invalid data type. Expected Integer for itDirRequests.");
	    }
	
	    int value = (int) newValue;
	
	    if (value < 0 || value > 100) {
	        throw new SnmpException("Invalid value. itDirRequests must be between 0 and 100.");
	    }        
    	
    }
    
    /**
     * Sets new itDirRequests value
     * @param value the new value
     */
    public synchronized void setItDirRequests(int newValue)
    {
        // TODO: Add your implementation
        this._itDirRequests = newValue;
    }
    
    /**
     * Gets new itFrecSondeo value
     */
    public synchronized int getItFrecSondeo()
    {
        // TODO: Add your implementation
        return this._itFrecSondeo;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItFrecSondeoValue(Object newValue, SnmpPdu pdu) 
    {
    	// Adicional para mi diseño
        // Ensure newValue is an Integer (assuming it should be an integer)
	    if (!(newValue instanceof Integer)) {
	        throw new SnmpException("Invalid data type. Expected Integer for itFrecSondeo.");
	    }
	
	    int value = (int) newValue;
	
	    // Perform specific validation checks based on your requirements
	    if (value < 0 || value > 10) {
	        throw new SnmpException("Invalid value. itFrecSondeo must be between 0 and 10.");
	    }
        
    }
    
    /**
     * Sets new itFrecSondeo value
     * @param value the new value
     */
    public synchronized void setItFrecSondeo(int newValue)
    {
        // TODO: Add your implementation
        this._itFrecSondeo = newValue;
    }
    
}
