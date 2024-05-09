package SnmpProyect;
import com.ireasoning.protocol.snmp.*;

/**
 * Interface represents itObjetosState mib object in NK_MIB
 */
public interface ItObjetosStateGroupMBean extends SnmpBaseGroupMBean
{
    /**
     * Gets new itNumFiles value
     */
    public int getItNumFiles();
    
}
