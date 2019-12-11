package application.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ArtistDAOJPAImpl implements ArtistDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
	private EntityManager em;
	

	@Override
	public boolean add(Artist artist) {
		try {
			em.persist(artist);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Artist artist) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Artist> getAll() {
		try {
			em = emf.createEntityManager();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select a FROM Artist a", Artist.class);
			

			List<Artist> results = query.getResultList();
			
//			for(Artist artist: results)
//				System.out.println(artist);
			em.getTransaction().commit();

//			query = em.createQuery("select a from Artists a", Artist.class);
//			System.out.println(query.getSingleResult());

			return results;

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
	}

	@Override
	public Artist findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artist> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artist> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Artist> findByAge(int age) {
		// TODO Auto-generated method stub
		return null;
	}

}
