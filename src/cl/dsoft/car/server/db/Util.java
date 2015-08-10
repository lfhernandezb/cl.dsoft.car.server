/**
 * 
 */
package cl.dsoft.car.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lfhernandez
 *
 */
public class Util {

	/**
	 * 
	 */
	public Util() {
		// TODO Auto-generated constructor stub
	}

	public static String getDateFromServer(Connection conn) throws SQLException {
		
		String ret = null;
		
		String strSQL = "SELECT DATE_FORMAT(now(), '%Y-%m-%d %H:%i:%s') AS dd";
		
        Statement stmt = conn.createStatement();
        
        ResultSet rs = stmt.executeQuery(strSQL);
        
        if (rs.next()) {
        	ret = rs.getString("dd");
        }
		
        return ret;
	}
}
