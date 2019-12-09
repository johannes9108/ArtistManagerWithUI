package application.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestMain {

	
	public static void main(String[] args) {
		try {
		Connection con; 
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artistdatabase", "root", "root");

		PreparedStatement findByFirstName = con.prepareStatement("SELECT * FROM ARTISTS WHERE firstName like ?");
		
		findByFirstName.setString(1, "%jo%");
		ResultSet rs = findByFirstName.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("firstName"));
		}
		
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
