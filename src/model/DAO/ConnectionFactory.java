package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static final String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static final String URL_MYSQL = "jdbc:mysql://";
	private static final String HOSTNAME = "localhost";
	private static final String PORT = "3306";
	private static final String DATABASE = "biblioteca";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String SSL_FALSE = "?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String URL = URL_MYSQL + HOSTNAME + ":" + PORT + "/" + DATABASE + SSL_FALSE;
			
	public static Connection createConnectionToMySQL()  throws Exception {
		Class.forName(DRIVER_MYSQL);
		Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return connection;
	}
}