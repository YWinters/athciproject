package uh.ahci.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * This class represents a db connection to a MySQL server.
 * Singleton.
 * @author Seppe Magiels
 */
public class RemoteDb {

    /**
     * The connection 
     */
    protected Connection _conn = null;
    /**
     * The host of the database.
     */
    protected String _host = null;
    /**
     * The username of the database account.
     */
    protected String _user = null;
    /**
     * The password of the database account.
     */
    protected String _password = null;
    
    /**
     * Constructor.
     */
    public RemoteDb() {
    	_host = "jdbc:mysql:";
    	_user = "";
    	_password = "";
        try {
            Class.forName ("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LocalDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Connect to the database.
     * 
     * @throws SQLException if an error occurred.
     */
    public void connect() throws SQLException {
        if(_conn != null)
            disconnect();
        _conn = DriverManager.getConnection(_host);
    }
    
    /**
     * Disconnect from the database.
     * 
     * @throws SQLException if an error occurred.
     */
    public void disconnect() throws SQLException {
        if(_conn != null) {
            _conn.close();
            _conn = null;
        }
    }

    /**
     * Get a basic Statement.
     * 
     * @return The basic Statement.
     * @throws SQLException if an error occurred.
     */
    public Statement getStatement() throws SQLException {
    	if(_conn == null)
    		connect();
    	return _conn.createStatement();
    }

    /**
     * Get a prepared Statement.
     * 
     * @param q The query that needs to be prepared.
     * @return The prepared Statement.
     * @throws SQLException if an error occurred.
     */
    public PreparedStatement getPreparedStatement(String q) throws SQLException {
    	if(_conn == null)
    		connect();
    	return _conn.prepareStatement(q);
    }
}
