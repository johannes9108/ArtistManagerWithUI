package application;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import application.model.Artist;

public class TestJPAMain {

	public static void main(String[] args) {


		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		Artist testArtist = em.find(Artist.class, 15);
		
		System.out.println(testArtist);
		
		testArtist.setAge(20);

		System.out.println(testArtist);
//		Artist artist = em.find(Artist.class, 8);
//		System.out.println(artist.getFirstName());
//		List<Artist> list =  q.getResultList();
//		System.out.println(list.size());
//		
		
		
		em.getTransaction().commit();
	}

}
