/**
 * 
 */
package cl.dsoft.car.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import cl.dsoft.car.misc.UnsupportedParameterException;

/**
 * @author petete-ntbk
 *
 */
public class PermisoCirculacion {
    protected Long _id;
    protected Byte _mes;
    protected String _alertaHtml;
    protected String _tipHtml;
    protected String _regiones;
    protected String _fechaModificacion;

    private final static String _str_sql = 
        "    SELECT" +
        "    pe.id_permiso_circulacion AS id," +
        "    pe.mes AS mes," +
        "    pe.alerta_html AS alerta_html," +
        "    pe.tip_html AS tip_html," +
        "    pe.regiones AS regiones," +
        "    DATE_FORMAT(pe.fecha_modificacion, '%Y-%m-%d %H:%i:%s') AS fecha_modificacion" +
        "    FROM permiso_circulacion pe";

    public PermisoCirculacion() {
        _id = null;
        _mes = null;
        _alertaHtml = null;
        _tipHtml = null;
        _regiones = null;
        _fechaModificacion = null;

    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _mes
     */
    public Byte getMes() {
        return _mes;
    }
    /**
     * @return the _alertaHtml
     */
    public String getAlertaHtml() {
        return _alertaHtml;
    }
    /**
     * @return the _tipHtml
     */
    public String getTipHtml() {
        return _tipHtml;
    }
    /**
     * @return the _regiones
     */
    public String getRegiones() {
        return _regiones;
    }
    /**
     * @return the _fechaModificacion
     */
    public String getFechaModificacion() {
        return _fechaModificacion;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _mes the _mes to set
     */
    public void setMes(Byte _mes) {
        this._mes = _mes;
    }
    /**
     * @param _alertaHtml the _alertaHtml to set
     */
    public void setAlertaHtml(String _alertaHtml) {
        this._alertaHtml = _alertaHtml;
    }
    /**
     * @param _tipHtml the _tipHtml to set
     */
    public void setTipHtml(String _tipHtml) {
        this._tipHtml = _tipHtml;
    }
    /**
     * @param _regiones the _regiones to set
     */
    public void setRegiones(String _regiones) {
        this._regiones = _regiones;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }

    public static PermisoCirculacion fromRS(ResultSet p_rs) throws SQLException {
        PermisoCirculacion ret = new PermisoCirculacion();

        ret.setId(p_rs.getLong("id"));
        ret.setMes(p_rs.getByte("mes"));
        ret.setAlertaHtml(p_rs.getString("alerta_html"));
        ret.setTipHtml(p_rs.getString("tip_html"));
        ret.setRegiones(p_rs.getString("regiones"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));

        return ret;
    }

    public static PermisoCirculacion getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        PermisoCirculacion ret = null;
        
        String str_sql = _str_sql +
            "  WHERE pe." + p_key + " = " + p_value +
            "  LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                ret = fromRS(rs);
                //System.out.println("fromRS(rs) ok");
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
        return ret;        
    }

    public static PermisoCirculacion getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_permiso_circulacion", p_id);
    }
    
    public static ArrayList<PermisoCirculacion> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<PermisoCirculacion> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<PermisoCirculacion>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_permiso_circulacion")) {
                    array_clauses.add("pe.id_permiso_circulacion = " + p.getValue());
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("pe.fecha_modificacion > STR_TO_DATE('" + p.getValue() + "', '%Y-%m-%d %H:%i:%s')");
                }
                else {
                    throw new UnsupportedParameterException("Parametro no soportado: " + p.getKey());
                }
            }
                                
            boolean bFirstTime = false;
            
            for(String clause : array_clauses) {
                if (!bFirstTime) {
                     bFirstTime = true;
                     str_sql += " WHERE ";
                }
                else {
                     str_sql += " AND ";
                }
                str_sql += clause;
            }
            
            if (p_order != null && p_direction != null) {
                str_sql += " ORDER BY " + p_order + " " + p_direction;
            }
            
            if (p_offset != -1 && p_limit != -1) {
                str_sql += "  LIMIT " +  Integer.toString(p_offset) + ", " + Integer.toString(p_limit);
            }
            
            //echo "<br>" . str_sql . "<br>";
        
            stmt = p_conn.createStatement();
            
            rs = stmt.executeQuery(str_sql);
            
            while (rs.next()) {
                ret.add(fromRS(rs));
            }
            /*
            if (ret.size() == 0) {
                ret = null;
            }
            */
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        catch (UnsupportedParameterException ex) {
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        

        return ret;
    }

    public int update(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    UPDATE permiso_circulacion" +
            "    SET" +
            "    mes = " + (_mes != null ? _mes : "null") + "," +
            "    alerta_html = " + (_alertaHtml != null ? "'" + _alertaHtml + "'" : "null") + "," +
            "    tip_html = " + (_tipHtml != null ? "'" + _tipHtml + "'" : "null") + "," +
            "    regiones = " + (_regiones != null ? "'" + _regiones + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE('" + _fechaModificacion + "', '%Y-%m-%d %H:%i:%s')" : "null") +
            "    WHERE" +
            "    id_permiso_circulacion = " + Long.toString(this._id);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
            /*
            if (stmt.executeUpdate(str_sql) < 1) {
                throw new Exception("No hubo filas afectadas");
            }
            */
            
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }
    
    public int insert(Connection p_conn) throws SQLException {
        
        int ret = -1;
        Statement stmt = null;
        ResultSet rs = null;

        String str_sql =
            "    INSERT INTO permiso_circulacion" +
            "    (" +
            "    mes, " +
            "    alerta_html, " +
            "    tip_html, " +
            "    regiones)" +
            "    VALUES" +
            "    (" +
            "    " + (_mes != null ? "'" + _mes + "'" : "null") + "," +
            "    " + (_alertaHtml != null ? "'" + _alertaHtml + "'" : "null") + "," +
            "    " + (_tipHtml != null ? "'" + _tipHtml + "'" : "null") + "," +
            "    " + (_regiones != null ? "'" + _regiones + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql, Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                _id = rs.getLong(1);
            } else {
                // throw an exception from here
                // throw new Exception("Error al obtener id");
            }

            rs.close();
            rs = null;
            //System.out.println("Key returned from getGeneratedKeys():" + _id.toString());

            load(p_conn);

        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }

    public int delete(Connection p_conn) throws SQLException {

        int ret = -1;
        Statement stmt = null;

        String str_sql =
            "    DELETE FROM permiso_circulacion" +
            "    WHERE" +
            "    id_permiso_circulacion = " + Long.toString(this._id);

        try {
            stmt = p_conn.createStatement();
            
            ret = stmt.executeUpdate(str_sql);
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }
        
        return ret;
    }

    public void load(Connection p_conn) throws SQLException {
        PermisoCirculacion obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_permiso_circulacion = " + Long.toString(this._id) +
            "    LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....
            
            if (rs.next()) {
                //System.out.println("rs.next() ok");
                obj = fromRS(rs);
                //System.out.println("fromRS(rs) ok");

                _mes = obj.getMes();
                _alertaHtml = obj.getAlertaHtml();
                _tipHtml = obj.getTipHtml();
                _regiones = obj.getRegiones();
                _fechaModificacion = obj.getFechaModificacion();
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
    }

    public void save(Connection p_conn) throws SQLException {
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_permiso_circulacion = " + Long.toString(this._id) +
            "    LIMIT 0, 1";
        
        //System.out.println(str_sql);
        
        // assume that conn is an already created JDBC connection (see previous examples)
        Statement stmt = null;
        ResultSet rs = null;
        Boolean exists = false;
        
        try {
            stmt = p_conn.createStatement();
            //System.out.println("stmt = p_conn.createStatement() ok");
            rs = stmt.executeQuery(str_sql);
            //System.out.println("rs = stmt.executeQuery(str_sql) ok");

            // Now do something with the ResultSet ....

            if (rs.next()) {
                // registro existe
                exists = true;
            }

            rs.close();
            stmt.close();

            if (exists) {
            	// update
            	update(p_conn);
            }
            else {
            	// insert
            	insert(p_conn);
            }
        }
        catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage() + " sentencia: " + str_sql);
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            
            throw ex;
        }
        finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { 
                    
                } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    
                } // ignore
                stmt = null;
            }
        }        
        
    }

    @Override
    public String toString() {
        return "PermisoCirculacion [" +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _mes = " + (_mes != null ? _mes : "null") + "," +
	           "    _alerta_html = " + (_alertaHtml != null ? "'" + _alertaHtml + "'" : "null") + "," +
	           "    _tip_html = " + (_tipHtml != null ? "'" + _tipHtml + "'" : "null") + "," +
	           "    _regiones = " + (_regiones != null ? "'" + _regiones + "'" : "null") + "," +
	           "    _fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE(" + _fechaModificacion + ", '%Y-%m-%d %H:%i:%s')" : "null") +
			   "]";
    }


    public String toJSON() {
        return "PermisoCirculacion : {" +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_mes\" : " + (_mes != null ? _mes : "null") + "," +
	           "    \"_alerta_html\" : " + (_alertaHtml != null ? "\"" + _alertaHtml + "\"" : "null") + "," +
	           "    \"_tip_html\" : " + (_tipHtml != null ? "\"" + _tipHtml + "\"" : "null") + "," +
	           "    \"_regiones\" : " + (_regiones != null ? "\"" + _regiones + "\"" : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") +
			   "}";
    }


    public String toXML() {
        return "<PermisoCirculacion>" +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <mes" + (_mes != null ? ">" + _mes + "</mes>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <alertaHtml" + (_alertaHtml != null ? ">" + _alertaHtml + "</alertaHtml>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <tipHtml" + (_tipHtml != null ? ">" + _tipHtml + "</tipHtml>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <regiones" + (_regiones != null ? ">" + _regiones + "</regiones>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</PermisoCirculacion>";
    }


    public static PermisoCirculacion fromXMLNode(Node xmlNode) {
        PermisoCirculacion ret = new PermisoCirculacion();

        Element element = (Element) xmlNode;

        ret.setId(Long.decode(element.getElementsByTagName("id_permiso_circulacion").item(0).getTextContent()));
        ret.setMes(Byte.decode(element.getElementsByTagName("mes").item(0).getTextContent()));
        ret.setAlertaHtml(element.getElementsByTagName("alerta_html").item(0).getTextContent());
        ret.setTipHtml(element.getElementsByTagName("tip_html").item(0).getTextContent());
        ret.setRegiones(element.getElementsByTagName("regiones").item(0).getTextContent());
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());

        return ret;
    }
}
