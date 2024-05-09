package SnmpProyect;

import com.ireasoning.util.*;
import com.ireasoning.protocol.snmp.*;

/**
 * Clase para definir y manejar eventos SNMP.
 */
public class Eventos extends Thread {

    private static final int frecuencia = 2000; // 2 segundos

    public void run() {
        System.out.println("Hilo de Eventos iniciado.");

        while (true) {
            try {
            	int activar = AgentMib.getItObjetosConfigGroup().getItActivarEvents();
            	if (activar == 1) {
	            	//Evaluación del evento ItUmbralFiles 
	            	SnmpInt valor = new SnmpInt(AgentMib.getItObjetosConfigGroup().getItUmbralFiles());
	            	if (valor.getValue()== 0) {
	            		
	            		//Guarda en oid1 el OID del evento a enviar
	            		SnmpOID oid1 = new SnmpOID(OIDTree.ITEVENTUMFICH);
	            		
	            		//Crear una lista de VariableBindings (este evento envia solo uno)
	            		SnmpVarBind[] variables = new SnmpVarBind[1];
	            		variables[0] = new SnmpVarBind();
	            		
	            		//Establecer el OID y el valor del VariableBinding a enviar
	            		variables[0].setName(OIDTree.ITUMBRALFILES);
	            		variables[0].setValue(valor);
	            		
	            		//Enviar el evento
	            		Agent.sendV2Trap(oid1,variables);
	            	}
            	}
                Thread.sleep(frecuencia);
                
            } catch (InterruptedException e) {
                System.out.println("Excepcion en evaluador de eventos: "+e);
            } catch (Exception ex) {
                Logger.error("Error en el hilo de eventos: " + ex);
            }
        }
    }

 
}

