package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private static Connect instance;
	private Connection connection;
	
	private Connect() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_KaraokeNice;encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1";
		try {
		
			connection = DriverManager.getConnection(url , "sa", "sa");
			System.out.println("thanh cong !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized static Connect getInstance() {
		if(instance == null)
			instance = new Connect();
		return instance;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public static void main(String[] args) {
		
		Connect cn = new Connect();
	}
	
	
}

