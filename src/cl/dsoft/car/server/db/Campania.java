/**
 * 
 */
package cl.dsoft.car.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Date;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import cl.dsoft.car.misc.UnsupportedParameterException;

/**
 * @author petete-ntbk
 *
 */
public class Campania {
    protected Integer _id;
    protected String _descripcion;
    protected Boolean _activa;
    protected String _condicion;
    protected String _detalle;
    protected String _fechaInicio;
    protected String _fechaFin;
    protected Short _periodicidad;
    protected Short _numeroImpresiones;
    protected Boolean _manual;
    protected String _fechaModificacion;

    private final static String _str_sql = 
        "    SELECT" +
        "    ca.id_campania AS id," +
        "    ca.descripcion AS descripcion," +
        "    0+ca.activa AS activa," +
        "    ca.condicion AS condicion," +
        "    ca.detalle AS detalle," +
        "    DATE_FORMAT(ca.fecha_inicio, '%Y-%m-%d %H:%i:%s') AS fecha_inicio," +
        "    DATE_FORMAT(ca.fecha_fin, '%Y-%m-%d %H:%i:%s') AS fecha_fin," +
        "    ca.periodicidad AS periodicidad," +
        "    ca.numero_impresiones AS numero_impresiones," +
        "    0+ca.manual AS manual," +
        "    DATE_FORMAT(ca.fecha_modificacion, '%Y-%m-%d %H:%i:%s') AS fecha_modificacion" +
        "    FROM campania ca";

    public Campania() {
        _id = null;
        _descripcion = null;
        _activa = null;
        _condicion = null;
        _detalle = null;
        _fechaInicio = null;
        _fechaFin = null;
        _periodicidad = null;
        _numeroImpresiones = null;
        _manual = null;
        _fechaModificacion = null;

    }
    /**
     * @return the _id
     */
    public Integer getId() {
        return _id;
    }
    /**
     * @return the _descripcion
     */
    public String getDescripcion() {
        return _descripcion;
    }
    /**
     * @return the _activa
     */
    public Boolean getActiva() {
        return _activa;
    }
    /**
     * @return the _condicion
     */
    public String getCondicion() {
        return _condicion;
    }
    /**
     * @return the _detalle
     */
    public String getDetalle() {
        return _detalle;
    }
    /**
     * @return the _fechaInicio
     */
    public String getFechaInicio() {
        return _fechaInicio;
    }
    /**
     * @return the _fechaFin
     */
    public String getFechaFin() {
        return _fechaFin;
    }
    /**
     * @return the _periodicidad
     */
    public Short getPeriodicidad() {
        return _periodicidad;
    }
    /**
     * @return the _numeroImpresiones
     */
    public Short getNumeroImpresiones() {
        return _numeroImpresiones;
    }
    /**
     * @return the _manual
     */
    public Boolean getManual() {
        return _manual;
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
    public void setId(Integer _id) {
        this._id = _id;
    }
    /**
     * @param _descripcion the _descripcion to set
     */
    public void setDescripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }
    /**
     * @param _activa the _activa to set
     */
    public void setActiva(Boolean _activa) {
        this._activa = _activa;
    }
    /**
     * @param _condicion the _condicion to set
     */
    public void setCondicion(String _condicion) {
        this._condicion = _condicion;
    }
    /**
     * @param _detalle the _detalle to set
     */
    public void setDetalle(String _detalle) {
        this._detalle = _detalle;
    }
    /**
     * @param _fechaInicio the _fechaInicio to set
     */
    public void setFechaInicio(String _fechaInicio) {
        this._fechaInicio = _fechaInicio;
    }
    /**
     * @param _fechaFin the _fechaFin to set
     */
    public void setFechaFin(String _fechaFin) {
        this._fechaFin = _fechaFin;
    }
    /**
     * @param _periodicidad the _periodicidad to set
     */
    public void setPeriodicidad(Short _periodicidad) {
        this._periodicidad = _periodicidad;
    }
    /**
     * @param _numeroImpresiones the _numeroImpresiones to set
     */
    public void setNumeroImpresiones(Short _numeroImpresiones) {
        this._numeroImpresiones = _numeroImpresiones;
    }
    /**
     * @param _manual the _manual to set
     */
    public void setManual(Boolean _manual) {
        this._manual = _manual;
    }
    /**
     * @param _fechaModificacion the _fechaModificacion to set
     */
    public void setFechaModificacion(String _fechaModificacion) {
        this._fechaModificacion = _fechaModificacion;
    }
    
    /**
     * @param _fechaInicio the _fechaInicio to set
     */
    public void setFechaInicio(Date _fechaInicio) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaInicio = formatter.format(_fechaInicio);
    }
    /**
     * @param _fechaFin the _fechaFin to set
     */
    public void setFechaFin(Date _fechaFin) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        this._fechaFin = formatter.format(_fechaFin);
    }
    

    public static Campania fromRS(ResultSet p_rs) throws SQLException {
        Campania ret = new Campania();

        ret.setId(p_rs.getInt("id"));
        ret.setDescripcion(p_rs.getString("descripcion"));
        ret.setActiva(p_rs.getBoolean("activa"));
        ret.setCondicion(p_rs.getString("condicion"));
        ret.setDetalle(p_rs.getString("detalle"));
        ret.setFechaInicio(p_rs.getString("fecha_inicio"));
        ret.setFechaFin(p_rs.getString("fecha_fin"));
        ret.setPeriodicidad(p_rs.getShort("periodicidad"));
        ret.setNumeroImpresiones(p_rs.getShort("numero_impresiones"));
        ret.setManual(p_rs.getBoolean("manual"));
        ret.setFechaModificacion(p_rs.getString("fecha_modificacion"));

        return ret;
    }

    public static Campania getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        Campania ret = null;
        
        String str_sql = _str_sql +
            "  WHERE ca." + p_key + " = " + p_value +
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

    public static Campania getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_campania", p_id);
    }
    
    public static ArrayList<Campania> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<Campania> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<Campania>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_campania")) {
                    array_clauses.add("ca.id_campania = " + p.getValue());
                }
                else if (p.getKey().equals("activa")) {
                    array_clauses.add("ca.activa = true");
                }
                else if (p.getKey().equals("vigente")) {
                    array_clauses.add("(ca.fecha_inicio <= now() AND ca.fecha_fin >= now())");
                }
                else if (p.getKey().equals("manual")) {
                    array_clauses.add("ca.manual = true");
                }
                else if (p.getKey().equals("mas reciente")) {
                    array_clauses.add("ca.fecha_modificacion > STR_TO_DATE('" + p.getValue() + "', '%Y-%m-%d %H:%i:%s')");
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
            "    UPDATE campania" +
            "    SET" +
            "    descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    activa = " + (_activa != null ? "b'" + (_activa ? 1 : 0) + "'" : "null") + "," +
            "    condicion = " + (_condicion != null ? "'" + _condicion + "'" : "null") + "," +
            "    detalle = " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
            "    fecha_inicio = " + (_fechaInicio != null ? "STR_TO_DATE('" + _fechaInicio + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    fecha_fin = " + (_fechaFin != null ? "STR_TO_DATE('" + _fechaFin + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    periodicidad = " + (_periodicidad != null ? _periodicidad : "null") + "," +
            "    numero_impresiones = " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
            "    manual = " + (_manual != null ? "b'" + (_manual ? 1 : 0) + "'" : "null") + "," +
            "    fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE('" + _fechaModificacion + "', '%Y-%m-%d %H:%i:%s')" : "null") +
            "    WHERE" +
            "    id_campania = " + Integer.toString(this._id);

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
            "    INSERT INTO campania" +
            "    (" +
            "    descripcion, " +
            "    activa, " +
            "    condicion, " +
            "    detalle, " +
            "    fecha_inicio, " +
            "    fecha_fin, " +
            "    periodicidad, " +
            "    numero_impresiones, " +
            "    manual)" +
            "    VALUES" +
            "    (" +
            "    " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
            "    " + (_activa != null ? "b'" + (_activa ? 1 : 0) + "'" : "null") + "," +
            "    " + (_condicion != null ? "'" + _condicion + "'" : "null") + "," +
            "    " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
            "    " + (_fechaInicio != null ? "STR_TO_DATE('" + _fechaInicio + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    " + (_fechaFin != null ? "STR_TO_DATE('" + _fechaFin + "', '%Y-%m-%d %H:%i:%s')" : "null") + "," +
            "    " + (_periodicidad != null ? "'" + _periodicidad + "'" : "null") + "," +
            "    " + (_numeroImpresiones != null ? "'" + _numeroImpresiones + "'" : "null") + "," +
            "    " + (_manual != null ? "b'" + (_manual ? 1 : 0) + "'" : "null") +
            "    )";
        
        try {
            stmt = p_conn.createStatement();

            ret = stmt.executeUpdate(str_sql, Statement.RETURN_GENERATED_KEYS);

            rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                _id = rs.getInt(1);
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
            "    DELETE FROM campania" +
            "    WHERE" +
            "    id_campania = " + Integer.toString(this._id);

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
        Campania obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_campania = " + Integer.toString(this._id) +
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

                _descripcion = obj.getDescripcion();
                _activa = obj.getActiva();
                _condicion = obj.getCondicion();
                _detalle = obj.getDetalle();
                _fechaInicio = obj.getFechaInicio();
                _fechaFin = obj.getFechaFin();
                _periodicidad = obj.getPeriodicidad();
                _numeroImpresiones = obj.getNumeroImpresiones();
                _manual = obj.getManual();
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
            "    id_campania = " + Integer.toString(this._id) +
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
        return "Campania [" +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _descripcion = " + (_descripcion != null ? "'" + _descripcion + "'" : "null") + "," +
	           "    _activa = " + (_activa != null ? "b'" + _activa : "null") + "," +
	           "    _condicion = " + (_condicion != null ? "'" + _condicion + "'" : "null") + "," +
	           "    _detalle = " + (_detalle != null ? "'" + _detalle + "'" : "null") + "," +
	           "    _fecha_inicio = " + (_fechaInicio != null ? "STR_TO_DATE(" + _fechaInicio + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _fecha_fin = " + (_fechaFin != null ? "STR_TO_DATE(" + _fechaFin + ", '%Y-%m-%d %H:%i:%s')" : "null") + "," +
	           "    _periodicidad = " + (_periodicidad != null ? _periodicidad : "null") + "," +
	           "    _numeroImpresiones = " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
	           "    _manual = " + (_manual != null ? "b'" + _manual : "null") + "," +
	           "    _fecha_modificacion = " + (_fechaModificacion != null ? "STR_TO_DATE(" + _fechaModificacion + ", '%Y-%m-%d %H:%i:%s')" : "null") +
			   "]";
    }


    public String toJSON() {
        return "Campania : {" +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_descripcion\" : " + (_descripcion != null ? "\"" + _descripcion + "\"" : "null") + "," +
	           "    \"_activa\" : " + (_activa != null ? "b'" + _activa : "null") + "," +
	           "    \"_condicion\" : " + (_condicion != null ? "\"" + _condicion + "\"" : "null") + "," +
	           "    \"_detalle\" : " + (_detalle != null ? "\"" + _detalle + "\"" : "null") + "," +
	           "    \"_fecha_inicio\" : " + (_fechaInicio != null ? "\"" + _fechaInicio + "\"" : "null") + "," +
	           "    \"_fecha_fin\" : " + (_fechaFin != null ? "\"" + _fechaFin + "\"" : "null") + "," +
	           "    \"_periodicidad\" : " + (_periodicidad != null ? _periodicidad : "null") + "," +
	           "    \"_numeroImpresiones\" : " + (_numeroImpresiones != null ? _numeroImpresiones : "null") + "," +
	           "    \"_manual\" : " + (_manual != null ? "b'" + _manual : "null") + "," +
	           "    \"_fecha_modificacion\" : " + (_fechaModificacion != null ? "\"" + _fechaModificacion + "\"" : "null") +
			   "}";
    }


    public String toXML() {
        return "<Campania>" +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <descripcion" + (_descripcion != null ? ">" + _descripcion + "</descripcion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <activa" + (_activa != null ? ">" + _activa + "</activa>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <condicion" + (_condicion != null ? ">" + _condicion + "</condicion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <detalle" + (_detalle != null ? ">" + _detalle + "</detalle>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaInicio" + (_fechaInicio != null ? ">" + _fechaInicio + "</fechaInicio>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaFin" + (_fechaFin != null ? ">" + _fechaFin + "</fechaFin>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <periodicidad" + (_periodicidad != null ? ">" + _periodicidad + "</periodicidad>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <numeroImpresiones" + (_numeroImpresiones != null ? ">" + _numeroImpresiones + "</numeroImpresiones>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <manual" + (_manual != null ? ">" + _manual + "</manual>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <fechaModificacion" + (_fechaModificacion != null ? ">" + _fechaModificacion + "</fechaModificacion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</Campania>";
    }


    public static Campania fromXMLNode(Node xmlNode) {
        Campania ret = new Campania();

        Element element = (Element) xmlNode;

        ret.setId(Integer.decode(element.getElementsByTagName("id_campania").item(0).getTextContent()));
        ret.setDescripcion(element.getElementsByTagName("descripcion").item(0).getTextContent());
        ret.setActiva(Boolean.valueOf(element.getElementsByTagName("activa").item(0).getTextContent()));
        ret.setCondicion(element.getElementsByTagName("condicion").item(0).getTextContent());
        ret.setDetalle(element.getElementsByTagName("detalle").item(0).getTextContent());
        ret.setFechaInicio(element.getElementsByTagName("fecha_inicio").item(0).getTextContent());
        ret.setFechaFin(element.getElementsByTagName("fecha_fin").item(0).getTextContent());
        ret.setPeriodicidad(Short.decode(element.getElementsByTagName("periodicidad").item(0).getTextContent()));
        ret.setNumeroImpresiones(Short.decode(element.getElementsByTagName("numero_impresiones").item(0).getTextContent()));
        ret.setManual(Boolean.valueOf(element.getElementsByTagName("manual").item(0).getTextContent()));
        ret.setFechaModificacion(element.getElementsByTagName("fecha_modificacion").item(0).getTextContent());

        return ret;
    }
}
