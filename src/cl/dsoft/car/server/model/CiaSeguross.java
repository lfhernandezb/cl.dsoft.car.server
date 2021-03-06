package cl.dsoft.car.server.model;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import cl.dsoft.car.server.db.CiaSeguros;

@XmlType(name = "CiaSeguross", propOrder = {
	    "ciaSeguross"
})
public class CiaSeguross {

	@XmlElement(name = "ciaSeguros")
    protected ArrayList<CiaSeguros> ciaSeguross;

    public CiaSeguross() {
    	ciaSeguross = null;
	}

    public CiaSeguross(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
		seek(conn, idUsuario, fechaModificacion);
	}

    public List<CiaSeguros> getCiaSeguross() {
		if (ciaSeguross == null) {
			ciaSeguross = new ArrayList<CiaSeguros>();
		}
		return ciaSeguross;
	}

    private void seek(java.sql.Connection conn, Long idUsuario, String fechaModificacion) {
    	
    	ArrayList<AbstractMap.SimpleEntry<String, String>> listParameters;
    	
    	try {
			listParameters = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
			
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("id_usuario", String.valueOf(idUsuario)));
			listParameters.add(new AbstractMap.SimpleEntry<String, String>("mas reciente", fechaModificacion));
			
			this.ciaSeguross = CiaSeguros.seek(conn, listParameters, null, null, 0, 10000);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
