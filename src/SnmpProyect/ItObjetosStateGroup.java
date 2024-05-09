package SnmpProyect;
import java.io.*;
import com.ireasoning.protocol.snmp.*;

/**
 * Class represents itObjetosState mib object in NK_MIB
 */
public class ItObjetosStateGroup extends SnmpBaseGroup implements ItObjetosStateGroupMBean
{
    // SnmpOID: .1.3.6.1.4.1.47454.1.3.1.0
    protected int _itNumFiles = 0;
    
    /**
     * Constructor
     * @param root SnmpOID tree root
     * @param oid the SnmpOID of this group
     * @param args the objects passed from caller for Initialization purpose
     */
    public ItObjetosStateGroup(OIDTreeNode root, String oid, Object [] args)
    {
        super(root, oid);
        // TODO: Add your implementation
    }
    
    /**
     * Gets new itNumFiles value
     */
    public synchronized int getItNumFiles()
    {
        // TODO: Add your implementation
        return this._itNumFiles;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItNumFilesValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	// Check if the new value is valid (e.g., positive integer)
        if (!(newValue instanceof Integer)) {
            throw new SnmpException("Invalid data type for itNumFiles. Expected Integer.");
        }

        int value = (Integer) newValue;

        // Perform additional validation if needed
        if (value < 0) {
            throw new SnmpException("itNumFiles value must be a non-negative integer.");
        }

        setItNumFiles(value); // Set the value after validation
        // Write the value to the file
        String ruta = "C:\\prueba\\estado.txt";
        try (Writer wr = new FileWriter(ruta)) {
            wr.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        } 
    	
    }
    
    /**
     * Sets new itNumFiles value
     * @param value the new value
     */
    public synchronized void setItNumFiles(int newValue)
    {
        // TODO: Add your implementation
        this._itNumFiles = newValue;
    }
    
}
