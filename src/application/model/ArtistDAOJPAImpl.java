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
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(artist);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public boolean delete(int id) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Artist a = em.find(Artist.class, id);
			em.remove(a);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public boolean update(Artist artist) {
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Artist updateableArtist = em.find(Artist.class, artist.getId());
			System.out.println("Nuvarande artist: " + updateableArtist);
			System.out.println("Nya värden: " + artist);
			updateableArtist.setAge(artist.getAge());
			updateableArtist.setFirstName(artist.getFirstName());
			updateableArtist.setLastName(artist.getLastName());
//			em.persist(updateableArtist);
			
			System.out.println("...");
			updateableArtist = em.find(Artist.class, artist.getId());
			System.out.println("Efter Persist: " + updateableArtist);
			
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return false;
		}
	}

	@Override
	public List<Artist> getAll() {
		try {
			em = emf.createEntityManager();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("select a FROM Artist a", Artist.class);

			List<Artist> results = query.getResultList();
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
		try {
			em = emf.createEntityManager();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			Artist a = em.find(Artist.class, id);

			em.getTransaction().commit();

			return a;

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}

	}

	@Override
	public List<Artist> findByFirstName(String firstName) {
		try {
			em = emf.createEntityManager();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			Query q = em.createQuery("from Artist a WHERE a.firstName like :firstName");
			q.setParameter("firstName", "%" + firstName + "%");

			List<Artist> artists = q.getResultList();
			for (Artist nextArtist : artists)
				System.out.println(nextArtist);

			em.getTransaction().commit();

			return artists;

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}

	}

	@Override
	public List<Artist> findByLastName(String lastName) {
		try {
			em = emf.createEntityManager();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			Query q = em.createQuery("from Artist a WHERE a.lastName like :lastName");
			q.setParameter("lastName", "%" + lastName + "%");

			List<Artist> artists = q.getResultList();
			for (Artist nextArtist : artists)
				System.out.println(nextArtist);

			em.getTransaction().commit();

			return artists;

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}

	}

	@Override
	public List<Artist> findByAge(int age) {
		try {
			em = emf.createEntityManager();
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

			Query q = em.createQuery("from Artist a WHERE a.age = :age");
			q.setParameter("age", age);

			List<Artist> artists = q.getResultList();
//			for (Artist nextArtist : artists)
//				System.out.println(nextArtist);

			em.getTransaction().commit();

			return artists;

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}

	}

}
