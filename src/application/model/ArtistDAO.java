package application.model;
import java.util.List;

public interface ArtistDAO {

	public boolean add(Artist artist);

	public boolean delete(int id);

	public boolean update(Artist artist);

	public List<Artist> getAll();

	public Artist findById(int id);

}
