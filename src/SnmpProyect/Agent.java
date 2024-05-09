package SnmpProyect;
import java.io.*;
import com.ireasoning.util.*;
import com.ireasoning.protocol.snmp.*;
import javax.management.*;


/**
 * Agent main class
 */
public class Agent extends SnmpBaseAgent
{
	private String _rootFolder = "C:\\\\prueba\\\\";//Adicional para mi diseño
    /**
     * Constructor. Create MBeanServer instance internally. Agent will be listening on port specified in config file, which can be retrieved by using SnmpAgentConfig.getPort().
     * @param configFileName Agent's config file name. If absolute path is not specified, the file will be assumed located under ./config directory or current directory
     */
    public Agent(String configFileName) throws Exception
    {
        super(configFileName);
    }
    
    /**
     * Constructor. Use MBeanServer object passed from caller
     * @param server MBeanServer object
     * @param configFileName Agent's config file name. If absolute path is not specified, the file will be assumed located under ./config directory or current directory
     */
    public Agent(MBeanServer server, String configFileName) throws Exception
    {
        super(server, configFileName);
    }
    
    /**
     * Main method to start the SNMP agent
     */
    public static void main(String[] args)
    {
        try
        {
            String configFile = "SnmpAgent.xml";
            Agent agent = new Agent(configFile);
            // UnComment one of the following two lines if you want to send coldStart trap
            sendV1ColdStartTrap();
            //sendV2ColdStartTrap();
        }
        catch(Exception e)
        {
            Logger.error(e);
        }
    }
    
    /**
     * Sets the MIB tree data structure. This method gets called by base class
     */
    protected void setOIDTree()
    {
        _root = OIDTree.getTree();
    }
    
    /**
     * Registers necessary MBeans
     */
    protected void registerMBeans() throws SnmpException
    {
        if(_root == null) {
        	setOIDTree();
        }
        	
        AgentMib.registerMBeans(_mbeanServer, _root);
    }
    
    /**
     * Unregisters necessary MBeans
     */
    protected void unregisterMBeans()
    {
        AgentMib.unregisterMBeans();
        OIDTree.resetTree();
    }
    
    //Adicionales para mi diseño
    //Extras para operaciones del diseño MIB
    
     // Métodos para consultar y modificar la carpeta root
    public String getRootFolder() {
        // Implementa la lógica para obtener la carpeta root
    	return _rootFolder;
    }

    public void setRootFolder(String path) throws IOException {
        // Implementa la lógica para establecer la carpeta root
        if (path.length() > 32) {
            throw new IOException("La longitud de la ruta supera los 32 caracteres.");
        }
        // Código para establecer la nueva ruta
        _rootFolder = path;
    }
     // Método para obtener el número de ficheros en la carpeta root
    public int getNumFilesInRoot() {
        // Implementa la lógica para contar los ficheros en la carpeta raíz
        File rootDir = new File(_rootFolder);
        if (rootDir.isDirectory())
        {
            String[] files = rootDir.list();
            return files != null ? files.length : 0;
        }
        return 0;
    }

    // Método para borrar todos los ficheros en la carpeta root
    public void deleteAllFilesInRoot() throws IOException {
        // Implementa la lógica para borrar los ficheros en la carpeta root
    	File rootDir = new File(_rootFolder);
        if (rootDir.isDirectory())
        {
            File[] files = rootDir.listFiles();
            if (files != null)
            {
                for (File file : files)
                {
                    if (file.isFile())
                    {
                        if (!file.delete())
                        {
                            throw new IOException("No se pudo borrar el archivo: " + file.getName());
                        }
                    }
                }
            }
        }
    }
     
    
}
