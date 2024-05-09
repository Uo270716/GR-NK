package SnmpProyect;
import com.ireasoning.core.jmx.MBeanManager;
import com.ireasoning.util.*;
import com.ireasoning.protocol.snmp.*;
import javax.management.*;


/**
 * Class for registering MBeans
 */
public class AgentMib 
{
    private static MBeanManager _mgr = MBeanManager.getInstance();
    // Root node of OID tree
    private static OIDTreeNode _root;
    /**
     * Registers and Unregisters all necessary MBeans
     */
    public static void registerMBeans(MBeanServer server, OIDTreeNode root)
    {
        _root = root;
        try
        {
            registerItObjetosInfoGroup();
            registerItObjetosStateGroup();
            registerItObjetosConfigGroup();
                      
        }
        catch(Exception e)
        {
            Logger.error(e);
            throw new SnmpException(e.toString());
        }
    }
    public static void unregisterMBeans()
    {
        try
        {
            unregisterItObjetosInfoGroup();
            unregisterItObjetosStateGroup();
            unregisterItObjetosConfigGroup();
           
        }
        catch(Exception e)
        {
            Logger.error(e);
            throw new SnmpException(e.toString());
        }
    }
    
    /**
     * Creates instance,registers and unregisters MBean
     */
    public static void registerItObjetosInfoGroup() throws Exception
    {
        if ( _itObjetosInfoGroup == null )
        {
            _itObjetosInfoGroup = new ItObjetosInfoGroup(_root, ".1.3.6.1.4.1.47454.1.2", null);
        }
        ObjectName objName = new ObjectName("iReasoning:name=ItObjetosInfoGroup,noPdu=true");
        if(!_mgr.isRegistered(objName))
        {
            _mgr.registerMBean(_itObjetosInfoGroup, objName);
        }
    }
    public static void unregisterItObjetosInfoGroup() throws Exception
    {
        _mgr.unregisterMBean(new ObjectName("iReasoning:name=ItObjetosInfoGroup,noPdu=true"));
        _itObjetosInfoGroup = null;
    }
    
    /**
     * Creates instance, registers and unregisters MBean
     */
    public static void registerItObjetosStateGroup() throws Exception
    {
        if ( _itObjetosStateGroup == null )
        {
            _itObjetosStateGroup = new ItObjetosStateGroup(_root, ".1.3.6.1.4.1.47454.1.3", null);
        }
        ObjectName objName = new ObjectName("iReasoning:name=ItObjetosStateGroup,noPdu=true");
        if(!_mgr.isRegistered(objName))
        {
            _mgr.registerMBean(_itObjetosStateGroup, objName);
        }
    }
    public static void unregisterItObjetosStateGroup() throws Exception
    {
        _mgr.unregisterMBean(new ObjectName("iReasoning:name=ItObjetosStateGroup,noPdu=true"));
        _itObjetosStateGroup = null;
    }
    
    /**
     * Creates instance, registers and unregisters MBean
     */
    public static void registerItObjetosConfigGroup() throws Exception
    {
        if ( _itObjetosConfigGroup == null )
        {
            _itObjetosConfigGroup = new ItObjetosConfigGroup(_root, ".1.3.6.1.4.1.47454.1.1", null);
        }
        ObjectName objName = new ObjectName("iReasoning:name=ItObjetosConfigGroup,noPdu=true");
        if(!_mgr.isRegistered(objName))
        {
            _mgr.registerMBean(_itObjetosConfigGroup, objName);
        }
    }
    public static void unregisterItObjetosConfigGroup() throws Exception
    {
        _mgr.unregisterMBean(new ObjectName("iReasoning:name=ItObjetosConfigGroup,noPdu=true"));
        _itObjetosConfigGroup = null;
    }
    
    /**
     * Returns ItObjetosInfoGroup object. If ItObjetosInfoGroup is null, it 'll register the corresponding MBean first
     */
    public static ItObjetosInfoGroup getItObjetosInfoGroup( )
    {
        if( _itObjetosInfoGroup == null )
        {
            try
            {
                registerItObjetosInfoGroup();
            }
            catch(Exception e)
            {
                Logger.error(e);
            }
        }
        return _itObjetosInfoGroup;
    }
    
    /**
     * Returns ItObjetosStateGroup object. If ItObjetosStateGroup is null, it 'll register the corresponding MBean first
     */
    public static ItObjetosStateGroup getItObjetosStateGroup( )
    {
        if( _itObjetosStateGroup == null )
        {
            try
            {
                registerItObjetosStateGroup();
            }
            catch(Exception e)
            {
                Logger.error(e);
            }
        }
        return _itObjetosStateGroup;
    }
    
    /**
     * Returns ItObjetosConfigGroup object. If ItObjetosConfigGroup is null, it 'll register the corresponding MBean first
     */
    public static ItObjetosConfigGroup getItObjetosConfigGroup( )
    {
        if( _itObjetosConfigGroup == null )
        {
            try
            {
                registerItObjetosConfigGroup();
            }
            catch(Exception e)
            {
                Logger.error(e);
            }
        }
        return _itObjetosConfigGroup;
    }
    
    // Instances of MBean groups
    static ItObjetosInfoGroup _itObjetosInfoGroup;
    static ItObjetosStateGroup _itObjetosStateGroup;
    static ItObjetosConfigGroup _itObjetosConfigGroup;
}
