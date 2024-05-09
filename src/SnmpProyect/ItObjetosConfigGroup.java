package SnmpProyect;
import java.io.*;
import com.ireasoning.protocol.snmp.*;

/**
 * Class represents itObjetosConfig mib object in NK_MIB
 */
public class ItObjetosConfigGroup extends SnmpBaseGroup implements ItObjetosConfigGroupMBean
{
    // SnmpOID: .1.3.6.1.4.1.47454.1.1.1.0
    protected String _rootFolder = "";
    // SnmpOID: .1.3.6.1.4.1.47454.1.1.2.0
    protected int _itDeleteFiles = 0;
    // SnmpOID: .1.3.6.1.4.1.47454.1.1.3.0
    protected int _itTestAndIncr = 0;
    // SnmpOID: .1.3.6.1.4.1.47454.1.1.4.0
    protected int _itGravityLevel = 0;
    // SnmpOID: .1.3.6.1.4.1.47454.1.1.5.0
    protected int _itUmbralFiles = 10; // DEFVAL is "10"
    // SnmpOID: .1.3.6.1.4.1.47454.1.1.6.0
    protected int _itActivarEvents = 1; // DEFVAL is "1"
    
    protected String ruta = "C:\\prueba\\dato.txt";
    /**
     * Constructor
     * @param root SnmpOID tree root
     * @param oid the SnmpOID of this group
     * @param args the objects passed from caller for Initialization purpose
     */
    public ItObjetosConfigGroup(OIDTreeNode root, String oid, Object [] args)
    {
        super(root, oid);
        // TODO: Add your implementation
    }
    
    /**
     * Gets new rootFolder value
     */
    public synchronized String getRootFolder()
    {
        // TODO: Add your implementation
        return this._rootFolder;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetRootFolderValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	setRootFolder((String) newValue); // Establecer el valor después de la validación
        // Escribir el valor en el archivo de texto
        try (Writer wr = new FileWriter(this.ruta)) {
            wr.write(String.valueOf(newValue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    /**
     * Sets new rootFolder value
     * @param value the new value
     */
    public synchronized void setRootFolder(String newValue)
    {
        // TODO: Add your implementation
        this._rootFolder = newValue;
    }
    
    /**
     * Gets new itDeleteFiles value
     */
    public synchronized int getItDeleteFiles()
    {
        // TODO: Add your implementation
        return this._itDeleteFiles;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItDeleteFilesValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	// Validate the new value (e.g., range check)
        if (!(newValue instanceof Integer)) {
            throw new SnmpException("Invalid data type for itDeleteFiles. Expected Integer.");
        }

        int value = (Integer) newValue;

        // Perform additional validation if needed
        if (value < 0) {
            throw new SnmpException("itDeleteFiles value must be a non-negative integer.");
        }

        setItDeleteFiles(value); // Set the value after validation
        // Write the value to the file
        try (Writer wr = new FileWriter(this.ruta)) {
            wr.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
    /**
     * Sets new itDeleteFiles value
     * @param value the new value
     */
    public synchronized void setItDeleteFiles(int newValue)
    {
        // TODO: Add your implementation
        this._itDeleteFiles = newValue;
    }
    
    /**
     * Gets new itTestAndIncr value
     */
    public synchronized int getItTestAndIncr()
    {
        // TODO: Add your implementation
        return this._itTestAndIncr;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItTestAndIncrValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	if (!(newValue instanceof Integer)) {
            throw new SnmpException("Invalid data type for itTestAndIncr. Expected Integer.");
        }

        int value = (Integer) newValue;

        if (value < 0) {
            throw new SnmpException("itTestAndIncr value must be a non-negative integer.");
        }

        setItTestAndIncr(value);
        try (Writer wr = new FileWriter(this.ruta)) {
            wr.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
   
    }
    
    /**
     * Sets new itTestAndIncr value
     * @param value the new value
     */
    public synchronized void setItTestAndIncr(int newValue)
    {
        // TODO: Add your implementation
        this._itTestAndIncr = newValue;
    }
    
    /**
     * Gets new itGravityLevel value
     */
    public synchronized int getItGravityLevel()
    {
        // TODO: Add your implementation
        return this._itGravityLevel;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItGravityLevelValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	if (!(newValue instanceof Integer)) {
            throw new SnmpException("Invalid data type for itGravityLevel. Expected Integer.");
        }

        int value = (Integer) newValue;

        if (value < 0 || value > 100) {
            throw new SnmpException("itGravityLevel value must be between 0 and 100 (inclusive).");
        }

        setItGravityLevel(value);
        try (Writer wr = new FileWriter(this.ruta)) {
            wr.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    /**
     * Sets new itGravityLevel value
     * @param value the new value
     */
    public synchronized void setItGravityLevel(int newValue)
    {
        // TODO: Add your implementation
        this._itGravityLevel = newValue;
    }
    
    /**
     * Gets new itUmbralFiles value
     */
    public synchronized int getItUmbralFiles()
    {
        // TODO: Add your implementation
        return this._itUmbralFiles;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItUmbralFilesValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	if (!(newValue instanceof Integer)) {
            throw new SnmpException("Invalid data type for itUmbralFiles. Expected Integer.");
        }

        int value = (Integer) newValue;

        if (value < 0 || value > 100) {
            throw new SnmpException("itUmbralFiles value must be between 0 and 100 (inclusive).");
        }

        setItUmbralFiles(value);
        try (Writer wr = new FileWriter(this.ruta)) {
            wr.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    }
    
    /**
     * Sets new itUmbralFiles value
     * @param value the new value
     */
    public synchronized void setItUmbralFiles(int newValue)
    {
        // TODO: Add your implementation
        this._itUmbralFiles = newValue;
    }
    
    /**
     * Gets new itActivarEvents value
     */
    public synchronized int getItActivarEvents()
    {
        // TODO: Add your implementation
        return this._itActivarEvents;
    }
    
    /**
     * Gets called before corresponding setter method is invoked when agent receives an SNMP SET request.
     * @param newValue the new value
     * @param pdu the received SnmpPdu object
     * @exception SnmpException Throw an SnmpException if the passed <code>newValue</code> is not acceptable, and you need to set SnmpException object's errorStatus field, which will be used in the response PDU's errorStatus field.
     */
    public synchronized void preSetItActivarEventsValue(Object newValue, SnmpPdu pdu)
    {
    	// Adicional para mi diseño
    	if (!(newValue instanceof Integer)) {
            throw new SnmpException("Invalid data type for itActivarEvents. Expected Integer.");
        }

        int value = (Integer) newValue;

        if (value != 0 && value != 1) {
            throw new SnmpException("itActivarEvents value must be either 0 (disabled) or 1 (enabled).");
        }

        setItActivarEvents(value);
        try (Writer wr = new FileWriter(this.ruta)) {
            wr.write(String.valueOf(value));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Sets new itActivarEvents value
     * @param value the new value
     */
    public synchronized void setItActivarEvents(int newValue)
    {
        // TODO: Add your implementation
        this._itActivarEvents = newValue;
    }
    
}
