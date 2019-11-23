package application.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArtistDAOJDBCImpl implements ArtistDAO {

	Connection con;
	PreparedStatement add, delete, update, showAll, findById;

	public ArtistDAOJDBCImpl() {

		try {

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/artistdatabase", "root", "root");

			add = con.prepareStatement("INSERT INTO artists (firstName,lastName,age) values (?,?,?)");
			delete = con.prepareStatement("DELETE FROM ARTISTS where id=?");
			update = con.prepareStatement("UPDATE ARTISTS SET firstName=?,lastName=?,age=? where id=?");
			showAll = con.prepareStatement("SELECT * FROM ARTISTS");
			findById = con.prepareStatement("SELECT * FROM ARTISTS where id=?");

		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong with the SQL");
		}

	}

	@Override
	public boolean add(Artist artist) {
		try {
			add.setString(1, artist.getFirstName());
			add.setString(2, artist.getLastName());
			add.setInt(3, artist.getAge());
			add.executeUpdate();
			System.out.println("Added: " + artist);
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong with the SQL: " + e.getMessage());
		}

	}

	@Override
	public boolean delete(int id) {
		try {
			delete.setInt(1, id);
			delete.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong with the SQL");
		}

	}

	@Override
	public boolean update(Artist artist) {
		try {
			update.setString(1, artist.getFirstName());
			update.setString(2, artist.getLastName());
			update.setInt(3, artist.getAge());
			update.setInt(4, artist.getId());
			update.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong with the SQL");
		}
	}

	@Override
	public List<Artist> showAll() {
		try {
			ResultSet rs = showAll.executeQuery();
			List<Artist> result = new ArrayList<Artist>();
			while (rs.next()) {
				Artist artist = new Artist(rs.getInt("age"), rs.getString("firstName"),
						rs.getString("lastName"));
				artist.setId(rs.getInt("id"));
				result.add(artist);
			}

			return result;
		} catch (SQLException e) {
//			return null;
			throw new RuntimeException("Something went wrong with the SQL:" + e.getMessage());
		}

	}

	@Override
	public Artist findById(int id) {
		try {
			findById.setInt(1, id);
			ResultSet rs = findById.executeQuery();
			if (rs.next()) {
				Artist artist = new Artist(rs.getInt("age"), rs.getString("firstName"),
						rs.getString("lastName"));
				artist.setId(rs.getInt("id"));
				return artist;
			}
		} catch (SQLException e) {
			throw new RuntimeException("Something went wrong with the SQL: " +  e.getMessage());
		}

		return null;
	}

}
