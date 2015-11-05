package iavanish;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DBConnection {
	
    @SuppressWarnings("finally")
	public static Connection createConnection() {
    	
        Connection connection = null;
        
        try {
            Class.forName(Constants.dbClass);
            connection = (Connection)DriverManager.getConnection(Constants.dbURL, Constants.dbUser, Constants.dbPassword);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            return connection;
        }
        
    }

    public static boolean checkLogin(String user, String password) {
    	
        boolean isUserAvailable = false;
        Connection connection = null;
        
        try {
            
        	try {
                connection = DBConnection.createConnection();
            }
            catch(Exception e) {
            	e.printStackTrace();
            }
            
            Statement stmt = (Statement)connection.createStatement();
            
            String query = "SELECT * FROM user WHERE username = '" + user + "' AND password=" + "'" + password + "'";

            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                isUserAvailable = true;
            }
            
        }
        
        catch(SQLException sqlE) {
            sqlE.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            if(connection != null) {
            	try {
            		connection.close();
            	}
            	catch(SQLException sqlE) {
            		sqlE.printStackTrace();
            	}
            	catch(Exception e) {
            		e.printStackTrace();
            	}
            }
        }
        
        return isUserAvailable;
        
    }

    public static boolean insertUser(String name, String uname, String pwd) {
        boolean insertStatus = false;
        Connection dbConn = null;
        try {
            try {
                dbConn = DBConnection.createConnection();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            Statement stmt = dbConn.createStatement();
            String query = "INSERT into user(name, username, password) values('"+name+ "',"+"'"
                    + uname + "','" + pwd + "')";
            //System.out.println(query);
            int records = stmt.executeUpdate(query);
            //System.out.println(records);
            //When record is successfully inserted
            if (records > 0) {
                insertStatus = true;
            }
        } catch (SQLException sqle) {
            //sqle.printStackTrace();
            throw sqle;
        } catch (Exception e) {
            //e.printStackTrace();
            // TODO Auto-generated catch block
            if (dbConn != null) {
                dbConn.close();
            }
            throw e;
        } finally {
            if (dbConn != null) {
                dbConn.close();
            }
        }
        return insertStatus;
    }
}