package SnmpProyect;
import com.ireasoning.protocol.snmp.SnmpBaseGroupMBean;
import com.ireasoning.protocol.snmp.SnmpException;
import com.ireasoning.protocol.snmp.SnmpPdu;

/**
 * Interface represents itObjetosConfig mib object in NK_MIB
 */
public interface ItObjetosConfigGroupMBean extends SnmpBaseGroupMBean
{
    /**
     * Gets new rootFolder value
     */
    public String getRootFolder();
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param value the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public void preSetRootFolderValue(Object value, SnmpPdu pdu);
    
    /**
     * Sets new rootFolder value
     * @param value the new value
     */
    public void setRootFolder(String value);
    
    /**
     * Gets new itDeleteFiles value
     */
    public int getItDeleteFiles();
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param value the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public void preSetItDeleteFilesValue(Object value, SnmpPdu pdu);
    
    /**
     * Sets new itDeleteFiles value
     * @param value the new value
     */
    public void setItDeleteFiles(int value);
    
    /**
     * Gets new itTestAndIncr value
     */
    public int getItTestAndIncr();
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param value the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public void preSetItTestAndIncrValue(Object value, SnmpPdu pdu);
    
    /**
     * Sets new itTestAndIncr value
     * @param value the new value
     */
    public void setItTestAndIncr(int value);
    
    /**
     * Gets new itUmbralFiles value
     */
    public int getItUmbralFiles();
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param value the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public void preSetItUmbralFilesValue(Object value, SnmpPdu pdu);
    
    /**
     * Sets new itUmbralFiles value
     * @param value the new value
     */
    public void setItUmbralFiles(int value);
    
    /**
     * Gets new itActivarEvents value
     */
    public int getItActivarEvents();
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param value the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public void preSetItActivarEventsValue(Object value, SnmpPdu pdu);
    
    /**
     * Sets new itActivarEvents value
     * @param value the new value
     */
    public void setItActivarEvents(int value);
    
}
