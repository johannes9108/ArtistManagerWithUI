package application.model;
import java.util.List;

public class ArtistController implements ArtistDAO {

	private ArtistDAO dao;
	public ArtistController() {
		dao = new ArtistDAOJDBCImpl();
	}
	
	@Override
	public boolean add(Artist artist) {
		return dao.add(artist);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public boolean update(Artist artist) {
		return dao.update(artist);
	}

	@Override
	public List<Artist> getAll() {
		return dao.getAll();
	}

	@Override
	public Artist findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Artist> findByFirstName(String firstName) {
		return dao.findByFirstName(firstName);
	}

	@Override
	public List<Artist> findByLastName(String lastName) {
		return dao.findByLastName(lastName);
	}

	@Override
	public List<Artist> findByAge(int age) {
		return dao.findByAge(age);
	}


}
