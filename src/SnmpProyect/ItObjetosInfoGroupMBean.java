package SnmpProyect;
import com.ireasoning.protocol.snmp.*;

/**
 * Interface represents itObjetosInfo mib object in NK_MIB
 */
public interface ItObjetosInfoGroupMBean extends SnmpBaseGroupMBean
{
    /**
     * Gets new itDirRequests value
     */
    public int getItDirRequests();
    
    /**
     * Gets new itFrecSondeo value
     */
    public int getItFrecSondeo();
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param value the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public void preSetItFrecSondeoValue(Object value, SnmpPdu pdu);
    
    /**
     * Sets new itFrecSondeo value
     * @param value the new value
     */
    public void setItFrecSondeo(int value);
    
}
