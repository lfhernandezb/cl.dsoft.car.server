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
public class UsuarioInfo {
    protected Long _id;
    protected Long _idUsuario;
    protected Double _latitud;
    protected Double _longitud;
    protected String _houseNumber;
    protected String _road;
    protected String _neighbourhood;
    protected String _suburb;
    protected String _city;
    protected String _county;
    protected String _state;
    protected String _country;
    protected String _countryCode;
    protected String _android;
    protected String _appVersion;

    private final static String _str_sql = 
        "    SELECT" +
        "    us.id_usuario_info AS id," +
        "    us.id_usuario AS id_usuario," +
        "    us.latitud AS latitud," +
        "    us.longitud AS longitud," +
        "    us.house_number AS house_number," +
        "    us.road AS road," +
        "    us.neighbourhood AS neighbourhood," +
        "    us.suburb AS suburb," +
        "    us.city AS city," +
        "    us.county AS county," +
        "    us.state AS state," +
        "    us.country AS country," +
        "    us.country_code AS country_code," +
        "    us.android AS android," +
        "    us.app_version AS app_version" +
        "    FROM usuario_info us";

    public UsuarioInfo() {
        _id = null;
        _idUsuario = null;
        _latitud = null;
        _longitud = null;
        _houseNumber = null;
        _road = null;
        _neighbourhood = null;
        _suburb = null;
        _city = null;
        _county = null;
        _state = null;
        _country = null;
        _countryCode = null;
        _android = null;
        _appVersion = null;

    }
    /**
     * @return the _id
     */
    public Long getId() {
        return _id;
    }
    /**
     * @return the _idUsuario
     */
    public Long getIdUsuario() {
        return _idUsuario;
    }
    /**
     * @return the _latitud
     */
    public Double getLatitud() {
        return _latitud;
    }
    /**
     * @return the _longitud
     */
    public Double getLongitud() {
        return _longitud;
    }
    /**
     * @return the _houseNumber
     */
    public String getHouseNumber() {
        return _houseNumber;
    }
    /**
     * @return the _road
     */
    public String getRoad() {
        return _road;
    }
    /**
     * @return the _neighbourhood
     */
    public String getNeighbourhood() {
        return _neighbourhood;
    }
    /**
     * @return the _suburb
     */
    public String getSuburb() {
        return _suburb;
    }
    /**
     * @return the _city
     */
    public String getCity() {
        return _city;
    }
    /**
     * @return the _county
     */
    public String getCounty() {
        return _county;
    }
    /**
     * @return the _state
     */
    public String getState() {
        return _state;
    }
    /**
     * @return the _country
     */
    public String getCountry() {
        return _country;
    }
    /**
     * @return the _countryCode
     */
    public String getCountryCode() {
        return _countryCode;
    }
    /**
     * @return the _android
     */
    public String getAndroid() {
        return _android;
    }
    /**
     * @return the _appVersion
     */
    public String getAppVersion() {
        return _appVersion;
    }
    /**
     * @param _id the _id to set
     */
    public void setId(Long _id) {
        this._id = _id;
    }
    /**
     * @param _idUsuario the _idUsuario to set
     */
    public void setIdUsuario(Long _idUsuario) {
        this._idUsuario = _idUsuario;
    }
    /**
     * @param _latitud the _latitud to set
     */
    public void setLatitud(Double _latitud) {
        this._latitud = _latitud;
    }
    /**
     * @param _longitud the _longitud to set
     */
    public void setLongitud(Double _longitud) {
        this._longitud = _longitud;
    }
    /**
     * @param _houseNumber the _houseNumber to set
     */
    public void setHouseNumber(String _houseNumber) {
        this._houseNumber = _houseNumber;
    }
    /**
     * @param _road the _road to set
     */
    public void setRoad(String _road) {
        this._road = _road;
    }
    /**
     * @param _neighbourhood the _neighbourhood to set
     */
    public void setNeighbourhood(String _neighbourhood) {
        this._neighbourhood = _neighbourhood;
    }
    /**
     * @param _suburb the _suburb to set
     */
    public void setSuburb(String _suburb) {
        this._suburb = _suburb;
    }
    /**
     * @param _city the _city to set
     */
    public void setCity(String _city) {
        this._city = _city;
    }
    /**
     * @param _county the _county to set
     */
    public void setCounty(String _county) {
        this._county = _county;
    }
    /**
     * @param _state the _state to set
     */
    public void setState(String _state) {
        this._state = _state;
    }
    /**
     * @param _country the _country to set
     */
    public void setCountry(String _country) {
        this._country = _country;
    }
    /**
     * @param _countryCode the _countryCode to set
     */
    public void setCountryCode(String _countryCode) {
        this._countryCode = _countryCode;
    }
    /**
     * @param _android the _android to set
     */
    public void setAndroid(String _android) {
        this._android = _android;
    }
    /**
     * @param _appVersion the _appVersion to set
     */
    public void setAppVersion(String _appVersion) {
        this._appVersion = _appVersion;
    }

    public static UsuarioInfo fromRS(ResultSet p_rs) throws SQLException {
        UsuarioInfo ret = new UsuarioInfo();

        ret.setId(p_rs.getLong("id"));
        ret.setIdUsuario(p_rs.getLong("id_usuario"));
        ret.setLatitud(p_rs.getDouble("latitud"));
        ret.setLongitud(p_rs.getDouble("longitud"));
        ret.setHouseNumber(p_rs.getString("house_number"));
        ret.setRoad(p_rs.getString("road"));
        ret.setNeighbourhood(p_rs.getString("neighbourhood"));
        ret.setSuburb(p_rs.getString("suburb"));
        ret.setCity(p_rs.getString("city"));
        ret.setCounty(p_rs.getString("county"));
        ret.setState(p_rs.getString("state"));
        ret.setCountry(p_rs.getString("country"));
        ret.setCountryCode(p_rs.getString("country_code"));
        ret.setAndroid(p_rs.getString("android"));
        ret.setAppVersion(p_rs.getString("app_version"));

        return ret;
    }

    public static UsuarioInfo getByParameter(Connection p_conn, String p_key, String p_value) throws SQLException {
        UsuarioInfo ret = null;
        
        String str_sql = _str_sql +
            "  WHERE us." + p_key + " = " + p_value +
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

    public static UsuarioInfo getById(Connection p_conn, String p_id) throws SQLException {
        return getByParameter(p_conn, "id_usuario_info", p_id);
    }
    
    public static ArrayList<UsuarioInfo> seek(Connection p_conn, ArrayList<AbstractMap.SimpleEntry<String, String>> p_parameters, String p_order, String p_direction, int p_offset, int p_limit) throws UnsupportedParameterException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        String str_sql;
        ArrayList<UsuarioInfo> ret;
        
        str_sql = "";
        
        try {
            ArrayList<String> array_clauses = new ArrayList<String>();
            
            ret = new ArrayList<UsuarioInfo>();
            
            str_sql = _str_sql;
            
            for (AbstractMap.SimpleEntry<String, String> p : p_parameters) {
                if (p.getKey().equals("id_usuario_info")) {
                    array_clauses.add("us.id_usuario_info = " + p.getValue());
                }
                else if (p.getKey().equals("id_usuario")) {
                    array_clauses.add("us.id_usuario = " + p.getValue());
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
            "    UPDATE usuario_info" +
            "    SET" +
            "    latitud = " + (_latitud != null ? _latitud : "null") + "," +
            "    longitud = " + (_longitud != null ? _longitud : "null") + "," +
            "    house_number = " + (_houseNumber != null ? "'" + _houseNumber + "'" : "null") + "," +
            "    road = " + (_road != null ? "'" + _road + "'" : "null") + "," +
            "    neighbourhood = " + (_neighbourhood != null ? "'" + _neighbourhood + "'" : "null") + "," +
            "    suburb = " + (_suburb != null ? "'" + _suburb + "'" : "null") + "," +
            "    city = " + (_city != null ? "'" + _city + "'" : "null") + "," +
            "    county = " + (_county != null ? "'" + _county + "'" : "null") + "," +
            "    state = " + (_state != null ? "'" + _state + "'" : "null") + "," +
            "    country = " + (_country != null ? "'" + _country + "'" : "null") + "," +
            "    country_code = " + (_countryCode != null ? "'" + _countryCode + "'" : "null") + "," +
            "    android = " + (_android != null ? "'" + _android + "'" : "null") + "," +
            "    app_version = " + (_appVersion != null ? "'" + _appVersion + "'" : "null") +
            "    WHERE" +
            "    id_usuario_info = " + Long.toString(this._id);

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
            "    INSERT INTO usuario_info" +
            "    (" +
            "    id_usuario, " +
            "    latitud, " +
            "    longitud, " +
            "    house_number, " +
            "    road, " +
            "    neighbourhood, " +
            "    suburb, " +
            "    city, " +
            "    county, " +
            "    state, " +
            "    country, " +
            "    country_code, " +
            "    android, " +
            "    app_version)" +
            "    VALUES" +
            "    (" +
            "    " + (_idUsuario != null ? "'" + _idUsuario + "'" : "null") + "," +
            "    " + (_latitud != null ? "'" + _latitud + "'" : "null") + "," +
            "    " + (_longitud != null ? "'" + _longitud + "'" : "null") + "," +
            "    " + (_houseNumber != null ? "'" + _houseNumber + "'" : "null") + "," +
            "    " + (_road != null ? "'" + _road + "'" : "null") + "," +
            "    " + (_neighbourhood != null ? "'" + _neighbourhood + "'" : "null") + "," +
            "    " + (_suburb != null ? "'" + _suburb + "'" : "null") + "," +
            "    " + (_city != null ? "'" + _city + "'" : "null") + "," +
            "    " + (_county != null ? "'" + _county + "'" : "null") + "," +
            "    " + (_state != null ? "'" + _state + "'" : "null") + "," +
            "    " + (_country != null ? "'" + _country + "'" : "null") + "," +
            "    " + (_countryCode != null ? "'" + _countryCode + "'" : "null") + "," +
            "    " + (_android != null ? "'" + _android + "'" : "null") + "," +
            "    " + (_appVersion != null ? "'" + _appVersion + "'" : "null") +
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
            "    DELETE FROM usuario_info" +
            "    WHERE" +
            "    id_usuario_info = " + Long.toString(this._id);

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
        UsuarioInfo obj = null;
        
        String str_sql = _str_sql +
            "    WHERE" +
            "    id_usuario_info = " + Long.toString(this._id) +
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

                _idUsuario = obj.getIdUsuario();
                _latitud = obj.getLatitud();
                _longitud = obj.getLongitud();
                _houseNumber = obj.getHouseNumber();
                _road = obj.getRoad();
                _neighbourhood = obj.getNeighbourhood();
                _suburb = obj.getSuburb();
                _city = obj.getCity();
                _county = obj.getCounty();
                _state = obj.getState();
                _country = obj.getCountry();
                _countryCode = obj.getCountryCode();
                _android = obj.getAndroid();
                _appVersion = obj.getAppVersion();
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
            "    id_usuario_info = " + Long.toString(this._id) +
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
        return "UsuarioInfo [" +
	           "    _id = " + (_id != null ? _id : "null") + "," +
	           "    _idUsuario = " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    _latitud = " + (_latitud != null ? _latitud : "null") + "," +
	           "    _longitud = " + (_longitud != null ? _longitud : "null") + "," +
	           "    _house_number = " + (_houseNumber != null ? "'" + _houseNumber + "'" : "null") + "," +
	           "    _road = " + (_road != null ? "'" + _road + "'" : "null") + "," +
	           "    _neighbourhood = " + (_neighbourhood != null ? "'" + _neighbourhood + "'" : "null") + "," +
	           "    _suburb = " + (_suburb != null ? "'" + _suburb + "'" : "null") + "," +
	           "    _city = " + (_city != null ? "'" + _city + "'" : "null") + "," +
	           "    _county = " + (_county != null ? "'" + _county + "'" : "null") + "," +
	           "    _state = " + (_state != null ? "'" + _state + "'" : "null") + "," +
	           "    _country = " + (_country != null ? "'" + _country + "'" : "null") + "," +
	           "    _country_code = " + (_countryCode != null ? "'" + _countryCode + "'" : "null") + "," +
	           "    _android = " + (_android != null ? "'" + _android + "'" : "null") + "," +
	           "    _app_version = " + (_appVersion != null ? "'" + _appVersion + "'" : "null") +
			   "]";
    }


    public String toJSON() {
        return "UsuarioInfo : {" +
	           "    \"_id\" : " + (_id != null ? _id : "null") + "," +
	           "    \"_idUsuario\" : " + (_idUsuario != null ? _idUsuario : "null") + "," +
	           "    \"_latitud\" : " + (_latitud != null ? _latitud : "null") + "," +
	           "    \"_longitud\" : " + (_longitud != null ? _longitud : "null") + "," +
	           "    \"_house_number\" : " + (_houseNumber != null ? "\"" + _houseNumber + "\"" : "null") + "," +
	           "    \"_road\" : " + (_road != null ? "\"" + _road + "\"" : "null") + "," +
	           "    \"_neighbourhood\" : " + (_neighbourhood != null ? "\"" + _neighbourhood + "\"" : "null") + "," +
	           "    \"_suburb\" : " + (_suburb != null ? "\"" + _suburb + "\"" : "null") + "," +
	           "    \"_city\" : " + (_city != null ? "\"" + _city + "\"" : "null") + "," +
	           "    \"_county\" : " + (_county != null ? "\"" + _county + "\"" : "null") + "," +
	           "    \"_state\" : " + (_state != null ? "\"" + _state + "\"" : "null") + "," +
	           "    \"_country\" : " + (_country != null ? "\"" + _country + "\"" : "null") + "," +
	           "    \"_country_code\" : " + (_countryCode != null ? "\"" + _countryCode + "\"" : "null") + "," +
	           "    \"_android\" : " + (_android != null ? "\"" + _android + "\"" : "null") + "," +
	           "    \"_app_version\" : " + (_appVersion != null ? "\"" + _appVersion + "\"" : "null") +
			   "}";
    }


    public String toXML() {
        return "<UsuarioInfo>" +
	           "    <id" + (_id != null ? ">" + _id + "</id>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <idUsuario" + (_idUsuario != null ? ">" + _idUsuario + "</idUsuario>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <latitud" + (_latitud != null ? ">" + _latitud + "</latitud>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <longitud" + (_longitud != null ? ">" + _longitud + "</longitud>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <houseNumber" + (_houseNumber != null ? ">" + _houseNumber + "</houseNumber>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <road" + (_road != null ? ">" + _road + "</road>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <neighbourhood" + (_neighbourhood != null ? ">" + _neighbourhood + "</neighbourhood>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <suburb" + (_suburb != null ? ">" + _suburb + "</suburb>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <city" + (_city != null ? ">" + _city + "</city>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <county" + (_county != null ? ">" + _county + "</county>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <state" + (_state != null ? ">" + _state + "</state>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <country" + (_country != null ? ">" + _country + "</country>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <countryCode" + (_countryCode != null ? ">" + _countryCode + "</countryCode>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <android" + (_android != null ? ">" + _android + "</android>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
	           "    <appVersion" + (_appVersion != null ? ">" + _appVersion + "</appVersion>" : " xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>") +
			   "</UsuarioInfo>";
    }


    public static UsuarioInfo fromXMLNode(Node xmlNode) {
        UsuarioInfo ret = new UsuarioInfo();

        Element element = (Element) xmlNode;

        ret.setId(Long.decode(element.getElementsByTagName("id_usuario_info").item(0).getTextContent()));
        ret.setIdUsuario(Long.decode(element.getElementsByTagName("id_usuario").item(0).getTextContent()));
        ret.setLatitud(Double.valueOf(element.getElementsByTagName("latitud").item(0).getTextContent()));
        ret.setLongitud(Double.valueOf(element.getElementsByTagName("longitud").item(0).getTextContent()));
        ret.setHouseNumber(element.getElementsByTagName("house_number").item(0).getTextContent());
        ret.setRoad(element.getElementsByTagName("road").item(0).getTextContent());
        ret.setNeighbourhood(element.getElementsByTagName("neighbourhood").item(0).getTextContent());
        ret.setSuburb(element.getElementsByTagName("suburb").item(0).getTextContent());
        ret.setCity(element.getElementsByTagName("city").item(0).getTextContent());
        ret.setCounty(element.getElementsByTagName("county").item(0).getTextContent());
        ret.setState(element.getElementsByTagName("state").item(0).getTextContent());
        ret.setCountry(element.getElementsByTagName("country").item(0).getTextContent());
        ret.setCountryCode(element.getElementsByTagName("country_code").item(0).getTextContent());
        ret.setAndroid(element.getElementsByTagName("android").item(0).getTextContent());
        ret.setAppVersion(element.getElementsByTagName("app_version").item(0).getTextContent());

        return ret;
    }
}
