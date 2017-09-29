package com.bridgeit.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bridgeit.SingleTon.SingleTonSF;

public class TestManyToMany {

	public static void main(String[] args) {

		ActorDTO actor1 = new ActorDTO();
		actor1.setActorName("Siddu");
		actor1.setActorAge("24");
		actor1.setNoofMovies(10);

		ActorDTO actor2 = new ActorDTO();
		actor2.setActorName("Yogi");
		actor2.setActorAge("23");
		actor2.setNoofMovies(12);

		ActorDTO actor3 = new ActorDTO();
		actor3.setActorName("Harshil");
		actor3.setActorAge("22");
		actor3.setNoofMovies(9);

		MovieDTO movie1 = new MovieDTO();
		movie1.setMovieName("ABCD");
		movie1.setMovieRating(4);
		movie1.setMovieDirector("Harshil");

		MovieDTO movie2 = new MovieDTO();
		movie2.setMovieName("XYZ");
		movie2.setMovieRating(5);
		movie2.setMovieDirector("Siddu");

		MovieDTO movie3 = new MovieDTO();
		movie3.setMovieName("LightHouse");
		movie3.setMovieRating(5);
		movie3.setMovieDirector("Om");

		List<ActorDTO> actors = new ArrayList<>();
		actors.add(actor1);
		actors.add(actor2);
		actors.add(actor3);

		List<MovieDTO> movies = new ArrayList<>();
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);

		movie1.setActor(actors);
		movie2.setActor(actors);
		movie3.setActor(actors);

		actor1.setMovie(movies);
		actor2.setMovie(movies);
		actor3.setMovie(movies);

		SessionFactory sessionFactory = SingleTonSF.getSF();
		Session session = sessionFactory.openSession();

		session.save(movie1);
		session.save(movie2);
		session.save(movie3);

		session.save(actor1);
		session.save(actor2);
		session.save(actor3);
		session.beginTransaction().commit();
	}
}
